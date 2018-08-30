package javafxapplication3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author Seredyuk_Roman
 */
public class JavaFXApplication3 extends Application {
//Массив для сохранентия сгенерированіх фигур(Круг, квадрат, треугольник, трапеция)
List<figInterface>listOfFigures=new ArrayList<>(); 
String[] figuresColors={"black","white","grey","green","magenta","blue","orange","purple","yellow","red","brown","gold"};
infoWindow infoWindow = new infoWindow();
Random rand = new Random();
public static void main(String[] args) { launch(args);  }

@Override
public void start(Stage primaryStage) {
 
//Создаем Pane
   GridPane root = new GridPane();
    
//Создаем кнопки
    Button circleButton = new Button("Рисовать круг");
    circleButton.setPrefSize(150, 30);
    circleButton.setAlignment(Pos.CENTER);
      
    Button squareButton = new Button("Рисовать квадрат");
    squareButton.setPrefSize(150, 30);
    squareButton.setAlignment(Pos.CENTER);
        
    Button triangleButton = new Button("Рисовать треугольник");
    triangleButton.setPrefSize(150, 30);
    triangleButton.setAlignment(Pos.CENTER);
        
    Button trapezeButton = new Button("Рисовать трапецию");
    trapezeButton.setPrefSize(150, 30);
    trapezeButton.setAlignment(Pos.CENTER);
        
    Button genFigs = new Button("Сгенерировать фигуры");
    genFigs.setPrefSize(150, 30);
    genFigs.setAlignment(Pos.CENTER);
        
    Button printFigs = new Button("Вивести фигуры");
    printFigs.setPrefSize(150, 30);
    printFigs.setAlignment(Pos.CENTER);
        
//прописываем работу кнопок для рисования новых фигур
  circleButton.setOnAction(    (ActionEvent event) -> {System.out.println(new Circle(Math.random()*100).info());                                                                });        
  squareButton.setOnAction(    (ActionEvent event) -> {System.out.println(new Square (Math.random()*100).info());                                  });
  triangleButton.setOnAction(  (ActionEvent event) -> {System.out.println(new Triangle(Math.random()*100,Math.random()*80).info());                });
  trapezeButton.setOnAction(   (ActionEvent event) -> {System.out.println(new Trapeze(Math.random()*25,Math.random()*20,Math.random()*78).info()); });
        
 //генерируем фигуры каждый раз очищая массив
 genFigs.setOnAction( (ActionEvent event) -> {listOfFigures.removeAll(listOfFigures);
                                              System.out.println("------------Фигуры сгенерировано------------");
                                              gen();
                                                    } ); 
       
//Выводим сгенерированые фигуры
  printFigs.setOnAction( (ActionEvent event) -> { 
if (listOfFigures.isEmpty()){ infoWindow.showNoInfo("Сначала сгенерируйте фигуры.");}    
    else printGenFigs(); } );
      
//Добавляем кнопки на GridPane
      root.setHgap(5);
      root.setVgap(5);
        root.add(circleButton,    0, 0);
        root.add(squareButton,    0, 1);
        root.add(triangleButton,  0, 2);
        root.add(trapezeButton,   0, 3);
        root.add(genFigs,0,7);
        root.add(printFigs,0,8);
        root.setAlignment(Pos.CENTER);
        //Добавляем главный узел на сцену.
        Scene scene = new Scene(root, 200, 250);
       //Устанавливаем сцену на "театральные подмостки"(primaryStage)
        primaryStage.setTitle("Рисование и генерация фигур");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//Метод для генерации случайного количества случайных фигур. 
public void gen() {
//генерація к-сті фігур від 1..10;
int k=(1+rand.nextInt(10));
for (int i = 0; i < k; i++) {
 int WhatFigureToChose = rand.nextInt(4);  
 switch (WhatFigureToChose) {
case 0:listOfFigures.add(new Circle(Math.random()*100));break;
case 1:listOfFigures.add(new Square (Math.random()*100));break;
case 2:listOfFigures.add(new Triangle(Math.random()*100,Math.random()*80));break;
case 3:listOfFigures.add(new Trapeze(Math.random()*25,Math.random()*20,Math.random()*78));break;
       default:break;
         }}     }


//Метод для вывода созданого рандомного количества случайных фигур в новом окне
public void printGenFigs(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("infoWindow");
        window.setWidth(640);   
        window.setHeight(350);
        
      GridPane root=new GridPane();
      root.setPadding(new Insets(10,10,10,10));
      root.setHgap(10);
      root.setVgap(10);
      
 //Для каждой новой фигуры создаем новую метку и сохраняем в ней инфо о фигуре. 
 //Метку помещаем в i клетку сетки.(0 столбец)
 for (int i = 0; i < listOfFigures.size(); i++) {
       Label label = new Label( listOfFigures.get(i).info());   
       label.setAlignment(Pos.CENTER);
       GridPane.setConstraints(label, 0, i);
       root.getChildren().add(label);
       System.out.println(listOfFigures.get(i).info());
    }
//    Кнопку помещаем в следущую клетку после всех созданих меток с фигурами.   
        Button b=new Button("Close");
        b.setOnAction(e -> window.close());
        GridPane.setConstraints(b, 1, listOfFigures.size()+1);
        root.getChildren().add(b);
                                
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
}



}        
        
   
    


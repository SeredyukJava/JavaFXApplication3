package javafxapplication3;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class infoWindow {
 

public static void showNoInfo(String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("infoWindow");
        window.setWidth(300);   
        window.setHeight(150);
       
       GridPane root=new GridPane();
       root.setPadding(new Insets(10,10,10,10));
       root.setVgap(10);
       root.setHgap(10);
       root.setAlignment(Pos.CENTER);
       
       Label label = new Label(message);     
       label.setAlignment(Pos.CENTER);
       
       Button b=new Button("Ok");
       b.setOnAction(e -> window.close());
       b.setAlignment(Pos.CENTER);
       
          GridPane.setConstraints(label, 0, 0);
          GridPane.setConstraints(b, 0, 1);
       root.getChildren().addAll(label,b);
      
       Scene scene = new Scene(root);
       window.setScene(scene);
       window.show();

    }

}

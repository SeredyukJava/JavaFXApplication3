package javafxapplication3;
public class Square extends JavaFXApplication3 implements figInterface {
private double a,s;
private String color;
    Square(double a){
    this.a=a;
    int x=rand.nextInt(12);
    this.color=figuresColors[x];
    this.s=a*a;
    }

public double getSide()  {return a;}
    
@Override
public String draw()     {return "Квадрат";}
@Override
public String getColor() {return color;}
@Override
public double getSquare(){return s;}
@Override
public String info() { return draw()+" Цвет: "+getColor()+"  Сторона А: "+getSide()+ "  Площадь =  "+getSquare();}
    
       
}

package javafxapplication3;
public class Trapeze extends JavaFXApplication3 implements figInterface {
  private double h,a,b,s;
  private String color;
    Trapeze(double h,double a,double b){
    this.h=h;
    this.a=a;
    this.b=b;
    int x=rand.nextInt(12);
    this.color=figuresColors[x];
    this.s=((a+b)/2)*h; 
       }

public double getH()     { return h;}

@Override
public String draw()     { return "Трапеция";}
@Override
public String getColor() { return color;}
@Override
public double getSquare(){ return s;}
@Override
  public String info()   { return draw()+" Цвет: "+getColor()+"  Высота: "+getH()+"  Площадь: "+getSquare();}
 
}

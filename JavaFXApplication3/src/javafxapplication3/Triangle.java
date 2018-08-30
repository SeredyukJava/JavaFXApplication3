package javafxapplication3;
public class Triangle extends JavaFXApplication3 implements figInterface{
    private double a,b,c,s;
    private String color; 
        
    Triangle(double a,double b){
    this.a=a;
    this.b=b;
    this.c=Math.sqrt((a*a)+(b*b));
    int x=rand.nextInt(12);
    this.color=figuresColors[x];
    this.s=(a*b)/2;}
    
public double getHypotenuse() { return c; }

@Override
public String draw()      {  return "Треугольник"; }
@Override
public String getColor()  {  return color; }
@Override
public double getSquare() {  return s;  }
@Override
public String info(){return draw()+" Цвет: "+getColor()+"  Гипотенуза = "+getHypotenuse()+"  Площадь = "+getSquare();}
       
    
    
}

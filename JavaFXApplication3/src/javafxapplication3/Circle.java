package javafxapplication3;
public class Circle  extends JavaFXApplication3  implements figInterface {
 private double r,s;
 private String color;
 
   Circle(double r){
        this.r=r;
        int x=rand.nextInt(12);
        this.color=figuresColors[x];
        this.s=Math.PI*r*r;
         }
   
public double getR()     {return r;}  

@Override
public String draw()     {return "Круг";}
@Override
public String getColor() {return color; }
@Override
public double getSquare(){return s;     }
@Override
public String info() {return draw()+" Цвет: "+getColor()+"  Радиус круга = "+getR()+"  Площадь =  "+getSquare();   }
    


    
    
}

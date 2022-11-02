package com.vamshi.coding.ford;

public class ShapeFactory {
    Shape sh;

    // at ford, I implemented this factory with return type as EU or NA image service based on request
    public void drawShape(String string) {


        if(string.equals("Circle")) {
            sh = new Circle();
            sh.drawShape();
        }else if(string.equals("Rectangle")){
            sh = new Rectangle();
            sh.drawShape();
        }else if(string.equals("Square")){
            sh = new Square();
            sh.drawShape();
        }else{
            System.out.println("Drawing "+ string+" is not supported");
        }
    }
}


abstract class Shape{
    public abstract void drawShape();
}
class Circle extends Shape{

    public void drawShape(){
        System.out.println("Drawing a Circle");
    }
}
class Rectangle extends Shape {
    public void drawShape() {
        System.out.println("Drawing a Rectangle");
    }
}
class Square extends Shape{
    public void drawShape() {
        System.out.println("Drawing a Square");
    }
}
package Lesson9.Figure;

public class Rectangle extends Figure{
    double width,height;

    public Rectangle(double width,double height){
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea(){
        return width*height;
    }
    @Override
    public double calculatePerimeter(){
        return 2*(width+height);
    }
}

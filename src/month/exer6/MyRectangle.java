package month.exer6;

public class MyRectangle extends GeometricObject{

    private double width;
    private  double height;

    public MyRectangle(String color, double weight,double height,double width) {
        super(color, weight);
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double findArea() {
        return width*height;
    }
}

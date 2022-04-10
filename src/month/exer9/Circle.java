package month.exer9;



import java.util.Objects;

public class Circle extends GeometricObject {

    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
       this.radius = radius;
    }

    public Circle(double weight, String color, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double findArea() {
        return 3.14*radius*radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

}

package month.exer6;

import org.junit.Test;

public class GeometricTest {
    public boolean equalsArea(GeometricObject g1,GeometricObject g2){
        return g1.findArea() == g2.findArea();
    }

    public void displayGeometricObject(GeometricObject g1){
        System.out.println("面积为：" + g1.findArea());
    }

    public static void main(String[] args) {
        GeometricTest geometricTest = new GeometricTest();
        Circle c1 = new Circle(2.3,"white",1.0);
        geometricTest.displayGeometricObject(c1);
        Circle c2 = new Circle(3.3,"black",1.0);
        geometricTest.displayGeometricObject(c2);

        System.out.println("c1和c2的面试是否相等："+geometricTest.equalsArea(c1,c2));
    }

    @Test
    public void test(){
        int num = 2147483647;
        System.out.println(num);
        long temp = num +2L;
        System.out.println(num);
        System.out.println(temp);
    }
}

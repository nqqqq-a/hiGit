package month.day14;

public class ComparableCircleTest {
    public static void main(String[] args) {


        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int i = c1.compareTo(c2);
        if (i > 0){
            System.out.println("c1大于c2");
        }else if (i < 0){
            System.out.println("c1小于c2");
        }else System.out.println("c1与c1一样大");
    }
}

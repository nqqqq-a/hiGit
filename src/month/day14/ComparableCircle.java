package month.day14;

public class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o){
            return 0;
        }
        if (o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle) o;
//          有漏洞，2.3-2.1 = 0.2 int会导致变为0；
//            return (int)(this.getRadius() - c.getRadius());
            if (this.getRadius() > c.getRadius()) return 1;
            else if (this.getRadius() < c.getRadius()) return -1;
            else return 0;
        }else {
            return 0;
        }

    }
}

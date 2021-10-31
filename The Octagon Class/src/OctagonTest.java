//Jared Truitt
//CIS315
//July 1, 2021
//The Octagon Test

public class OctagonTest {
    public static void main(String[] args)throws CloneNotSupportedException{
        Octagon oct = new Octagon(5, "blue", true);
        Octagon clone = (Octagon) oct.clone();

        System.out.printf("Area of the octagon with side value %.2f is %.2f\n", oct.getSide(), oct.getArea());
        System.out.printf("Perimeter of the octagon with side value %.2f is %.2f\n", oct.getSide(), oct.getPerimeter());
        System.out.printf("Comparison result between an octagon and its clone: %d\n", oct.compareTo(clone));
    }
}

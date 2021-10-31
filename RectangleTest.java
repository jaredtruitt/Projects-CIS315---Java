public class RectangleTest {
    public static void main(String[] args){
	Rectangle rectangle = new Rectangle(40.0, 4.0);

	System.out.println("Before the change: \n");
	System.out.printf(
		"The rectangle's width is %.2f and its height is %.2f.\n", 
		rectangle.getWidth(), rectangle.getHeight()
	);

	System.out.printf("Its area is %.2f and its perimeter is %.2f.\n\n",
		rectangle.getArea(), rectangle.getPerimeter()
	);

	rectangle.setWidth(35.9);
	rectangle.setHeight(3.5);
	System.out.println("After the change: \n");
	System.out.printf("The rectangle's width is %.2f and its height is %.2f.\n",
		rectangle.getWidth(), rectangle.getHeight()
	);
	System.out.printf("Its area is %.2f and its perimeter is %.2f.\n", 
		rectangle.getArea(), rectangle.getPerimeter()
	);
    }
}

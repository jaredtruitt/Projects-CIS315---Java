import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SierpinskiTriangleFractal extends Application{
	
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();
        TextField tfOrder = new TextField();
        tfOrder.setOnAction(e -> trianglePane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(trianglePane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        borderPane.widthProperty().addListener(ov -> trianglePane.setW(borderPane.getWidth()));
        borderPane.heightProperty().addListener(ov -> trianglePane.setH(borderPane.getHeight()));

    }

    /** Pane for displaying triangles */
    static class SierpinskiTrianglePane extends Pane{
        private int order = 0;
        private double w = 200, h = 200;
        /** Set a new order */

        public void setOrder(int order){
            this.order = order;
            paint();
        }

        SierpinskiTrianglePane(){
        }

        /** Set Triangle Pane width */
        public void setW(double w){
            this.w = w;
            paint();
        }

        /** Set Triangle Pane width */
        public void setH(double h){
            this.h = h;
            paint();
        }

        protected void paint(){
            // Select three points in proportion to the pane size
            Point2D p1 = new Point2D(10, h - 20);
            Point2D p2 = new Point2D(w -10, h - 20);
            Point2D p3 = new Point2D((p1.getX() + p2.getX())/2, 10);
            this.getChildren().clear(); // Clear the pane before redisplay

            displayTriangles(order, p3, p1, p2);
        }

        private void displayTriangles(int order, Point2D p3, Point2D p1, Point2D p2){
            if (order == 0){
                // Draw a triangle to connect three points
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p3.getX(), p3.getY(), p1.getX(), p1.getY(), p2.getX(), p2.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.BLACK);

                this.getChildren().add(triangle);
            }
            else{
                // Get the midpoint on each edge in the triangle
                Point2D p12 = p3.midpoint(p1);
                Point2D p23 = p1.midpoint(p2);
                Point2D p31 = p2.midpoint(p3);

                // Recursively display three triangles
                displayTriangles(order - 1, p3, p12, p31);
                displayTriangles(order - 1, p12, p1, p23);
                displayTriangles(order - 1, p31, p23, p2);
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
        SierpinskiTriangleFractal.launch(args);
    }
}

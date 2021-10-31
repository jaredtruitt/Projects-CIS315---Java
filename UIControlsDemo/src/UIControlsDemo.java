import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UIControlsDemo extends Application{
    TextField input;
    RadioButton red, green, blue;
    CheckBox bold, italic;
    Button left, right;
    Text text;

    @Override
    public void start(Stage primaryStage){
        Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2)));

        Label lbl = new Label("Enter a new message");
        input = new TextField();
        input.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                if(!input.getText().equalsIgnoreCase("")){
                    text.setText(input.getText());
                }
            }
        });

        HBox topPanel = new HBox(lbl, input);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setSpacing(20.0);
        topPanel.setBorder(border);

        ToggleGroup group = new ToggleGroup();

        red = new RadioButton("Red");
        red.setToggleGroup(group);
        green = new RadioButton("Green");
        green.setToggleGroup(group);
        blue = new RadioButton("Blue");
        blue.setToggleGroup(group);

        red.setOnAction(e -> update());
        green.setOnAction(e -> update());
        blue.setOnAction(e -> update());

        VBox leftPanel = new VBox(red, green, blue);
        leftPanel.setBorder(border);
        leftPanel.setSpacing(20.0);
        bold = new CheckBox("Bold");
        italic = new CheckBox("Italic");

        bold.setOnAction(e -> update());
        italic.setOnAction(e -> update());
        VBox rightPanel = new VBox(bold, italic);
        rightPanel.setAlignment(Pos.CENTER);
        rightPanel.setSpacing(20);
        rightPanel.setBorder(border);

        text = new Text("JavaFX programming is cool!");
        text.setFont(Font.font("Serif", 20));
        HBox centerPanel = new HBox(text);
        centerPanel.setAlignment(Pos.CENTER);

        left = new Button("Left");

        left.setGraphic(new ImageView(new Image("file: /Users/jaredtruitt/Desktop/CIS315-Java/UIControlsDemo/src/left.gif")));


        right = new Button("Right");

        right.setGraphic(new ImageView(new Image("file: /Users/jaredtruitt/Desktop/CIS315-Java/UIControlsDemo/src/right.gif")));

        right.setContentDisplay(ContentDisplay.RIGHT);

        left.setOnAction(e -> centerPanel.setAlignment(Pos.CENTER_LEFT));
        right.setOnAction(e -> centerPanel.setAlignment(Pos.CENTER_RIGHT));
        HBox bottomPanel = new HBox(left, right);
        bottomPanel.setAlignment(Pos.CENTER);
        bottomPanel.setSpacing(20);
        bottomPanel.setBorder(border);

        BorderPane pane = new BorderPane(centerPanel, topPanel, rightPanel, bottomPanel, leftPanel);
        Scene scene = new Scene(pane, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    public void update(){
        if(red.isSelected()){
            text.setFill(Color.RED);
        }
        else if(green.isSelected()){
            text.setFill(Color.GREEN);
        }
        else if(blue.isSelected()){
            text.setFill(Color.BLUE);
        }

        Font f = text.getFont();
        FontPosture posture = null;
        FontWeight weight = null;
        if(italic.isSelected()){
            posture = FontPosture.ITALIC;
        }
        else{
            posture = FontPosture.REGULAR;
        }

        if(bold.isSelected()){
            weight = FontWeight.BOLD;
        }
        else{
            weight = FontWeight.LIGHT;
        }
        text.setFont(Font.font(f.getFamily(), weight, posture, f.getSize()));
    }

    public static void main(String[] args){
        launch(args);
    }
}

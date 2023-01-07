package Replit;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        int radius = 10;
        int lan = 265;//265 is about middle 
        
        Rectangle rec = new Rectangle(110,140,300,250);
        //Line lin = new Line(lan,140,lan,390);
        Polygon ter = new       Polygon(110,140,lan,140,lan,390,110,390);
        
         Label label1 = new Label("Country A");
         Label label2 = new Label("Country B");
         Label label3 = new Label("Conquest");
         Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 20);
         Font font2 = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 33);
         label1.setFont(font);
         
         label2.setFont(font);
         
         label3.setFont(font2);
        
         
        label1.setTranslateX(145);
        label1.setTranslateY(105);
        
        label2.setTranslateX(300);
        label2.setTranslateY(105);
        
        label3.setTranslateX(210);
        label3.setTranslateY(40);
        
         
        
        Pane root = new Pane(rec,ter,label1,label2,label3);
        Scene scene = new Scene(root, 500, 500,Color.AQUAMARINE);
        
        
        
        primaryStage.setTitle("Conquest");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        //rec.setFill(Color.BURLYWOOD);
        rec.setFill(Color.CRIMSON);
        rec.setStroke(Color.BLACK);
        //ter.setFill(Color.GREEN);
        ter.setFill(Color.DODGERBLUE);
        
        label1.setTextFill(Color.DODGERBLUE);
        label2.setTextFill(Color.CRIMSON);
        label3.setTextFill(Color.FORESTGREEN);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

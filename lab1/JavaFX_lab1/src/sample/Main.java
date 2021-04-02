package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab1");
        Group mygroup = new Group();
        Scene scene = new Scene (mygroup, 1080, 720);

        Rectangle box = new Rectangle(150,350,800,300);
        mygroup.getChildren().add(box);
        box.setFill(Color.MAROON);

        Polygon roof = new Polygon(150, 350, 500, 200, 950, 350);
        mygroup.getChildren().add(roof);
        roof.setFill(Color.GRAY);

        Rectangle leftwin = new Rectangle(300,425,100,100);
        mygroup.getChildren().add(leftwin);
        leftwin.setFill(Color.YELLOW);

        Rectangle righttwin = new Rectangle(550,425,100,110);
        mygroup.getChildren().add(righttwin);
        righttwin.setFill(Color.YELLOW);

        Rectangle star1 = new Rectangle(40,150,35,35);
        mygroup.getChildren().add(star1);
        star1.setFill(Color.YELLOW);

        Rectangle star2 = new Rectangle(200,40,35,35);
        mygroup.getChildren().add(star2);
        star2.setFill(Color.YELLOW);

        Rectangle star3 = new Rectangle(750,40,35,35);
        mygroup.getChildren().add(star3);
        star3.setFill(Color.YELLOW);

        Rectangle star4 = new Rectangle(570,150,35,35);
        mygroup.getChildren().add(star4);
        star4.setFill(Color.YELLOW);

        scene.setFill(Color.rgb(1, 0, 128));

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

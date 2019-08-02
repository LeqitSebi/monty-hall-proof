import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class monty_hall_proof extends Application {

    public void start (Stage stage){
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 650, 150); // w, h
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        stage.setScene(scene);
        stage.setTitle("The Monty Hall Problem");
        stage.setScene(scene);
        Label main_menu = new Label("Do you want to play the game manually or just see the stats?");
        Button manually = new Button("manually");
        Button automatically = new Button("see the stats");
        gridPane.add(main_menu, 0, 1);
        gridPane.add(manually, 1, 1);
        gridPane.add(automatically, 2, 1);

        manually.setOnAction(event -> {
            start_manually(stage);
        });

        automatically.setOnAction(event -> {
            start_automatically(stage);
        });
        stage.show();
    }

    public static boolean[] selectdoors() {
        boolean[] doors = new boolean[3];
        ArrayList<Boolean> booleans = new ArrayList<Boolean>();
        booleans.add(true);
        booleans.add(false);
        booleans.add(false);
        for (int i = 0; i < 2; i++) {
            int stelle = (int) (Math.random()*booleans.size());
            doors[i] = booleans.get(stelle);
            booleans.remove(stelle);
        }
        return doors;
    }

    public void start_manually(Stage stage){
        boolean[] doors = selectdoors();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 650, 250); // w, h
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        stage.setScene(scene);
        stage.setTitle("The Monty Hall Problem - Play it Yourself");
        stage.setScene(scene);
        Button door1 = new Button("1");
        Button door2 = new Button("2");
        Button door3 = new Button("3");
        Label l1 = new Label("Which door do you choose?");
        TextField tf = new TextField("enter number");
        Button submit = new Button("take that number");
        gridPane.add(door1, 0, 0);
        gridPane.add(door2, 1, 0);
        gridPane.add(door3, 2, 0);
        gridPane.add(l1, 0, 1);
        gridPane.add(tf, 0, 2);
        gridPane.add(submit, 1, 2);

        submit.setOnAction(event -> {
            int taken_number = Integer.parseInt(tf.getText());
        });

        stage.show();
    }

    public void start_automatically(Stage stage){
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 650, 150); // w, h
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        stage.setScene(scene);
        stage.setTitle("The Monty Hall Problem - See proof");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
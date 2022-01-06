package projet.labyrinth;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;



import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        MainController.A_Maze_Ing(10);
    }



}
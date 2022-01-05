package projet.labyrinth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button exitBtn;

    @FXML
    private Button gamemodeBtn;

    @FXML
    private Button menuBtn;

    @FXML
    private AnchorPane rootAll;

    @FXML
    private AnchorPane rootMain;

    @FXML
    private ToolBar rootMenu;

    @FXML
    private Button scorringBtn;

    @FXML
    private Button solutionBtn;

    Stage stage ;

    @FXML
    void exitAction(ActionEvent event) {
       stage= (Stage) rootAll.getScene().getWindow();
        stage.close();

    }

    @FXML
    void launchgame(ActionEvent event) throws IOException {

        rootMain.getChildren().setAll((Node) FXMLLoader.load(HelloApplication.class.getResource("start-view.fxml")));
    }

    @FXML
    void launchSolution(ActionEvent event) {

    }

}

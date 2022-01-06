package projet.labyrinth;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button cleanCanvasBtn;
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

    @FXML
    private Canvas rootCanvasTest;

    public Stage stage ;


    SolutionController stageSolutionController = new SolutionController();
    StartController stageStartController = new StartController();





    @FXML
    void exitAction(ActionEvent event) {
       Stage stage= (Stage) rootAll.getScene().getWindow();
       stage.close();



    }

    @FXML
    void launchgame(ActionEvent event) throws IOException {
        rootMain.getChildren().setAll((Node) FXMLLoader.load(HelloApplication.class.getResource("start-view.fxml")));
        canvasVisibilityHidden();
        gamemodeBtn.setDisable(true);


    }

    @FXML
    void launchSolution(ActionEvent event)throws IOException {

        rootCanvasTest.setVisible(true);
        cleanCanvasBtn.setVisible(true);
        stageSolutionController.Draw(stage,rootCanvasTest);
        rootMain.getChildren().setAll((Node) FXMLLoader.load(HelloApplication.class.getResource("solution-view.fxml")));


    }

    @FXML
    void launchScorring(ActionEvent event) {
        canvasVisibilityHidden();

    }


    public void cleanCanvas(ActionEvent actionEvent) {
        canvasVisibilityHidden();
        rootCanvasTest.getGraphicsContext2D().clearRect(0, 0, rootCanvasTest.getWidth(), rootCanvasTest.getHeight());
    }

    public void canvasVisibilityHidden(){
        rootCanvasTest.getGraphicsContext2D().clearRect(0, 0, rootCanvasTest.getWidth(), rootCanvasTest.getHeight());
        rootCanvasTest.setVisible(false);
        cleanCanvasBtn.setVisible(false);
    }
}

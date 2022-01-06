package projet.labyrinth;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class StartController implements Initializable {

    @FXML
    private TextField EntryAlgo;

    @FXML
    private AnchorPane rootStart;

    @FXML
    private Label StartText;

    @FXML
    public ComboBox<String> combotBoxBTN;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.combotBoxBTN.setItems(FXCollections.observableArrayList("Banane"));
        combotBoxBTN.getSelectionModel().selectFirst();

    }
    public void Entry() {
        System.out.println(combotBoxBTN.getValue());
    }
    @FXML
    public void display(ActionEvent event) {
        combotBoxBTN.getItems().add(EntryAlgo.getText());

    }


}


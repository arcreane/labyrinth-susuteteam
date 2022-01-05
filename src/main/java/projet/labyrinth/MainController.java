package projet.labyrinth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void A_Maze_Ing(int table_length) {


        // creation of the table that represent the amazing maze
        String[][] table = new String[table_length][table_length];

        int random_wall1 = 0;
        int random_wall2 = 0;

        int number_of_entries = 2;

        // That part initialize the table with "x" everywhere
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[x].length; y++) {
                table[x][y] = "x";
            }
        }

        // That part put the middle to "0"
        for(int x = 1; x < (table.length - 1); x++){
            for (int y = 1; y < (table[x].length -1) ; y++) {
                table[x][y]= "O";
            }
        }
        // That part randomize walls in the maze
        for(int k = 1; k < table.length * 8; k++){
            random_wall1 = (int) ((Math.floor(Math.random() * (table.length -2)) +1));
            random_wall2 = (int) ((Math.floor(Math.random() * (table.length -2)) +1));
            table[random_wall1][random_wall2] = "x";
            if((table[random_wall1 + 1][random_wall2] == "O" && table[random_wall1 ][random_wall2 + 1] == "O") || (table[random_wall1 + 1 ][random_wall2] == "O" && table[random_wall1 ][random_wall2 - 1] == "O") || (table[random_wall1 + 1 ][random_wall2] == "O" && table[random_wall1 - 1][random_wall2] == "O") || (table[random_wall1 - 1 ][random_wall2] == "O" && table[random_wall1 ][random_wall2 - 1] == "O") || (table[random_wall1 - 1 ][random_wall2] == "O" && table[random_wall1 ][random_wall2 + 1] == "O") || (table[random_wall1][random_wall2 + 1] == "O" && table[random_wall1 ][random_wall2 - 1] == "O")){
                table[random_wall1][random_wall2] = "x";
            }
        }
        // That parts check if there is an isolated path and fixx the error.
        for(int x = 1; x < table.length; x++){
            for(int y = 1; y < table.length; y++){
                if(Objects.equals(table[x][y], "O")){
                    while(table[x - 1][y] == "x" && table[x + 1][y] == "x" && table[x][y - 1] == "x" && table[x][y + 1] == "x"){
                        if(table[x + 1][y] == table[14][y]){
                            table[x - 1][y] = "O";
                        }
                        else{
                            table[x + 1][y] = "O";
                        }
                    }
                }
                if(Objects.equals(table[x][y], "O")){
                    while(table[x - 1][y] == "O" && table[x + 1][y] == "O" && table[x][y - 1] == "O" && table[x][y + 1] == "O" && table[x][y] == "O"){
                        table[x][y] = "x";
                    }
                }
            }
        }
        int side1 = (int) (Math.random() * 4);
        int side2 = 0;
        if (side1 == 0){
            side2 = 1;
            String[] my_coords1 = side_to_coordinates(side1,table).split(":");
            System.out.println(my_coords1[0] + " " + my_coords1[1]); /* coordinates of entry */
            String[] my_coords2 = side_to_coordinates(side2,table).split(":");
            System.out.println(my_coords2[0] + " " + my_coords2[1]); /* coordinates of escape */
        }else if(side1 == 1){
            side2 = 0;
            String[] my_coords1 = side_to_coordinates(side1,table).split(":");
            System.out.println(my_coords1[0] + " " + my_coords1[1]); /* coordinates of entry */
            String[] my_coords2 = side_to_coordinates(side2,table).split(":");
            System.out.println(my_coords2[0] + " " + my_coords2[1]); /* coordinates of escape */
        }else if(side1 == 2){
            side2 = 3;
            String[] my_coords1 = side_to_coordinates(side1,table).split(":");
            System.out.println(my_coords1[0] + " " + my_coords1[1]); /* coordinates of entry */
            String[] my_coords2 = side_to_coordinates(side2,table).split(":");
            System.out.println(my_coords2[0] + " " + my_coords2[1]); /* coordinates of escape */
        }else if(side1 == 3){
            side2 = 2;
            String[] my_coords1 = side_to_coordinates(side1,table).split(":");
            System.out.println(my_coords1[0] + " " + my_coords1[1]); /* coordinates of entry */
            String[] my_coords2 = side_to_coordinates(side2,table).split(":");
            System.out.println(my_coords2[0] + " " + my_coords2[1]); /* coordinates of escape */
        }



        /* That part display the amazing maze */
        for(int x = 0; x < table.length; x++){
            for (int y = 0; y < table[x].length; y++) {
                if (table[x][y] == "O"){
                    System.out.print(ANSI_RED + table[x][y] + ANSI_RESET + "  ");
                }else{
                    System.out.print(ANSI_GREEN + table[x][y] + ANSI_RESET + "  ");
                }
            }
            System.out.println();
        }
    }

    private static String side_to_coordinates (int myside, String[][] mytable){
        /*
        variation of y:
            0 : x= max-range         y= 0 -> max-range    right
            1 : x= 0                y= 0 -> max-range    left

        variation de x:
            2 : x= 0 -> max-range    y= max-range          bottom
            3 : x= 0 -> max-range    y= 0                top
         */
        int x = 0;
        int y = 0;
        if (myside == 0){
            x = mytable.length;
            y = (int) ((Math.random() * (mytable.length - 4)) + 2);
        }else if(myside == 1){
            y = (int) ((Math.random() * (mytable.length - 4)) + 2);
        }else if(myside == 2){
            x = (int) ((Math.random() * (mytable.length - 4)) + 2);
            y = mytable.length;
        }else if(myside == 3){
            x = (int) ((Math.random() * (mytable.length - 4)) + 2);
        }
        return x + ":" + y;

    }
}


package projet.labyrinth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    void launchSolution() {

    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void A_Maze_Ing(int table_length) {

        // creation of the table that represent the amazing maze
        String[][] table = new String[table_length][table_length];

        // That part initialize the table with "x" everywhere
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[x].length; y++) {
                table[x][y] = "x";
            }
        }

        // That part put the middle to "x"
        for(int x = 1; x < (table.length - 1); x++){
            for (int y = 1; y < (table[x].length -1) ; y++) {
                table[x][y]= "x";
            }
        }
        int side1 = (int) (Math.random() * 4);
        int side2;
        String[] my_coords1 = side_to_coordinates(side1,table).split(":");
        String[] my_coords2;
        if (side1 == 0){
            side2 = 1;
            my_coords2 = side_to_coordinates(side2,table).split(":");
            mazeGeneration(table, my_coords1, my_coords2);
        }else if(side1 == 1){
            side2 = 0;
            my_coords2 = side_to_coordinates(side2,table).split(":");
            mazeGeneration(table, my_coords1, my_coords2);
        }else if(side1 == 2){
            side2 = 3;
            my_coords2 = side_to_coordinates(side2,table).split(":");
            mazeGeneration(table, my_coords1, my_coords2);
        }else if(side1 == 3){
            side2 = 2;
            my_coords2 = side_to_coordinates(side2,table).split(":");
            mazeGeneration(table, my_coords1, my_coords2);
        }




        /* That part display the amazing maze */
        for(int x = 0; x < table.length; x++){
            for (int y = 0; y < table[x].length; y++) {
                if (Objects.equals(table[x][y], "O")){
                    System.out.print(ANSI_RED + table[x][y] + ANSI_RESET + "  ");
                }else{
                    System.out.print(ANSI_GREEN + table[x][y] + ANSI_RESET + "  ");
                }
            }
            System.out.println();
        }
    }

    private static void mazeGeneration(String[][] maze, String[] coord_entrance, String[] coord_exit) {
        int magic_random_number = (int) (Math.random() * 4);
        int magic_random_number2 = (int) (Math.random() * 100);
        int magic_random_number3 = magic_random_number2;

        maze[Integer.parseInt(coord_entrance[0])][Integer.parseInt(coord_entrance[1])] = "O";
        maze[Integer.parseInt(coord_exit[0])][Integer.parseInt(coord_exit[1])] = "O";

        int coord_x = 0;
        int coord_y = 0;

        //Create the entrance and the exit
        // if x = 0
        if (coord_entrance[0].equals("0")) {
            maze[1][Integer.parseInt(coord_entrance[1])] = "O";
            coord_x = 1;
            coord_y = Integer.parseInt(coord_entrance[1]);
        }
        // if x = max length
        else if (coord_entrance[0].equals("" + (maze.length - 1))) {
            maze[maze.length - 2][Integer.parseInt(coord_entrance[1])] = "O";
            coord_x = maze.length - 2;
            coord_y = Integer.parseInt(coord_entrance[1]);
        }
        // if y = 0
        else if (coord_entrance[1].equals("0")) {
            maze[Integer.parseInt(coord_entrance[0])][1] = "O";
            coord_x = Integer.parseInt(coord_entrance[0]);
            coord_y = 1;
        }
        // if y = max length
        else if (coord_entrance[1].equals("" + (maze.length - 1))) {
            maze[Integer.parseInt(coord_entrance[0])][maze.length - 2] = "O";
            coord_x = Integer.parseInt(coord_entrance[0]);
            coord_y = maze.length - 2;
        }
        int coords_exit_x = 0;
        int coords_exit_y = 0;
        if (coord_exit[0].equals("0")) {
            maze[1][Integer.parseInt(coord_exit[1])] = "O";
            coords_exit_x = 1;
            coords_exit_y = Integer.parseInt(coord_exit[1]);
        } else if (coord_exit[0].equals("" + (maze.length - 1))) {
            maze[maze.length - 2][Integer.parseInt(coord_exit[1])] = "O";
            coords_exit_x = maze.length - 2;
            coords_exit_y = Integer.parseInt(coord_exit[1]);
        } else if (coord_exit[1].equals("0")) {
            maze[Integer.parseInt(coord_exit[0])][1] = "O";
            coords_exit_x = Integer.parseInt(coord_exit[0]);
            coords_exit_y = 1;
        } else if (coord_exit[1].equals("" + (maze.length - 1))) {
            maze[Integer.parseInt(coord_exit[0])][maze.length - 2] = "O";
            coords_exit_x = Integer.parseInt(coord_exit[0]);
            coords_exit_y = maze.length - 2;
        }

        //Path creator
        while (coord_x != coords_exit_x || coord_y != Integer.parseInt(coord_exit[1])) {
            magic_random_number = (int) (Math.random() * 4);
            magic_random_number2 = (int) (Math.random() * 100.0);
            magic_random_number3 = (int) (Math.random() * 100.0);
            int the_probability_to_go_to_exit = 30;

            if (magic_random_number2 <= the_probability_to_go_to_exit) {
                if (coord_x == coords_exit_x) {
                    if (coord_y + 1 != (maze.length - 1)) {
                        maze[coord_x][coord_y + 1] = "O";
                        coord_y = coord_y + 1;
                    }
                } else if (coord_y == coords_exit_y) {
                    if (coord_x + 1 != (maze.length - 1)) {
                        maze[coord_x + 1][coord_y] = "O";
                        coord_x = coord_x + 1;
                    }
                } else {
                    if (magic_random_number3 > 50) {
                        if (coord_x + 1 != (maze.length - 1)) {
                            maze[coord_x + 1][coord_y] = "O";
                            coord_x = coord_x + 1;
                        }

                    } else {
                        if (coord_y + 1 != (maze.length - 1)) {
                            maze[coord_x][coord_y + 1] = "O";
                            coord_y = coord_y + 1;
                        }

                    }
                }
            } else {
                //Value 0 = right.
                if (magic_random_number == 0) {
                    if (coord_x + 1 == (maze.length - 1)) {

                    } else {
                        maze[coord_x + 1][coord_y] = "O";
                        coord_x = coord_x + 1;
                    }
                }
                //Value 1 = left.
                else if (magic_random_number == 1) {
                    if (coord_x - 1 == 0) {

                    } else {
                        maze[coord_x - 1][coord_y] = "O";
                        coord_x = coord_x - 1;
                    }
                }
                //Value 2 = top.
                else if (magic_random_number == 2) {
                    if (coord_y + 1 == (maze.length - 1)) {

                    } else {
                        maze[coord_x][coord_y + 1] = "O";
                        coord_y = coord_y + 1;
                    }
                }
                //Value 3 = bottom.
                else {
                    if (coord_y - 1 == 0) {

                    } else {
                        maze[coord_x][coord_y - 1] = "O";
                        coord_y = coord_y - 1;
                    }
                }
            }
        }
        int number_of_plus_O = 0;
        for(int i = 1; i < (maze.length-2); i++) {
            for(int j = 1; j < (maze.length-2); j++){
                if(maze[i][j].equals("O")){
                    if(maze[i + 1][j].equals("O") && maze[i - 1][j].equals("O") && maze[i][j + 1].equals("O") && maze[i][j - 1].equals("O")){
                        if(maze[i + 1][j + 1].equals("O")){
                            number_of_plus_O += 1;
                        }
                        if(maze[i + 1][j - 1].equals("O")){
                            number_of_plus_O += 1;
                        }
                        if(maze[i - 1][j + 1].equals("O")){
                            number_of_plus_O += 1;
                        }
                        if(maze[i - 1][j - 1].equals("O")){
                            number_of_plus_O += 1;
                        }
                        if(number_of_plus_O >= 3){
                            maze[i][j] = "x";
                        }
                        number_of_plus_O = 0;
                    }
                }

                if(maze[i][j].equals("x")) {
                    number_of_plus_O = 0;
                    if(maze[i + 1][j].equals("O") && maze[i - 1][j].equals("O") && maze[i][j + 1].equals("O") && maze[i][j - 1].equals("O")){
                        if(maze[i + 1][j + 1].equals("O")){

                            number_of_plus_O += 1;
                        }
                        if(maze[i + 1][j - 1].equals("O")){
                            number_of_plus_O += 1;
                        }
                        if(maze[i - 1][j + 1].equals("O")){
                            number_of_plus_O += 1;
                        }
                        if(maze[i - 1][j - 1].equals("O")){
                            number_of_plus_O += 1;
                        }
                        if(number_of_plus_O <= 2) {
                            if (number_of_plus_O > 0) {
                                maze[i][j] = "O";
                            }
                        }
                    }
                }
            }
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
            x = mytable.length - 1;
            y = (int) ((Math.random() * (mytable.length - 2))+ 1);
        }else if(myside == 1){
            y = (int) ((Math.random() * (mytable.length - 2))+ 1);
        }else if(myside == 2){
            x = (int) ((Math.random() * (mytable.length - 2))+ 1);
            y = mytable.length - 1;
        }else if(myside == 3){
            x = (int) ((Math.random() * (mytable.length - 2))+ 1);
        }
        return x + ":" + y;

    }
}


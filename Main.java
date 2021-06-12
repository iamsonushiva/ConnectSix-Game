package Connect6.Sonu;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;

    @Override
    // Mandatory to override Start method
    // Init & Stop are optional to override

    public void start(Stage primaryStage) throws Exception // Stage is outermost container of the app
    {
        System.out.println("Application Started");

        // Loader connects MyMain with FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("App_Layout.fxml"));
        GridPane rootGridPane = loader.load(); // Loads rootNode as GridPane

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();

        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        // Matches the menuBar width with primaryStage width

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        // Setting the scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect SIX Game");
        primaryStage.setResizable(false); // If you want to prevent the user from resizing the Stage
        primaryStage.show();
    }

    private MenuBar createMenu() {
        //File Menu
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame()); // Replaced with Lambda

        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame()); // Replaced with Lambda

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        // allows for a horizontal Separator to be embedded within it

        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        //Help Menu
        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Connect SIX");
        aboutGame.setOnAction(event -> aboutConnect6());
        SeparatorMenuItem separatorItem = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame, separatorItem, aboutMe);

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu); // Adding Menus to Menu Bar

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Shiv Shanker Singh");
        alert.setContentText("Hi! I am Shiv Shanker Singh, a Programmer focused on Creativity with simplicity ." +
                " I am an Electronics and Communication Engineer in Hyderabad . " +
                " I have a passionate interest towards programming. " +
                " My hobbies are Gardening , Watching web series and playing Cricket.  " +
                " I am An Active Volunteer too.");

        alert.show(); // To display the About section
    }

    private void aboutConnect6() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect SIX Game");
        alert.setHeaderText("How To Play ?");
        alert.setContentText("The Connect SIX Game Rules are easy to understand." +
                " In fact, it is in the name. To win Connect six, all you have to do" +
                " is to choose a color and then take turns dropping colored discs from" +
                " the top into a ten-column, nine-row vertically suspended grid." +
                " The pieces fall straight down, occupying the next available space within the column." +
                " The objective of this game is to connect six of your colored checker pieces in a row," +
                " much the same as tic tac toe. This can be done horizontally, vertically only" +
                " Each player will drop in one checker piece at a time. This will give you a chance" +
                " to either build your row, or stop your opponent from getting six in a row." +
                "\n\n" +
                "\tThe game is over either when you or your friend reaches six in a row," +
                " or when all  slots are filled, ending in a stalemate." +
                " If you and your friend decide to play again, the first player typically goes first." +
                " The rules of the game are easy to learn, but difficult to master." +
                " That is the beauty of Connect SIX . Now that you know the Connect SIX" +
                " board game rules, now is the time to challenge everyone you know." +
                " No matter their age or skill level, they can play this game with you." +
                " Now that you understand the rules, share Connect SIX with everyone around you." +
                " You’ll be glad you did.\n\n");

        alert.show();
    }

    private void exitGame() {
        Platform.exit(); // Closes the Virtual Machine
        System.exit(0); // Closes the Application
    }

    public static void main(String[] args) // Optional
    {
        launch(args);
    }
}


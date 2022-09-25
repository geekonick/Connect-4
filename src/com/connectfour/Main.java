package com.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Main extends Application {
    public Controller controller;

    @Override     //we use override feature when we use class interface i.e Application is class interface
    public void start(Stage primaryStage) throws Exception{ // This method will Set the stage for the FX-application and then start the app ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml")); // It will connect the Fxml file with the controller in order to gain access of fxml resources and control them ;
        GridPane rootGridPane = loader.load();

        controller=loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().addAll(menuBar);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Scene scene = new Scene(rootGridPane); // Setting scene whose object is Grid pane as grid pane is root of the current application
        primaryStage.setScene(scene); // setting primary stage whose object is Scene -> scene
        primaryStage.setTitle("Connecting Block");// Setting title of the application
        primaryStage.setResizable(false); //Setting App to non resizabele form
        primaryStage.show();// This will show up the Application


    }

    private MenuBar createMenu(){ //This method will create a menu bar and then will return it.
        //File Menu
        Menu fileMenu = new Menu("File");//creating option of file in menu bar i.e. ,creating object of file menu.

        MenuItem newGame = new MenuItem("New Game");//creating option of New game in File menu i.e. ,creating object of New game .
        newGame.setOnAction(event -> {controller.resetGame();});//105
        MenuItem resetGame = new MenuItem("Reset Game");//creating option of New game in File menu i.e. ,creating object of New game
        resetGame.setOnAction(event -> {controller.resetGame();});//105
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");//creating option of Exit game in File menu i.e. ,creating object of Exit game
        exitGame.setOnAction(event -> { exitGame();});//105

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);//adding menu items to the field menu pane

        //Help Menu
        Menu helpMenu = new Menu("Help");//creating option of Help menu in menu bar i.e. ,creating object of Help Menu

        MenuItem aboutMenu = new MenuItem("About Connecting Block");//creating option of About game in Help menu i.e. ,creating object of About Game
        aboutMenu.setOnAction(event -> {aboutConnect4();});//105
        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");//creating option of About Developer in Help menu i.e. ,creating object of About developer
        aboutMe.setOnAction(event -> {aboutMe();}); //105

        helpMenu.getItems().addAll(aboutMenu,separatorMenuItem1,aboutMe);//adding about game & about developer objects to help menu pane

        MenuBar menuBar = new MenuBar();// creating object of menu bar
        menuBar.getMenus().addAll(fileMenu,helpMenu);// adding file menu and help menu to menu bar

        return menuBar;

    }

    private void aboutMe() {// The menu option will pop
        Alert alert = new Alert(Alert.AlertType.INFORMATION);//
        alert.setTitle("About The Developer");
        alert.setHeaderText("Nikhil Anand");
        alert.setContentText("Simply , I Love Java and also I do like building using it.");

        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connecting Blocks");
        alert.setHeaderText("How To Play ?");
        alert.setContentText("Connecting Blocks is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");

        alert.show();

    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        //TODO
    }


    public static void main(String[] args) {
        launch(args);
    }
}
/*
setOnAction --> This will ensure that on clicking that particular item it may lead to perform certain action as per directed to it ;
seperatorMenuItem --> This piece of code will create a menu seperator between menu Options ;

*/

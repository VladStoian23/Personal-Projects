package main;

import gui.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import repository.Repository;
import service.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(Main.class.getResource("/gui/ui.fxml"));

        Repository repo = new Repository();
        Service service = new Service(repo);
        /*Controller firstController=new Controller(service);
        firstLoader.setController(firstController);
        Scene firstScene = new Scene (firstLoader.load());
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Window 1");
        primaryStage.show();
*/
        //second stage
        Stage secondStage=new Stage();
        FXMLLoader secondLoader = new FXMLLoader(Main.class.getResource("/gui/ui.fxml"));
        Controller secondController = new Controller(service);
        secondLoader.setController(secondController);
        Scene secondScene=new Scene(secondLoader.load());

        secondStage.setTitle("window 2");
        secondStage.setScene(secondScene);
        secondStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
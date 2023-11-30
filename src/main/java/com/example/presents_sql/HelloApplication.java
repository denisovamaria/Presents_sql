package com.example.presents_sql;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        primaryStage.setTitle("Present shop");

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.nguyenninh.letterfrequency;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image icon = new Image(getClass().getResource("/image/logo.png").toExternalForm());
        stage.getIcons().add(icon);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_activity.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Letter Frequency");
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
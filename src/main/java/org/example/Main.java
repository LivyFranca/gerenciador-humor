package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // O Maven busca direto da raiz da pasta resources/view
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));

        primaryStage.setTitle("Gerenciador de Rotina + Humor");
        primaryStage.setScene(new Scene(root, 450, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

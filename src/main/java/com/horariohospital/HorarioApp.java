package com.horariohospital;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HorarioApp extends Application {

    @Override
    public void start(Stage stage){

        Label titulo = new Label("Horario del Hospital");

        Button boton = new Button("Generar Horario");

        VBox root = new VBox(20, titulo, boton);

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Horario Hospital");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
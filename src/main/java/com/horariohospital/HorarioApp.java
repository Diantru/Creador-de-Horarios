package com.horariohospital;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class HorarioApp extends Application {

    @Override
    public void start(Stage stage){

        Label titulo = new Label("Horario del Hospital");

        ComboBox<Month> comboMes = new ComboBox<>();

        comboMes.getItems().addAll(Month.values());

        comboMes.setValue(LocalDate.now().getMonth());

        ComboBox<Integer> comboAño = new ComboBox<>();

        for (int año = 2025; año <= 2025; año++){
            comboAño.getItems().add(año);
        }

        comboAño.setValue(LocalDate.now().getYear());

        Button boton = new Button("Generar Horario");

        HBox controles = new HBox(10, comboMes, comboAño, boton);

        TableView<Persona> tabla = new TableView<>();

        Turno turnoManana = new Turno("07:00 - 15:00",
            LocalTime.of(7,0), LocalTime.of(15,0)
        );

        Turno turnoLargo = new Turno("07:00 - 19:00",
            LocalTime.of(7,0), LocalTime.of(19,0)
        );

        Turno turnoNoche = new Turno("19:00 - 07:00",
            LocalTime.of(19,0), LocalTime.of(7,0)
        );

        boton.setOnAction(event -> {

            Month mes = comboMes.getValue();

            int año = comboAño.getValue();

            LocalDate fecha = LocalDate.of(año, mes, 1);

            int cantidadDias = fecha.lengthOfMonth();

            generarDias(tabla, año, mes);

            System.out.println("El mes tiene " + cantidadDias + " días");
        });

        TableColumn<Persona, String> columnaNombre = new TableColumn<>("PERSONAL");

        columnaNombre.setCellValueFactory(
            new PropertyValueFactory<>("nombre")
        );

        columnaNombre.setPrefWidth(180);

        VBox root = new VBox(20, titulo, controles, tabla);

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Horario Hospital");
        stage.setScene(scene);
        stage.show();

    }

    private void generarDias(TableView<Persona> tabla, int año, Month mes){

        //Eliminamos las columnas de días anteriores
        while (tabla.getColumns().size() > 1){
            tabla.getColumns().remove(1);
        }

        LocalDate primerDia = LocalDate.of(año, mes, 1);

        int cantidadDias = primerDia.lengthOfMonth();

        for (int dia = 1; dia <= cantidadDias; dia++){
            LocalDate fecha = LocalDate.of(año, mes, dia);

            String nombreDia = fecha
            .getDayOfWeek().getDisplayName(
                TextStyle.SHORT, Locale.forLanguageTag("es")
            );

            TableColumn<Persona, String> columna = 
                new TableColumn<>(dia + " " + nombreDia);

            columna.setUserData(fecha);

            columna.setPrefWidth(100);

            tabla.getColumns().add(columna);
        }
    }

    public static void main(String[] args){
        launch();
    }
}
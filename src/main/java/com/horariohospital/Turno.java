package com.horariohospital;

import java.time.Duration;
import java.time.LocalTime;

public class Turno {

    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Turno(String nombre, LocalTime horaInicio, LocalTime horaFin) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    public double CalcularHoras(){

        Duration duracion;

        if (horaFin.isAfter(horaInicio)){

            duracion = Duration.between(horaInicio, horaFin);
        } else {

            //El turno pasa de un día al siguiente
            duracion = Duration.between(horaInicio, LocalTime.MIDNIGHT).plus(Duration.between(LocalTime.MIDNIGHT, horaFin));
        }

        return duracion.toMinutes() / 60.0;
    }

    @Override 
    public String toString(){
        return nombre;
    }
}

package com.horariohospital;

import java.time.LocalDate;

public class Asignacion {

    private Persona persona;
    private LocalDate fecha;
    private Turno turno;

    public Asignacion(Persona persona, LocalDate fecha, Turno turno) {
        this.persona = persona;
        this.fecha = fecha;
        this.turno = turno;
    }

    public Persona getPersona() {
        return persona;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Turno getTurno() {
        return turno;
    }
}

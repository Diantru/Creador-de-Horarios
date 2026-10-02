package com.horariohospital;

public class Persona {

    private String nombre;
    private String cargo;

    public Persona(String nombre, String cargo){
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCargo(){
        return cargo;
    }

    @Override 
    public String toString(){
        return nombre + " - " + cargo;
    }
}

package com.alldata.abstractas;

public abstract class Animal {

    protected String nombre;
    public Animal(String nombre){
        this.nombre=nombre;
    }

    abstract void hacerSonido();

    public void dormir(){
        System.out.println(nombre+ " "+ "esta durmiendo.");
    }
}

package com.alldata.abstractas;

public class Perro extends  Animal{

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    void hacerSonido() {
        System.out.println(nombre + "dice BARK BARK!");
    }

}

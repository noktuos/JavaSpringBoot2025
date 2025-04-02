package com.alldata.patrones.factory;

public class Moto implements Vehiculo{
    @Override
    public void conducir() {
        System.out.println("Conduciendo una MOTO!");
    }
}

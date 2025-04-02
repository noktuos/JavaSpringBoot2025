package com.alldata.patrones.factory;

public class Coche implements Vehiculo{
    @Override
    public void conducir() {
        System.out.println("Conduciendo un COCHE!");
    }
}

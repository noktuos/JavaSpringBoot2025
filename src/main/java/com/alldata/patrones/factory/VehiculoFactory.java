package com.alldata.patrones.factory;

public class VehiculoFactory {
    public static Vehiculo crearVehiculo(String tipo){
        switch (tipo){
            case("coche"):
                return  new Coche();
            case("moto"):
                return new Moto();
            default:
                throw new IllegalArgumentException("Tipo de vehiculo incorrecto");
        }
    }
}

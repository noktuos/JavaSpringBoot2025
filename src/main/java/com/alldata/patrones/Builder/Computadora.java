package com.alldata.patrones.Builder;

public class Computadora {

    // Atributos obligatorios
    private String procesador;
    private int ram;
    // Atributos opcionales
    private int almacenamiento;
    private boolean tarjetaGrafica;

    // Constructor privado para forzar el uso del Builder
    private Computadora(Builder builder) {
        this.procesador = builder.procesador;
        this.ram = builder.ram;
        this.almacenamiento = builder.almacenamiento;
        this.tarjetaGrafica = builder.tarjetaGrafica;
    }

    // Clase interna Builder
    public static class Builder {
        // Atributos obligatorios
        private final String procesador;
        private final int ram;
        // Atributos opcionales
        private int almacenamiento = 256; // valor por defecto
        private boolean tarjetaGrafica = false;

        public Builder(String procesador, int ram) {
            this.procesador = procesador;
            this.ram = ram;
        }

        public Builder setAlmacenamiento(int almacenamiento) {
            this.almacenamiento = almacenamiento;
            return this;
        }

        public Builder setTarjetaGrafica(boolean tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        public Computadora build() {
            return new Computadora(this);
        }
    }

    @Override
    public String toString() {
        return "Computadora [procesador=" + procesador + ", ram=" + ram +
                ", almacenamiento=" + almacenamiento + ", tarjetaGrafica=" + tarjetaGrafica + "]";
    }

}

package com.alldata.patrones;

public class Singleton {
    private static Singleton instancia;

    private Singleton() {
    }
    // Método público y sincronizado para obtener la instancia única
    public static synchronized Singleton getInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }

    public void mostrarMensaje() {
        System.out.println("Hola, soy el Singleton");
    }
}

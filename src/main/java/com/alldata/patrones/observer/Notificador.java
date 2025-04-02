package com.alldata.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class Notificador {
    private List<Observador> observadores = new ArrayList<>();
    private String mensaje;

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar(mensaje);
        }
    }
}

package com.alldata.patrones.decorator;

public class NotificacionDecorator implements Notificacion{
    protected Notificacion notificacionDecorada;

    public NotificacionDecorator(Notificacion notificacion) {
        this.notificacionDecorada = notificacion;
    }

    public void enviar(String mensaje) {
        notificacionDecorada.enviar(mensaje);
    }
}

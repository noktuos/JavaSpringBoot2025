package com.alldata.patrones.decorator;

public class NotificacionConLog  extends NotificacionDecorator{
    public NotificacionConLog(Notificacion notificacion) {
        super(notificacion);
    }
    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        registrarLog(mensaje);
    }

    private void registrarLog(String mensaje) {
        System.out.println("Registrando log: " + mensaje);
    }
}

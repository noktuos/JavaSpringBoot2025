package com.alldata.JavaCourse2025.DTO;/*
 * @created 12/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import java.time.LocalDateTime;

public class MensajeExceptionDTO {

    private String mensaje;
    private int codigoError;
    private LocalDateTime timestamp;

    public MensajeExceptionDTO(String mensaje, int codigoError) {
        this.mensaje = mensaje;
        this.codigoError = codigoError;
        this.timestamp = LocalDateTime.now();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

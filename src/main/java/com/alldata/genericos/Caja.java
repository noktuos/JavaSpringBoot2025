package com.alldata.genericos;

public class Caja<T> {
    private T objeto;

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
}

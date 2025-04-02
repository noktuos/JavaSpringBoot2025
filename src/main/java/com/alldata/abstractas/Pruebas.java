package com.alldata.abstractas;

import org.json.JSONObject;

public class Pruebas {

    public double operacion(){
        int resultado = 0;
        try{
             resultado = 0 / 10;
        }catch(ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
        }
        return resultado;
    }

}

package Actividad_6;

import java.io.Serializable;

public class Fecha implements Serializable {
    private int dia, mes, año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAño() { return año; }
}
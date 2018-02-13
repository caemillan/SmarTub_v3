package com.example.mil_asus.smartub;

/**
 * Created by Mil_ASUS on 13/2/2018.
 */

public class SmartubeData {

    String Hora;
    int smartub1;

    public SmartubeData() {
    }

    public SmartubeData(String hora, int smartub1) {
        Hora = hora;
        this.smartub1 = smartub1;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public int getSmartub1() {
        return smartub1;
    }

    public void setSmartub1(int smartub1) {
        this.smartub1 = smartub1;
    }
}

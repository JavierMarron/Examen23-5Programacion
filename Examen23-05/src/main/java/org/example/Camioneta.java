package org.example;

public class Camioneta extends Vehiculo{
    int pesoMax;

    public Camioneta(String marca, String modelo, String matricula, float kilometraje, float precio, String tipo, Boolean disponible, int pesoMax) {
        super(marca, modelo, matricula, kilometraje, precio, tipo, disponible);
        if (pesoMax>=3500 && pesoMax<=7500){
            this.pesoMax = pesoMax;
        }else {
            this.pesoMax = 0;
        }

    }

    public int getPesoMax() {
        return pesoMax;
    }

    public boolean setPesoMax(int pesoMax) {
        boolean estado=true;

        if (pesoMax>=3500 && pesoMax<=7500){
            this.pesoMax = pesoMax;
        }else {
            estado=false;
        }

        return estado;
    }


    @Override
    public float facturaAlquiler(int kms) {
        float pagar = 0f;

        if (pesoMax>5000){
            pagar = precio * kms ;
            pagar += (pagar * 0.3f);
        } else if (pesoMax == 0) {
            pagar = -1f;
        } else {
            pagar = precio * kms;
        }

        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%f;%s;%f;%b;%s;%d",marca, modelo, kilometraje, matricula, precio, disponible, tipo ,pesoMax);
    }
}

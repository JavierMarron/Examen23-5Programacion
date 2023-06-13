package org.example;

public class Moto extends Vehiculo{
    int cilindrada;

    public Moto(String marca, String modelo, String matricula, float kilometraje, float precio, String tipo, Boolean disponible, int cilindrada) {
        super(marca, modelo, matricula, kilometraje, precio, tipo, disponible);
        this.cilindrada = cilindrada;

    }


    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public float facturaAlquiler(int kms) {
        float pagar=0f;

        if (cilindrada>= 500){
            pagar = kms * precio;
            pagar += (pagar * 0.2f);
        }else {
            pagar = kms * precio;
        }

        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%f;%s;%f;%b;%s;%d",marca, modelo, kilometraje, matricula, precio, disponible, tipo, cilindrada);
    }
}

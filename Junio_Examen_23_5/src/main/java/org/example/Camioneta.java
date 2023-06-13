package org.example;

public class Camioneta extends Vehiculo{
    int pesoMax;
    public Camioneta(String marca, String modelo, String matricula, int km, int precio, int pesoMax) {
        super(marca, modelo, matricula, "Camioneta", km, precio);
        if (pesoMax>=3500 && pesoMax<=7500){
            this.pesoMax=pesoMax;
        }else {
            this.pesoMax=0;
        }
    }

    @Override
    public float facturaAlquiler(int kms) {
        float pagar=0;

        pagar = kms * precio;
        if (pesoMax>=5000){
            pagar += pagar*0.3f;
        }
        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%d;%s;%d;%b;%s;%d",marca, modelo, km, matricula, precio, disponible, tipo, pesoMax);

    }

    public int getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(int pesoMax) {
        if (pesoMax>=3500 && pesoMax<=7500){
            this.pesoMax=pesoMax;
        }
    }
}

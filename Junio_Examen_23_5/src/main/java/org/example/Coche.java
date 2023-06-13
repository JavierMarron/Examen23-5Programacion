package org.example;

public class Coche extends Vehiculo{
    int pasajeros;
    public Coche(String marca, String modelo, String matricula, int km, int precio, int pasajeros) {
        super(marca, modelo, matricula, "Coche", km, precio);
        if (pasajeros>1 && pasajeros<8){
            this.pasajeros=pasajeros;
        }else {
            this.pasajeros=5;
        }
    }

    @Override
    public float facturaAlquiler(int kms) {
        float pagar=0;

        pagar = kms * precio;
        if (pasajeros==6 || pasajeros==7){
            pagar += pagar*0.1f;
        }
        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%d;%s;%d;%b;%s;%d ",marca, modelo, km, matricula, precio, disponible, tipo, pasajeros);

    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        if (pasajeros>1 && pasajeros<8){
            this.pasajeros=pasajeros;
        }
    }
}

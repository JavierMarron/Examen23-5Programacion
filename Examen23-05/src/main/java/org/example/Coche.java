package org.example;

public class Coche extends Vehiculo{
    int pasajeros;
    public Coche(String marca, String modelo, String matricula, float kilometraje, float precio, String tipo, Boolean disponible, int pasajeros) {
        super(marca, modelo, matricula, kilometraje, precio, tipo, disponible);
        if(pasajeros>=2 && pasajeros<=7){ //Valor correcto
            this.pasajeros=pasajeros;
        }else {
            this.pasajeros=5;
        }
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        if(pasajeros>=2 && pasajeros<=7){ //Valor correcto
            this.pasajeros=pasajeros;
        }
    }

    @Override
    public float facturaAlquiler(int kms) {
        float pagar=0f;

        if (pasajeros==6 || pasajeros==7){
            pagar= kms * precio;
            pagar += (pagar * 0.1f);
        }else {
            pagar= kms * precio;
        }

        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%f;%s;%f;%b;%s;%d",marca, modelo, kilometraje, matricula, precio, disponible, tipo, pasajeros);

    }
}

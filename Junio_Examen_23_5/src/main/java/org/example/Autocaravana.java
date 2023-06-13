package org.example;

public class Autocaravana extends Vehiculo{
    int camas;
    public Autocaravana(String marca, String modelo, String matricula, int km, int precio, int camas) {
        super(marca, modelo, matricula, "Autocaravana", km, precio);
        if (camas>=1 && camas<=6){
            this.camas= camas;
        }else {
            this.camas=0;
        }
    }

    @Override
    public float facturaAlquiler(int kms) {
        float pagar=0;

        pagar = kms * precio;
        if (camas>=5){
            pagar += pagar*0.15f;
        }
        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%d;%s;%d;%b;%s;%d",marca, modelo, km, matricula, precio, disponible, tipo, camas);

    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        if (camas>=1 && camas<=6){
            this.camas= camas;
        }
    }
}

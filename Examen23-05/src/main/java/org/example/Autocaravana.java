package org.example;

public class Autocaravana extends Vehiculo{
 int camas;

    public Autocaravana(String marca, String modelo, String matricula, float kilometraje, float precio, String tipo, Boolean disponible, int camas) {
        super(marca, modelo, matricula, kilometraje, precio, tipo, disponible);
        if (camas>=1 && camas<=6){
            this.camas = camas;
        }else {
            this.camas = 0;
        }
    }

    public int getCamas() {
        return camas;
    }

    public boolean setCamas(int camas) {
        boolean estado= true;

        if (camas>=1 && camas<=6){
            this.camas = camas;
        }else {
            estado= false;
        }

        return estado;
    }

    @Override
    public float facturaAlquiler(int kms) {
        float pagar=0f;

        if (camas>=5){
            pagar= kms * precio ;
            pagar= (pagar*0.15f);
        }else if (camas==0){
            pagar = -1f;
        }else {
            pagar= kms * precio;
        }

        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%f;%s;%f;%b;%s;%d",marca, modelo, kilometraje, matricula, precio, disponible, tipo, camas);
    }
}

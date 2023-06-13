package org.example;

public class Moto extends Vehiculo{
    int cilindrada;
    public Moto(String marca, String modelo, String matricula, int km, int precio, int cilindrada) {
        super(marca, modelo, matricula, "Moto", km, precio);
        this.cilindrada=cilindrada;
    }

    @Override
    public float facturaAlquiler(int kms) {
        float pagar=0;

        pagar = kms * precio;
        if (cilindrada>=500){
            pagar += pagar*0.2f;
        }
        return pagar;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%d;%s;%d;%b;%s;%d ",marca, modelo, km, matricula, precio, disponible, tipo, cilindrada);
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}

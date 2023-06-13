package org.example;

public abstract class Vehiculo {
    String marca, modelo, matricula, tipo;
    int km; int precio;
    boolean disponible;

    public Vehiculo(String marca, String modelo, String matricula, String tipo, int km, int precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipo = tipo;
        if (km>=0){
            this.km = km;
        }else {
            this.km = 0;
        }

        this.precio = precio;
        disponible = true;
    }

    abstract public float facturaAlquiler(int kms);

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%d;%s;%d;%b;%s",marca, modelo, km, matricula, precio, disponible, tipo);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        if (km>=0){
            this.km += km;
        }
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

package org.example;

public abstract class Vehiculo {
    protected String marca, modelo, matricula;
    protected float kilometraje=0f,precio;
    protected String  tipo; //(será un valor entre los siguientes: moto, coche, camioneta y autocaravana)
    protected Boolean disponible=true;

    public Vehiculo(String marca, String modelo, String matricula, float kilometraje, float precio, String tipo, Boolean disponible) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = disponible;
        if (kilometraje>=0){
            this.kilometraje = kilometraje;
        }else{
            this.kilometraje = 0;
        }

    }
    abstract public float facturaAlquiler(int kms);

    @Override
    public String toString() {
        return String.format("VEHICULO:%s;%s;%f;%s;%f;%b;%s",marca, modelo, kilometraje, matricula, precio, disponible, tipo);
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

    public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        if (kilometraje>=0){
            this.kilometraje += kilometraje;
        }
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}

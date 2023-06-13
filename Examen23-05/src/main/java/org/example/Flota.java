package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Flota {
    String nombreGerente, dniGerente , emailGerente;
    HashMap<String, Vehiculo> lVehiculos;
    ArrayList<Vehiculo> Lvehiculos;

    public Flota(String nombreGerente, String dniGerente, String emailGerente) {
        this.nombreGerente = nombreGerente;
        this.dniGerente = dniGerente;
        this.emailGerente = emailGerente;
        lVehiculos = new HashMap<String, Vehiculo>();
        Lvehiculos = new ArrayList<>();
    }
    @Override
    public String toString() {
        return String.format("%s;%s;%s", nombreGerente, dniGerente, emailGerente);
    }

    public ArrayList<Moto> motosDisponibles(){
        ArrayList<Moto> Lmotos = new ArrayList<>();

        for (int i=0; i< Lvehiculos.size();i++){
            if (Lvehiculos.get(i).getTipo().equals("Moto")){ //Este vehiculo es una moto
                if (Lvehiculos.get(i).getDisponible()){ //La moto esta disponible
                    Lmotos.add((Moto) Lvehiculos.get(i));
                }
            }
        }

        Lmotos.sort(new ComparaCilindrada());

        return Lmotos;
    }

    public ArrayList<Coche> cochesDisponibles(){
        ArrayList<Coche> Lcoches = new ArrayList<>();

        for (int i=0; i< Lvehiculos.size();i++){
            if (Lvehiculos.get(i).getTipo().equals("Coche")){ //Este vehiculo es una moto
                if (Lvehiculos.get(i).getDisponible()){ //La moto esta disponible
                    Lcoches.add((Coche) Lvehiculos.get(i));
                }
            }
        }

        Lcoches.sort(new ComparaPrecio());

        return Lcoches;
    }

    public ArrayList<Camioneta> camionetasDisponibles(){
        ArrayList<Camioneta> Lcamionetas = new ArrayList<>();

        for (int i=0; i< Lvehiculos.size();i++){
            if (Lvehiculos.get(i).getTipo().equals("Camioneta")){ //Este vehiculo es una moto
                if (Lvehiculos.get(i).getDisponible()){ //La moto esta disponible
                    Lcamionetas.add((Camioneta) Lvehiculos.get(i));
                }
            }
        }

        Lcamionetas.sort(new ComparaPeso());

        return Lcamionetas;
    }

    public ArrayList<Autocaravana> autocaravanasDisponibles(){
        ArrayList<Autocaravana> Lautocaravana = new ArrayList<>();

        for (int i=0; i< Lvehiculos.size();i++){
            if (Lvehiculos.get(i).getTipo().equals("Autocaravana")){ //Este vehiculo es una moto
                if (Lvehiculos.get(i).getDisponible()){ //La moto esta disponible
                    Lautocaravana.add((Autocaravana) Lvehiculos.get(i));
                }
            }
        }

        Lautocaravana.sort(new ComparaCama());

        return Lautocaravana;
    }

    public Vehiculo crearVehiculo(String[] datosAtributos, String tipo){
        String marca = datosAtributos[0];
        String modelo = datosAtributos[1];
        float kilometraje = Float.parseFloat(datosAtributos[2]);
        String matricula = datosAtributos[3];
        float precio = Float.parseFloat(datosAtributos[4]);
        boolean disponible = Boolean.parseBoolean(datosAtributos[5]);
        int atribEsp = Integer.parseInt(datosAtributos[7]);
        //marca;modelo;kilometraje;matricula;precio;disponible;tipo;pasajeros

        switch (tipo){
            case "Coche" -> {
                return new Coche(marca, modelo, matricula, kilometraje, precio, tipo, disponible, atribEsp);
            }
            case "Moto" -> {
                return new Moto(marca, modelo, matricula, kilometraje, precio, tipo, disponible, atribEsp);
            }
            case "Camioneta" -> {
                return new Camioneta(marca, modelo, matricula, kilometraje, precio, tipo, disponible, atribEsp);
            }
            case "Autocaravana" -> {
                return new Autocaravana(marca, modelo, matricula, kilometraje, precio, tipo, disponible, atribEsp);
            }
        }
        return null;
    }

    public boolean putVehiculo(Vehiculo v){
        boolean estado=true;
        try {
            if (lVehiculos.putIfAbsent(v.getMatricula(), v) == null){
                lVehiculos.replace(v.getMatricula(), v);
            }

            for (int i=0; i< Lvehiculos.size();i++){
                if (v.getMatricula().equals(Lvehiculos.get(i).getMatricula())){ //Si nueva mat es igual a mat ant.
                    Lvehiculos.remove(i);
                }
            }
            Lvehiculos.add(v);


        }catch (Exception e){
            estado=false;
        }

        return estado;
    }

    public float facturarVehiculo(String matricula, int kms) {
        float pagar = 0f;

        try {
            pagar = lVehiculos.get(matricula).facturaAlquiler(kms);

            int index = -1;
            for (int i = 0; i < Lvehiculos.size(); i++) {
                if (matricula.equals(Lvehiculos.get(i).getMatricula())) {
                    index = i;
                }
            }
            lVehiculos.get(matricula).setKilometraje(kms);
            Lvehiculos.get(index).setKilometraje(kms);

            lVehiculos.get(matricula).setDisponible(true);
            Lvehiculos.get(index).setDisponible(true);
        }catch (Exception e){
            pagar= -1f;
        }

        return pagar;
    }

    public boolean alquilarVehiculo(String matricula){
        boolean estado=true;
        try {
            lVehiculos.get(matricula).setDisponible(false);
            for (int i=0; i<Lvehiculos.size();i++){
                if (matricula.equals(Lvehiculos.get(i).getMatricula())) {
                    Lvehiculos.get(i).setDisponible(false);
                }
            }
        }catch (Exception e){
            estado=false;
        }

        return estado;
    }
    public String getNombreGerente() {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }

    public String getDniGerente() {
        return dniGerente;
    }

    public void setDniGerente(String dniGerente) {
        this.dniGerente = dniGerente;
    }

    public String getEmailGerente() {
        return emailGerente;
    }

    public void setEmailGerente(String emailGerente) {
        this.emailGerente = emailGerente;
    }

    public HashMap<String, Vehiculo> getlVehiculos() {
        return lVehiculos;
    }

    public ArrayList<Vehiculo> getLvehiculos() {
        return Lvehiculos;
    }
}

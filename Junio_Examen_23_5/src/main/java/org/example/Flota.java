package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Flota {
    String nombreGerente;
    String dniGerente;
    String emailGerente;
    HashMap<String,Vehiculo> mVehiculos;

    public Flota(String nombreGerente, String dniGerente, String emailGerente) {
        this.nombreGerente = nombreGerente;
        this.dniGerente = dniGerente;
        this.emailGerente = emailGerente;
        mVehiculos = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s ",nombreGerente, dniGerente, emailGerente);
    }

    public Moto[] motosDisponible(){
        ArrayList<Moto> lMoto = new ArrayList<>();
        mVehiculos.forEach((key, vehiculo) -> {

            if (vehiculo.getTipo().equals("Moto")){ //Es una moto
                if (vehiculo.isDisponible()){ //Esta diponible
                    lMoto.add((Moto) vehiculo);
                }
            }
        });
        lMoto.sort(new ComparaCilindrada());
        Moto[] lista = new Moto[lMoto.size()];
        for (int i=0; i<lista.length;i++){
            lista[i]=lMoto.get(i);
        }

        return lista;
    }

    public Coche[] cochesDisponible(){
        ArrayList<Coche> lCoche = new ArrayList<>();
        mVehiculos.forEach((key, vehiculo) -> {
            if (vehiculo.getTipo().equals("Coche")){
                if (vehiculo.isDisponible()){
                    lCoche.add((Coche) vehiculo);
                }
            }
        });
        lCoche.sort(new ComparaPrecio());
        Coche[] lista = new Coche[lCoche.size()];
        for (int i=0; i<lista.length;i++){
            lista[i]=lCoche.get(i);
        }

        return lista;
    }

    public Camioneta[] camionetasDisponible(){
        ArrayList<Camioneta> lCamioneta = new ArrayList<>();
        mVehiculos.forEach((key, vehiculo) -> {
            if (vehiculo.getTipo().equals("Camioneta")){
                if (vehiculo.isDisponible()){
                    lCamioneta.add((Camioneta) vehiculo);
                }
            }
        });
        lCamioneta.sort(new ComparaPeso());
        Camioneta[] lista = new Camioneta[lCamioneta.size()];
        for (int i=0; i<lista.length;i++){
            lista[i]=lCamioneta.get(i);
        }

        return lista;
    }

    public Autocaravana[] autocaravanasDisponible(){
        ArrayList<Autocaravana> lAutocaravana = new ArrayList<>();
        mVehiculos.forEach((key, vehiculo) ->{
            if (vehiculo.getTipo().equals("Autocaravana")){
                if (vehiculo.isDisponible()){
                    lAutocaravana.add((Autocaravana) vehiculo);
                }
            }
        });
        lAutocaravana.sort(new ComparaCama());
        Autocaravana[] lista = new Autocaravana[lAutocaravana.size()];
        for (int i=0; i<lista.length;i++){
            lista[i]=lAutocaravana.get(i);
        }

        return lista;
    }

    public Vehiculo crearVehiculo(String[] datosAtributos, String tipo){
        switch (tipo){
            //marca;modelo;kilometraje;matricula;precio;disponible;tipo;atributoEspecifico
            case "Moto":
                //String marca, String modelo, String matricula, int km, int precio, int cilindrada
                Moto m = new Moto(datosAtributos[0], datosAtributos[1], datosAtributos[3], Integer.parseInt(datosAtributos[2]), Integer.parseInt(datosAtributos[4]),Integer.parseInt(datosAtributos[7]));
                return m;
            case "Coche":
                //String marca, String modelo, String matricula, int km, int precio, int pasajeros
                Coche c = new Coche(datosAtributos[0], datosAtributos[1], datosAtributos[3], Integer.parseInt(datosAtributos[2]), Integer.parseInt(datosAtributos[4]),Integer.parseInt(datosAtributos[7]));
                return c;
            case "Camioneta":
                //String marca, String modelo, String matricula, int km, int precio, int pesoMax
                Camioneta ca = new Camioneta(datosAtributos[0], datosAtributos[1], datosAtributos[3], Integer.parseInt(datosAtributos[2]), Integer.parseInt(datosAtributos[4]),Integer.parseInt(datosAtributos[7]));
                return ca;
            case "Autocaravana":
                //String marca, String modelo, String matricula, int km, int precio, int camas
                Autocaravana a = new Autocaravana(datosAtributos[0], datosAtributos[1], datosAtributos[3], Integer.parseInt(datosAtributos[2]), Integer.parseInt(datosAtributos[4]),Integer.parseInt(datosAtributos[7]));
                return a;
        }
        return null;
    }

    public void putVehiculo(Vehiculo v){
        mVehiculos.put(v.getMatricula(), v);
    }

    public float facturarVehiculo(String matricula, int kms){
        if(!mVehiculos.get(matricula).isDisponible()) {
            mVehiculos.get(matricula).setDisponible(true);
            mVehiculos.get(matricula).setKm(kms);
            return mVehiculos.get(matricula).facturaAlquiler(kms);
        }
        return 0;
    }

    public boolean alquilarVehiculo(String matricula){
        try {
            if (mVehiculos.get(matricula).isDisponible()){
                mVehiculos.get(matricula).setDisponible(false);
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public Vehiculo buscarVehiculo(String matricula){
        return mVehiculos.get(matricula);
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
}

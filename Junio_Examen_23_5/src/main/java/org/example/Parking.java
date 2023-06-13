package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parking {
    int diponibles, contador=0;
    HashMap<Vehiculo,Plaza> mparking;
    ArrayList<Plaza> lLibres;
    String nombreGerente, dniGerente, emailGerente;

    public Parking(String nombreGerente, String dniGerente, String emailGerente) {
        this.nombreGerente = nombreGerente;
        this.dniGerente = dniGerente;
        this.emailGerente = emailGerente;
        mparking=new HashMap<>();
        lLibres=new ArrayList<>();
    }

    public int  crearPlaza(){
        contador++;
        lLibres.add(new Plaza(contador));
        diponibles= lLibres.size();
        return contador;
    }


    public int aparcarVehiculo(Vehiculo  v){
        int plaza=0; //El parking esta lleno, se retorna un cero.
        if (diponibles!=0){ //Siempre cogemos la primera plaza libre y la asignamos.
            plaza = lLibres.get(0).getNum();
            mparking.put(v , lLibres.get(0));
            lLibres.get(0).setLibre(false);
            lLibres.remove(0);
            diponibles= lLibres.size();
        }

        return plaza;
    }

    public int sacarVehiculo(Vehiculo  v, int dias){
        int precio=0;
        for (Map.Entry<Vehiculo, Plaza> entry : mparking.entrySet()) {
            Vehiculo vehiculo = entry.getKey();
            Plaza plaza = entry.getValue();
            if (vehiculo.getMatricula().equals(v.getMatricula())) {  //La matricula del vehiculo de la plaza coincide con la pasada.
                precio = dias * mparking.get(v).getPrecio();
                plaza.setLibre(true);
                lLibres.add(plaza);
                diponibles= lLibres.size();
                mparking.remove(plaza);
                break;
            }
        }
        return precio;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s ",nombreGerente, dniGerente, emailGerente);
    }
}

package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> misvehiculos= new ArrayList<>();
        Flota f = new Flota("Javier", "79112318J", "Mimail@gmail.com");

        Coche c = new Coche("marca", "modelo", "matricula", -1f, 10, "Coche", true, 6);
        Moto m = new Moto("marca", "modelo", "matricula", -1f, 10, "Moto", true, 6);

        if(f.putVehiculo(c)){
            System.out.println("bien");
        }
        f.putVehiculo(m);
        misvehiculos= f.getLvehiculos();

        /*for (int i=0; i< misvehiculos.size();i++){
            System.out.println(misvehiculos.get(i).getTipo());
        }*/

        /*Coche c = new Coche("marca", "modelo", "matricula", -1f, 10, "Coche", true, 6); //Todo correcto
        System.out.println(c.facturaAlquiler(100));

        System.out.println(c.toString());

        Moto m = new Moto("marca", "modelo", "matricula", -1f, 10, "Moto", true, 6);
        System.out.println(m.facturaAlquiler(100));

        System.out.println(m.toString());*/

        System.out.println(f.toString());


    }
}
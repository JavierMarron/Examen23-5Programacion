package org.example;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class ControladorVehiculos {

    static boolean grabarAFichero(String fichero, Flota miFlota){
        boolean estado =true;
        PrintWriter out = null;
        ArrayList<Vehiculo> lista = new ArrayList<>();
        String texto="";

        lista=miFlota.Lvehiculos;
        for (int i=0; i<lista.size();i++){
            texto+= lista.get(i).toString();
            texto+="\n";
        }

        try {
            out = new PrintWriter(new FileWriter("/Users/javiermarrondellanoramirez/Desktop/"+fichero, true));
            out.println(texto);
        }catch (Exception exception){
            estado = false;
        }finally {
            if (out != null){
                out.close();
            }
        }

        return estado;
    }

    static ArrayList<Integer>  leerDeFichero(String fichero, Flota miFlota){
        ArrayList<Integer> lLineas= new ArrayList<>();
        String contenido="";
        Scanner in = null;

        try {
            in = new Scanner(new FileReader("/Users/javiermarrondellanoramirez/Desktop/"+fichero));
            while (in.hasNext()){
                contenido+=in.nextLine();
            }

            String[] lines = contenido.split("\n");
            String[] atributos;

            for (int i = 0; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll("\n", "");
                atributos = lines[i].split(":")[1].split(";");

                Coche c;
                Moto m;
                Camioneta ca;
                Autocaravana a;

                switch (atributos[6]){
                    case "Coche" -> {
                        c = (Coche) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(c);
                        c= null;
                        lLineas.add(i);
                    }
                    case "Moto" -> {
                        m = (Moto) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(m);
                        m=null;
                        lLineas.add(i);
                    }
                    case "Camioneta" -> {
                        ca = (Camioneta) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(ca);
                        ca=null;
                        lLineas.add(i);
                    }
                    case "Autocaravana" -> {
                        a = (Autocaravana) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(a);
                        a=null;
                        lLineas.add(i);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e){
            lLineas = null;
        } finally {
            if(in!=null){
                in.close();
            }
        }

        return lLineas;
    }
}

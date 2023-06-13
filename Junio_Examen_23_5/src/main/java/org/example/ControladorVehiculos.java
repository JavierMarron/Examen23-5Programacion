package org.example;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
public class ControladorVehiculos {
    public ControladorVehiculos(){

    }
    static boolean grabarAFichero(String fichero, Flota miFlota){
        boolean estado =true;
        PrintWriter out = null;
        String texto = "";



        for (Map.Entry<String, Vehiculo> entry : miFlota.mVehiculos.entrySet()) {
            Vehiculo vehiculo = entry.getValue();
            texto += vehiculo.toString();
            texto += "\n";
        }

        try {
            out = new PrintWriter(new FileWriter("/Users/javiermarrondellanoramirez/Desktop/"+fichero, false));
            out.write("");
            out.print(texto);
        }catch (Exception exception){
            estado = false;
        }finally {
            if (out != null){
                out.close();
            }
        }

        return estado;
    }

    public static void leerDeFichero(String fichero, Flota miFlota){
        String contenido="";
        Scanner in = null;

        try {
            in = new Scanner(new FileReader("/Users/javiermarrondellanoramirez/Desktop/"+fichero));
            while (in.hasNext()){
                contenido+=in.nextLine();
            }

            String[] lines = contenido.split(" ");
            String[] atributos;

            for (int i = 0; i < lines.length; i++) {
                //lines[i] = lines[i].replaceAll("\n", "");
                atributos = lines[i].split(":")[1].split(";");


                miFlota.putVehiculo(miFlota.crearVehiculo(atributos, atributos[6]));
                /*Coche c;
                Moto m;
                Camioneta ca;
                Autocaravana a;

                switch (atributos[6]){
                    case "Coche" -> {
                        c = (Coche) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(c);

                    }
                    case "Moto" -> {
                        m = (Moto) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(m);

                    }
                    case "Camioneta" -> {
                        ca = (Camioneta) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(ca);
                        ca=null;
                    }
                    case "Autocaravana" -> {
                        a = (Autocaravana) miFlota.crearVehiculo(atributos, atributos[6]);
                        miFlota.putVehiculo(a);
                        a=null;
                    }
                }*/
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } finally {
            if(in!=null){
                in.close();
            }
        }
    }
}

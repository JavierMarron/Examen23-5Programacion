package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String teclado; String[] atributos = new String[8];
        int km=0, num;
        boolean repetirf = true, repetir=true, repetirp=true;
        Flota f; Parking p;
        String nomGer, dni, email;

        System.out.println("Creación del gerente");
        System.out.println("Dime el nombre del gerente:");
        nomGer = sc.nextLine();
        System.out.println("Dime su DNI:");
        dni = sc.nextLine();
        System.out.println("Dime su email:");
        email = sc.nextLine();
        f = new Flota(nomGer, dni, email);
        p= new Parking(nomGer, dni, email);
        sc.nextLine();
        while (repetir){
            mprincipal();
            teclado = sc.nextLine();

            switch (teclado){
                case "1":
                    while (repetirf) {    //FLOTA//
                        mflota();
                        teclado = sc.nextLine();
                        switch (teclado) {
                            case "1": //Muestra los datos del gerente.
                                System.out.println("Nombre: "+f.getNombreGerente()+" \nDNI: "+f.getDniGerente()+" \nEmail: "+f.getEmailGerente());
                                sc.nextLine();
                                break;
                            case "2": //Añadir vehiculo.
                                System.out.println("¿Que tipo de vehiculo es?");
                                System.out.println("Moto(m), Coche(c), Camioneta(ca) o Autocaravana(a)");
                                teclado=sc.nextLine();
                                sc.nextLine();
                                //marca;modelo;kilometraje;matricula;precio;disponible;tipo;atributoEspecifico
                                System.out.println("Dime la marca:");
                                atributos[0]=sc.nextLine();
                                System.out.println("Dime el modelo:");
                                atributos[1]= sc.nextLine();
                                System.out.println("Dime los kilometros:");
                                atributos[2]= sc.nextLine();
                                sc.nextLine();
                                System.out.println("Dime la matricula:");
                                atributos[3]=sc.nextLine();
                                System.out.println("Dime su precio:");
                                atributos[4]=sc.nextLine();
                                System.out.println("Dime si esta disponible(true/false):");
                                atributos[5]=sc.nextLine();
                                sc.nextLine();

                                switch (teclado){
                                    case "c": //Coche
                                        atributos[6]="Coche";
                                        System.out.println("Dime el num de pasajeros:");
                                        atributos[7]= sc.nextLine();
                                        break;
                                    case "m": //Moto
                                        atributos[6]="Moto";
                                        System.out.println("Dime la cilindrada:");
                                        atributos[7]=sc.nextLine();
                                        break;
                                    case "ca": //Camioneta
                                        atributos[6]="Camioneta";
                                        System.out.println("Dime el peso máximo:");
                                        atributos[7]=sc.nextLine();
                                        break;
                                    case "a": //Autocaravana
                                        atributos[6]="Autocaravana";
                                        System.out.println("Dime el num de camas:");
                                        atributos[7]=sc.nextLine();
                                        break;
                                }
                                f.putVehiculo(f.crearVehiculo(atributos, atributos[6]));
                                sc.nextLine();
                                break;
                            case "3": //Muestra los diponibles.
                                System.out.println("Dime de que tipo de vehiculo: ");
                                System.out.println("Moto(m), Coche(c), Camioneta(ca) o Autocaravana(a)");
                                teclado=sc.nextLine();
                                switch (teclado){
                                    case "m":
                                        Moto[] lmoto = f.motosDisponible();
                                        for (int i=0; i< lmoto.length;i++){
                                            System.out.println(lmoto[i].toString());
                                        }
                                        break;
                                    case "c":
                                        Coche[] lcoche = f.cochesDisponible();
                                        for (int i=0; i< lcoche.length;i++){
                                            System.out.println(lcoche[i].toString());
                                        }
                                        break;
                                    case "ca":
                                        Camioneta[] lcamioneta = f.camionetasDisponible();
                                        for (int i=0; i< lcamioneta.length;i++){
                                            System.out.println(lcamioneta[i].toString());
                                        }
                                        break;
                                    case "a":
                                        Autocaravana[] lautocaravana = f.autocaravanasDisponible();
                                        for (int i=0; i< lautocaravana.length;i++){
                                            System.out.println(lautocaravana[1].toString());
                                        }
                                        break;
                                }
                                sc.nextLine();
                                break;
                            case "4": //Alquila un vehiculo.
                                System.out.println("Dime la matricula del vehiculo:");
                                teclado=sc.nextLine();

                                if(f.alquilarVehiculo(teclado)){
                                    System.out.println("Todo bien!");
                                }else {
                                    System.out.println("Se ha encontrado un error.");
                                }
                                sc.nextLine();
                                break;
                            case "5": //Factura un vehiculo.
                                System.out.println("Dime la matricula del vehiculo:");
                                teclado=sc.nextLine();
                                System.out.println("Dime los km:");
                                km = sc.nextInt();

                                System.out.println("Total a pagar: "+f.facturarVehiculo(teclado,km)+"€");
                                sc.nextLine();
                                break;
                            case "6": //Guarda flota en fichero.
                                System.out.println("Dime el nombre del fichero");
                                teclado=sc.nextLine();

                                if(ControladorVehiculos.grabarAFichero(teclado, f)){
                                    System.out.println("Todo bien!");
                                }else {
                                    System.out.println("Se ha encontrado un error.");
                                }
                                sc.nextLine();
                                break;
                            case "7": //Lee flota de fichero.
                                System.out.println("Dime el nombre del fichero");
                                teclado=sc.nextLine();

                                ControladorVehiculos.leerDeFichero(teclado, f);
                                break;
                            default:
                                repetirf = false;
                                System.out.println("Saliendo...");
                                sc.nextLine();
                                break;
                        }
                    }
                    repetirf=true;
                    break;
                case "2":
                    while (repetirp){
                        mparking();
                        teclado= sc.nextLine();
                        switch (teclado){
                            case "1": //Crear plaza
                                System.out.println("Acabas de crear la plaza nº "+p.crearPlaza());
                                sc.nextLine();
                                break;
                            case "2": //Aparcar vehiculo
                                System.out.println("Dime la matricula del vehiculo");
                                teclado= sc.nextLine();
                                num=p.aparcarVehiculo(f.buscarVehiculo(teclado));
                                if (num==0){
                                    System.out.println("El parking esta lleno.");
                                }else {
                                    System.out.println("Su plaza es la "+num);
                                }
                                sc.nextLine();
                                break;
                            case "3": //Sacar vehiculo
                                System.out.println("Dime la matricula del vehiculo");
                                teclado= sc.nextLine();
                                System.out.println("Dime los días que llevas aparcado");
                                num=sc.nextInt();

                                System.out.println("Total a pagar: "+p.sacarVehiculo(f.buscarVehiculo(teclado), num));
                                sc.nextLine();
                                break;
                            default:
                                repetirp = false;
                                System.out.println("Saliendo...");
                                sc.nextLine();
                                break;
                        }
                    }
                    repetirp=true;
                    break;
                default:
                    repetir = false;
                    System.out.println("Saliendo...");
                    break;
            }
        }

    }


    public static void mflota(){
        System.out.println("===================================");
        System.out.println("Alquiler de Vehiculos:");
        System.out.println("===================================");
        System.out.println("1.- Muestra los datos del gerente.");
        System.out.println("2.- Añadir vehiculo.");
        System.out.println("3.- Muestra los diponibles.");
        System.out.println("4.- Alquila un vehiculo.");
        System.out.println("5.- Factura un vehiculo.");
        System.out.println("6.- Guarda flota en fichero.");
        System.out.println("7.- Lee flota de fichero.");
        System.out.println("SALIR.(Cualquier Tecla)");
    }

    public static void mparking(){
        System.out.println("===================================");
        System.out.println("Parking:");
        System.out.println("===================================");
        System.out.println("1.- Crear plaza.");
        System.out.println("2.- Aparcar vehiculo.");
        System.out.println("3.- Sacar vehiculo.");
        System.out.println("SALIR.(Cualquier Tecla)");
    }

    public static void mprincipal(){
        System.out.println("===================================");
        System.out.println("Menu:");
        System.out.println("===================================");
        System.out.println("1.- Entrar en alquiler.");
        System.out.println("2.- Entrar en parking.");
        System.out.println("SALIR.(Cualquier Tecla)");
    }
}
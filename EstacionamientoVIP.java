package com.mycompany.estacionamientovip;
import java.util.Scanner;

public class EstacionamientoVIP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
              
        Tickets ticket = new Tickets("","","","",""); //Almacenamiento del ticket actual
        Cajones cajones = new Cajones ();
        Caja caja = new Caja ();
        Estacionamiento estacionamiento = new Estacionamiento("marca","color","modelo","grande","placas");
        
        System.out.println("--------------BIENVENIDO A CARGUARD S.A-----------------");
        int opcion;
        do {
            System.out.println("\n........¿Qué quieres hacer?........\n");
            System.out.println("1. Ingresar Coche: ");
            System.out.println("2. Retirar Coche: ");
            System.out.println("3. Guardar status estacionamiento");
            System.out.println("4. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch(opcion){
                case 1:
                    estacionamiento.ingresarCoche(caja, ticket, cajones);
                    break;
                case 2:
                    //Opcion para retirar coche
                    estacionamiento.retirarVehiculo(caja, ticket, cajones);
                    
                    break;
                case 3:
                    estacionamiento.mostrarStatusEstacionamiento(ticket, cajones);
                 
                    break;
                case 4: 
                    //Opción para salir
                    System.out.println("Saliendo del programa. Hasta luego");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción valida"); 
        }
   }while (opcion != 4);
   
   scanner.close();
    }
}








    
    


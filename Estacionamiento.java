package com.mycompany.estacionamientovip;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Estacionamiento extends Vehiculo {

    
    public Estacionamiento(String marca, String color, String modelo, String tamanio, String placas) {
        super(marca, color, modelo, tamanio, placas);

    }
        //Case 1
    public void ingresarCoche(Caja caja, Tickets ticket, Cajones cajones){
        
        ticket.recolectarDatos();
        
        cajones.mostrarCajonesDisponibles();
        System.out.println("el precioes :"+ticket.CalcularCostos());
        System.out.println("la tarifa es de: "+ caja.tarifa(ticket));
        ticket.ticked();
        cajones.mostrarCajonesDisponibles();
        int ocuparCajones=cajones.ocuparCajones();
    }
        // Case 2
    public void retirarVehiculo(Caja caja, Tickets ticket, Cajones cajones){
        if (ticket != null) {
        caja.pedirboleto(ticket);
        System.out.println("Buscando Coche......");
        System.out.println("Total a pagar: $" + caja.tarifa(ticket));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto pagado: ");
        int montoPagado = scanner.nextInt();
        caja.cambio(ticket);
    } else {
        System.out.println("No hay veh�culo para retirar.");
    }
}
    //Case 3 
  public void mostrarStatusEstacionamiento(Tickets ticket, Cajones cajones) {
        // Guardar en archivos la informaci�n del ticket y la posici�n de los coches
        guardarTicketEnArchivo(ticket);
        guardarPosicionCochesEnArchivo(cajones);
    }

    private void guardarTicketEnArchivo(Tickets ticket) {
        try {
            File file = new File("ticket.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("--------------IMPRIMIR TICKET----------------\n");
            writer.write("Color: " + ticket.color + "\n");
            writer.write("Tama�o: " + ticket.tamanio + "\n");
            writer.write("Placas: " + ticket.placas + "\n");
            writer.write("Marca: " + ticket.marca + "\n");
            writer.write("Espacio estacionado: \n");
            writer.write("La fecha es: ");
            ticket.ObtenerDiaMesAnio();
            writer.write("\nHora de entrada: " + ticket.ObtenerHoraActual() + ":" + ticket.obtenerMinutoActual() + "\n");
            writer.write("N�mero de serie: " + ticket.generarNumeroSerieBoleto() + "\n");

            writer.close();
            System.out.println("Ticket guardado en archivo 'ticket.txt'");
        } catch (IOException e) {
        }
    }

    private void guardarPosicionCochesEnArchivo(Cajones cajones) {
        try {
            File file = new File("posicion_coches.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("-----------POSICI�N DE LOS COCHES-----------\n");
            writer.write("Cajones ocupados:\n");

            for (int i = 0; i < cajones.totalCajones; i++) {
                if (cajones.cajonesOcupados[i] == 1) {
                    writer.write("Caj�n " + (i + 1) + ": Ocupado\n");
                }
            }

            for (int i = 0; i < cajones.totalCajones; i++) {
                if (cajones.cajonesOcupados[i] == 0) {
                    writer.write("Caj�n " + (i + 1) + ": Disponible\n");
                }
            }

            writer.close();
            System.out.println("Posici�n de los coches guardada en archivo 'posicion_coches.txt'");
        } catch (IOException e) {
        }
    }
}
       
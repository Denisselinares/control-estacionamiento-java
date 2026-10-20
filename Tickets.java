package com.mycompany.estacionamientovip;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Tickets extends Vehiculo{
    Calendar Horario;
    String tamanio;

    //Constructor
    public Tickets(String marca, String color, String modelo, String tamaño, String placas) {
        super(marca, color, modelo, tamaño, placas); //Llamada al constructor de la clase Vehiculo
        this.Horario=new GregorianCalendar();
    }
    int precio;
    int numeroDeSerieBoleto;
    
    //Método para imprimir el mensaje de costo total basado en el tiempo de estacionamiento
    public int CalcularCostos(){
        if(tamaño.equalsIgnoreCase("Chico")) {
            precio = 15;
        }else if(tamaño.equalsIgnoreCase("Grande")) {
                precio=35;
        }else {
          System.out.println("\nEl valor es diferente a Chico y Grande");  
        }
        return precio;
        }
    
    public int ObtenerHoraActual(){
        return Horario.get(Calendar.HOUR_OF_DAY);
    }
    
    public int obtenerMinutoActual(){
        return Horario.get(Calendar.MINUTE);
    }
    
    public int registrarEntrada(){
        int horaEntrada = ObtenerHoraActual();
        return horaEntrada;
    }
    
    public void ObtenerDiaMesAño(){
        int year = Horario.get(Calendar.YEAR);
        int month = Horario.get(Calendar.MONTH)+1;
        int day = Horario.get(Calendar.DAY_OF_MONTH);
            System.out.print(""+day+ "/"+ month + "/" + year);   
    }
    
    public int generarNumeroSerieBoleto() {
        // Generar un número aleatorio con 8 dígitos
        int minimo = (int) Math.pow(10, 7);
        int maximo = (int) Math.pow(10, 8) - 1;
        this.numeroDeSerieBoleto = minimo + (int) (Math.random() * ((maximo - minimo) + 1));
        return this.numeroDeSerieBoleto;
    }
    
    public void recolectarDatos(){
        
        Scanner scanner = new Scanner(System.in);
        
            System.out.println("Ingrese la marca del coche : ");
            marca= scanner.nextLine();
                        
            System.out.println("Ingrese el color del coche: ");
            color = scanner.nextLine();
                        
            System.out.println("Ingrese el modelo del coche: ");
            modelo = scanner.nextLine();
                        
            System.out.println("Ingrese el tamaño del coche: ");
            tamaño = scanner.nextLine();
                        
            System.out.println("Ingrese las placas del coche: ");
            placas = scanner.nextLine();
            
            //ticket = new Tickets(marca, color, modelo, tamaño, placas);
            //ticket.ticked();
    }

    // Método para obtener el número de serie del boleto
    public int obtenerNumeroSerieBoleto() {
        return numeroDeSerieBoleto;
    }
    
    
    public void ticked() {
		System.out.println("--------------IMPRIMIR TICKET----------------");
		System.out.println("color: "+color);
		System.out.println("tamaño: "+tamaño);
		System.out.println("placas: "+placas);
		System.out.println("marca: "+ marca);
		System.out.println("Espacio estacionado: ");
		System.out.println("la fecha es:");ObtenerDiaMesAño();
		System.out.println("\nHora de entrada: "+ObtenerHoraActual()+":"+obtenerMinutoActual());
		System.out.println("Numero de serie: "+generarNumeroSerieBoleto());
	}

    void ObtenerDiaMesAnio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

    

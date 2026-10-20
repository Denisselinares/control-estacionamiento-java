package com.mycompany.estacionamientovip;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Caja {
    Calendar calendario;
    
    public Caja() {
        this.calendario = new GregorianCalendar();
    }

    public int registrarSalida() {
        int horaSalida = obtenerHoraActual();
        return horaSalida;
    }
    
    public int tarifa(Tickets precio) {
        int cobro;
        
    	if(registrarSalida()==precio.registrarEntrada()) {
        
            cobro=precio.CalcularCostos();
    	}else {
            int horasTotales =registrarSalida()-precio.registrarEntrada();
                cobro=precio.CalcularCostos()*horasTotales;
    	}
    	return cobro;
    }
    
    public int obtenerHoraActual() {
        return calendario.get(Calendar.HOUR_OF_DAY);
    }
    
    public void pedirboleto(Tickets pedir) {
    	int R;
    	do { System.out.println("Ingrese el número de serie de su boleto: ");
    		Scanner D1 = new Scanner(System.in);
    		R = D1.nextInt();
    		if(pedir.obtenerNumeroSerieBoleto()!=R) {
                    System.out.println("Numero incorrecto.");
                    System.out.println("Si perdio su boleto digite 0");
                    if(R==0) {
                       R=0;
    			}
    		}else{
                    System.out.println("Numero correcto, Hasta la proxima...");
    			R=0;
    		}
    	}while(R!=0);
    }
    int pago=0;
    public int pedirDinero(){
        if(pago==0){
        Scanner scan = new Scanner(System.in);
        System.out.println("Monto recibido: ");
        pago= scan.nextInt();
        
        }
        return pago;
    }
    public int cambio(Tickets tickets) {
        int cambio=0;
    	cambio=pedirDinero()-tarifa(tickets);
    	int tarifa= tarifa(tickets);
    	
    	do {
    		//cambio=0
    		if(pedirDinero()==tarifa) {
    			
    			System.out.println("El monto recibido es correcto. ");
    	    	cambio=0;
    		}
    		else {
    			//cambio>0
            	if(pedirDinero()>tarifa) {
            		
            		System.out.println("El cambio es: "+ cambio);
            		cambio=0;
            	}
            	//cambio<0
            	else {
            		cambio*=-1;
            		
            		System.out.println("para completar el pago faltan: "+cambio);
            		pago=0;
            		tarifa=cambio;
            		pedirDinero();
                	cambio=pedirDinero()-tarifa;
            		if(pedirDinero()==tarifa) {
            			
            			System.out.println("El monto recibido es correcto. ");
            	    	cambio=0;
            		}
            	}
    		}
    	}while(cambio!=0);
    		
    	return cambio;
    }
    public int Cambio(int montoPagado, int tarifa) {
        return montoPagado - tarifa;
    }
}

    



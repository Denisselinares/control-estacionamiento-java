package com.mycompany.estacionamientovip;

import java.util.Scanner;

class Cajones{
    Scanner scan = new Scanner(System.in);
    int[] cajonesOcupados= new int[30];
    int totalCajones=30;
    
    public void mostrarCajonesDisponibles(){
        System.out.println("Mostrar Cajones disponibles :\n\"");
        for(int i = 0; i < totalCajones; i++){
            if(cajonesOcupados[i]==0){
                System.out.println((i + 1)+ "");
            } 
        }
        System.out.println();
    }
    int cajon=0;
    public int ocuparCajones(){
            System.out.println("selecciona un cajon desocupado");
            cajon = scan.nextInt();
            cajon-=1;
            if(cajonesOcupados[cajon]==0){
                cajonesOcupados[cajon]=1;
                System.out.println("lugar ocupado: "+ (cajon+1)+"="+ cajonesOcupados[cajon]);
            }
            else{
                System.out.println("No hay espacios disponibles");
                     
            }
        return cajon;
    }
    
    public void liberarCajones(){
        if( cajonesOcupados[cajon]==1){
            cajonesOcupados[cajon]= 0;
           System.out.println("Espacio"+cajon+ "liberado");
        }else{
            System.out.println("Número de cajones no válido");
        }
    }
}
    


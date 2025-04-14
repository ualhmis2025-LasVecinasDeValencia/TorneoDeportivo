package org.ualhmis.torneos;

import java.time.LocalDate;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

	    Entrenador entrenadorPrueba = new Entrenador("Luis", "hombre", LocalDate.of(1990, 04, 05)); 

	    Equipo equipoPrueba = new Equipo("GallardoMartinez", "Juvenil", "Masculino", entrenadorPrueba);
	    Equipo equipoPrueba2 = new Equipo("Gallardo", "Juvenil", "Masculino", entrenadorPrueba);

	    
        GestorTorneos gt = new GestorTorneos(); 

        Torneo torneo = gt.crearTorneo("Liga Juvenil", "Fútbol", "Juvenil", "Masculino", "Liga");
        Torneo torneo2 = gt.crearTorneo("Liga Juvenil", "Fútbol", "Juvenil", "Masculino", "Copa");

        boolean condicion = true; 
        
        while (condicion == true) {
        	
        	
        	System.out.println("Elige una de las opciones");
        	System.out.println("1. Crear un torneo");
            System.out.println("2. Agregar equipo a un torneo");
            Scanner sc = new Scanner(System.in);  
            int decision = sc.nextInt(); 
            sc.nextLine();

            
            if (decision == 1) {
            	
                System.out.println("Introzuca el nombre del torneo");
                String nombre = sc.nextLine(); 
                System.out.println("Introzuca el deporte");
                String deporte = sc.nextLine(); 
                System.out.println("Introduzca la categoria"); 
                String categoria = sc.nextLine();
                System.out.println("Introduzca la modalidad");
                String modalidad = sc.nextLine();
                System.out.println("Introduzca el tipo");
                String tipo = sc.nextLine(); 
                
                Torneo nuevoTorneo = gt.crearTorneo(nombre, deporte, categoria, modalidad, tipo);
                
                System.out.println("Lista de torneos: ");
                
                for(Torneo torneo1 : gt.getTorneos()) {
                	
                	System.out.println(torneo1.toString());
                }
                
                System.out.println("Añada ahora equipos al torneo");
                System.out.println("...");
                
           
            }

            
            
        	
        	
        	
        	
        	
        	
        	
        	
        	
        }
        
        
        
        
        
        boolean resultado = gt.RegistrarEquipoTorneo(equipoPrueba2, torneo); 
        boolean resultado2 = gt.RegistrarEquipoTorneo(equipoPrueba, torneo);
        boolean resultado3 = gt.RegistrarEquipoTorneo(equipoPrueba, torneo2); 
        
        System.out.println(resultado);
        System.out.println(resultado2);
        System.out.println(resultado3);

        
        
        for(Torneo torneo1 : gt.getTorneos()) {
        	
        	System.out.println(torneo1.toString());
        }
        
        

	    
	    

		
		
		
		
		
		
		
	}

}

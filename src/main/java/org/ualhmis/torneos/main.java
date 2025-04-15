package org.ualhmis.torneos;

import java.time.LocalDate;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

	    
        GestorTorneos gt = new GestorTorneos(); 


        boolean condicion = true; 
        
        while (condicion == true) {
        	
        	
        	System.out.println("Elige una de las opciones");
        	System.out.println("1. Crear un torneo");
            System.out.println("2. Buscar torneo");
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
                
             
           
            }
            
            else if(decision == 2) {
            	
            	Torneo torneoBuscado = null; 
            	
            	System.out.println("Introzuca el nombre del torneo");
                String nombre = sc.nextLine();
                for(Torneo torneo2 : gt.getTorneos()) {
                	
                	if(torneo2.getNombre().equals(nombre)) {
                		
                		 torneoBuscado = torneo2; 
                		break; 
                		
                	}
                }
                
                if(torneoBuscado == null) {
                	
                	System.out.println("El torneo que busca no existe");
                }
                
                else {
                	
                	System.out.println("Torneo: " + torneoBuscado.getNombre());
                	System.out.println("Elija la opción que desea"); 
                	System.out.println("1. Agregar Equipo");
                    System.out.println("2. Agregar partido");
                    int decision2 = sc.nextInt(); 
                    
                    if(decision2 == 1) {
                    	
                    	System.out.println("Agregar equipo");
                    }
                    

                    
                    
                    
                }
                
                
            	
            }

            
            
        	
        	
        	
        	
        	
        	
        	
        	
        	
        }
        
        
        
        
    

	    
	    

		
		
		
		
		
		
		
	}

}

package org.ualhmis.torneos;

import java.util.HashSet;

public class Instalacion {

	String nombre;
	HashSet<String> deportesPermitidos;
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; 

        Instalacion otra = (Instalacion) obj;
        return nombre != null ? nombre.equals(otra.nombre) : otra.nombre == null;
    }
}

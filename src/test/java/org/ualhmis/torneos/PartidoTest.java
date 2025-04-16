package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

// Registro de equipos en torneos con validación de categoría y modalidad

class PartidoTest {

    @Test
    void testRegistrarResultado() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        partido.registrarResultado(2, 1);

        assertEquals(2, partido.getGolesEquipo1());
        assertEquals(1, partido.getGolesEquipo2());
    }
    
    @Test
    void testGetEquipo1() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        assertEquals(equipo1,partido.getEquipo1());
        assertNotEquals(equipo2,partido.getEquipo1());
    }
    
    @Test
    void testGetEquipo2() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        assertEquals(equipo2,partido.getEquipo2());
        assertNotEquals(equipo1,partido.getEquipo2());
    }
    
    @Test
    void testSetEquipo1() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        Equipo equipo3 =new Equipo("Hienas", "Juvenil", "Masculino", entrenador2);
        partido.setEquipo1(equipo3);
        assertEquals(equipo3,partido.getEquipo1());
        assertNotEquals(equipo1,partido.getEquipo1());
    }
    
    @Test
    void testSetEquipo2() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        Equipo equipo3 =new Equipo("Hienas", "Juvenil", "Masculino", entrenador2);
        partido.setEquipo2(equipo3);
        assertEquals(equipo3,partido.getEquipo2());
        assertNotEquals(equipo2,partido.getEquipo2());
    }
    
    @Test
    void testGetySetGolesEquipo1() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        partido.setGolesEquipo1(2);
        assertEquals(partido.getGolesEquipo1(),2);
    }
    
    @Test
    void testGetySetGolesEquipo2() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

        Partido partido = new Partido(equipo1, equipo2);
        partido.setGolesEquipo2(2);
        assertEquals(partido.getGolesEquipo2(),2);
    }
    
    
    
}

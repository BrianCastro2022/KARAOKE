/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_karaoke
 * Autor: Equipo Cupi2  2018-2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.karaoke.test;

import junit.framework.TestCase;
import uniandes.cupi2.karaoke.mundo.Cancion;

/**
 * Esta es la clase usada para verificar la correcta implementación de la clase Canción
 */
public class CancionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Cancion cancion;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva Canción
     * 
     */
    private void setupEscenario1( )
    {
        cancion = new Cancion( "nombre", 100, "letra", 5, "ruta" );
    }

    /**
     * Prueba 1 - Verifica que el nombre de la canción sea correcto
     */
    public void testDarNombre( )
    {
        setupEscenario1( );

        assertNotNull( "El nombre de la canción no fue inicializado", cancion.darNombre( ) );
        assertEquals( "El nombre de la canción no es el esperado", "nombre", cancion.darNombre( ) );
    }

    /**
     * Prueba 2 - Verifica que la duración de la canción sea correcta
     */
    public void testDarDuracion( )
    {
        setupEscenario1( );

        assertEquals( "La duración de la canción no es la esperada", 100, cancion.darDuracion( ) );
    }

    /**
     * Prueba 3 - Verifica que la dificultad de la canción sea correcta
     */
    public void testDarDificultad( )
    {
        setupEscenario1( );

        assertEquals( "La dificultad de la canción no es el esperada", 5, cancion.darDificultad( ) );
    }

    /**
     * Prueba 4 - Verifica que la letra de la canción sea correcta
     */
    public void testDarLetra( )
    {
        setupEscenario1( );

        assertNotNull( "La letra de la canción no fue inicializada", cancion.darLetra( ) );
        assertEquals( "La letra de la canción no es la esperada", "letra", cancion.darLetra( ) );
    }

    /**
     * Prueba 5 - Verifica que la ruta de la canción sea correcta
     */
    public void testDarRuta( )
    {
        setupEscenario1( );
        assertNotNull( "La ruta de la canción no fue inicializada", cancion.darRuta( ) );
        assertEquals( "La ruta de la canción no es la esperada", "ruta", cancion.darRuta( ) );
    }

    /**
     * <b>Prueba 6:</b> Verifica el método cambiarSiguiente.<br>
     * <b>Métodos a probar:</b><br>
     * darSiguiente<br>
     * cambiarSiguiente<br>
     * <b>Casos de prueba:</b><br>
     * 1. No hay un siguiente al crear la canción. <br>
     * 2. La siguiente es correcta después de haber sido asignada.
     */
    public void testCambiarSiguiente( )
    {
        setupEscenario1( );
        assertTrue( "No debería haber una siguiente", cancion.darSiguiente( ) == null );
        cancion.cambiarSiguiente( new Cancion( "C001", 123, "letra", 7, "ruta" ) );
        assertTrue( "No se está cambiando el siguiente artista.", cancion.darSiguiente( ) != null );
        assertTrue( "La canción siguiente no es correcta.", cancion.darSiguiente( ).darNombre( ).equals( "C001" ) );
    }
}

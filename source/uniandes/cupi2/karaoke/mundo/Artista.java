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

package uniandes.cupi2.karaoke.mundo;

import java.util.ArrayList;

/**
 * Artista intérprete de las canciones del karaoke
 */
public class Artista
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Nombre del artista
	 */
	private String nombre;

	/**
	 * Categoría del artista.
	 */
	private String categoria;

	/**
	 * Ruta del archivo con la imagen del artista
	 */
	private String imagen;

	/**
	 * Primer cancion de la lista.
	 */
	private Cancion primerCancion;

	/**
	 * El artista anterior de la lista.
	 */
	private Artista anterior;

	/**
	 * El siguiente artista de la lista.
	 */
	private Artista siguiente;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea un Artista.<br>
	 * <b>post:</b> Inicializa sus atributos con los parámetro recibidos.
	 * @param pNombre Nombre del artista. pNombre != null y pNombre != ""
	 * @param pCategoria Categoría del artista. pCategoria != null && pCategoria pertenece a Karaoke.CATEGORIAS
	 * @param pImagen Ruta del archivo con la imagen del artista. pImagen != null y pImagen != ""
	 */
	public Artista( String pCategoria, String pNombre, String pImagen )
	{
		nombre = pNombre;
		imagen = pImagen;
		categoria = pCategoria;

		anterior = null;
		siguiente = null;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el nombre del artista
	 * @return Nombre del artista
	 */
	public String darNombre( )
	{
		return nombre;
	}

	/**
	 * Retorna la categoría del artista
	 * @return Categoría del artista
	 */
	public String darCategoria( )
	{
		return categoria;
	}

	/**
	 * Retorna la ruta del archivo con la imagen del artista
	 * @return Ruta de la imagen
	 */
	public String darImagen( )
	{
		return imagen;
	}

	/**
	 * Retorna el anterior artista de la lista.
	 * @return Artista anterior.
	 */
	public Artista darAnterior() {

		return anterior;
	}


	/**
	 * Retorna el siguiente artista de la lista.
	 * @return Siguiente artista.
	 */    
	public Artista darSiguiente() {

		return siguiente;
	}

	/**
	 * Cambia el anterior artista de la lista.
	 * @param pArtista Artista a asignar como anterior.
	 */    
	public void cambiarAnterior(Artista pArtista) {

		anterior = pArtista;
	}


	/**
	 * Cambia el siguiente artista de la lista.
	 * @param pArtista Artista a asignar como siguiente.
	 */   
	public void cambiarSiguiente(Artista pArtista) {

		siguiente = pArtista;
	}

	/**
	 * Agrega una nueva canción a la lista de canciones del artista<br>
	 * La canción se agrega en la posición que le corresponda de tal manera que la lista quede ordenada por nombre de manera ascendente.<br>
	 * <b> post: </b> Se agregó una nueva canción a la lista de canciones.
	 * @param pNombre Nombre de la canción. pNombre != null y pNombre != ""
	 * @param pDuracion Duración en segundos de la canción. pDuracion > 0
	 * @param pLetra Letra de la canción. pLetra != null y pLetra != ""
	 * @param pDificultad Dificultad de la canción. pDificultad >= 1 y pDificultad <= 10
	 * @param pRuta Ruta del archivo con la canción. pRuta != null y pRuta != ""
	 * @throws Exception Si ya existe una canción con el mismo nombre
	 */
	public void agregarCancion( String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta ) throws Exception
	{
		if(buscarCancion(pNombre)!=null)
			throw new Exception("Ya existe una canción con el nombre "+pNombre);

		Cancion nuevaCancion = new Cancion(pNombre, pDuracion, pLetra, pDificultad, pRuta);

		if(primerCancion==null)
			primerCancion = nuevaCancion;

		else if(primerCancion.darNombre().compareTo(pNombre)>0)
		{
			nuevaCancion.cambiarSiguiente(primerCancion);
			primerCancion = nuevaCancion;
		}

		else
		{
			Cancion osAuxiliar = primerCancion;
			while(osAuxiliar.darSiguiente()!=null && osAuxiliar.darSiguiente().darNombre().compareTo(nuevaCancion.darNombre())<0) {
				osAuxiliar = osAuxiliar.darSiguiente();
			}

			if(osAuxiliar.darSiguiente()==null)
				osAuxiliar.cambiarSiguiente(nuevaCancion);

			else
			{	
				nuevaCancion.cambiarSiguiente(osAuxiliar.darSiguiente());
				osAuxiliar.cambiarSiguiente(nuevaCancion);

			}   	
		}
	}

	/**
	 * Elimina la canción con el nombre dado.<br>
	 * <b>pre:</b> La canción existe.<br>
	 * <b>post:</b>Se eliminó la canción de la lista de canciones del artista.
	 * @param pNombre Nombre de la canción a eliminar. pNombre!=null && pNombre != "".
	 */
	public void eliminarCancion( String pNombre )
	{
		if(primerCancion.darNombre().equals(pNombre))
			primerCancion=primerCancion.darSiguiente();
		else
		{
			Cancion osCancion = primerCancion;
			while(!osCancion.darSiguiente().darNombre().equals(pNombre)) 
			{
				osCancion = osCancion.darSiguiente();
			}

			osCancion.cambiarSiguiente(osCancion.darSiguiente().darSiguiente());
		}    	
	}

	/**
	 * Retorna una lista con las canciones del artista
	 * @return Lista de canciones
	 */
	public ArrayList<Cancion> darCanciones( )
	{
		Cancion auxiliar = primerCancion;
		ArrayList<Cancion>canciones = new ArrayList<Cancion>();

		while(auxiliar!=null)
		{
			canciones.add(auxiliar);
			auxiliar = auxiliar.darSiguiente();
		}

		return canciones;
	}

	/**
	 * Busca una canción con el nombre dado.<br>
	 * @param pNombre Nombre de la canción. nombre != null y nombre != ""
	 * @return La canción con el nombre dado. Si no existe una canción con ese nombre se retorna null
	 */
	public Cancion buscarCancion( String pNombre )
	{
		Cancion osCancion = primerCancion;
		while(osCancion!=null && !osCancion.darNombre().equals(pNombre)) {

			osCancion = osCancion.darSiguiente();
		}

		return osCancion;
	}

	/**
	 * Busca la canción con mayor dificultad. Si existen varias canciones con la misma dificultad retorna la primera canción encontrada.
	 * @return La canción del artista con mayor dificultad. Si el artista no tiene ninguna canción se retorna null
	 */
	public Cancion darCancionMasDificil( )
	{
		Cancion osDificil = primerCancion;
		Cancion osMasDificil = null;
		int dificultad = 0;
		while(osDificil != null) {

			if(osDificil.darDificultad()>dificultad) {
				dificultad = osDificil.darDificultad();
				osMasDificil = osDificil;
			}

			osDificil = osDificil.darSiguiente();
		}

		return osMasDificil;
	}

	/**
	 * Busca la canción con menor dificultad. Si existen varias canciones con la misma dificultad retorna la primera canción encontrada.
	 * @return La canción del artista con menor dificultad. Si el artista no tiene ninguna canción se retorna null
	 */
	public Cancion darCancionMasFacil( )
	{
		Cancion osFacil = primerCancion;
		Cancion osMasFacil = null;
		int dificultad = 11;

		while(osFacil!=null) {

			if(osFacil.darDificultad()<dificultad)
			{
				dificultad = osFacil.darDificultad();
				osMasFacil = osFacil;

			}
			osFacil = osFacil.darSiguiente();
		}

		return osMasFacil;
	}

	/**
	 * Busca la canción con mayor duración. Si existen varias canciones con la misma duración retorna la primera canción encontrada.
	 * @return La canción del artista con mayor duración. Si el artista no tiene ninguna canción se retorna null
	 */
	public Cancion darCancionMasLarga( )
	{
		Cancion osLarga = primerCancion;
		Cancion osMasLarga = null;
		int duracion = 0;
		while(osLarga!=null) {

			if(osLarga.darDuracion()>duracion)
			{
				duracion = osLarga.darDuracion();
				osMasLarga = osLarga;
			}
			osLarga=osLarga.darSiguiente();
		}

		return osMasLarga;
	}

	/**
	 * Busca la canción con menor duración. Si existen varias canciones con la misma duración retorna la primera canción encontrada.
	 * @return La canción del artista con menor duración. Si el artista no tiene ninguna canción se retorna null
	 */
	public Cancion darCancionMasCorta( )
	{
		Cancion osCorta = primerCancion;
		Cancion osMasCorta = null;
		int duracion = 999999;
		while(osCorta!=null) {

			if(osCorta.darDuracion()<duracion)
			{
				duracion = osCorta.darDuracion();
				osMasCorta = osCorta;
			}
			osCorta=osCorta.darSiguiente();
		}

		return osMasCorta; 	
	}

	/**
	 * Devuelve la representación en String del artista
	 * @return La representación en String del artista: nombre.
	 */
	public String toString( )
	{
		return nombre;
	}

	public Cancion darPrimeraCancion() {
		// TODO Auto-generated method stub
		return null;
	}
}
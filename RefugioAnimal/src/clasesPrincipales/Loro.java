package clasesPrincipales;


import java.io.Serializable;


/**
 * Clase loro que hereda de Ave
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Loro extends Ave implements Serializable {
	/**
	 * Constructor de la clase
	 * @param nombre nombre del loro
	 * @param peso peso del loro
	 * @param edad edad del loro
	 * @param sexo sexo del loro
	 * @param anioAlta año de alta en el refugio del loro
	 * @param mesAlta mes de alta del loro
	 * @param diaAlta dia de alta del loro
	 * @param cantidadComidaMensual cantidad de comida en kg del loro mensual
	 * @param costeAdopcion coste adopción del loro
	 * @throws NombreNoValidoException excepción que salta em caso de que el nombre no sea válido
	 * @throws EdadNoValidaException excepción que salta en caso de que la edad no sea válida
	 * @throws DecimalNoValidoException
	 */
	public Loro(String nombre, float peso, int edad, Sexos sexo,
			int anioAlta, int mesAlta, int diaAlta, float cantidadComidaMensual,float costeAdopcion)
					throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, edad, sexo, anioAlta, mesAlta, diaAlta,
				cantidadComidaMensual,true,true);
		this.costeAdopcion = costeAdopcion;
	}



}

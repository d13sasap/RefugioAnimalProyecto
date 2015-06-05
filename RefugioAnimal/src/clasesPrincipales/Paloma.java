package clasesPrincipales;

import java.io.Serializable;

/**
 * Clase Paloma que hereda de Ave
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Paloma extends Ave implements Serializable {
	/**
	 * Constructor de la clase Paloma
	 * @param nombre nombre de la paloma
	 * @param peso peso de la paloma
	 * @param edad edad de la paloma
	 * @param sexo sexo de la paloma
	 * @param anioAlta año alta de la paloma
	 * @param diaAlta dia de alta de la paloma
	 * @param mesAlta mes de alta de la paloma
	 * @param cantidadComidaMensual cantidad de comida mensual de la paloma en kg
	 * @param costeAdopcion coste de adopción de la paloma
	 * @throws NombreNoValidoException en caso de que el nombre de la paloma no sea correcto 
	 * @throws EdadNoValidaException en caso de que la edad de la paloma no sea correcta
	 * @throws DecimalNoValidoException
	 */
	public Paloma(String nombre, float peso, int edad, Sexos sexo,
			int anioAlta, int diaAlta, int mesAlta, float cantidadComidaMensual,float costeAdopcion) throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso,  edad, sexo, anioAlta, mesAlta, diaAlta,
				cantidadComidaMensual,true, true);
		this.costeAdopcion = costeAdopcion;
	}




}

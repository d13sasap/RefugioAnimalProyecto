package clasesPrincipales;


import java.io.Serializable;


/**
 * Clase loro que hereda de Ave
 * @author Pablo S�nchez Sanvicente
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
	 * @param anioAlta a�o de alta en el refugio del loro
	 * @param mesAlta mes de alta del loro
	 * @param diaAlta dia de alta del loro
	 * @param cantidadComidaMensual cantidad de comida en kg del loro mensual
	 * @param costeAdopcion coste adopci�n del loro
	 * @throws NombreNoValidoException excepci�n que salta em caso de que el nombre no sea v�lido
	 * @throws EdadNoValidaException excepci�n que salta en caso de que la edad no sea v�lida
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

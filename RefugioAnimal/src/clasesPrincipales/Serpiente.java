package clasesPrincipales;

import java.io.Serializable;

/**
 * Clase serpiente que hereda de reptil
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Serpiente extends Reptil implements Serializable {
	/**
	 * Constructor de la clase
	 * @param nombre nombre de la serpiente
	 * @param peso peso de la serpiente
	 * @param edad edad de la serpiente
	 * @param sexo sexo de la serpiente
	 * @param anioAlta año alta de la serpiente
	 * @param mesAlta mes alta d la serpiente
	 * @param diaAlta dia alta de la serpiente
	 * @param cantidadComidaMensual cantidad comida mensual de la serpiente en kg
	 * @param costeAdopcion coste adopción de la serpiente
	 * @param venenoso si es venenosa o no la serpiente
	 * @throws NombreNoValidoException en caso de no ser válido el nombre de la serpiente
	 * @throws EdadNoValidaException en caso de que la edad no sea válida
	 * @throws DecimalNoValidoException
	 */
	public Serpiente(String nombre, float peso, int edad,
			Sexos sexo, int anioAlta, int mesAlta, int diaAlta,
			float cantidadComidaMensual,float costeAdopcion,boolean venenoso) throws NombreNoValidoException,
			EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, 0, edad, sexo, anioAlta, mesAlta, diaAlta,
				cantidadComidaMensual,false,venenoso);
		this.costeAdopcion = costeAdopcion;
	}



}

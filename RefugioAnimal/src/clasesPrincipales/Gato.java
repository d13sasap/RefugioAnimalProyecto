package clasesPrincipales;

import java.io.Serializable;
/**
 * Clase Gato que hereda de mamífero
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Gato extends Mamifero implements Serializable{
	/**
	 * Constructor de la clase gato
	 * @param nombre nombre del gato
	 * @param peso peso del gato
	 * @param edad edad del gato
	 * @param sexo sexo del gato 
	 * @param anioAlta año de alta del gato
	 * @param mesAlta mes de alta del gato
	 * @param diaAlta dia de alta del gato
	 * @param cantidadComidaMensual cantidad de comida en kilogramos que come el gato
	 * @param raza raza del gato
	 * @param costeAdopcion coste de la adopción del gato
	 * @throws NombreNoValidoException excepción que salta en caso que el nombre del gato no es válido
	 * @throws EdadNoValidaException excepción que salta en caso de que la edad del gato no sea válida
	 * @throws DecimalNoValidoException excepci´n que salta en caso de que el decimal no sea valido
	 */
	public Gato(String nombre, float peso, int edad, Sexos sexo,
			int anioAlta, int mesAlta, int diaAlta,
			float cantidadComidaMensual, String raza,float costeAdopcion)
					throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, edad, sexo, anioAlta, mesAlta, diaAlta,
				cantidadComidaMensual, raza);
		this.costeAdopcion = costeAdopcion;
	}

	@Override
	public String toString() {
		return "Gato [alimentacion=" + alimentacion + ", costeAdopcion="
				+ costeAdopcion + ", getPeso()=" + getPeso() + ", getEdad()="
				+ getEdad() + ", getNombre()=" + getNombre() + "]";
	}


}

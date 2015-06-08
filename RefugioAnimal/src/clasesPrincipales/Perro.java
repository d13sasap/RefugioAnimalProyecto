package clasesPrincipales;


import java.io.Serializable;
import java.util.Calendar;

/**
 * Clase Perro que hereda de Mamífero
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Perro extends Mamifero implements Serializable {

	/**
	 * Constructor de la clase Perro
	 * @param nombre nombre del perro
	 * @param peso peso del perro
	 * @param edad edad del perro
	 * @param sexo sexo del perro
	 * @param anioAlta año alta del perro
	 * @param mesAlta mes de alta del perro
	 * @param diaAlta dia de alta del perro
	 * @param cantidadComidaMensual cantidad de comida mensual del perro en kg
	 * @param raza raza del perro
	 * @param costeAdopcion coste adopción del perro
	 * @throws NombreNoValidoException en caso de que el nombre no sea válido
	 * @throws EdadNoValidaException en caso de que la edad del perro no sea válida
	 * @throws DecimalNoValidoException
	 */
	public Perro(String nombre, float peso, int edad, Sexos sexo, 
			Calendar fechaAlta, float cantidadComidaMensual,String raza,float costeAdopcion)
					throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, edad, sexo, fechaAlta,cantidadComidaMensual,raza);
		this.costeAdopcion = costeAdopcion;
	}



	@Override
	public String toString() {
		return "Perro [reproduccion=" + reproduccion + ", alimentacion="
				+ alimentacion + ", cantidadComidaMensual="
				+ cantidadComidaMensual + ", costeAdopcion=" + costeAdopcion
				+ ", costeMantenimientoMensual=" + costeMantenimientoMensual
				+ ", tipoAnimal=" + tipoAnimal + ", getPeso()=" + getPeso()
				+ ", getEdad()=" + getEdad() + ", getNombre()=" + getNombre()
				+ "]";
	}

}

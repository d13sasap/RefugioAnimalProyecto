package clasesPrincipales;


import java.io.Serializable;

/**
 * Clase Tortuga que hereda de reptil
 * @author Pablo S�nchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Tortuga extends Reptil implements Serializable {
	/**
	 * Constructor de la clase
	 * @param nombre nombre de la tortuga 
	 * @param peso peso de la tortuga
	 * @param edad edad de la tortuga
	 * @param sexo sexo de la tortuga
	 * @param anioAlta a�o alta de la tortuga
	 * @param mesAlta mes alta de la tortuga
	 * @param diaAlta dia alta de la tortuga
	 * @param cantidadComidaMensual cantidad de comida mensual de la torrtuga en kg
	 * @param costeAdopcion coste adopcion de la tortuga
	 * @throws NombreNoValidoException em caso de que el nombre no sea v�lido
	 * @throws EdadNoValidaException si la edad no es v�lida
	 * @throws DecimalNoValidoException
	 */
	public Tortuga(String nombre, float peso, int edad, Sexos sexo,
			int anioAlta, int mesAlta, int diaAlta, float cantidadComidaMensual,float costeAdopcion)
					throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, 4, edad, sexo, anioAlta, mesAlta, diaAlta,
				cantidadComidaMensual,true, false);
		this.costeAdopcion = costeAdopcion;
	}

	@Override
	public String toString() {
		return "Tortuga [reproduccion=" + reproduccion + ", alimentacion="
				+ alimentacion + ", costeAdopcion=" + costeAdopcion
				+ ", getPeso()=" + getPeso() + ", getNombre()=" + getNombre()
				+ "]";
	}

}

package clasesPrincipales;


import java.io.Serializable;


@SuppressWarnings("serial")
/**
 * Clase Mamífero que hereda de Animal
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
public abstract class Mamifero extends Animal implements Serializable{
	private static final float factor = (float) 2.2;//Constante factor de la familia animal en cuanto al coste de comida.
	/**
	 * Constructor de la clase Mamífero
	 * @param nombre nombre del mamífero
	 * @param peso peso del mamífero
	 * @param edad edad del mamífero
	 * @param sexo sexo del mamífero
	 * @param anioAlta año alta del mamífero
	 * @param mesAlta mes de alta del mamífero
	 * @param diaAlta dia de alta del mamífero
	 * @param cantidadComidaMensual cantidad de comida mensual del mamífero en kg
	 * @param raza raza del mamífero
	 * @throws NombreNoValidoException excepción que salta en caso que el nombre no sea válido
	 * @throws EdadNoValidaException excepción que salta en caso que la edad no sea válida
	 * @throws DecimalNoValidoException
	 */
	public Mamifero(String nombre, float peso, int edad,
			Sexos sexo, int anioAlta, int mesAlta, int diaAlta,
			float cantidadComidaMensual,String raza) throws NombreNoValidoException,
			EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, 4, edad, sexo, anioAlta, mesAlta, diaAlta,cantidadComidaMensual,factor);
		this.tipoAnimal = FamiliaAnimales.MAMIFERO;
		this.alimentacion = TiposAlimentacion.CARNIVORO;
		this.reproduccion = TiposReproduccion.VIVIPARO;

		setRaza(raza);
		// TODO Auto-generated constructor stub
	}



	private String raza;

	/**
	 * Método que establece la raza del mamífero
	 * @param raza cadena para la raza del mamífero
	 * @throws NombreNoValidoException si el nombre no es válido según patrón
	 */
	public void setRaza(String raza) throws NombreNoValidoException {
		if(esNombreValido(raza))
			this.raza = raza;
		else throw new NombreNoValidoException("Raza no válida");
	}

	@Override
	public String toString() {
		return "Mamifero [raza=" + raza + ", getPeso()=" + getPeso()
				+ ", getEdad()=" + getEdad() + ", getNombre()=" + getNombre()
				+ "]";
	}
	/**
	 * Méetodo para obtener la cadena raza del mamífero
	 * @return
	 */
	public String getRaza() {
		return raza;
	}



}

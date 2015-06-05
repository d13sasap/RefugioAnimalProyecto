package clasesPrincipales;


import java.io.Serializable;


@SuppressWarnings("serial")
/**
 * Clase Mam�fero que hereda de Animal
 * @author Pablo S�nchez Sanvicente
 * @version 2.0
 */
public abstract class Mamifero extends Animal implements Serializable{
	private static final float factor = (float) 2.2;//Constante factor de la familia animal en cuanto al coste de comida.
	/**
	 * Constructor de la clase Mam�fero
	 * @param nombre nombre del mam�fero
	 * @param peso peso del mam�fero
	 * @param edad edad del mam�fero
	 * @param sexo sexo del mam�fero
	 * @param anioAlta a�o alta del mam�fero
	 * @param mesAlta mes de alta del mam�fero
	 * @param diaAlta dia de alta del mam�fero
	 * @param cantidadComidaMensual cantidad de comida mensual del mam�fero en kg
	 * @param raza raza del mam�fero
	 * @throws NombreNoValidoException excepci�n que salta en caso que el nombre no sea v�lido
	 * @throws EdadNoValidaException excepci�n que salta en caso que la edad no sea v�lida
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
	 * M�todo que establece la raza del mam�fero
	 * @param raza cadena para la raza del mam�fero
	 * @throws NombreNoValidoException si el nombre no es v�lido seg�n patr�n
	 */
	public void setRaza(String raza) throws NombreNoValidoException {
		if(esNombreValido(raza))
			this.raza = raza;
		else throw new NombreNoValidoException("Raza no v�lida");
	}

	@Override
	public String toString() {
		return "Mamifero [raza=" + raza + ", getPeso()=" + getPeso()
				+ ", getEdad()=" + getEdad() + ", getNombre()=" + getNombre()
				+ "]";
	}
	/**
	 * M�etodo para obtener la cadena raza del mam�fero
	 * @return
	 */
	public String getRaza() {
		return raza;
	}



}

package clasesPrincipales;

import java.io.Serializable;

/**
 * Clase reptil que hereda de Animal
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public abstract class Reptil extends Animal implements Serializable{
	boolean caparazon;
	boolean venenoso;
	private static final float factor = (float) 1.5;
	/**
	 * 
	 * @param nombre nombre del reptil
	 * @param peso peso del reptil
	 * @param nPatas numero de patas del reptil
	 * @param edad edad del reptil
	 * @param sexo sexo del reptil
	 * @param anioAlta año de alta del reptil
	 * @param mesAlta mes de alta del reptil
	 * @param diaAltadia de alta del reptil
	 * @param cantidadComidaMensual cantidad de comida mensual del reptil
	 * @param caparazon para saber si el reptil tiene caparazon
	 * @param venenoso en caso de que el reptil sea venenoso true
	 * @throws NombreNoValidoException si el nombre no es válido
	 * @throws EdadNoValidaException si la edad del reptil no es válida
	 * @throws DecimalNoValidoException
	 */
	public Reptil(String nombre, float peso, int nPatas, int edad, Sexos sexo,
			int anioAlta, int mesAlta, int diaAlta, float cantidadComidaMensual, boolean caparazon, boolean venenoso)
					throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, nPatas, edad, sexo, anioAlta, mesAlta, diaAlta,
				cantidadComidaMensual,factor);
		this.tipoAnimal = FamiliaAnimales.REPTIL;
		this.alimentacion = TiposAlimentacion.OMNIVORO;
		this.reproduccion = TiposReproduccion.OVIPARO;
		this.caparazon = caparazon;
		this.venenoso = venenoso;

	}
	/**
	 * Método para saber si el reptil tiene caparazon
	 * @return true si tiene caparazón, false en caso contrario
	 */
	public boolean isCaparazon() {
		return caparazon;
	}
	/**
	 * Méteodo para saber si el reptil es venenoso
	 * @return true si es venenoso, false si no lo es
	 */
	public boolean isVenenoso() {
		return venenoso;
	}





}

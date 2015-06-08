package clasesPrincipales;

import java.io.Serializable;
import java.util.Calendar;
/**
 * Clase abstracta Ave
 * @author Pablo S�nchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public abstract class Ave extends Animal implements Serializable{
	boolean vuela;
	boolean plumas;
	private static final float factor = (float) 1.2;
	/**
	 * Constructor de la clase Ave
	 * @param nombre nombre del ave
	 * @param peso peso del ave
	 * @param edad edad del ave
	 * @param sexo sexo del ave
	 * @param anioAlta a�o de alta del ave
	 * @param mesAlta mes de alta del ave
	 * @param diaAlta dia de alta del ave
	 * @param cantidadComidaMensual cantidad de comida mensual que come el animal
	 * @param vuela si el ave vuela
	 * @param plumas si el ave tiene plumas
	 * @throws NombreNoValidoException excepci�n que salta si el nombre no es v�lido
	 * @throws EdadNoValidaException excepci�n que salta si la edad no es v�lida
	 * @throws DecimalNoValidoException excepci�n que salta si el decimal no es v�lido
	 */
	public Ave(String nombre, float peso, int edad, Sexos sexo,
			Calendar fechaAlta, float cantidadComidaMensual,boolean vuela, boolean plumas)
					throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super(nombre, peso, 2, edad, sexo, fechaAlta,
				cantidadComidaMensual,factor);
		this.tipoAnimal = FamiliaAnimales.AVE;
		this.alimentacion = TiposAlimentacion.HERVIBORO;
		this.reproduccion = TiposReproduccion.OVIPARO;
		this.vuela = vuela;
		this.plumas = plumas;

	}
	/**
	 * Metodo que nos dice si el ave vuela
	 * @return true si el ave vuela, false en caso negativo
	 */
	public boolean isVuela() {
		return vuela;
	}
	/**
	 * M�todo que nos dice si el ave tiene plumas
	 * @return true si el ave tiene plumas, false en caso negativo
	 */
	public boolean isPlumas() {
		return plumas;
	}



}

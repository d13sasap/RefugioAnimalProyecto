package clasesPrincipales;

import java.util.Comparator;
/**
 * Clase para ordenar animales por coste adopción
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */

public class OrdenarAnimalCosteAdopcion implements Comparator<Animal>{
	/**
	 * Método para comparar 2 animales, y ordenarlos según el resultado.
	 */
	public int compare(Animal a1, Animal a2){
		return (int) (a1.costeAdopcion -a2.costeAdopcion);//devuelve un entero positivo si la altura del primero es mayor que del segundo
	}



}

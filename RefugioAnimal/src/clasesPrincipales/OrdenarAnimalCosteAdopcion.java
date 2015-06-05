package clasesPrincipales;

import java.util.Comparator;
/**
 * Clase para ordenar animales por coste adopci�n
 * @author Pablo S�nchez Sanvicente
 * @version 2.0
 */

public class OrdenarAnimalCosteAdopcion implements Comparator<Animal>{
	/**
	 * M�todo para comparar 2 animales, y ordenarlos seg�n el resultado.
	 */
	public int compare(Animal a1, Animal a2){
		return (int) (a1.costeAdopcion -a2.costeAdopcion);//devuelve un entero positivo si la altura del primero es mayor que del segundo
	}



}

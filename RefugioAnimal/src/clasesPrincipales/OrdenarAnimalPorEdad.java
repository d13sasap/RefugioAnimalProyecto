package clasesPrincipales;

import java.util.Comparator;
/**
 * Clase para ordenar animal por edad
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
public class OrdenarAnimalPorEdad implements Comparator<Animal> {
	public int compare(Animal a1, Animal a2){
		return (int)(a1.getEdad() -a2.getEdad());//devuelve un entero positivo si la altura del primero es mayor que del segundo
	}


}

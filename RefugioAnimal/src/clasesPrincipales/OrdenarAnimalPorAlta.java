package clasesPrincipales;

import java.util.Comparator;
/**
 * Clase para ordenar por alta animal
 * @author Pablo Sánchez Sanvicente
 * @version 2.0
 */
public class OrdenarAnimalPorAlta implements Comparator<Animal>{
	public int compare(Animal a1, Animal a2){
		return a1.getFechaAlta().compareTo(a2.getFechaAlta());
	}
}

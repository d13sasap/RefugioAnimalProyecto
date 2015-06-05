package clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Clase para gestionar nuestro refugio animal y su lista de animales
 * @author Pablo S�nchez Sanvicente
 * @version 2.0
 */
public class RefugioAnimal implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refugio == null) ? 0 : refugio.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefugioAnimal other = (RefugioAnimal) obj;
		if (refugio == null) {
			if (other.refugio != null)
				return false;
		} else if (!refugio.equals(other.refugio))
			return false;
		return true;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3106782368704939824L;
	public boolean nuevo = true;//true si no fue guardado a�n el refugio
	/**
	 * M�todo para saber si el refugio est� ya guardado en fichero o no
	 * @return true si a�n no fue guardado, false si ya fue guardado
	 */
	public boolean isNuevo() {
		return nuevo;
	}
	/**
	 * M�todo para cambiar el estado del atributo nuevo, cuando hagamos un nuevo listado
	 * @param nuevo
	 */
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	/**
	 * ArrayList de animales para el control del refugio
	 */
	public ArrayList<Animal> refugio = new ArrayList<Animal>();
	/**
	 * M�todo que nos devuelve el tama�o del refugio
	 * @return
	 */
	public int getTamanioRefugio(){
		return refugio.size();
	}
	/**
	 * M�todo para  establecer el refugio
	 * @param refugio
	 */
	public void setRefugio(ArrayList<Animal> refugio) {
		this.refugio = refugio;
	}
	/**
	 * m�todo para obtener el arrayList del refugio
	 * @return
	 */
	public ArrayList<Animal> getRefugio() {
		return refugio;
	}
	/**
	 * M�todo para dar de alta un animal
	 * @param animal objeto animal 
	 * @return true si se dio de alta correctamente, false en caso contrario
	 * @throws NombreYaExisteException en caso de que el nombre ya exista
	 */
	public boolean altaAnimal(Animal animal) throws NombreYaExisteException{
		if(!nombreExiste(animal.getNombre().toString()))
			return refugio.add(animal);
		else throw new NombreYaExisteException("Nombre ya en uso");

	}
	/**
	 * M�todo para saber si un nombre ya existe en el refugio
	 * @param nombre cadena con el valor del nombre del animal que queremos dar de alta
	 * @return true si el nombre ya existe, false en caso contrario
	 */
	private boolean nombreExiste(String nombre) {
		for (int i = 0; i < refugio.size(); i++) {
			Animal tmp = refugio.get(i);
			if(tmp.getNombre().equals(nombre))
				return true;

		}
		return false;
	}
	/**
	 * M�todo para dar de baja un animal seg�n el nombre del animal en cuesti�n
	 * @param nombre cadena para el nombre del animal a dar de baja
	 * @return true si se dio de baja correctamente, false en caso contrario
	 */
	public boolean bajaAnimal(String nombre){
		Animal tmp = null;
		for (int i = 0; i < refugio.size(); i++) {
			tmp = refugio.get(i);
			if(tmp.getNombre().equalsIgnoreCase(nombre))
			{
				refugio.remove(i);
				return true;
			}

		}
		return false;
	}//bajaanimal
	/**
	 * M�todo para obtener un animal por su nombre
	 * @param nombre cadena nombre del animal
	 * @return el animal buscado, si no existe se devolver� null
	 */
	public Animal getAnimalNombre(String nombre){
		Animal tmp = null;
		for (int i = 0; i < refugio.size(); i++) {
			tmp = refugio.get(i);
			if(tmp.getNombre().equalsIgnoreCase(nombre))
				return tmp;

		}
		return null;

	}//getAnimal por nombre

	/**
	 * M�todo para obtener un listado de los animales adoptads
	 * @return arraylist con los animales adoptados
	 */
	public ArrayList<Animal> getListaAdoptados(){
		Animal tmp = null;
		ArrayList<Animal> adoptados = new ArrayList<Animal>();
		for (int i = 0; i < refugio.size(); i++) {
			tmp = refugio.get(i);
			if(tmp.estaAdoptado())
				adoptados.add(tmp);
		}

		return adoptados;

	}
	/**
	 * M�todo para obtener una lista de los animales no adoptados
	 * @return arrayList con los animales sin adoptar
	 */
	public ArrayList<Animal> getListaNoAdoptados() {
		Animal tmp = null;
		ArrayList<Animal> adoptados = new ArrayList<Animal>();
		for (int i = 0; i < refugio.size(); i++) {
			tmp = refugio.get(i);
			if(!tmp.estaAdoptado())
				adoptados.add(tmp);
		}

		return adoptados;
	}
	/**
	 * M�todo para obtener una lista de los mam�fero
	 * @return arraylist con los mam�feros del refugio
	 */
	public ArrayList<Mamifero> getlistaMamiferos() {
		Animal temp = null;
		ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp.tipoAnimal == FamiliaAnimales.MAMIFERO))
				mamiferos.add((Mamifero) temp);
		}
		return mamiferos;
	}
	/**
	 * M�todo para obtener una lista de los perros del refugio
	 * @return lista con los perros del refugio
	 */
	public ArrayList<Mamifero> getlistaPerros() {
		Animal temp = null;
		ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp instanceof Perro))
				mamiferos.add((Mamifero) temp);

		}
		return mamiferos;
	}
	/**
	 * M�todo para obtener una lista de los gatos del refugio
	 * @return devuelve un arrayList con los gatos dle refugio
	 */
	public ArrayList<Mamifero> getListaGatos() {
		Animal temp = null;
		ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp instanceof Gato))
				mamiferos.add((Mamifero) temp);

		}
		return mamiferos;
	}
	/**
	 * M�todo para obtener una lista de los reptiles del refugio
	 * @return devuelve un arrayList con los reptiles del rrefuio
	 */
	public ArrayList<Reptil> getlistaReptiles() {
		Animal temp = null;
		ArrayList<Reptil> reptiles = new ArrayList<Reptil>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp.tipoAnimal == FamiliaAnimales.REPTIL))
				reptiles.add((Reptil) temp);
		}
		return reptiles;
	}
	/**
	 * M�todo que devuelve un arrayList de la lista de tortugas del refugio
	 * @return devuelve un arrayList con las tortugas del refugio
	 */
	public ArrayList<Reptil> getlistaTortugas() {
		Animal temp = null;
		ArrayList<Reptil> listaTortugas = new ArrayList<Reptil>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp instanceof Tortuga))
				listaTortugas.add((Reptil) temp);

		}
		return listaTortugas;
	}
	/**
	 * M�todo para obtener un arraylist de las serpientes del refugio
	 * @return devuelve un arraylist con las serpientes del refugio
	 */
	public ArrayList<Reptil> getListaSerpientes() {
		Animal temp = null;
		ArrayList<Reptil> listaSerpientes = new ArrayList<Reptil>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp instanceof Serpiente))
				listaSerpientes.add((Reptil) temp);

		}
		return listaSerpientes;
	}
	/**
	 * M�todo para obtener una lista de las aves del refugio
	 * @return devuelve un arrayList con las aves del refugio
	 */
	public ArrayList<Ave> getlistaAves() {
		Animal temp = null;
		ArrayList<Ave> aves = new ArrayList<Ave>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp.tipoAnimal == FamiliaAnimales.AVE))
				aves.add((Ave) temp);
		}
		return aves;
	}
	/**
	 * M�todo para obtener una lista con las palomas del refugio
	 * @return deuvelve un arrayList con las palomas del refugio
	 */
	public ArrayList<Ave> getlistaPalomas() {
		Animal temp = null;
		ArrayList<Ave> palomas = new ArrayList<Ave>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp instanceof Paloma))
				palomas.add((Paloma) temp);

		}
		return palomas;
	}
	/**
	 * M�todo que ns devuelve una lista con los loros del refugio
	 * @return devuelve un arrayList con los loros del refugio
	 */
	public ArrayList<Ave> getListaLoros() {
		Animal temp = null;
		ArrayList<Ave> palomas = new ArrayList<Ave>();
		for (int i = 0; i < refugio.size(); i++) {
			temp = refugio.get(i);
			if((temp instanceof Loro))
				palomas.add((Loro) temp);

		}
		return palomas;
	}
	/**
	 * M�todo para vaciar el refugio de animales.
	 */
	public void vaciarRefugio(){
		refugio.clear();
		setNuevo(true);

	}
	/**
	 * M�todo para saber si un nombre ya existe
	 * @param nombre nombre para comprobar si ya existe
	 * @return devuelve true si ya existe, false en caso contrario
	 */
	public boolean nombreYaExiste(String nombre){
		Animal tmp;
		for (int i = 0; i < refugio.size(); i++) {
			tmp = refugio.get(i);
			if(tmp.getNombre().equals(nombre))
				return true;
		}
		return false;

	}
}



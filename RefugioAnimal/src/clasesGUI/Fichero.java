package clasesGUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import clasesPrincipales.RefugioAnimal;

public class Fichero {

	static File fichero;  

	/**
	 * Constructor de la clase
	 * @param file objeto de la clase File creado en la interfaz principal
	 */
	public Fichero(File file){
		super();

		fichero = file;
	}

	/**
	 * Método para guardar un fichero nuevo
	 * @param file objeto de la clase File creado en la interfaz principal desde el jfilechooser
	 * @param refugio objeto refugioAnimal el cual queremos guardar
	 * @throws IOException 
	 */
	public void guardarFichero(File file,RefugioAnimal refugio) throws IOException{
		ObjectOutputStream salida = null;
		try {
			salida=new ObjectOutputStream(new FileOutputStream(file));
			salida.writeObject(refugio);


		} catch (IOException e) {

		}finally{
			salida.close();
		}
	}
	/**
	 * Método para guardar un fichero ya creado anteriormente(sobreescribe)
	 * @param file objeto de la clase File creado en la interfaz principal
	 * @param refugio objeto RefugioAnimal el cual queremos guardar
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void guardarFicheroExistente(File file, RefugioAnimal refugio) throws FileNotFoundException, IOException{

		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(file));
		salida.writeObject(refugio);
		salida.close();


	}
	/**
	 * Método con el cual devolvemos el RefugioAnimales del fichero
	 * @param file archivo del cual queremos leer el objeto RefugioAnimal con su arrayList de animales
	 * @return objeto RefugioAnimal
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws ColorNoValidoException
	 * @throws ModeloNoValidoeException
	 * @throws MatriculaNoValidaException
	 */
	public static RefugioAnimal leerFichero(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		RefugioAnimal tmp = new RefugioAnimal();


		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file));
		tmp = (RefugioAnimal) entrada.readObject();
		entrada.close();

		return tmp;

	}



}

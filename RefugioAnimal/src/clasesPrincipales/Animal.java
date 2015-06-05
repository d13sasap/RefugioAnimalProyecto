package clasesPrincipales;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
/**
 * Clase abstracta animal para el refugio de animales
 * @author Pablo S�nchez Sanvicente
 * @version 2.0
 */
@SuppressWarnings("serial")
public abstract class Animal implements Alimentable, Serializable{

	protected String nombre;//
	protected float peso;//
	protected int nPatas;//
	private int edad;//
	protected Sexos sexo;//
	protected Boolean adoptado;//
	protected Calendar fechaAlta;
	protected Calendar fechaAdopcion;
	protected TiposReproduccion reproduccion;//
	protected TiposAlimentacion alimentacion;//
	public float cantidadComidaMensual;//
	protected float costeAdopcion;//

	protected FamiliaAnimales tipoAnimal;
	protected static Pattern patronNombre = Pattern.compile("^[A-Z||�][a-z||�]{2,15}$");//Una sola palabra minimo 3 y m�ximo 10 letras
	protected float factor;



	protected float costeMantenimientoMensual;
	//constructor
	/**
	 * Constructor de la clase Animal
	 * @param nombre nombre del animal
	 * @param peso peso del animal
	 * @param nPatas n�mero de patas del animal
	 * @param edad edad del animal
	 * @param sexo sexo del animal
	 * @param anioAlta a�o de alta del animal en el refugio
	 * @param mesAlta mes de alta del animal en el refugio
	 * @param diaAlta dia de alta del animal en el refugio
	 * @param cantidadComidaMensual cantidad de comida mensual del animal en kilogramos
	 * @param factor factor para calcular el coste de alimentaci�n, factor �nico para cada familia de animales
	 * @throws NombreNoValidoException excepci�n que ocurre cuando el nombre no cumple el patr�n
	 * @throws EdadNoValidaException excepci�n que ocurre cuando la edad no es v�lida(negativa)
	 * @throws DecimalNoValidoException excepci�n que ocurre cuando el decimal es negativo
	 */
	public Animal(String nombre, float peso,int nPatas, int edad, Sexos sexo, int anioAlta, 
			int mesAlta, int diaAlta,float cantidadComidaMensual,float factor) throws NombreNoValidoException, EdadNoValidaException, DecimalNoValidoException {
		super();

		setNombre(nombre);
		setPeso(peso);
		this.nPatas = nPatas;
		setEdad(edad);
		this.sexo = sexo;
		this.adoptado = false;
		//fechaAlta.setLenient(false);
		//fechaAdopcion.setLenient(false);
		this.fechaAlta = new GregorianCalendar(anioAlta,(mesAlta-1),diaAlta);
		setFactor(factor);
		this.cantidadComidaMensual = cantidadComidaMensual;
		this.costeMantenimientoMensual = calcularCosteAlimentacion();





	}//Constructor
	/**
	 * M�todo para establecer el valor del estado de adopci�n del animal
	 * @param adoptado true si est� adoptado false si no est� adoptado
	 */
	public void setAdoptado(Boolean adoptado) {
		this.adoptado = adoptado;
	}
	/**
	 * M�todo para obtener el n�mero de patas del animal
	 * @return devuelve el n�mero de patas del animal
	 */
	public int getnPatas() {
		return nPatas;
	}
	/**
	 * M�etodo para obtener el sexo del animal
	 * @return valor de la enumeraci�n del sexo del animal
	 */
	public Sexos getSexo() {
		return sexo;
	}
	/**
	 * M�todo para obtener el estado del animal en cuanto a si est� adoptado o no
	 * @return true si est� adoptado, false en caso contrario
	 */
	public Boolean getAdoptado() {
		return adoptado;
	}
	/**
	 * M�todo para obtener el tipo de reproducci�n del animal
	 * @return valor de la enumeraci�n del tipo de reproducci�n del animal
	 */
	public TiposReproduccion getReproduccion() {
		return reproduccion;
	}
	/**
	 * m�todo para obtener el tipo de alimentaci�n del animal
	 * @return valor de la enumeraci�n del tipo de alimentaci�n del animal
	 */
	public TiposAlimentacion getAlimentacion() {
		return alimentacion;
	}
	/**
	 * M�todo para obtener el coste de la adopci�n del animal
	 * @return valor decimal del coste de la adopci�n del animal
	 */
	public float getCosteAdopcion() {
		return costeAdopcion;
	}
	/**
	 * M�todo para obtener el coste del mantenimiento mensual del animal
	 * @return valor del coste del mantenimiento mensual del animal
	 */
	public float getCosteMantenimientoMensual() {
		return (float)costeMantenimientoMensual;
	}
	/**
	 * M�todo para obtener el valor de la enumeraci�n del tipo del animal
	 * @return valor del tipo del animal
	 */
	public FamiliaAnimales getTipoAnimal() {
		return tipoAnimal;
	}
	/**
	 * M�todo para establecer la fecha de alta del animal.
	 * @param fechaAlta objeto tipo calendar para manejar la fecha de alta
	 */
	public void setFechaAlta(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * M�todo para obtener la fecha de alta del animal en el refugio
	 * @return Objeto de tipo Calendar que representa la fecha de alta del animal
	 */
	public Calendar getFechaAlta() {
		return fechaAlta;
	}


	/**
	 * M�todo para obtener el peso del animal
	 * @return decimal con el valor del peso del animal
	 */
	public float getPeso() {
		return peso;
	}
	/**
	 * M�todo para establecer el peso del animal
	 * @param peso decimal con valor del peso del animal
	 * @throws DecimalNoValidoException excepci�n que salta en caso de que el argumento peso sea negativo o no v�lido
	 */
	public void setPeso(float peso) throws DecimalNoValidoException {
		if(peso>0)
			this.peso = peso;
		else

			throw new DecimalNoValidoException("El decimal no puede ser negativo");

	}
	/**
	 * M�todo para obtener la edad del animal
	 * @return entero con valor de la edad del animal
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * M�todo para establecer la edad del animal
	 * @param edad entero con valor a la edad del animal
	 * @throws EdadNoValidaException excepci�n que salta en caso que la edad no sea v�lida, valor negativo
	 */
	public void setEdad(int edad) throws EdadNoValidaException {
		if(!esEnteroPositivo(edad))
			throw new EdadNoValidaException("La edad es menor de 0.ERROR");
		else
			this.edad = edad;
	}
	/**
	 * M�todo que nos dice si un entero es positivo o no.
	 * @param entero entero el cual queremos saber si es positivo o no
	 * @return true en caso de ser positivo o false en caso de que el entero sea negativo
	 */
	public static boolean esEnteroPositivo(int entero) {
		if(entero>0)
			return true;
		return false;
	}
	/**
	 * M�todo para obtener el nombre del animal
	 * @return cadena con el valor del nombre del animal
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * M�todo para establecer el nombre del animal
	 * @param nombre cadena con valor del nombre del animal
	 * @throws NombreNoValidoException excepci�n que salta en caso que el nombre del animal no cumpla el patr�n(Palabra de entre 2 y 15 carateres empezando con may�scula y s�lo letras)
	 */
	public void setNombre(String nombre) throws NombreNoValidoException {
		if(esNombreValido(nombre))
			this.nombre = nombre;
		else throw new NombreNoValidoException("Nombre no v�lido");
	}
	/**
	 * M�todo para comprobar si un nombre cumple el patr�n establecido para que sea v�lido
	 * @param nombre cadena de nombre a comprobar si es v�lido 
	 * @return true en caso de ser v�lido el nombre, false en caso negativo
	 */
	public static boolean esNombreValido(String nombre){

		return patronNombre.matcher(nombre).matches();

	}
	/**
	 * M�todo con el cual adoptaremos un animal registrado en el refugio
	 * @param diaAdopcion entero valor del d�a de adopcion	
	 * @param mesAdopcion entero valor al mes de adopci�n del animal
	 * @param anioAdopcion entero valor al a�o del adopci�n del animal
	 * @return true si fue adoptado correctamente, false si no fue posible
	 * @throws FechaAdopcionAnteriorAlta excepci�n que salta si se pretende registrar una fecha de adopci�n previa a la alta en el refugio
	 */
	public boolean adoptarAnimal(int diaAdopcion, int mesAdopcion, int anioAdopcion) throws FechaAdopcionAnteriorAlta{
		if(!adoptado){
			Calendar tmp = new GregorianCalendar(anioAdopcion,mesAdopcion,diaAdopcion);
			if(esAdopcionPosteriorAlta(tmp)){
				setAdoptado(true);
				setFechaAdopcion(tmp);
				return true;
			}
			else throw new FechaAdopcionAnteriorAlta();


		}
		return false;

	}
	/**
	 * M�todo para comprobar si una fecha de adopci�n es anterior a la fecha de alta del animal
	 * @param tmp objeto tipo calendar con valor de la fecha de adopci�n
	 * @return true si fecha es posterior por lo tanto correcta, false si se pretende adoptar antes del registro del animal
	 */
	private boolean esAdopcionPosteriorAlta(Calendar tmp) {
		if(fechaAlta.compareTo(tmp)==-1 || fechaAlta.compareTo(tmp)==0)
			return true;
		return false;


	}
	/**
	 * M�todo para comprobar si est� adoptado el animal
	 * @return true si est� adoptado, false en caso contrario
	 */
	public boolean estaAdoptado(){
		return adoptado;
	}
	/**
	 * M�todo para obtener la fecha de adopci�n del animal
	 * @return objeto tipo Calendar que representa la fecha de adopci�n del animal
	 */
	public Calendar getFechaAdopcion() {
		return fechaAdopcion;
	}
	/**
	 * M�todo para establecer la fecha adopci�n del animal
	 * @param fechaAdopcion objeto tipo calendar que representa la fecha de adopci�n del animal
	 */
	public void setFechaAdopcion(Calendar fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adoptado == null) ? 0 : adoptado.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Animal other = (Animal) obj;
		if (adoptado == null) {
			if (other.adoptado != null)
				return false;
		} else if (!adoptado.equals(other.adoptado))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	/**
	 * M�todo para comparar un animal con otro, y ordenarlo por nombre(debido al equals de Animal)
	 * @param o objeto de tipo Animal
	 * @return 1 si el argumento est� primero alfab�ticamente, 0 si son iguales, y 1 si el argumento es el segundo en orden alfab�tico
	 */
	public int compareTo(Animal o) { 
		return this.nombre.compareTo(o.nombre);
	}

	/**
	 * M�todo del interfaz alimentable para calcular el coste mensual del animal. En el devolvemos el producto del factor por la cantidad de comida mensual
	 */
	@Override
	public float calcularCosteAlimentacion() {
		float producto =getFactor()*cantidadComidaMensual;
		producto*= (float)1;

		return producto;
	}

	/**
	 * M�todo que para calcular si un n�mero de tipo float es positivo
	 * @param doble numero decimal float para calcular
	 * @return true si es positivo , false si es negativo
	 */
	public static boolean esDecimalPositivo(float decimal) {
		if(decimal>0)
			return true;
		return false;
	}
	/**
	 * M�todo para obtener el factor de alimentaci�n del animal
	 * @return valor del factor del animal
	 */
	public float getFactor() {
		return factor;
	}
	/**
	 * M�todo para establecer el factor del animal seg�n su familia.
	 * @param factor
	 */
	public void setFactor(float factor) {
		this.factor = factor;
	}
}

package clasesGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import clasesPrincipales.EdadNoValidaException;
import clasesPrincipales.NombreNoValidoException;
import clasesPrincipales.NombreYaExisteException;
import clasesPrincipales.RefugioAnimal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Principal extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	public static RefugioAnimal refugio = new RefugioAnimal();
	private static boolean ayudaAbierta;

	Fichero fichero;
	File file;
	JFileChooser guardar;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() throws NombreYaExisteException, NombreNoValidoException, EdadNoValidaException {

		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Refugio(*.ref)", "ref");
		final JFileChooser abrir = new JFileChooser();
		guardar = new JFileChooser();
		guardar.setFileFilter(filtro);
		abrir.setFileFilter(filtro);
		setTituloSinGuardar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setTituloSinGuardar();
				int seleccion = 0;
				if(!refugioModificado()){
					nuevoRefugio();
				}
				else{
					seleccion = JOptionPane.showOptionDialog(contentPane, "El archivo está modificado sin guardar.¿Desea guardar?", "ATENCIÓN", 
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No","Cancelar"}, "Si");
					if(seleccion == 1){
						nuevoRefugio();
					}
					else if(seleccion == 0){
						if(refugio.isNuevo())
						{
							guardarComo(guardar);
							nuevoRefugio();
						}

						else
						{
							guardarRefugio(guardar);
							nuevoRefugio();
						}
					}
				}

			}


		});
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = 0;
				opcion = abrir.showOpenDialog(contentPane);
				if(opcion == JFileChooser.APPROVE_OPTION){
					file = abrir.getSelectedFile();
					try {
						refugio = Fichero.leerFichero(abrir.getSelectedFile());
						setTitle("Refugio - "+file.getName());
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(contentPane,
								"ERROR! El archivo no se existe", "Error",
								JOptionPane.ERROR_MESSAGE);// TODO Auto-generated catch block
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(contentPane,
								"ERROR! El archivo no es del tipo Refugio Animal (*.ref)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane,
								"ERROR! El archivo no es del tipo Refugio Animal (*.ref)", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		mnArchivo.add(mntmAbrir);

		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarRefugio(guardar);
			}


		});
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo(guardar);
			}


		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = 0;
				if(!refugioModificado()){
					System.exit(0);
				}
				else{
					seleccion = JOptionPane.showOptionDialog(contentPane, "El archivo está modificado sin guardar.¿Desea guardar antes de salir?", "ATENCIÓN", 
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No","Cancelar"}, "Si");
					if(seleccion == 1){
						System.exit(0);
					}
					else if(seleccion == 0){
						if(refugio.isNuevo())
						{
							guardarComo(guardar);
							System.exit(0);
						}

						else
						{
							guardarRefugio(guardar);
							System.exit(0);
						}
					}
				}
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnRefugio = new JMenu("Refugio");
		menuBar.add(mnRefugio);

		JMenu mnAltaAnimal = new JMenu("Alta Animal");
		mnRefugio.add(mnAltaAnimal);

		JMenu mnMamifero = new JMenu("Mamifero");
		mnAltaAnimal.add(mnMamifero);


		JMenuItem mntmPerro = new JMenuItem("Perro");
		mntmPerro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaMamifero alta = new AltaMamifero(true);
				alta.setVisible(true);

			}
		});
		mnMamifero.add(mntmPerro);

		JMenuItem mntmGato = new JMenuItem("Gato");
		mntmGato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaMamifero alta = new AltaMamifero(false);
				alta.setVisible(true);
			}
		});
		mnMamifero.add(mntmGato);

		JMenu mnAve = new JMenu("Ave");
		mnAltaAnimal.add(mnAve);

		JMenuItem mntmPaloma = new JMenuItem("Paloma");
		mntmPaloma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaNoMamifero alta = new AltaNoMamifero(0);
				alta.setVisible(true);
			}
		});
		mnAve.add(mntmPaloma);

		JMenuItem mntmLoro = new JMenuItem("Loro");
		mntmLoro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaNoMamifero alta = new AltaNoMamifero(1);
				alta.setVisible(true);
			}
		});
		mnAve.add(mntmLoro);

		JMenu mnReptil = new JMenu("Reptil");
		mnAltaAnimal.add(mnReptil);

		JMenuItem mntmTortuga = new JMenuItem("Tortuga");
		mntmTortuga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaNoMamifero alta = new AltaNoMamifero(2);
				alta.setVisible(true);
			}
		});
		mnReptil.add(mntmTortuga);

		JMenuItem mntmSerpiente = new JMenuItem("Serpiente");
		mntmSerpiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaNoMamifero alta = new AltaNoMamifero(3);
				alta.setVisible(true);
			}
		});
		mnReptil.add(mntmSerpiente);

		JMenuItem mntmBajaAnimal = new JMenuItem("Baja Animal");
		mntmBajaAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaAnimal baja = new BajaAnimal();
				baja.setVisible(true);
			}
		});
		mnRefugio.add(mntmBajaAnimal);

		JMenuItem mntmAdoptarAnimal = new JMenuItem("Adoptar Animal");
		mntmAdoptarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdoptarAnimal adop = new AdoptarAnimal();
				adop.setVisible(true);
			}
		});
		mnRefugio.add(mntmAdoptarAnimal);

		JMenu mnMostrar = new JMenu("Mostrar");
		menuBar.add(mnMostrar);

		JMenuItem mntmAnimal = new JMenuItem("Animal");
		mntmAnimal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mntmAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarAnimal mostrar = new MostrarAnimal();
				mostrar.setVisible(true);
			}
		});

		JMenuItem mntmTamaoRefugio = new JMenuItem("Tama\u00F1o Refugio");
		mntmTamaoRefugio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mntmTamaoRefugio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTamanioRefugio();



			}
		});
		mnMostrar.add(mntmTamaoRefugio);

		JMenuItem mntmRefugioCompleto = new JMenuItem("Refugio Completo");
		mntmRefugioCompleto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
		mntmRefugioCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(refugio.refugio.size() !=0){
					MostrarRefugio mostrar = new MostrarRefugio();
					mostrar.setVisible(true);
				}else
					JOptionPane.showMessageDialog(contentPane,
							"No hay animales en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	

			}
		});
		mnMostrar.add(mntmRefugioCompleto);
		mnMostrar.add(mntmAnimal);

		JMenu mnMamiferos = new JMenu("Mamiferos");
		mnMostrar.add(mnMamiferos);

		JMenuItem mntmTodos = new JMenuItem("Todos");
		mntmTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MostrarMamiferos mamiferos = new MostrarMamiferos(0);
					mamiferos.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay mamíferos en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}

			}
		});
		mnMamiferos.add(mntmTodos);

		JMenuItem mntmPerros = new JMenuItem("Perros");
		mntmPerros.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					MostrarMamiferos perros = new MostrarMamiferos(1);
					perros.setVisible(true);
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay perros en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		mnMamiferos.add(mntmPerros);

		JMenuItem mntmGatos = new JMenuItem("Gatos");
		mntmGatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarMamiferos perros = new MostrarMamiferos(2);
					perros.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay gatos en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		mnMamiferos.add(mntmGatos);

		JMenu mnAves = new JMenu("Aves");
		mnMostrar.add(mnAves);

		JMenuItem mntmTodos_1 = new JMenuItem("Todos");
		mntmTodos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MostrarAves aves = new MostrarAves(0);
					aves.setVisible(true);
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay aves en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		mnAves.add(mntmTodos_1);

		JMenuItem mntmPalomas = new JMenuItem("Palomas");
		mntmPalomas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarAves aves = new MostrarAves(1);
					aves.setVisible(true);
				} catch (IndexOutOfBoundsException ee) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay palomas en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		mnAves.add(mntmPalomas);

		JMenuItem mntmLoros = new JMenuItem("Loros");
		mntmLoros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarAves aves = new MostrarAves(2);
					aves.setVisible(true);
				} catch (IndexOutOfBoundsException ee) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay loros en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		mnAves.add(mntmLoros);

		JMenu mnReptiles = new JMenu("Reptiles");
		mnMostrar.add(mnReptiles);

		JMenuItem mntmTodos_2 = new JMenuItem("Todos");
		mntmTodos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarReptiles reptiles = new MostrarReptiles(0);
					reptiles.setVisible(true);
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay reptiles en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}

			}
		});
		mnReptiles.add(mntmTodos_2);

		JMenuItem mntmTortugas = new JMenuItem("Tortugas");
		mntmTortugas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarReptiles reptiles = new MostrarReptiles(1);
					reptiles.setVisible(true);
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay tortugas en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}

			}
		});
		mnReptiles.add(mntmTortugas);

		JMenuItem mntmSerpientes = new JMenuItem("Serpientes");
		mntmSerpientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarReptiles reptiles = new MostrarReptiles(2);
					reptiles.setVisible(true);
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(contentPane,
							"No hay serpientes en el refugio", "Error",
							JOptionPane.ERROR_MESSAGE);	
				}

			}
		});
		mnReptiles.add(mntmSerpientes);

		JMenuItem mntmPorFechaAlta = new JMenuItem("Por Fecha Alta");
		mntmPorFechaAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarRefugioPorAlta mostrarAlta = new MostrarRefugioPorAlta();
				mostrarAlta.setVisible(true);
			}
		});
		mnMostrar.add(mntmPorFechaAlta);

		JMenuItem mntmPorPeso = new JMenuItem("Por peso");
		mntmPorPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarRefugioPorPeso peso = new MostrarRefugioPorPeso();
				peso.setVisible(true);
			}
		});
		mnMostrar.add(mntmPorPeso);

		JMenuItem mntmPorEdad = new JMenuItem("Por edad");
		mntmPorEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarRefugioPorEdad edad = new MostrarRefugioPorEdad();
				edad.setVisible(true);
			}
		});
		mnMostrar.add(mntmPorEdad);

		JMenuItem mntmSinAdoptar = new JMenuItem("Sin Adoptar");
		mntmSinAdoptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarSinAdoptar libres;
				try {
					libres = new MostrarSinAdoptar();
					libres.setVisible(true);
				} catch (ListaVaciaException e1) {
					if(refugio.refugio.size() !=0){
						JOptionPane.showMessageDialog(contentPane,"No hay animales sin adoptar. Genial!");
					}
					else
						JOptionPane.showMessageDialog(contentPane,"Refugio Vacío");

				}

			}
		});
		mnMostrar.add(mntmSinAdoptar);

		JMenuItem mntmAdoptados = new JMenuItem("Adoptados");
		mntmAdoptados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarAdoptados adoptados;
				try {
					adoptados = new MostrarAdoptados();
					adoptados.setVisible(true);
				} catch (ListaVaciaException e1) {
					if(refugio.refugio.size() !=0){
						JOptionPane.showMessageDialog(contentPane,"No hay animales adoptados.");
					}
					else
						JOptionPane.showMessageDialog(contentPane,"Refugio Vacío");

				}
			}
		});
		mnMostrar.add(mntmAdoptados);

		JMenu mnMs = new JMenu("M\u00E1s...");
		menuBar.add(mnMs);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirAyuda();

			}




		});
		mnMs.add(mntmAyuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		mnMs.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private static void getTamanioRefugio() {
		JOptionPane.showMessageDialog(contentPane,
				"El refugio tiene "+ refugio.getTamanioRefugio() +" animales registrados.");
	}
	private void guardarComo(JFileChooser guardar) {
		int opcion = 0;
		opcion = guardar.showSaveDialog(contentPane);
		if(opcion == JFileChooser.APPROVE_OPTION){
			file = guardar.getSelectedFile();
			fichero = new Fichero(file);

			try {
				refugio.setNuevo(false);
				fichero.guardarFichero(file, refugio);

				setTitle("Refugio - "+file.getName());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(contentPane,
						"ERROR! Fallo al guardar (IOException)", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}//guardarComo
	private void guardarRefugio(JFileChooser guardar) {
		if(refugio.isNuevo())
			guardarComo(guardar);
		else{
			try {
				Fichero.guardarFicheroExistente(file, refugio);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(contentPane,
						"ERROR! El archivo a guardar no existe", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(contentPane,
						"ERROR! Fallo al guardar (IOException)", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}//guardarRefugio

	/**
	 * Método para establecer el título en el caso que el archivo sea nuevo
	 */
	private void setTituloSinGuardar() {
		setTitle("Refugio - Sin Guardar");
	}
	@SuppressWarnings("static-access")
	private boolean refugioModificado(){
		if(!refugio.isNuevo()){
			RefugioAnimal guardado = null;
			try {
				guardado = fichero.leerFichero(file);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(contentPane,
						"ERROR! El archivo a guardar no existe", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(contentPane,
						"ERROR! Tipo de archivo inválido", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(contentPane,
						"ERROR! Fallo al guardar (IOException)", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			return !(guardado.equals(refugio));//false si no esta modificado
		}
		else{
			RefugioAnimal tmp = new RefugioAnimal();
			if(tmp.equals(refugio))
				return false;

		}
		return true;


	}//refugioModificado
	private void nuevoRefugio() {
		refugio = new RefugioAnimal();
		setTituloSinGuardar();
	}

	public static boolean isAyudaAbierta() {
		return ayudaAbierta;
	}

	public static void setAyudaAbierta(boolean estadoAyuda) {
		ayudaAbierta = estadoAyuda;
	}
	static void abrirAyuda() {
		if(!isAyudaAbierta()){
			setAyudaAbierta(true);
			Ayuda ayuda = new Ayuda();
			ayuda.setVisible(true);
		}
	}
}

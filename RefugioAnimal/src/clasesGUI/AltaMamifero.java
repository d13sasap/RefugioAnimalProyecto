package clasesGUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import clasesPrincipales.Animal;
import clasesPrincipales.DecimalNoValidoException;
import clasesPrincipales.EdadNoValidaException;
import clasesPrincipales.Gato;
import clasesPrincipales.NombreNoValidoException;
import clasesPrincipales.NombreYaExisteException;
import clasesPrincipales.Perro;
import clasesPrincipales.Sexos;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
@SuppressWarnings("serial")
public class AltaMamifero extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static boolean bool = true;
	private JTextField nombreTextField;
	private JTextField pesoTextField;
	private JTextField razaTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField CosteAdopTextField;
	private JTextField diaAltatextField_1;
	private JTextField comidaMensualtextField;
	JLabel etiqueta = null;
	private JTextField edadTextField_2;
	private JTextField mesAltaTextField;
	private JTextField anioAltaTextField;
	boolean creado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaMamifero dialog = new AltaMamifero(bool);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaMamifero(final boolean bool) {
		setResizable(false);
		setModal(true);
		//		//Probando
		//		tmp = Principal.refugio;
		//		//--------

		establecerTitulo(bool);
		setBounds(100, 100, 582, 408);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 61, 25);
		contentPanel.add(lblNombre);

		nombreTextField = new JTextField();
		nombreTextField.setBounds(167, 11, 127, 25);
		contentPanel.add(nombreTextField);
		nombreTextField.setColumns(10);
		{
			JLabel lblPeso = new JLabel("Peso");
			lblPeso.setBounds(10, 46, 61, 25);
			contentPanel.add(lblPeso);
		}
		{
			pesoTextField = new JTextField();
			pesoTextField.setColumns(10);
			pesoTextField.setBounds(167, 46, 127, 25);
			contentPanel.add(pesoTextField);
		}
		{
			JLabel lblRaza = new JLabel("Raza");
			lblRaza.setBounds(10, 82, 61, 25);
			contentPanel.add(lblRaza);
		}
		{
			razaTextField = new JTextField();
			razaTextField.setColumns(10);
			razaTextField.setBounds(167, 82, 127, 25);
			contentPanel.add(razaTextField);
		}

		JPanel sexoPanel = new JPanel();
		sexoPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		sexoPanel.setBounds(10, 258, 157, 46);
		contentPanel.add(sexoPanel);
		sexoPanel.setLayout(null);

		JRadioButton rdbtnMacho = new JRadioButton("Macho");
		rdbtnMacho.setSelected(true);
		rdbtnMacho.setBounds(6, 16, 70, 23);
		sexoPanel.add(rdbtnMacho);

		buttonGroup.add(rdbtnMacho);

		final JRadioButton rdbtnHembra = new JRadioButton("Hembra");
		rdbtnHembra.setBounds(86, 16, 78, 23);
		sexoPanel.add(rdbtnHembra);
		buttonGroup.add(rdbtnHembra);

		JLabel lblCosteAdopcin = new JLabel("Coste Adopci\u00F3n");
		lblCosteAdopcin.setBounds(10, 154, 91, 25);
		contentPanel.add(lblCosteAdopcin);

		CosteAdopTextField = new JTextField();
		CosteAdopTextField.setColumns(10);
		CosteAdopTextField.setBounds(167, 154, 127, 25);
		contentPanel.add(CosteAdopTextField);

		JLabel lblFechaAlta = new JLabel("Fecha Alta (dd/mm/aaaa)");
		lblFechaAlta.setBounds(10, 222, 157, 25);
		contentPanel.add(lblFechaAlta);

		diaAltatextField_1 = new JTextField();
		diaAltatextField_1.setColumns(10);
		diaAltatextField_1.setBounds(167, 222, 30, 25);
		contentPanel.add(diaAltatextField_1);

		JLabel lblMantenimientoMensual = new JLabel("Comida Mensual");
		lblMantenimientoMensual.setBounds(10, 188, 136, 25);
		contentPanel.add(lblMantenimientoMensual);

		comidaMensualtextField = new JTextField();
		comidaMensualtextField.setColumns(10);
		comidaMensualtextField.setBounds(167, 188, 127, 25);
		contentPanel.add(comidaMensualtextField);

		etiqueta = new JLabel(new ImageIcon("Perro.jpg"));
		if(!bool)
			etiqueta.setIcon(new ImageIcon("gato.jpg"));
		etiqueta.setBounds(336, 46, 194, 178);
		contentPanel.add(etiqueta);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 118, 61, 25);
		contentPanel.add(lblEdad);

		edadTextField_2 = new JTextField();
		edadTextField_2.setColumns(10);
		edadTextField_2.setBounds(167, 118, 127, 25);
		contentPanel.add(edadTextField_2);

		mesAltaTextField = new JTextField();
		mesAltaTextField.setColumns(10);
		mesAltaTextField.setBounds(207, 222, 28, 25);
		contentPanel.add(mesAltaTextField);

		anioAltaTextField = new JTextField();
		anioAltaTextField.setColumns(10);
		anioAltaTextField.setBounds(245, 222, 49, 25);
		contentPanel.add(anioAltaTextField);

		final JLabel enUsolbl = new JLabel("Nombre en uso");
		enUsolbl.setVisible(false);
		enUsolbl.setForeground(Color.RED);
		enUsolbl.setBounds(336, 11, 114, 25);
		contentPanel.add(enUsolbl);

		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.abrirAyuda();
			}
		});
		btnAyuda.setBounds(438, 12, 92, 23);
		contentPanel.add(btnAyuda);
		FocusListener nombreListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if(!Animal.esNombreValido(nombreTextField.getText()))
					nombreTextField.setForeground(Color.red);
				if(Principal.refugio.nombreYaExiste(nombreTextField.getText()))
					enUsolbl.setVisible(true);

			}

			@Override
			public void focusGained(FocusEvent e) {
				nombreTextField.setForeground(Color.black);
				if(Principal.refugio.nombreYaExiste(nombreTextField.getText()))
					enUsolbl.setVisible(false);

			}
		};
		nombreTextField.addFocusListener(nombreListener);
		FocusListener edadListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esEnteroPositivo(Integer.parseInt(edadTextField_2.getText())))
						edadTextField_2.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					edadTextField_2.setForeground(Color.red);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					edadTextField_2.setForeground(Color.black);
				} catch (NumberFormatException e2) {
					edadTextField_2.setForeground(Color.black);
				}

			}
		};//listeneredad
		edadTextField_2.addFocusListener(edadListener);
		FocusListener pesoListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esDecimalPositivo(Float.parseFloat(pesoTextField.getText())))
						pesoTextField.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					pesoTextField.setForeground(Color.red);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					pesoTextField.setForeground(Color.black);
				} catch (NumberFormatException e2) {
					pesoTextField.setForeground(Color.black);
				}

			}
		};
		pesoTextField.addFocusListener(pesoListener);
		FocusListener costeAdopcionListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esDecimalPositivo(Float.parseFloat(CosteAdopTextField.getText())))
						CosteAdopTextField.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					CosteAdopTextField.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					CosteAdopTextField.setForeground(Color.black);
				} catch (NumberFormatException e2) {
					CosteAdopTextField.setForeground(Color.black);
				}

			}
		};
		CosteAdopTextField.addFocusListener(costeAdopcionListener);
		FocusListener comidaMensual = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esDecimalPositivo(Float.parseFloat(comidaMensualtextField.getText())))
						comidaMensualtextField.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					comidaMensualtextField.setForeground(Color.red);
				}


			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					comidaMensualtextField.setForeground(Color.black);
				} catch (NumberFormatException e2) {
					comidaMensualtextField.setForeground(Color.black);

				}

			}
		};
		comidaMensualtextField.addFocusListener(comidaMensual);

		FocusListener razaListener = new FocusListener() {


			@Override
			public void focusLost(FocusEvent e) {
				if(!Animal.esNombreValido(razaTextField.getText()))
					razaTextField.setForeground(Color.red);

			}

			@Override
			public void focusGained(FocusEvent e) {
				razaTextField.setForeground(Color.black);

			}
		};
		razaTextField.addFocusListener(razaListener);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(bool){//si true es un perro

							altaPerro();


						}//if
						else{
							altaGato();


						}

						if(creado)
						{
							JOptionPane.showMessageDialog(contentPanel,
									"Animal añadido con éxito");
							dispose();
						}
						else{
							//						
							int opcion = JOptionPane.showConfirmDialog(contentPanel,  "Datos Incorrectos. ¿Desea consultar la ayuda?", "Error al dar de alta", JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
							if(opcion == JOptionPane.YES_OPTION)
								Principal.abrirAyuda();
						}

					}

					private void altaGato() {
						//si no =  es un gato

						try {
							creado = Principal.refugio.altaAnimal(new Gato(nombreTextField.getText(), Float.parseFloat(pesoTextField.getText()), Integer.parseInt(edadTextField_2.getText())
									, sexoElegido(), Integer.parseInt(anioAltaTextField.getText()), Integer.parseInt(mesAltaTextField.getText()),
									Integer.parseInt(diaAltatextField_1.getText()), Float.parseFloat(comidaMensualtextField.getText()), 
									razaTextField.getText().trim(), Float.parseFloat(CosteAdopTextField.getText())));
						} catch (EdadNoValidaException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Edad no válida", "Error",
									JOptionPane.ERROR_MESSAGE);	
						}catch (NombreNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre no válido", "Error",
									JOptionPane.ERROR_MESSAGE);	

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Formato de número inválido", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NombreYaExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre ya existe", "Error",
									JOptionPane.ERROR_MESSAGE);	

						} 
						catch (DecimalNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Decimal No Válido. Debe ser positivo.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					private void altaPerro() {
						try {
							creado = Principal.refugio.altaAnimal(new Perro(nombreTextField.getText(), Float.parseFloat(pesoTextField.getText()), Integer.parseInt(edadTextField_2.getText())
									, sexoElegido(), Integer.parseInt(anioAltaTextField.getText()), Integer.parseInt(mesAltaTextField.getText()),
									Integer.parseInt(diaAltatextField_1.getText()), Float.parseFloat(comidaMensualtextField.getText()), 
									razaTextField.getText().trim(), Float.parseFloat(CosteAdopTextField.getText())));
						}
						catch (EdadNoValidaException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Edad no válida", "Error",
									JOptionPane.ERROR_MESSAGE);	
						}catch (NombreNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre no válido", "Error",
									JOptionPane.ERROR_MESSAGE);	

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Formato de número inválido", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NombreYaExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre ya existe", "Error",
									JOptionPane.ERROR_MESSAGE);	

						} 
						catch (DecimalNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Decimal No Válido. Debe ser positivo.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					private Sexos sexoElegido() {
						if(rdbtnHembra.isSelected())
							return Sexos.HEMBRA;
						return Sexos.MACHO;
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	/**
	 * Método que nos establece el título del diálogo según el tipo de mamífero a dar de alta
	 * @param bool2
	 */
	private void establecerTitulo(boolean bool2) {
		if(bool2)
			setTitle("Alta Perro");
		else
			setTitle("Alta Gato");

	}
}

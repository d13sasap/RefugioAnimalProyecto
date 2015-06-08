package clasesGUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JRadioButton;

import clasesPrincipales.Animal;
import clasesPrincipales.DecimalNoValidoException;
import clasesPrincipales.EdadNoValidaException;
import clasesPrincipales.Loro;
import clasesPrincipales.NombreNoValidoException;
import clasesPrincipales.NombreYaExisteException;
import clasesPrincipales.Paloma;
import clasesPrincipales.Serpiente;
import clasesPrincipales.Sexos;
import clasesPrincipales.Tortuga;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class AltaNoMamifero extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6520989707856544366L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombretextField;
	private JTextField pesotextField_1;
	private JTextField costeAdopcontextField_3;
	private JTextField comidaMensualtextField_4;
	static int idAnimal = 0;
	JLabel etiqueta = new JLabel((Icon) null);
	private JTextField edadtextField_2;
	private JTextField mesAltatextField_6;
	private JTextField anioAltatextField_7;
	private JTextField diaAltatextField_5;
	JRadioButton hembraradioButton;
	JRadioButton machoradioButton;
	JCheckBox venenosaCheckBox;
	boolean creado = false;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblEnUso;

	

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("static-access")
	public AltaNoMamifero(final int idAnimal) {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 573, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.idAnimal = idAnimal;

		setIcono(idAnimal);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Nombre");
			label.setBounds(10, 23, 61, 25);
			contentPanel.add(label);
		}
		{
			nombretextField = new JTextField();
			nombretextField.setColumns(10);
			nombretextField.setBounds(167, 23, 91, 23);
			contentPanel.add(nombretextField);
		}
		{
			JLabel label = new JLabel("Peso");
			label.setBounds(10, 57, 61, 25);
			contentPanel.add(label);
		}
		{
			pesotextField_1 = new JTextField();
			pesotextField_1.setColumns(10);
			pesotextField_1.setBounds(167, 57, 91, 23);
			contentPanel.add(pesotextField_1);
		}
		{
			JLabel label = new JLabel("Coste Adopci\u00F3n");
			label.setBounds(10, 127, 91, 25);
			contentPanel.add(label);
		}
		{
			costeAdopcontextField_3 = new JTextField();
			costeAdopcontextField_3.setColumns(10);
			costeAdopcontextField_3.setBounds(167, 127, 91, 23);
			contentPanel.add(costeAdopcontextField_3);
		}
		{
			JLabel lblComidaMensual = new JLabel("Comida Mensual");
			lblComidaMensual.setBounds(10, 161, 136, 25);
			contentPanel.add(lblComidaMensual);
		}
		{
			comidaMensualtextField_4 = new JTextField();
			comidaMensualtextField_4.setColumns(10);
			comidaMensualtextField_4.setBounds(167, 161, 91, 23);
			contentPanel.add(comidaMensualtextField_4);
		}
		{
			JLabel label = new JLabel("Fecha Alta");
			label.setBounds(10, 195, 61, 25);
			contentPanel.add(label);
		}
		{

			etiqueta.setBounds(304, 57, 243, 163);
			contentPanel.add(etiqueta);
		}
		{
			JPanel sexopanel = new JPanel();
			sexopanel.setLayout(null);
			sexopanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			sexopanel.setBounds(10, 226, 157, 46);
			contentPanel.add(sexopanel);
			{
				machoradioButton = new JRadioButton("Macho");
				buttonGroup.add(machoradioButton);
				machoradioButton.setSelected(true);
				machoradioButton.setBounds(6, 16, 70, 23);
				sexopanel.add(machoradioButton);
			}
			{
				hembraradioButton = new JRadioButton("Hembra");
				buttonGroup.add(hembraradioButton);
				hembraradioButton.setBounds(86, 16, 78, 23);
				sexopanel.add(hembraradioButton);

			}
		}
		{
			JLabel label = new JLabel("Edad");
			label.setBounds(10, 93, 61, 25);
			contentPanel.add(label);
		}
		{
			edadtextField_2 = new JTextField();
			edadtextField_2.setColumns(10);
			edadtextField_2.setBounds(167, 93, 91, 25);
			contentPanel.add(edadtextField_2);
		}
		{
			mesAltatextField_6 = new JTextField();
			mesAltatextField_6.setColumns(10);
			mesAltatextField_6.setBounds(207, 195, 28, 25);
			contentPanel.add(mesAltatextField_6);
		}
		{
			anioAltatextField_7 = new JTextField();
			anioAltatextField_7.setColumns(10);
			anioAltatextField_7.setBounds(245, 195, 49, 25);
			contentPanel.add(anioAltatextField_7);
		}
		{
			diaAltatextField_5 = new JTextField();
			diaAltatextField_5.setColumns(10);
			diaAltatextField_5.setBounds(167, 195, 28, 25);
			contentPanel.add(diaAltatextField_5);
		}

		venenosaCheckBox = new JCheckBox("Venenosa");
		venenosaCheckBox.setVisible(false);
		venenosaCheckBox.setBounds(173, 242, 97, 23);
		contentPanel.add(venenosaCheckBox);
		{
			lblEnUso = new JLabel("Nombre en uso");
			lblEnUso.setVisible(false);
			lblEnUso.setForeground(Color.RED);
			lblEnUso.setBounds(304, 24, 136, 23);
			contentPanel.add(lblEnUso);
		}

		JButton button = new JButton("Ayuda");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.abrirAyuda();
			}
		});
		button.setBounds(455, 24, 92, 23);
		contentPanel.add(button);
		FocusListener nombreListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if(!Animal.esNombreValido(nombretextField.getText()))
					nombretextField.setForeground(Color.red);
				if(Principal.refugio.nombreYaExiste(nombretextField.getText()))
					lblEnUso.setVisible(true);

			}

			@Override
			public void focusGained(FocusEvent e) {
				nombretextField.setForeground(Color.black);
				if(Principal.refugio.nombreYaExiste(nombretextField.getText()))
					lblEnUso.setVisible(false);

			}
		};
		nombretextField.addFocusListener(nombreListener);
		FocusListener edadListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esEnteroPositivo(Integer.parseInt(edadtextField_2.getText())))
						edadtextField_2.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					edadtextField_2.setForeground(Color.red);
				}


			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					edadtextField_2.setForeground(Color.black);
				} catch (NumberFormatException e2) {
					edadtextField_2.setForeground(Color.black);
				}

			}
		};//listeneredad
		edadtextField_2.addFocusListener(edadListener);
		FocusListener pesoListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esDecimalPositivo(Float.parseFloat(pesotextField_1.getText())))
						pesotextField_1.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					pesotextField_1.setForeground(Color.red);
				}


			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					pesotextField_1.setForeground(Color.black);
				} catch (Exception e2) {
					pesotextField_1.setForeground(Color.black);
				}

			}
		};
		pesotextField_1.addFocusListener(pesoListener);
		FocusListener costeAdopcionListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esDecimalPositivo(Float.parseFloat(costeAdopcontextField_3.getText())))
						costeAdopcontextField_3.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					costeAdopcontextField_3.setForeground(Color.red);
				}


			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					costeAdopcontextField_3.setForeground(Color.black);
				} catch (NumberFormatException e2) {
					costeAdopcontextField_3.setForeground(Color.black);				}

			}
		};
		costeAdopcontextField_3.addFocusListener(costeAdopcionListener);
		FocusListener comidaMensual = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(!Animal.esDecimalPositivo(Float.parseFloat(comidaMensualtextField_4.getText())))
						comidaMensualtextField_4.setForeground(Color.red);
				} catch (NumberFormatException e2) {
					comidaMensualtextField_4.setForeground(Color.red);
				}


			}

			@Override
			public void focusGained(FocusEvent e) {
				try {
					comidaMensualtextField_4.setForeground(Color.black);
				} catch (NumberFormatException e2) {
					comidaMensualtextField_4.setForeground(Color.black);				}

			}
		};
		comidaMensualtextField_4.addFocusListener(comidaMensual);
		if(idAnimal==3)
			venenosaCheckBox.setVisible(true);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						switch (idAnimal) {
						case 0:
							altaPaloma();
							break;
						case 1:
							altaLoro();
							break;
						case 2:
							altaTortuga();
							break;
						case 3:
							altaSerpiente();
							break;
						default:
							break;
						}

						if(creado)
						{
							JOptionPane.showMessageDialog(contentPanel,
									"Animal añadido con éxito");
							dispose();
						}
						else{
							int opcion = JOptionPane.showConfirmDialog(contentPanel,  "Datos Incorrectos. ¿Desea consultar la ayuda?", "Error al dar de alta", JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
							if(opcion == JOptionPane.YES_OPTION)
								Principal.abrirAyuda();
						}


					}

					private void altaSerpiente() {
						try {
							venenosaCheckBox.setVisible(true);
							creado = Principal.refugio.altaAnimal(new Serpiente(nombretextField.getText().trim(), Float.parseFloat(pesotextField_1.getText()), Integer.parseInt(edadtextField_2.getText()), sexoElegido(),Animal.comprobarFecha( Integer.parseInt(anioAltatextField_7.getText()), Integer.parseInt(mesAltatextField_6.getText()), Integer.parseInt(diaAltatextField_5.getText())), Float.parseFloat(comidaMensualtextField_4.getText()), Float.parseFloat(costeAdopcontextField_3.getText()), venenosaCheckBox.isSelected()));
						}  catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Formato de fecha inválido", "Error",
									JOptionPane.ERROR_MESSAGE);	
						} catch (NombreNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre no válido", "Error",
									JOptionPane.ERROR_MESSAGE);	
						} catch (EdadNoValidaException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Edad no válida", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (DecimalNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Decimal no válido", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NombreYaExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre ya existe", "Error",
									JOptionPane.ERROR_MESSAGE);
						}catch (IllegalArgumentException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"La fecha es incorrecta.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					private void altaTortuga() {
						try {
							creado = Principal.refugio.altaAnimal(new Tortuga(nombretextField.getText().trim(),  Float.parseFloat(pesotextField_1.getText()), Integer.parseInt(edadtextField_2.getText()), sexoElegido(), Animal.comprobarFecha( Integer.parseInt(anioAltatextField_7.getText()), Integer.parseInt(mesAltatextField_6.getText()), Integer.parseInt(diaAltatextField_5.getText())), Float.parseFloat(comidaMensualtextField_4.getText()), Float.parseFloat(costeAdopcontextField_3.getText())));
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Formato de fecha inválido", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NombreNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre no válido", "Error",
									JOptionPane.ERROR_MESSAGE);	
						} catch (EdadNoValidaException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Edad no válida", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (DecimalNoValidoException e1) {

						} catch (NombreYaExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre ya existe", "Error",
									JOptionPane.ERROR_MESSAGE);

						}catch (IllegalArgumentException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"La fecha es incorrecta.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					private void altaLoro() {
						try {
							creado = Principal.refugio.altaAnimal(new Loro(nombretextField.getText().trim(), Float.parseFloat(pesotextField_1.getText()), Integer.parseInt(edadtextField_2.getText()), sexoElegido(), Animal.comprobarFecha( Integer.parseInt(anioAltatextField_7.getText()), Integer.parseInt(mesAltatextField_6.getText()), Integer.parseInt(diaAltatextField_5.getText())), Float.parseFloat(comidaMensualtextField_4.getText()), Float.parseFloat(costeAdopcontextField_3.getText())));

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Formato de fecha incorrecto.\nIntroduzca digitos correctos.", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NombreNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre no válido", "Error",
									JOptionPane.ERROR_MESSAGE);	
						} catch (EdadNoValidaException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Edad no válida", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (DecimalNoValidoException e1) {

						} catch (NombreYaExisteException e1) {

							JOptionPane.showMessageDialog(contentPanel,
									"Nombre ya existe", "Error",
									JOptionPane.ERROR_MESSAGE);
						}catch (IllegalArgumentException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"La fecha es incorrecta.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					private void altaPaloma() {
						try {

							creado = Principal.refugio.altaAnimal(new Paloma(nombretextField.getText().trim(), Float.parseFloat(pesotextField_1.getText()), Integer.parseInt(edadtextField_2.getText()), sexoElegido(), Animal.comprobarFecha( Integer.parseInt(anioAltatextField_7.getText()), Integer.parseInt(mesAltatextField_6.getText()), Integer.parseInt(diaAltatextField_5.getText())), Float.parseFloat(comidaMensualtextField_4.getText()), Float.parseFloat(costeAdopcontextField_3.getText())));
						}  
						catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Formato de fecha inválido", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NombreNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre no válido", "Error",
									JOptionPane.ERROR_MESSAGE);	
						} catch (EdadNoValidaException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Edad no válida", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (DecimalNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"El decimal no es correcto, debe ser positivo.\nIntroduzca digitos correctos.", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NombreYaExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Nombre ya existe", "Error",
									JOptionPane.ERROR_MESSAGE);
						}catch (IllegalArgumentException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"La fecha es incorrecta.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
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
		establecerTitulo(idAnimal);
	}

	private void setIcono(int idAnimal2) {
		switch (idAnimal2) {
		case 0:
			etiqueta.setIcon(new ImageIcon("paloma.gif"));
			break;
		case 1:
			etiqueta.setIcon(new ImageIcon("loro.gif"));
			break;
		case 2:
			etiqueta.setIcon(new ImageIcon("tortuga.gif"));
			break;
		case 3:
			etiqueta.setIcon(new ImageIcon("serpiente.jpg"));
			break;
		default:
			break;
		}

	}
	/**
	 * Método para establecer el título del diálogo
	 * @param idAnimal2
	 */
	private void establecerTitulo(int idAnimal2) {
		switch (idAnimal2) {
		case 0:
			setTitle("Alta Paloma");
			break;
		case 1:
			setTitle("Alta Loro");
			break;
		case 2:
			setTitle("Alta Tortuga");
			break;
		case 3:
			setTitle("Alta Serpiente");
			venenosaCheckBox.setVisible(true);
			break;
		default:
			break;
		}

	}
	/**
	 * Méto para obtener el sexo elegido
	 * @return
	 */
	private Sexos sexoElegido() {
		if(hembraradioButton.isSelected())
			return Sexos.HEMBRA;
		return Sexos.MACHO;
	}
}

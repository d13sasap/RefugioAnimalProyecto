package clasesGUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clasesPrincipales.Animal;
import clasesPrincipales.FechaAdopcionAnteriorAlta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;

public class AdoptarAnimal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2038660027197340469L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombretextField;
	private JTextField diatextField_1;
	private JTextField mestextField_2;
	private JTextField aniotextField_3;
	private JTextField fechaAltaTextField_1;
	JButton adoptarButton;

	

	/**
	 * Create the dialog.
	 */
	public AdoptarAnimal() {
		setTitle("Adoptar Animal");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 361, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 34, 93, 28);
		contentPanel.add(lblNewLabel);

		nombretextField = new JTextField();
		nombretextField.setBounds(193, 38, 143, 20);
		contentPanel.add(nombretextField);
		nombretextField.setColumns(10);

		adoptarButton = new JButton("Adoptar");
		adoptarButton.setEnabled(false);
		adoptarButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {
					if(Principal.refugio.getAnimalNombre(nombretextField.getText())!=null){
//						tmp = Principal.refugio.getAnimalNombre(nombretextField.getText()).adoptarAnimal(Animal.comprobarFecha(Integer.parseInt(aniotextField_3.getText()),Integer.parseInt(mestextField_2.getText())-1,Integer.parseInt(diatextField_1.getText())));
						if(Principal.refugio.getAnimalNombre(nombretextField.getText()).adoptarAnimal(Animal.comprobarFecha(Integer.parseInt(aniotextField_3.getText()),Integer.parseInt(mestextField_2.getText())-1,Integer.parseInt(diatextField_1.getText())))
						){
							//ACTUALIZAMOS LISTAS CADA VEZ ADOPTAMOS
							Principal.refugio.getListaAdoptados();
							Principal.refugio.getListaNoAdoptados();

							JOptionPane.showMessageDialog(contentPanel,
									"Animal adoptado con éxito.");
						}
						else
							JOptionPane.showMessageDialog(contentPanel,
									"El animal ya está adoptado.", "Error",
									JOptionPane.ERROR_MESSAGE);
					}//if existe el animal
				}    catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							"Formato de fecha inválido", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
				catch (FechaAdopcionAnteriorAlta e1) {
					JOptionPane.showMessageDialog(contentPanel,
							"La adopción no puede ser previa al alta del animal.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							"La fecha es incorrecta.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}



			}
		});
		adoptarButton.setBounds(10, 144, 89, 23);
		contentPanel.add(adoptarButton);

		JLabel lblFechaAdopcinddmmaaaa = new JLabel("Fecha adopci\u00F3n (dd/mm/aaaa)");
		lblFechaAdopcinddmmaaaa.setBounds(10, 110, 173, 25);
		contentPanel.add(lblFechaAdopcinddmmaaaa);

		diatextField_1 = new JTextField();
		diatextField_1.setColumns(10);
		diatextField_1.setBounds(193, 110, 30, 25);
		contentPanel.add(diatextField_1);

		mestextField_2 = new JTextField();
		mestextField_2.setColumns(10);
		mestextField_2.setBounds(233, 110, 28, 25);
		contentPanel.add(mestextField_2);

		aniotextField_3 = new JTextField();
		aniotextField_3.setColumns(10);
		aniotextField_3.setBounds(271, 110, 65, 25);
		contentPanel.add(aniotextField_3);

		JLabel lblFechaAltaddmmaaaa = new JLabel("Fecha alta (dd/mm/aaaa)");
		lblFechaAltaddmmaaaa.setBounds(10, 74, 157, 25);
		contentPanel.add(lblFechaAltaddmmaaaa);

		fechaAltaTextField_1 = new JTextField();
		fechaAltaTextField_1.setEditable(false);
		fechaAltaTextField_1.setColumns(10);
		fechaAltaTextField_1.setBounds(193, 74, 143, 25);
		contentPanel.add(fechaAltaTextField_1);

		final JLabel noExistelbl = new JLabel("Nombre no existe");
		noExistelbl.setVisible(false);
		noExistelbl.setForeground(Color.RED);
		noExistelbl.setBounds(85, 41, 103, 14);
		contentPanel.add(noExistelbl);
		FocusListener nombreListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				Animal tmp = null;
				if(!Principal.refugio.nombreYaExiste(nombretextField.getText())){
					noExistelbl.setVisible(true);
				}
				else{
					adoptarButton.setEnabled(true);
					tmp = Principal.refugio.getAnimalNombre(nombretextField.getText());
					Calendar cal = tmp.getFechaAlta();
					

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					sdf.setLenient(false);
					String formatted = sdf.format(cal.getTime());

					fechaAltaTextField_1.setText(formatted);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				fechaAltaTextField_1.setText(" ");
				noExistelbl.setVisible(false);
				adoptarButton.setEnabled(false);

			}
		};
		nombretextField.addFocusListener(nombreListener);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}

				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

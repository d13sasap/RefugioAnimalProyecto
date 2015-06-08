package clasesGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String[] instrucciones = {"Alta","Baja","Búsquedas","Datos correctos"};



	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setModal(true);
		setTitle("Instrucciones de Uso");
		setBounds(100, 100, 597, 236);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 573, 138);
		contentPanel.add(panel);
		panel.setLayout(null);

		JPanel panelJList = new JPanel();
		panelJList.setBounds(15, 8, 180, 107);
		panelJList.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione Opci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.add(panelJList);
		panelJList.setLayout(null);

		final JList<String> list = new JList<String>(instrucciones);
		list.setBounds(6, 16, 164, 80);
		panelJList.add(list);
		list.setBackground(SystemColor.control);

		final JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setText("Seleccione opci\u00F3n.");
		textPane.setEditable(false);
		textPane.setBounds(204, 11, 349, 107);
		panel.add(textPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cerrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Principal.setAyudaAbierta(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(list.getSelectedIndex()== 0)
					textPane.setText(jlistString(list.getSelectedIndex()));
				if(list.getSelectedIndex()== 1)
					textPane.setText(jlistString(list.getSelectedIndex()));
				if(list.getSelectedIndex()== 2)
					textPane.setText(jlistString(list.getSelectedIndex()));
				if(list.getSelectedIndex()== 3)
					textPane.setText(jlistString(list.getSelectedIndex()));
			}
		});




	}// Constructor
	/**
	 * Método con el cual según la opción recibida mostraremos un mensaje de las instrucciones
	 * @param opcion entero para la opción elegida de las instrucciones
	 * @return nos devuelve la cadena con la instrucción elegida
	 */
	private String jlistString(int opcion){
		String alta = "Al dar de alta un animal recuerde que no puede dejar en blanco datos, introducir datos erróneos o introducir un nombre ya registrado en el refugio en otro animal.\nEl peso y cantidad comida es en kg";
		String baja = "Con la aplicación podrá dar de baja un animal introduciendo el nombre.";
		String busqueda = "Con la aplicación podrá realizar la búsqueda y mostrar el refugio completo, un animal en particular, o animales según su familia o tipo de animal.";
		String nombre = "Tanto el nombre como la raza serán válidos solamente si empiezan por mayúscula y siguen con minúsculas. Mínimo 2 caracteres y máximo 15. Una palabra única."
				+ "\nLa fechas deben ser correctas-\nTodo dato erróneo se visualizará en color rojo al salir del cuadro de texto";

		switch (opcion) {
		case 0:
			return alta;
		case 1:
			return baja;
		case 2:
			return busqueda;
		case 3:
			return nombre;

		}
		return null;
	}
}

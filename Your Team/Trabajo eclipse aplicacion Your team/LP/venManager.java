package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import COMUN.Constantes.ensexo;
import COMUN.clsExcepcionEquipoRepetido;
import COMUN.clsExcepcionManagerRepetido;
import LN.clsGestorLN;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import javax.swing.ImageIcon;



public class venManager extends JDialog implements ActionListener{

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellido1;
	private JTextField txtdni;
	private JComboBox combosexo;
	private JComboBox combocalidad;

	
	public static final String ACTION_COMMAND_SIGUIENTE = "Siguiente";
	
	private clsGestorLN gestor = new clsGestorLN();
	private JTextField txtapellido2;
	private JTextField txtcontrasenia;
	
	private String titulo = "Your Team: Manager";

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venCrearEquipo frame = new venCrearEquipo(this, true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public venManager(venInicio objInicio, boolean modal) {
		super(objInicio, modal);
		setTitle(titulo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(venInicio.class.getResource("/Imagenes/your team.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 451, 291);
		panel.setBackground(Color.RED);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		
		JLabel lblVamosACrear = new JLabel("Vamos a crear el manager, te ayudare");
		lblVamosACrear.setBounds(65, 22, 310, 24);
		lblVamosACrear.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNewLabel = new JLabel("\u00BFComo te llamas?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 57, 129, 14);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(29, 82, 108, 20);
		txtnombre.setColumns(10);
		
		JLabel lblcomoTeApellidas = new JLabel("\u00BFCual es tu primer apellido?");
		lblcomoTeApellidas.setForeground(Color.WHITE);
		lblcomoTeApellidas.setBounds(10, 113, 162, 14);
		
		txtapellido1 = new JTextField();
		txtapellido1.setBounds(29, 139, 108, 20);
		txtapellido1.setColumns(10);
		
		JLabel lblAadeleUnDni = new JLabel("A\u00F1adele un DNI");
		lblAadeleUnDni.setForeground(Color.WHITE);
		lblAadeleUnDni.setBounds(209, 57, 114, 14);
		
		txtdni = new JTextField();
		txtdni.setBounds(230, 82, 93, 20);
		txtdni.setColumns(10);
		
		JLabel lblcualTuGenero = new JLabel("\u00BFCual tu genero?");
		lblcualTuGenero.setForeground(Color.WHITE);
		lblcualTuGenero.setBounds(209, 113, 107, 14);
		
		combosexo = new JComboBox();
		combosexo.setBounds(233, 138, 98, 22);
		combosexo.setModel(new DefaultComboBoxModel(new String[] {"Otro", "Femenino", "Masculino"}));
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(329, 244, 89, 23);
		btnSiguiente.setActionCommand(ACTION_COMMAND_SIGUIENTE);
		btnSiguiente.addActionListener(this);
		
		JLabel lblcualEsTu = new JLabel("\u00BFCual es tu segundo apellido?");
		lblcualEsTu.setForeground(Color.WHITE);
		lblcualEsTu.setBounds(10, 171, 174, 14);
		
		txtapellido2 = new JTextField();
		txtapellido2.setBounds(29, 196, 108, 20);
		txtapellido2.setColumns(10);
		
		JLabel lblElijeCalidadDel = new JLabel("Elije calidad del manager");
		lblElijeCalidadDel.setForeground(Color.WHITE);
		lblElijeCalidadDel.setBounds(209, 171, 143, 14);
		
		combocalidad = new JComboBox();
		combocalidad.setBounds(235, 196, 98, 20);
		combocalidad.setModel(new DefaultComboBoxModel(new String[] {"Bronce", "Plata", "Oro"}));
		
		JLabel lblcontrasenia = new JLabel("\u00BFContrase\u00F1a?");
		lblcontrasenia.setForeground(Color.WHITE);
		lblcontrasenia.setBounds(10, 227, 155, 14);
		
		txtcontrasenia = new JTextField();
		txtcontrasenia.setBounds(32, 245, 105, 20);
		txtcontrasenia.setColumns(10);
		panel.setLayout(null);
		panel.add(btnSiguiente);
		panel.add(lblcualEsTu);
		panel.add(txtapellido2);
		panel.add(txtapellido1);
		panel.add(txtcontrasenia);
		panel.add(combosexo);
		panel.add(combocalidad);
		panel.add(txtnombre);
		panel.add(lblNewLabel);
		panel.add(lblcomoTeApellidas);
		panel.add(lblcualTuGenero);
		panel.add(lblElijeCalidadDel);
		panel.add(txtdni);
		panel.add(lblAadeleUnDni);
		panel.add(lblVamosACrear);
		panel.add(lblcontrasenia);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(venManager.class.getResource("/Imagenes/fotomanager1.png")));
		label.setBounds(0, 0, 451, 291);
		panel.add(label);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case ACTION_COMMAND_SIGUIENTE:
			if(!(txtnombre.getText().equals("") || txtapellido1.getText().equals("") || txtapellido2.getText().equals("") ||
					txtdni.getText().equals("") || txtcontrasenia.getText().equals(""))) {
				try 
				{
					gestor.anadirManager(txtnombre.getText(),
						txtapellido1.getText(),
						txtapellido2.getText(),
						txtdni.getText(),
						(String)combosexo.getSelectedItem(),
						(String)combocalidad.getSelectedItem(),						
						0,
						txtcontrasenia.getText());
				}
				catch(clsExcepcionManagerRepetido exv) 
				{
					JOptionPane.showMessageDialog(this,exv.getMessage());
				}
								
				txtnombre.setText("");
				txtapellido1.setText("");
				txtapellido2.setText("");
				txtdni.setText("");
				txtcontrasenia.setText("");
				this.dispose();
				venEquipacion obj = new venEquipacion(this, true);
				obj.setVisible(true);
				setModal(true);
				/**
				 * Sirve para que no puedas usar la ventana anterior
				 */	
			}else {
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos");
			}
			break;
	}
}
}

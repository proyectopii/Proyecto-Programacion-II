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
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class venCrearEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox combosexo;
	private JTextField txtnombre;
	private JTextField txtapellido1;
	private JTextField txtapellido2;
	private JTextField txtdni;
	private JTextField txtnombreequipo;
	
	public static final String ACTION_COMAND_SIGUIENTE = "Siguiente";
	
	private clsGestorLN gestor = new clsGestorLN();
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venCrearEquipo frame = new venCrearEquipo();
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
	public venCrearEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblcomoQuieresLlamar = new JLabel("\u00BFComo quieres llamar a tu equipo?");
		lblcomoQuieresLlamar.setBounds(238, 169, 163, 14);
		panel.add(lblcomoQuieresLlamar);
		
		JLabel lblVamosACrear = new JLabel("Vamos a crear el manager y\t equipo, te ayudare");
		lblVamosACrear.setBounds(29, 11, 376, 24);
		lblVamosACrear.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		panel.add(lblVamosACrear);
		
		textField = new JTextField();
		textField.setBounds(238, 194, 137, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u00BFComo te llamas?");
		lblNewLabel.setBounds(29, 57, 93, 14);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(29, 82, 108, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblcomoTeApellidas = new JLabel("\u00BFCual es tu primer apellido?");
		lblcomoTeApellidas.setBounds(29, 113, 143, 14);
		panel.add(lblcomoTeApellidas);
		
		textField_2 = new JTextField();
		textField_2.setBounds(29, 138, 108, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAadeleUnDni = new JLabel("A\u00F1adele un DNI");
		lblAadeleUnDni.setBounds(238, 57, 86, 14);
		panel.add(lblAadeleUnDni);
		
		textField_3 = new JTextField();
		textField_3.setBounds(238, 82, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblcualTuGenero = new JLabel("\u00BFCual tu genero?");
		lblcualTuGenero.setBounds(238, 113, 93, 14);
		panel.add(lblcualTuGenero);
		
		combosexo = new JComboBox();
		combosexo.setModel(new DefaultComboBoxModel(new String[] {"Otro", "Femenino", "Masculino"}));
		combosexo.setBounds(238, 136, 93, 22);
		panel.add(combosexo);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setActionCommand(ACTION_COMAND_SIGUIENTE);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venEquipacion obj = new venEquipacion();
				obj.setVisible(true);
			}
		});
		btnSiguiente.setBounds(316, 217, 89, 23);
		panel.add(btnSiguiente);
		
		JLabel lblcualEsTu = new JLabel("\u00BFCual es tu segundo apellido?");
		lblcualEsTu.setBounds(29, 169, 155, 14);
		panel.add(lblcualEsTu);
		
		textField_4 = new JTextField();
		textField_4.setBounds(29, 194, 108, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
	}
	
	public void actionPerformed(ActionEvent e) throws clsExcepcionManagerRepetido, clsExcepcionEquipoRepetido {
		switch(e.getActionCommand()) {
		case ACTION_COMAND_SIGUIENTE:
			ensexo sexo;
			
			switch(combosexo.getSelectedIndex()) {
			case 0:
				sexo = ensexo.Otro;
				break;
				
			case 1:
				sexo = ensexo.Femenino;
				break;
				
			default:
				sexo = ensexo.Masculino;
			}
			
			if(!(txtnombre.getText().equals("") && txtapellido1.getText().equals("") && txtapellido2.getText().equals("") && txtdni.getText().equals("") && txtnombreequipo.getText().equals(""))) {
				gestor.addManager(txtnombre.getText(), txtapellido1.getText(), txtapellido2.getText(), txtdni.getText(), null, null, 0);
				gestor.añadirEquipo(txtnombreequipo.getText(), null);
				
				txtnombre.setText("");
				txtapellido1.setText("");
				txtapellido2.setText("");
				txtdni.setText("");
				txtnombreequipo.setText("");
			}else {
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos");
			}
		}
	}
}

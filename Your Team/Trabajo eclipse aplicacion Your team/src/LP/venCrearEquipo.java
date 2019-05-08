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

public class venCrearEquipo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtnombreequipo;
	private JTextField txtnombre;
	private JTextField txtapellido1;
	private JTextField txtdni;
	private JComboBox combosexo;

	
	public static final String ACTION_COMMAND_SIGUIENTE = "Siguiente";
	
	private clsGestorLN gestor = new clsGestorLN();
	private JTextField txtapellido2;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblcomoQuieresLlamar = new JLabel("\u00BFComo quieres llamar a tu equipo?");
		lblcomoQuieresLlamar.setBounds(238, 169, 163, 14);
		panel.add(lblcomoQuieresLlamar);
		
		JLabel lblVamosACrear = new JLabel("Vamos a crear el manager y\t el equipo, te ayudare");
		lblVamosACrear.setBounds(24, 11, 394, 24);
		lblVamosACrear.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		panel.add(lblVamosACrear);
		
		txtnombreequipo = new JTextField();
		txtnombreequipo.setBounds(238, 194, 137, 20);
		panel.add(txtnombreequipo);
		txtnombreequipo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u00BFComo te llamas?");
		lblNewLabel.setBounds(29, 57, 93, 14);
		panel.add(lblNewLabel);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(29, 82, 108, 20);
		panel.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblcomoTeApellidas = new JLabel("\u00BFCual es tu primer apellido?");
		lblcomoTeApellidas.setBounds(29, 113, 143, 14);
		panel.add(lblcomoTeApellidas);
		
		txtapellido1 = new JTextField();
		txtapellido1.setBounds(29, 138, 108, 20);
		panel.add(txtapellido1);
		txtapellido1.setColumns(10);
		
		JLabel lblAadeleUnDni = new JLabel("A\u00F1adele un DNI");
		lblAadeleUnDni.setBounds(238, 57, 86, 14);
		panel.add(lblAadeleUnDni);
		
		txtdni = new JTextField();
		txtdni.setBounds(238, 82, 93, 20);
		panel.add(txtdni);
		txtdni.setColumns(10);
		
		JLabel lblcualTuGenero = new JLabel("\u00BFCual tu genero?");
		lblcualTuGenero.setBounds(238, 113, 93, 14);
		panel.add(lblcualTuGenero);
		
		combosexo = new JComboBox();
		combosexo.setModel(new DefaultComboBoxModel(new String[] {"Otro", "Femenino", "Masculino"}));
		combosexo.setBounds(238, 136, 93, 22);
		
		panel.add(combosexo);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setActionCommand(ACTION_COMMAND_SIGUIENTE);
		btnSiguiente.addActionListener(this);
		btnSiguiente.setBounds(316, 229, 89, 23);
		panel.add(btnSiguiente);
		
		JLabel lblcualEsTu = new JLabel("\u00BFCual es tu segundo apellido?");
		lblcualEsTu.setBounds(29, 169, 155, 14);
		panel.add(lblcualEsTu);
		
		txtapellido2 = new JTextField();
		txtapellido2.setBounds(29, 194, 108, 20);
		panel.add(txtapellido2);
		txtapellido2.setColumns(10);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case ACTION_COMMAND_SIGUIENTE:
			if(!(txtnombre.getText().equals("") || txtapellido1.getText().equals("") || txtapellido2.getText().equals("") ||
					txtdni.getText().equals("") || txtnombreequipo.getText().equals(""))) {
				try {gestor.addManager(txtnombre.getText(),
						txtapellido1.getText(),
						txtapellido2.getText(),
						txtdni.getText(),
						(String)combosexo.getSelectedItem(),
						null,
						0);
					gestor.añadirEquipo(txtnombreequipo.getText(), null);
				}catch(Exception exv) {
				}
								
				txtnombre.setText("");
				txtapellido1.setText("");
				txtapellido2.setText("");
				txtdni.setText("");
				txtnombreequipo.setText("");
				venEquipacion obj = new venEquipacion();
				obj.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos");
			}
			break;
		}
	}
}

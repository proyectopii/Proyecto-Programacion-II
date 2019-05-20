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
	public venManager(JFrame owner, boolean modal) {
		super(owner, modal);
		
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
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblVamosACrear = new JLabel("Vamos a crear el manager, te ayudare");
		lblVamosACrear.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNewLabel = new JLabel("\u00BFComo te llamas?");
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		
		JLabel lblcomoTeApellidas = new JLabel("\u00BFCual es tu primer apellido?");
		
		txtapellido1 = new JTextField();
		txtapellido1.setColumns(10);
		
		JLabel lblAadeleUnDni = new JLabel("A\u00F1adele un DNI");
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		
		JLabel lblcualTuGenero = new JLabel("\u00BFCual tu genero?");
		
		combosexo = new JComboBox();
		combosexo.setModel(new DefaultComboBoxModel(new String[] {"Otro", "Femenino", "Masculino"}));
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setActionCommand(ACTION_COMMAND_SIGUIENTE);
		btnSiguiente.addActionListener(this);
		
		JLabel lblcualEsTu = new JLabel("\u00BFCual es tu segundo apellido?");
		
		txtapellido2 = new JTextField();
		txtapellido2.setColumns(10);
		
		JLabel lblElijeCalidadDel = new JLabel("Elije calidad del manager");
		
		combocalidad = new JComboBox();
		combocalidad.setModel(new DefaultComboBoxModel(new String[] {"Bronce", "Plata", "Oro"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSiguiente, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblcualEsTu, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtapellido2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtapellido1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(combosexo, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
											.addGap(21))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(combocalidad, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
											.addGap(19))))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(29)
											.addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblcomoTeApellidas, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
									.addGap(37)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblcualTuGenero, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblElijeCalidadDel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(txtdni, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblAadeleUnDni, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))))
							.addGap(66)))
					.addGap(81))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(65)
					.addComponent(lblVamosACrear, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblVamosACrear, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblAadeleUnDni))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtdni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcomoTeApellidas)
						.addComponent(lblcualTuGenero))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtapellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(combosexo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcualEsTu)
						.addComponent(lblElijeCalidadDel))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtapellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(combocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnSiguiente)
					.addGap(16))
		);
		panel.setLayout(gl_panel);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case ACTION_COMMAND_SIGUIENTE:
			if(!(txtnombre.getText().equals("") || txtapellido1.getText().equals("") || txtapellido2.getText().equals("") ||
					txtdni.getText().equals(""))) {
				try {gestor.anadirManager(txtnombre.getText(),
						txtapellido1.getText(),
						txtapellido2.getText(),
						txtdni.getText(),
						(String)combosexo.getSelectedItem(),
						(String)combocalidad.getSelectedItem(),						
						0);
				}catch(Exception exv) {
				JOptionPane.showMessageDialog(this,exv.getMessage());
				}
								
				txtnombre.setText("");
				txtapellido1.setText("");
				txtapellido2.setText("");
				txtdni.setText("");
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
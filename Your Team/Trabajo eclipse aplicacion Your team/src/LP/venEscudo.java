package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsGestorLN;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class venEscudo extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JComboBox comboForma;
	private JComboBox comboColor;
	private JButton btnResgistrarse;
	private clsGestorLN gestor = new clsGestorLN();
	
	public static final String ACTION_COMMAND_REGISTRARSE = "Registrarse";

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venEscudo frame = new venEscudo();
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
	public venEscudo(venEquipacion objequipacion, boolean modal) {
		super(objequipacion, modal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblHoraDeCrear = new JLabel("Hora de crear el escudo");
		lblHoraDeCrear.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblElijeFormaDel = new JLabel("Elije forma del escudo");
		
		comboForma = new JComboBox();
		comboForma.setModel(new DefaultComboBoxModel(new String[] {"Circulo", "Triangulo", "Heptagono", "Octagono", "Hexagono"}));
		
		JLabel lblqueColorQuieres = new JLabel("\u00BFQue color quieres?");
		
		comboColor = new JComboBox();
		comboColor.setModel(new DefaultComboBoxModel(new String[] {"Amarillo", "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron"}));
		
		btnResgistrarse = new JButton("Registrarse");
		btnResgistrarse.addActionListener(this);
		btnResgistrarse.setActionCommand(ACTION_COMMAND_REGISTRARSE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(119)
							.addComponent(lblHoraDeCrear, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(70)
							.addComponent(comboForma, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(242)
							.addComponent(btnResgistrarse, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(70)
							.addComponent(comboColor, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblqueColorQuieres, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblElijeFormaDel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblHoraDeCrear, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblElijeFormaDel)
					.addGap(11)
					.addComponent(comboForma, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(btnResgistrarse))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(37)
							.addComponent(lblqueColorQuieres)))
					.addGap(11)
					.addComponent(comboColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case ACTION_COMMAND_REGISTRARSE:
			if(!comboForma.getSelectedItem().equals("") || comboColor.getSelectedItem().equals("")) {
				try {gestor.anadirEscudo((String) comboForma.getSelectedItem(), (String) comboColor.getSelectedItem());
				}catch(Exception exv) {
				}
								
				comboColor.setSelectedItem("");
				comboForma.setSelectedItem("");
				
				JOptionPane.showMessageDialog(this, "El usuario es el nombre de equipo y el DNI la contraseña");
				setVisible(true);
				setModal(true);
			}else {
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos");
			}
			break;
			
			
		}
	}
}

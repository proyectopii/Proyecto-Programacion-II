package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class venEscudo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox comboForma;
	private JComboBox comboColor;
	private JButton btnResgistrarse;
	
	public static final String ACTION_COMMAND_REGISTRARSE = "Registrarse";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public venEscudo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblHoraDeCrear = new JLabel("Hora de crear el escudo");
		lblHoraDeCrear.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		lblHoraDeCrear.setBounds(119, 11, 188, 14);
		panel.add(lblHoraDeCrear);
		
		JLabel lblElijeFormaDel = new JLabel("Elije forma del escudo");
		lblElijeFormaDel.setBounds(60, 61, 113, 14);
		panel.add(lblElijeFormaDel);
		
		comboForma = new JComboBox();
		comboForma.setModel(new DefaultComboBoxModel(new String[] {"Circulo", "Triangulo", "Heptagono", "Octagono", "Hexagono"}));
		comboForma.setBounds(70, 86, 87, 22);
		panel.add(comboForma);
		
		JLabel lblqueColorQuieres = new JLabel("\u00BFQue color quieres?");
		lblqueColorQuieres.setBounds(60, 145, 113, 14);
		panel.add(lblqueColorQuieres);
		
		comboColor = new JComboBox();
		comboColor.setModel(new DefaultComboBoxModel(new String[] {"Amarillo", "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron"}));
		comboColor.setBounds(70, 170, 87, 22);
		panel.add(comboColor);
		
		btnResgistrarse = new JButton("Registrarse");
		btnResgistrarse.addActionListener(this);
		btnResgistrarse.setActionCommand(ACTION_COMMAND_REGISTRARSE);
		btnResgistrarse.setBounds(242, 120, 89, 23);
		panel.add(btnResgistrarse);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case ACTION_COMMAND_REGISTRARSE:
			
			break;
		}
	}
}
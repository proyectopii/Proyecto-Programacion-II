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
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class venEscudo extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JComboBox comboForma;
	private JComboBox comboColor;
	private JButton btnSiguiente;
	private clsGestorLN gestor = new clsGestorLN();
	
	public static final String ACTION_COMMAND_SIGUIENTE = "Siguiente";
	
	private String titulo = "Your Team: Escudo";

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
		setTitle(titulo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(venInicio.class.getResource("/Imagenes/your team.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 451, 291);
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel);
		
		JLabel lblHoraDeCrear = new JLabel("Hora de crear el escudo");
		lblHoraDeCrear.setForeground(Color.RED);
		lblHoraDeCrear.setBounds(119, 11, 188, 14);
		lblHoraDeCrear.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblElijeFormaDel = new JLabel("Elije forma del escudo");
		lblElijeFormaDel.setForeground(Color.WHITE);
		lblElijeFormaDel.setBounds(60, 61, 175, 14);
		
		comboForma = new JComboBox();
		comboForma.setBounds(70, 86, 87, 22);
		comboForma.setModel(new DefaultComboBoxModel(new String[] {"Circulo", "Triangulo", "Heptagono", "Octagono", "Hexagono"}));
		
		JLabel lblqueColorQuieres = new JLabel("\u00BFQue color quieres?");
		lblqueColorQuieres.setForeground(Color.WHITE);
		lblqueColorQuieres.setBounds(60, 145, 121, 14);
		
		comboColor = new JComboBox();
		comboColor.setBounds(70, 170, 87, 22);
		comboColor.setModel(new DefaultComboBoxModel(new String[] {"Amarillo", "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron"}));
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(352, 247, 89, 23);
		btnSiguiente.addActionListener(this);
		btnSiguiente.setActionCommand(ACTION_COMMAND_SIGUIENTE);
		panel.setLayout(null);
		panel.add(lblHoraDeCrear);
		panel.add(comboForma);
		panel.add(btnSiguiente);
		panel.add(comboColor);
		panel.add(lblqueColorQuieres);
		panel.add(lblElijeFormaDel);
		
		JLabel labelejemplo = new JLabel("");
		labelejemplo.setIcon(new ImageIcon(venEscudo.class.getResource("/Imagenes/fotoejemploescudo2.png")));
		labelejemplo.setBounds(252, 80, 99, 105);
		panel.add(labelejemplo);
		
		JLabel lblIremosMejorandolosEn = new JLabel("Iremos mejorando los escudos");
		lblIremosMejorandolosEn.setForeground(Color.WHITE);
		lblIremosMejorandolosEn.setBounds(10, 247, 213, 22);
		panel.add(lblIremosMejorandolosEn);
		
		JLabel lblPorEjemplo = new JLabel("Por ejemplo");
		lblPorEjemplo.setForeground(Color.WHITE);
		lblPorEjemplo.setBounds(274, 61, 106, 14);
		panel.add(lblPorEjemplo);
		
		JLabel lblEnLasProximas = new JLabel("en las proximas actualizaciones");
		lblEnLasProximas.setForeground(Color.WHITE);
		lblEnLasProximas.setBounds(10, 258, 193, 22);
		panel.add(lblEnLasProximas);
		
		JLabel labelfoto = new JLabel("");
		labelfoto.setIcon(new ImageIcon(venEscudo.class.getResource("/Imagenes/fotoescudo1.png")));
		labelfoto.setBounds(0, 0, 451, 291);
		panel.add(labelfoto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case ACTION_COMMAND_SIGUIENTE:
			if(!comboForma.getSelectedItem().equals("") || comboColor.getSelectedItem().equals("")) {
				try {gestor.anadirEscudo((String) comboForma.getSelectedItem(), (String) comboColor.getSelectedItem());
				}catch(Exception exv) {
					System.out.println(exv.getMessage());
				}
								
				comboColor.setSelectedItem("");
				comboForma.setSelectedItem("");
				
				this.dispose();
				venEquipo obj = new venEquipo(this, true);
				obj.setVisible(true);
				setModal(true);
			}else {
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos");
			}
			break;
			
			
		}
	}
}

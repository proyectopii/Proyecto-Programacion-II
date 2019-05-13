package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;


public class venInicio extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venInicio frame = new venInicio();
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
	public venInicio() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 89, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(52, 152, 219));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblBienvenidoAYour = new JLabel("Bienvenido a Your Team");
		lblBienvenidoAYour.setBounds(72, 11, 307, 29);
		lblBienvenidoAYour.setForeground(new Color(241, 196, 15));
		lblBienvenidoAYour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		
		JLabel lblLaAppDonde = new JLabel("Dirige tu propio equipo");
		lblLaAppDonde.setBounds(137, 46, 165, 17);
		lblLaAppDonde.setForeground(new Color(241, 196, 15));
		lblLaAppDonde.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JButton btnCrearEquipo = new JButton();
		btnCrearEquipo.setBounds(50, 74, 139, 150);
		btnCrearEquipo.addActionListener(this);
		btnCrearEquipo.setIcon(new ImageIcon(venInicio.class.getResource("/Imagenes/crearequipo4.png")));
	
		JButton btnContinuar = new JButton(new ImageIcon(venInicio.class.getResource("/Imagenes/login1.png")));
		btnContinuar.setBounds(238, 74, 139, 150);
		panel.setLayout(null);
		panel.add(lblBienvenidoAYour);
		panel.add(lblLaAppDonde);
		panel.add(btnCrearEquipo);
		panel.add(btnContinuar);
		
		JLabel lblCrearEquipo_1 = new JLabel("Crear Equipo");
		lblCrearEquipo_1.setBounds(75, 223, 102, 27);
		lblCrearEquipo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblCrearEquipo_1);
		
		JLabel lblContinuar = new JLabel("Continuar");
		lblContinuar.setBounds(279, 222, 90, 29);
		lblContinuar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblContinuar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		venCrearEquipo obj = new venCrearEquipo();
		obj.setVisible(true);
	}
}

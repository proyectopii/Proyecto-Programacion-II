package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;


public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 89, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(52, 152, 219));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblBienvenidoAYour = new JLabel("Bienvenido a Your Team");
		lblBienvenidoAYour.setForeground(new Color(241, 196, 15));
		lblBienvenidoAYour.setBounds(72, 11, 307, 29);
		lblBienvenidoAYour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		
		JLabel lblLaAppDonde = new JLabel("Dirige tu propio equipo");
		lblLaAppDonde.setForeground(new Color(241, 196, 15));
		lblLaAppDonde.setBounds(137, 46, 165, 17);
		lblLaAppDonde.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JButton btnCrearEquipo = new JButton();
		btnCrearEquipo.setIcon(new ImageIcon("D:\\Aitor\\Industria Digital\\1\u00BA Curso\\Semestre II\\Programaci\u00F3n II\\Proyecto-Programacion-II\\Your Team\\Trabajo eclipse aplicacion Your team\\src\\Imagenes\\crearequipo.png"));
		btnCrearEquipo.setBounds(58, 90, 139, 150);
		
		JButton btnContinuar = new JButton(new ImageIcon());
		btnContinuar.setBounds(247, 90, 139, 150);
		panel.setLayout(null);
		panel.add(lblBienvenidoAYour);
		panel.add(lblLaAppDonde);
		panel.add(btnCrearEquipo);
		panel.add(btnContinuar);
	}
}

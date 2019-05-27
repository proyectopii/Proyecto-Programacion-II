package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;


public class venInicio extends JDialog implements ActionListener, WindowListener {

	private JPanel contentPane;
	
	private static final String ACTION_COMMAND_CREAREQUIPO = "Crear equipo";
	private static final String ACTION_COMMAND_INICIARSESION = "Iniciar Sesion";
	
	private String titulo = "Your Team";

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venInicio frame = new venInicio(null, true);
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
	public venInicio(venEquipo objEquipo, boolean modal) {
		super(objEquipo, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(venInicio.class.getResource("/Imagenes/your team.png")));
		setTitle(titulo);
		addWindowListener(this);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 451, 291);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
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
		btnCrearEquipo.setActionCommand(ACTION_COMMAND_CREAREQUIPO);
		btnCrearEquipo.setIcon(new ImageIcon(venInicio.class.getResource("/Imagenes/crearequipo4.png")));
	
		JButton btnContinuar = new JButton(new ImageIcon(venInicio.class.getResource("/Imagenes/login1.png")));
		btnContinuar.setBounds(238, 74, 139, 150);
		panel.setLayout(null);
		btnContinuar.addActionListener(this);
		btnContinuar.setActionCommand(ACTION_COMMAND_INICIARSESION);
		panel.add(lblBienvenidoAYour);
		panel.add(lblLaAppDonde);
		panel.add(btnCrearEquipo);
		panel.add(btnContinuar);
		
		JLabel lblCrearEquipo_1 = new JLabel("Crear Equipo");
		lblCrearEquipo_1.setForeground(Color.WHITE);
		lblCrearEquipo_1.setBounds(75, 223, 102, 27);
		lblCrearEquipo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblCrearEquipo_1);
		
		JLabel lblContinuar = new JLabel("Continuar");
		lblContinuar.setForeground(Color.WHITE);
		lblContinuar.setBounds(279, 222, 90, 29);
		lblContinuar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblContinuar);
		
		JLabel labelfoto = new JLabel("");
		labelfoto.setIcon(new ImageIcon(venInicio.class.getResource("/Imagenes/fotoinicio2.png")));
		labelfoto.setBounds(0, 0, 451, 291);
		panel.add(labelfoto);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch(e.getActionCommand()){
		case ACTION_COMMAND_CREAREQUIPO:
			venManager obj1 = new venManager(this, true);
			obj1.setVisible(true);
			break;
			
		case ACTION_COMMAND_INICIARSESION:
			venIniciarSesion obj2 = new venIniciarSesion(this, true);
			obj2.setVisible(true);
			break;
		}
}



	@Override
	public void windowClosing(WindowEvent e) {
		int r=JOptionPane.showConfirmDialog(this, "¿Estas seguro?",
				"Salir",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null);
		if(r==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	@Override
	public void windowOpened(WindowEvent e) {		
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}
	
    @Override
	public void windowIconified(WindowEvent e) {	
	}
    
    @Override
	public void windowDeiconified(WindowEvent e) {	
	}

	@Override
	public void windowActivated(WindowEvent e) {		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {	
	}
}
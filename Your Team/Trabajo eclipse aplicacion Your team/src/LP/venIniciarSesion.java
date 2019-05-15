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
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;

public class venIniciarSesion extends JDialog implements ActionListener{

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtcontraseña;
	
	private static final String ACTION_COMMAND_LOGIN = "Login";

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venIniciarSesion frame = new venIniciarSesion();
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
	public venIniciarSesion(JFrame owner, boolean modal) {
		super(owner, modal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 204));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNombreEquipo = new JLabel("Nombre equipo");
		
		txtusuario = new JTextField();
		txtusuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		
		JLabel lblHolaDeNuevo = new JLabel("Hola de nuevo");
		lblHolaDeNuevo.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JButton btnlogin = new JButton("");
		btnlogin.addActionListener(this);
		btnlogin.setActionCommand(ACTION_COMMAND_LOGIN);
		btnlogin.setIcon(new ImageIcon(venIniciarSesion.class.getResource("/Imagenes/sign-in1.png")));
		
		txtcontraseña = new JPasswordField();
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(128)
					.addComponent(lblHolaDeNuevo, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNombreEquipo, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtusuario, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(txtcontraseña, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(323)
					.addComponent(lblIniciarSesion, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(308)
					.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblHolaDeNuevo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNombreEquipo))
						.addComponent(txtusuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblContrasenia))
						.addComponent(txtcontraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(lblIniciarSesion)
					.addGap(6)
					.addComponent(btnlogin))
		);
		panel.setLayout(gl_panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
			case ACTION_COMMAND_LOGIN:
				char[] clave = txtcontraseña.getPassword();
				String clavefinal = new String(clave);
				
				//Cambiar los "nombreequipo" por la variables nombreequipo y dni respectivamente
				if(txtusuario.getText().equals("nombreequipo") && clavefinal.equals("nombreequipo")) {
					JOptionPane.showMessageDialog(null, "Que bueno que viniste", clavefinal, JOptionPane.INFORMATION_MESSAGE);
					venMostrarEquipo obj = new venMostrarEquipo(this, true);
					obj.setVisible(true);
					setModal(true);
				}else{
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
				}
				break;
		}
	}
}

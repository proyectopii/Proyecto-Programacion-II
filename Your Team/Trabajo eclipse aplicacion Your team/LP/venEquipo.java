package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import COMUN.clsExcepcionEquipoRepetido;
import LN.clsGestorLN;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class venEquipo extends JDialog implements ActionListener {
	
	public clsGestorLN gestor = new clsGestorLN();
	
	private static final String ACTION_COMMAND_REGISTRARSE = "registrarse";

	private JPanel contentPane;
	private JTextField txtnombreequipo;
	JDateChooser dateChooser;
		
	private String titulo = "Your Team: Equipo";

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venEquipo frame = new venEquipo();
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
	public venEquipo(venEscudo objEscudo, boolean modal) {
		super(objEscudo, modal);
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
		panel.setBackground(Color.MAGENTA);
		contentPane.add(panel);
		
		JLabel lblYaNoQueda = new JLabel("Ya no queda nada para terminar");
		lblYaNoQueda.setForeground(Color.ORANGE);
		lblYaNoQueda.setBounds(113, 0, 255, 21);
		lblYaNoQueda.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblcomoQuieresLlamar = new JLabel("\u00BFComo quieres llamar a tu equipo?");
		lblcomoQuieresLlamar.setForeground(Color.BLACK);
		lblcomoQuieresLlamar.setBounds(47, 101, 233, 14);
		
		txtnombreequipo = new JTextField();
		txtnombreequipo.setBounds(71, 126, 135, 20);
		txtnombreequipo.setColumns(10);
		
		JLabel lblqueDiaSe = new JLabel("\u00BFQue dia se fundo tu equipo?");
		lblqueDiaSe.setBounds(259, 101, 198, 14);
		
		JButton buttonlogin = new JButton("");
		buttonlogin.setBounds(0, 220, 91, 61);
		buttonlogin.addActionListener(this);
		buttonlogin.setActionCommand(ACTION_COMMAND_REGISTRARSE);
		buttonlogin.setIcon(new ImageIcon(venEquipo.class.getResource("/Imagenes/log-in.png")));
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setBounds(20, 195, 55, 14);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(265, 126, 103, 20);
		panel.setLayout(null);
		panel.add(txtnombreequipo);
		panel.add(lblqueDiaSe);
		panel.add(lblRegistrarse);
		panel.add(dateChooser);
		panel.add(buttonlogin);
		panel.add(lblcomoQuieresLlamar);
		panel.add(lblYaNoQueda);
		
		JLabel labelfoto = new JLabel("");
		labelfoto.setIcon(new ImageIcon(venEquipo.class.getResource("/Imagenes/fotoequipo1.png")));
		labelfoto.setBounds(0, 0, 451, 291);
		panel.add(labelfoto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case ACTION_COMMAND_REGISTRARSE:
			if(!(txtnombreequipo.getText().equals(""))){
				try 
				{		 
					gestor.anadirEquipo(txtnombreequipo.getText(), dateChooser.getDate());
				}catch(clsExcepcionEquipoRepetido exv) 
				{
					JOptionPane.showMessageDialog(this,exv.getMessage());
				}
								
				txtnombreequipo.setText("");
				
				JOptionPane.showMessageDialog(this, "El usuario es el DNI");
				
				this.dispose();
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


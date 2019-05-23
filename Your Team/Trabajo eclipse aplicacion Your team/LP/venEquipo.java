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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblYaNoQueda = new JLabel("Ya no queda nada para terminar");
		lblYaNoQueda.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblcomoQuieresLlamar = new JLabel("\u00BFComo quieres llamar a tu equipo?");
		
		txtnombreequipo = new JTextField();
		txtnombreequipo.setColumns(10);
		
		JLabel lblqueDiaSe = new JLabel("\u00BFQue dia se fundo tu equipo?");
		
		JButton buttonlogin = new JButton("");
		buttonlogin.addActionListener(this);
		buttonlogin.setActionCommand(ACTION_COMMAND_REGISTRARSE);
		buttonlogin.setIcon(new ImageIcon(venEquipo.class.getResource("/Imagenes/log-in.png")));
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		
		dateChooser = new JDateChooser();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(txtnombreequipo, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(lblqueDiaSe)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(48)
							.addComponent(lblRegistrarse)
							.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(85))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(buttonlogin, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblcomoQuieresLlamar)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(83)
					.addComponent(lblYaNoQueda)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYaNoQueda)
					.addGap(18)
					.addComponent(lblcomoQuieresLlamar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtnombreequipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblqueDiaSe))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRegistrarse))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonlogin, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
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
				
				venInicio obj = new venInicio(this, true);
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


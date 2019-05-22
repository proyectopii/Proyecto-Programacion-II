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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDayChooser;

import LN.clsGestorLN;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class venEquipo extends JDialog implements ActionListener {
	
	public clsGestorLN gestor = new clsGestorLN();
	
	private static final String ACTION_COMMAND_REGISTRARSE = "registrarse";

	private JPanel contentPane;
	private JTextField txtnombreequipo;
	JDayChooser dayChooser;

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
		
		dayChooser = new JDayChooser();
		System.out.println(dayChooser.getDay());
		
		JLabel lblqueDiaSe = new JLabel("\u00BFQue dia se fundo tu equipo?");
		
		JButton buttonlogin = new JButton("");
		buttonlogin.addActionListener(this);
		buttonlogin.setActionCommand(ACTION_COMMAND_REGISTRARSE);
		buttonlogin.setIcon(new ImageIcon(venEquipo.class.getResource("/Imagenes/log-in.png")));
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(txtnombreequipo, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(48)
									.addComponent(lblRegistrarse))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(22)
									.addComponent(buttonlogin, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dayChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblcomoQuieresLlamar)
							.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
							.addComponent(lblqueDiaSe)
							.addGap(62))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(83)
					.addComponent(lblYaNoQueda)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYaNoQueda)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcomoQuieresLlamar)
						.addComponent(lblqueDiaSe))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(dayChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtnombreequipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRegistrarse)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonlogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(13, Short.MAX_VALUE))
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
//					gestor.anadirEquipo(txtnombreequipo.getText(), dayChooser.());
					 
					gestor.anadirEquipo(txtnombreequipo.getText(), fundacionEquipo)
				catch(Exception exv) 
				{
					JOptionPane.showMessageDialog(this,exv.getMessage());
				}
								
				txtnombreequipo.setText("");
				
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

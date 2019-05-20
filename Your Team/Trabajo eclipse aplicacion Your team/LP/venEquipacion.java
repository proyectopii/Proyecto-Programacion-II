package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import LN.clsGestorLN;

public class venEquipacion extends JDialog implements ActionListener {
	
	private clsGestorLN gestor = new clsGestorLN();

	private JPanel contentPane;
	private JTextField txtSerigrafiadoEPrincipal;
	private JTextField txtSerigrafiadoESeuandaria;
	private JComboBox comboCPP;
	private JComboBox comboCPS;
	private JComboBox comboCSS;
	private JComboBox comboCSP;
	private JComboBox comboPubliP;
	private JComboBox comboPubliS;
	private JButton btnSiguiente;
	
	public static final String ACTION_COMMAND_SIGUIENTE = "Siguiente";

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venEquipacion frame = new venEquipacion();
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
	public venEquipacion(venManager objequipo, boolean modal) {
		super(objequipo, modal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(76, 175, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(76, 175, 80));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblEquipacionPrincipal = new JLabel("Equipacion Principal");
		
		JLabel lblTocaCrearLas = new JLabel("Toca crear las equipaciones");
		lblTocaCrearLas.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblEquipacionSecundaria = new JLabel("Equipacion Secundaria");
		
		comboCPP = new JComboBox();
		comboCPP.setModel(new DefaultComboBoxModel(new String[] {"Amarillo", "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron"}));
		
		JLabel lblColorPrincipal = new JLabel("Color Principal");
		
		JLabel lblColorSecundario = new JLabel("Color Secundario");
		
		JLabel label = new JLabel("Color Principal");
		
		comboCPS = new JComboBox();
		comboCPS.setModel(new DefaultComboBoxModel(new String[] {"Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron", "Amarillo"}));
		
		JLabel label_1 = new JLabel("Color Secundario");
		
		comboCSS = new JComboBox();
		comboCSS.setModel(new DefaultComboBoxModel(new String[] {"Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron", "Amarillo"}));
		
		JLabel lblSerigafiado = new JLabel("Serigafiado");
		
		comboCSP = new JComboBox();
		comboCSP.setModel(new DefaultComboBoxModel(new String[] {"Amarillo", "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron"}));
		
		txtSerigrafiadoEPrincipal = new JTextField();
		txtSerigrafiadoEPrincipal.setColumns(10);
		
		JLabel lblPublicidad = new JLabel("Publicidad");
		
		comboPubliP = new JComboBox();
		comboPubliP.setModel(new DefaultComboBoxModel(new String[] {"Spotify", "Cocacola", "Tinder", "Youtube", "Google", "McDonalds", "Audi", "BMW", "Instagram", "Sony"}));
		
		JLabel label_2 = new JLabel("Serigafiado");
		
		txtSerigrafiadoESeuandaria = new JTextField();
		txtSerigrafiadoESeuandaria.setColumns(10);
		
		JLabel label_3 = new JLabel("Publicidad");
		
		comboPubliS = new JComboBox();
		comboPubliS.setModel(new DefaultComboBoxModel(new String[] {"Spotify", "Cocacola", "Tinder", "Youtube", "Google", "McDonalds", "Audi", "BMW", "Instagram", "Sony"}));
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setActionCommand(ACTION_COMMAND_SIGUIENTE);
		btnSiguiente.addActionListener(this);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(72)
					.addComponent(lblTocaCrearLas, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(btnSiguiente))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addComponent(lblEquipacionPrincipal)
					.addGap(107)
					.addComponent(lblEquipacionSecundaria, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addComponent(lblColorSecundario, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(117)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addComponent(lblSerigafiado, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(133)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(61)
							.addComponent(comboCSP, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(lblPublicidad, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboPubliP, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtSerigrafiadoEPrincipal))))
					.addGap(104)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(10)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboPubliS, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtSerigrafiadoESeuandaria))))
						.addComponent(comboCSS, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(61)
							.addComponent(comboCPP, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(lblColorPrincipal, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addGap(102)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(comboCPS, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTocaCrearLas)
						.addComponent(btnSiguiente))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEquipacionPrincipal)
						.addComponent(lblEquipacionSecundaria))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColorPrincipal)
						.addComponent(label))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboCPP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboCPS, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColorSecundario)
						.addComponent(label_1))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboCSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboCSS, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSerigafiado)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(label_2)))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSerigrafiadoEPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSerigrafiadoESeuandaria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPublicidad)
						.addComponent(label_3))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboPubliS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboPubliP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case ACTION_COMMAND_SIGUIENTE:
			if(!(txtSerigrafiadoEPrincipal.getText().equals("") || txtSerigrafiadoESeuandaria.getText().equals(""))) {
				try {
					gestor.anadirclsEquipacion((String) comboCPP.getSelectedItem(), (String) comboCSP.getSelectedItem(),
						txtSerigrafiadoEPrincipal.getText(), (String) comboPubliP.getSelectedItem(),
						(String) comboCPS.getSelectedItem(), (String) comboCSS.getSelectedItem(), 
						txtSerigrafiadoESeuandaria.getText(), (String) comboPubliS.getSelectedItem(), 0);
				}catch(Exception exv) {
					JOptionPane.showMessageDialog(this,exv.getMessage());
				}
								
				txtSerigrafiadoEPrincipal.setText("");
				txtSerigrafiadoESeuandaria.setText("");
				venEscudo obj = new venEscudo(this, true);
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

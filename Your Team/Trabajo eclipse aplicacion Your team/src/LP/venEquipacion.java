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
	public venEquipacion(venCrearEquipo objequipo, boolean modal) {
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
		lblEquipacionPrincipal.setBounds(41, 34, 93, 14);
		
		JLabel lblTocaCrearLas = new JLabel("Toca crear las equipaciones");
		lblTocaCrearLas.setBounds(97, 0, 205, 21);
		lblTocaCrearLas.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		
		JLabel lblEquipacionSecundaria = new JLabel("Equipacion Secundaria");
		lblEquipacionSecundaria.setBounds(241, 34, 137, 14);
		
		comboCPP = new JComboBox();
		comboCPP.setBounds(61, 84, 67, 22);
		comboCPP.setModel(new DefaultComboBoxModel(new String[] {"Amarillo", "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron"}));
		
		JLabel lblColorPrincipal = new JLabel("Color Principal");
		lblColorPrincipal.setBounds(51, 59, 98, 14);
		
		JLabel lblColorSecundario = new JLabel("Color Secundario");
		lblColorSecundario.setBounds(51, 118, 83, 14);
		
		JLabel label = new JLabel("Color Principal");
		label.setBounds(251, 59, 98, 14);
		
		comboCPS = new JComboBox();
		comboCPS.setBounds(261, 84, 67, 22);
		comboCPS.setModel(new DefaultComboBoxModel(new String[] {"Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron", "Amarillo"}));
		
		JLabel label_1 = new JLabel("Color Secundario");
		label_1.setBounds(251, 118, 83, 14);
		
		comboCSS = new JComboBox();
		comboCSS.setBounds(261, 138, 67, 22);
		comboCSS.setModel(new DefaultComboBoxModel(new String[] {"Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron", "Amarillo"}));
		
		JLabel lblSerigafiado = new JLabel("Serigafiado");
		lblSerigafiado.setBounds(51, 164, 67, 14);
		
		comboCSP = new JComboBox();
		comboCSP.setBounds(61, 138, 67, 20);
		comboCSP.setModel(new DefaultComboBoxModel(new String[] {"Amarillo", "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro", "Blanco", "Verde", "Marron"}));
		
		txtSerigrafiadoEPrincipal = new JTextField();
		txtSerigrafiadoEPrincipal.setBounds(61, 184, 86, 20);
		txtSerigrafiadoEPrincipal.setColumns(10);
		
		JLabel lblPublicidad = new JLabel("Publicidad");
		lblPublicidad.setBounds(51, 210, 59, 14);
		
		comboPubliP = new JComboBox();
		comboPubliP.setBounds(61, 230, 68, 20);
		comboPubliP.setModel(new DefaultComboBoxModel(new String[] {"Spotify", "Cocacola", "Tinder", "Youtube", "Google", "McDonalds", "Audi", "BMW", "Instagram", "Sony"}));
		
		JLabel label_2 = new JLabel("Serigafiado");
		label_2.setBounds(251, 166, 67, 14);
		
		txtSerigrafiadoESeuandaria = new JTextField();
		txtSerigrafiadoESeuandaria.setBounds(261, 184, 86, 20);
		txtSerigrafiadoESeuandaria.setColumns(10);
		
		JLabel label_3 = new JLabel("Publicidad");
		label_3.setBounds(251, 210, 59, 14);
		
		comboPubliS = new JComboBox();
		comboPubliS.setBounds(261, 230, 68, 20);
		comboPubliS.setModel(new DefaultComboBoxModel(new String[] {"Spotify", "Cocacola", "Tinder", "Youtube", "Google", "McDonalds", "Audi", "BMW", "Instagram", "Sony"}));
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(337, 0, 77, 23);
		btnSiguiente.setActionCommand(ACTION_COMMAND_SIGUIENTE);
		btnSiguiente.addActionListener(this);
		panel.setLayout(null);
		panel.add(btnSiguiente);
		panel.add(lblTocaCrearLas);
		panel.add(lblEquipacionPrincipal);
		panel.add(lblEquipacionSecundaria);
		panel.add(lblColorPrincipal);
		panel.add(label);
		panel.add(comboCPP);
		panel.add(comboCPS);
		panel.add(lblColorSecundario);
		panel.add(txtSerigrafiadoEPrincipal);
		panel.add(comboCSP);
		panel.add(lblSerigafiado);
		panel.add(lblPublicidad);
		panel.add(comboPubliP);
		panel.add(label_3);
		panel.add(txtSerigrafiadoESeuandaria);
		panel.add(label_2);
		panel.add(comboCSS);
		panel.add(label_1);
		panel.add(comboPubliS);
		
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

package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import COMUN.clsExcepcionEquipacionRepetida;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.ImageIcon;

public class venEquipacion extends JDialog implements ActionListener {
	/**
	 * Aqui hacemos un obtgestor y definimos todas las constantes
	 */

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

	private String titulo = "Your Team: Equipación";

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { venEquipacion frame = new
	 * venEquipacion(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public venEquipacion(venManager objequipo, boolean modal) {
		super(objequipo, modal);
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
		panel.setBackground(new Color(76, 175, 80));
		contentPane.add(panel);

		JLabel lblEquipacionPrincipal = new JLabel("Equipacion Principal");
		lblEquipacionPrincipal.setForeground(Color.ORANGE);
		lblEquipacionPrincipal.setBounds(41, 34, 93, 14);

		JLabel lblTocaCrearLas = new JLabel("Toca crear las equipaciones");
		lblTocaCrearLas.setBounds(72, 0, 230, 21);
		lblTocaCrearLas.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));

		JLabel lblEquipacionSecundaria = new JLabel("Equipacion Secundaria");
		lblEquipacionSecundaria.setForeground(Color.ORANGE);
		lblEquipacionSecundaria.setBounds(241, 34, 137, 14);

		comboCPP = new JComboBox();
		comboCPP.setBounds(61, 84, 88, 22);
		comboCPP.setModel(new DefaultComboBoxModel(new String[] { "Amarillo", "Naranja", "Rojo", "Morado", "Azul",
				"Rosa", "Negro", "Blanco", "Verde", "Marron" }));

		JLabel lblColorPrincipal = new JLabel("Color Principal");
		lblColorPrincipal.setForeground(Color.ORANGE);
		lblColorPrincipal.setBounds(51, 59, 98, 14);

		JLabel lblColorSecundario = new JLabel("Color Secundario");
		lblColorSecundario.setForeground(Color.ORANGE);
		lblColorSecundario.setBounds(51, 118, 113, 14);

		comboCPS = new JComboBox();
		comboCPS.setBounds(261, 84, 88, 22);
		comboCPS.setModel(new DefaultComboBoxModel(new String[] { "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro",
				"Blanco", "Verde", "Marron", "Amarillo" }));

		JLabel label_1 = new JLabel("Color Secundario");
		label_1.setForeground(Color.ORANGE);
		label_1.setBounds(251, 118, 127, 14);

		comboCSS = new JComboBox();
		comboCSS.setBounds(261, 138, 86, 22);
		comboCSS.setModel(new DefaultComboBoxModel(new String[] { "Naranja", "Rojo", "Morado", "Azul", "Rosa", "Negro",
				"Blanco", "Verde", "Marron", "Amarillo" }));

		JLabel lblSerigafiado = new JLabel("Serigafiado");
		lblSerigafiado.setForeground(Color.ORANGE);
		lblSerigafiado.setBounds(51, 166, 67, 14);

		comboCSP = new JComboBox();
		comboCSP.setBounds(61, 138, 86, 20);
		comboCSP.setModel(new DefaultComboBoxModel(new String[] { "Amarillo", "Naranja", "Rojo", "Morado", "Azul",
				"Rosa", "Negro", "Blanco", "Verde", "Marron" }));

		txtSerigrafiadoEPrincipal = new JTextField();
		txtSerigrafiadoEPrincipal.setBounds(61, 186, 86, 20);
		txtSerigrafiadoEPrincipal.setColumns(10);

		JLabel lblPublicidad = new JLabel("Publicidad");
		lblPublicidad.setForeground(Color.ORANGE);
		lblPublicidad.setBounds(51, 212, 59, 14);

		comboPubliP = new JComboBox();
		comboPubliP.setBounds(61, 232, 86, 20);
		comboPubliP.setModel(new DefaultComboBoxModel(new String[] { "Spotify", "Cocacola", "Tinder", "Youtube",
				"Google", "McDonalds", "Audi", "BMW", "Instagram", "Sony" }));

		JLabel label_2 = new JLabel("Serigafiado");
		label_2.setForeground(Color.ORANGE);
		label_2.setBounds(251, 168, 67, 14);

		txtSerigrafiadoESeuandaria = new JTextField();
		txtSerigrafiadoESeuandaria.setBounds(261, 186, 86, 20);
		txtSerigrafiadoESeuandaria.setColumns(10);

		JLabel label_3 = new JLabel("Publicidad");
		label_3.setForeground(Color.ORANGE);
		label_3.setBounds(251, 212, 59, 14);

		comboPubliS = new JComboBox();
		comboPubliS.setBounds(261, 232, 86, 20);
		comboPubliS.setModel(new DefaultComboBoxModel(new String[] { "Spotify", "Cocacola", "Tinder", "Youtube",
				"Google", "McDonalds", "Audi", "BMW", "Instagram", "Sony" }));

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(348, 257, 93, 23);
		btnSiguiente.setActionCommand(ACTION_COMMAND_SIGUIENTE);
		btnSiguiente.addActionListener(this);

		panel.setLayout(null);
		panel.add(lblTocaCrearLas);
		panel.add(btnSiguiente);
		panel.add(lblEquipacionPrincipal);
		panel.add(lblEquipacionSecundaria);
		panel.add(lblColorSecundario);
		panel.add(label_1);
		panel.add(lblSerigafiado);
		panel.add(label_2);
		panel.add(comboCSP);
		panel.add(lblPublicidad);
		panel.add(comboPubliP);
		panel.add(txtSerigrafiadoEPrincipal);
		panel.add(label_3);
		panel.add(comboPubliS);
		panel.add(txtSerigrafiadoESeuandaria);
		panel.add(comboCSS);
		panel.add(comboCPP);
		panel.add(lblColorPrincipal);
		panel.add(comboCPS);

		JLabel lblColorPrincipal_1 = new JLabel("Color Principal");
		lblColorPrincipal_1.setForeground(Color.ORANGE);
		lblColorPrincipal_1.setBounds(241, 59, 106, 14);
		panel.add(lblColorPrincipal_1);

		JLabel labelfoto = new JLabel("");
		labelfoto.setIcon(new ImageIcon(venEquipacion.class.getResource("/Imagenes/fotoequipacion2.png")));
		labelfoto.setBounds(0, 0, 451, 291);
		panel.add(labelfoto);

	}

	/**
	 * Aqui con este switch haremos todas las acciones que hemos programado
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case ACTION_COMMAND_SIGUIENTE:
			if (!(txtSerigrafiadoEPrincipal.getText().equals("") || txtSerigrafiadoESeuandaria.getText().equals(""))) {
				try {
					gestor.anadirclsEquipacion((String) comboCPP.getSelectedItem(), (String) comboCSP.getSelectedItem(),
							txtSerigrafiadoEPrincipal.getText(), (String) comboPubliP.getSelectedItem(),
							(String) comboCPS.getSelectedItem(), (String) comboCSS.getSelectedItem(),
							txtSerigrafiadoESeuandaria.getText(), (String) comboPubliS.getSelectedItem(), 0);
				} catch (clsExcepcionEquipacionRepetida exv) {
					JOptionPane.showMessageDialog(this, exv.getMessage());
				}

				txtSerigrafiadoEPrincipal.setText("");
				txtSerigrafiadoESeuandaria.setText("");

				this.dispose();
				venEscudo obj = new venEscudo(this, true);
				obj.setVisible(true);
				setModal(true);
				/**
				 * Sirve para que no puedas usar la ventana anterior
				 */
			} else {
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos");
			}
			break;

		}

	}

}

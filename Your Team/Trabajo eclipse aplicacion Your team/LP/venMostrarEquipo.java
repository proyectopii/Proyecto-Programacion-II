package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import COMUN.itfProperty;
import LN.clsGestorLN;

import java.awt.Color;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class venMostrarEquipo extends JDialog implements ActionListener {
	/**
	 * Aqui definiremos todos los radiobutton panel y button que queramos utilizar
	 */
	private String titulo = "Your Team: Este es tu equipo";

	private final String ACTION_COMMAND_ATRAS = "atras";
	private final String ACTION_COMMAND_ALANTE = "adelante";
	private final String ACTION_COMMAND_REFRESCAR = "refrescar";
	private final String ACTION_COMMAND_ELIMINAR = "ELIMINAR";

	private clsGestorLN objgestor = new clsGestorLN();

	private JPanel contentPane;
	private JRadioButton rdbtnordenombre;
	private JRadioButton rdbtnordenequipo;
	private JRadioButton rdbtnordenColor;
	private JButton btnRefrescar;
	private JRadioButton rdbtnordenManager;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { venMostrarEquipo frame = new
	 * venMostrarEquipo(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 * 
	 * @param b
	 * @param objIniciarSesion
	 */
	public venMostrarEquipo(venIniciarSesion objIniciarSesion, boolean modal) {
		super(objIniciarSesion, modal);
		setTitle(titulo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(venInicio.class.getResource("/Imagenes/your team.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 451, 291);
		panel.setBackground(new Color(255, 204, 153));
		contentPane.add(panel);
		panel.setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setBounds(0, 0, 225, 146);
		panel.add(textArea);

		rdbtnordenombre = new JRadioButton("Ordenar por nombre");
		rdbtnordenombre.setBounds(267, 211, 148, 23);
		panel.add(rdbtnordenombre);

		rdbtnordenequipo = new JRadioButton("Ordenar por equipo");
		rdbtnordenequipo.setBounds(47, 261, 139, 23);
		panel.add(rdbtnordenequipo);

		btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(this);
		btnRefrescar.setActionCommand(ACTION_COMMAND_REFRESCAR);
		btnRefrescar.setBounds(302, 52, 113, 23);
		panel.add(btnRefrescar);

		rdbtnordenColor = new JRadioButton("Ordenar por color");
		rdbtnordenColor.setBounds(47, 211, 139, 23);
		panel.add(rdbtnordenColor);

		rdbtnordenManager = new JRadioButton("Ordenar por Manager");
		rdbtnordenManager.setBounds(267, 261, 148, 23);
		panel.add(rdbtnordenManager);

		JLabel labelfoto = new JLabel("");
		labelfoto.setIcon(new ImageIcon(venMostrarEquipo.class.getResource("/Imagenes/fotomostrarequipo2.png")));
		labelfoto.setBounds(0, 0, 451, 291);
		panel.add(labelfoto);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnordenColor);
		group.add(rdbtnordenombre);
		group.add(rdbtnordenequipo);
		group.add(rdbtnordenManager);
	}

	/**
	 * A traves del switch iremos a las diferentes opciones que necesitemos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {

		case ACTION_COMMAND_REFRESCAR:
			if (ordencolor()) {
		      objgestor.ordenporcolor();				
			} else if (ordennombre()) {
				objgestor.ordenpornombre();
			} else if (ordenequipo()) {
				objgestor.ordenporequipo();
			} else {
				objgestor.ordenpormanager();
			}
			break;

		case ACTION_COMMAND_ELIMINAR:
			objgestor.borrarManager();
		}

	}

	private boolean ordencolor() {
		return rdbtnordenColor.isSelected();
	}

	private boolean ordenequipo() {
		return rdbtnordenequipo.isSelected();
	}

	private boolean ordennombre() {
		return rdbtnordenombre.isSelected();
	}

	private boolean ordenmanager() {
		return rdbtnordenManager.isSelected();
	}
}

package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsGestorLN;

import java.awt.Color;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class venMostrarEquipo extends JDialog implements ActionListener {
	private String titulo = "Your Team: Este es tu equipo";
	
	private final String ACTION_COMMAND_ATRAS = "atras";
	private final String ACTION_COMMAND_ALANTE = "adelante";
	private final String ACTION_COMMAND_REFRESCAR = "refrescar";
	private final String ACTION_COMMAND_ELIMINAR = "ELIMINAR";
	
	private clsGestorLN objgestor = new clsGestorLN();

	private JPanel contentPane;
	private JButton buttonatras;
	private JButton buttonalante;
	private JButton btnEliminar;
	private JRadioButton rdbtnordenombre;
	private JRadioButton rdbtnordenequipo;
	private JRadioButton rdbtnordenColor;
	private JButton btnRefrescar;
	private JRadioButton rdbtnordenManager;
	
	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venMostrarEquipo frame = new venMostrarEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
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
		
		buttonatras = new JButton("<<");
		buttonatras.addActionListener(this);
		buttonatras.setActionCommand(ACTION_COMMAND_ATRAS);
		buttonatras.setBounds(10, 152, 89, 23);
		panel.add(buttonatras);
		
		buttonalante = new JButton(">>");
		buttonalante.addActionListener(this);
		buttonalante.setActionCommand(ACTION_COMMAND_ALANTE);
		buttonalante.setBounds(109, 152, 89, 23);
		panel.add(buttonalante);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ACTION_COMMAND_ELIMINAR);
		btnEliminar.setBounds(302, 86, 113, 23);
		panel.add(btnEliminar);
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case ACTION_COMMAND_ATRAS:
				int p = objgestor.atras();
				
				if(p != -1) {
					String nombre = objgestor.obtenernombre(p);
					String apellido1 = objgestor.obtenerapellido1(p);
					String apellido2 = objgestor.obtenerapellido2(p);
					String dni = objgestor.obtenerdni(p);
					String sexo = objgestor.obtenersexo(p);
					String calidad = objgestor.obtenercalidad(p);
					int valoracion = objgestor.obtenervaloracion(p);
					String contrasenia = objgestor.obtenercontrasenia(p);
				}
				break;
				
			case ACTION_COMMAND_ALANTE:
				p = objgestor.alante();
				
				if(p != -1) {
					String nombre = objgestor.obtenernombre(p);
					String apellido1 = objgestor.obtenerapellido1(p);
					String apellido2 = objgestor.obtenerapellido2(p);
					String dni = objgestor.obtenerdni(p);
					String sexo = objgestor.obtenersexo(p);
					String calidad = objgestor.obtenercalidad(p);
					int valoracion = objgestor.obtenervaloracion(p);
					String contrasenia = objgestor.obtenercontrasenia(p);
				}
				break;
			case ACTION_COMMAND_REFRESCAR:
				if(ordencolor()) {
					objgestor.ordenporcolor();
				}else if (ordennombre()){
					objgestor.ordenpornombre();
				}else if(ordenequipo()){
					objgestor.ordenporequipo();
				}else {
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

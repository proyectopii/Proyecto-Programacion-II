import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // Main para visualizar la ventana
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//medidas del panel
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("C\u00E9ntrico");//Todos los checkbox, los instanciamos
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Piso");
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("A las afueras");
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Chalet");
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Compra");
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Intermedio");
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("\u00C1tico");
		
		JCheckBox chckbxAlquiler = new JCheckBox("Alquiler");
		
		
		JButton btnNewButton = new JButton("Borrar todo"); // lo borramos todo
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				chckbxNewCheckBox.setSelected(false); //lo ponemos a false para que no este activo
				chckbxNewCheckBox_1.setSelected(false);
				chckbxNewCheckBox_2.setSelected(false);
				chckbxNewCheckBox_4.setSelected(false);
				chckbxNewCheckBox_5.setSelected(false);
				chckbxNewCheckBox_6.setSelected(false);
				chckbxNewCheckBox_2.setSelected(false);
				chckbxNewCheckBox_9.setSelected(false);
				chckbxAlquiler.setSelected(false);
				
				
				
			}
		});
		
		chckbxAlquiler.setToolTipText("");
		
		JLabel lblLocalizacin = new JLabel("Localizaci\u00F3n");
		lblLocalizacin.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblRenta = new JLabel("Renta");
		lblRenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //la accion de que nuestro boton esta pulsado
				
				if(chckbxNewCheckBox .isSelected()) {
					System.out.println("Usted ha elegido centrico");
				}
				if(chckbxNewCheckBox_1 .isSelected()) {
					System.out.println("Usted ha elegido piso");
				}
				if(chckbxNewCheckBox_4 .isSelected()) {
					System.out.println("Usted ha elegido a las afueras");
				}
				if(chckbxNewCheckBox_5 .isSelected()) {
					System.out.println("Usted ha elegido chalet");
				}
				if(chckbxNewCheckBox_6 .isSelected()) {
					System.out.println("Usted ha elegido compra");
				}
				if(chckbxNewCheckBox_2 .isSelected()) {
					System.out.println("Usted ha elegido intermedio");
				}
				if(chckbxNewCheckBox_9 .isSelected()) {
					System.out.println("Usted ha elegido atico");
				}
				if(chckbxAlquiler .isSelected()) {
					System.out.println("Usted ha elegido alquiler");
				}
				
				
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnSeleccionarTodo = new JButton("Seleccionar todo");
		btnSeleccionarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxNewCheckBox.setSelected(true);
				chckbxNewCheckBox_1.setSelected(true);
				chckbxNewCheckBox_2.setSelected(true);
				chckbxNewCheckBox_4.setSelected(true);
				chckbxNewCheckBox_5.setSelected(true);
				chckbxNewCheckBox_6.setSelected(true);
				chckbxNewCheckBox_2.setSelected(true);
				chckbxNewCheckBox_9.setSelected(true);
				chckbxAlquiler.setSelected(true);
			}
		});
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnBuscar)
							.addGap(34)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLocalizacin)
								.addComponent(chckbxNewCheckBox)
								.addComponent(chckbxNewCheckBox_4)
								.addComponent(chckbxNewCheckBox_2))
							.addGap(55)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxNewCheckBox_9)
								.addComponent(chckbxNewCheckBox_1)
								.addComponent(lblTipo)
								.addComponent(chckbxNewCheckBox_5))))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxAlquiler, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRenta)
						.addComponent(chckbxNewCheckBox_6)
						.addComponent(btnSeleccionarTodo))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizacin)
						.addComponent(lblTipo)
						.addComponent(lblRenta))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox)
						.addComponent(chckbxNewCheckBox_1)
						.addComponent(chckbxAlquiler))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox_4)
						.addComponent(chckbxNewCheckBox_5)
						.addComponent(chckbxNewCheckBox_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox_2)
						.addComponent(chckbxNewCheckBox_9))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBuscar)
						.addComponent(btnNewButton)
						.addComponent(btnSeleccionarTodo))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}

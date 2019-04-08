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

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("C\u00E9ntrico");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Piso");
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("A las afueras");
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Chalet");
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Compra");
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Intermedio");
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("\u00C1tico");
		
		JCheckBox chckbxAlquiler = new JCheckBox("Alquiler");
		
		
		JButton btnNewButton = new JButton("Borrar todo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				chckbxNewCheckBox.setSelected(false);
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
		System.out.println("Usted ha seleccionado: ");
		if(chckbxNewCheckBox .isSelected()) {
			System.out.println("Usted ha elegido centrico");
		}
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLocalizacin)
						.addComponent(chckbxNewCheckBox_4)
						.addComponent(chckbxNewCheckBox)
						.addComponent(chckbxNewCheckBox_2))
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxNewCheckBox_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipo)
								.addComponent(chckbxNewCheckBox_5)
								.addComponent(chckbxNewCheckBox_9))
							.addGap(45)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxNewCheckBox_6)
								.addComponent(lblRenta)
								.addComponent(chckbxAlquiler, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(146))
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
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxNewCheckBox)
								.addComponent(chckbxNewCheckBox_1))
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxNewCheckBox_4)
								.addComponent(chckbxNewCheckBox_5)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(chckbxAlquiler)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNewCheckBox_6)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox_2)
						.addComponent(chckbxNewCheckBox_9))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnBuscar))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}

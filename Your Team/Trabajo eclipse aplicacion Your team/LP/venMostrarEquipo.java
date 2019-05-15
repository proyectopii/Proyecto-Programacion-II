package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class venMostrarEquipo extends JDialog implements ActionListener {

	private JPanel contentPane;

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
	 */
	public venMostrarEquipo(venIniciarSesion objIniciarSesion, boolean modal) {
		super(objIniciarSesion, modal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		contentPane.add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}

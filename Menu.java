package wargame;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 853, 495);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images//background.jpg"));
		lblNewLabel.setBounds(-178, -68, 741, 856);
		panel.add(lblNewLabel);
		
		Button button = new Button("Joueur VS Joueur");
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed1(ActionEvent arg0) {
			
		}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		button.setBounds(583, 128, 187, 32);
		panel.add(button);
		
		Button button_1 = new Button("Joueur VS IA");
		button_1.setFont(new Font("Arial", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			        //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
			       
			}
		});
		button_1.setBounds(583, 177, 187, 32);
		panel.add(button_1);
		
		Button button_2 = new Button("Charger une partie");
		button_2.setFont(new Font("Arial", Font.BOLD, 12));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(583, 234, 187, 32);
		panel.add(button_2);
		
		Button button_3 = new Button("Régles");
		button_3.setFont(new Font("Arial", Font.BOLD, 12));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(583, 288, 187, 32);
		panel.add(button_3);
		
		JLabel lblNewLabel_1 = new JLabel("MENU");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(628, 79, 60, 14);
		panel.add(lblNewLabel_1);
		
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;


public class UstawPriorytet extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UstawPriorytet frame = new UstawPriorytet();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void closelButtonActionPerformed(java.awt.event.ActionEvent evt) {
	    this.dispose();
	}

	
	public UstawPriorytet() throws IOException {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.menu);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblZaznaczPrzedmiotyKtore = new JLabel("Zaznacz przedmioty ktore s\u0105 dla ciebie najwa\u017Cniejsze");
		lblZaznaczPrzedmiotyKtore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblZaznaczPrzedmiotyKtore.setBounds(10, 11, 414, 49);
		desktopPane.add(lblZaznaczPrzedmiotyKtore);
		
	
		
		final JCheckBox checkBox = new JCheckBox("Matematyka");
		checkBox.setBounds(20, 67, 97, 23);
		desktopPane.add(checkBox);
		
		final JCheckBox checkBox_1 = new JCheckBox("Jêzyk polski");
		checkBox_1.setBounds(20, 100, 97, 23);
		desktopPane.add(checkBox_1);
		
		final JCheckBox checkBox_2 = new JCheckBox("Historia");
		checkBox_2.setBounds(20, 136, 97, 23);
		desktopPane.add(checkBox_2);
		
		final JCheckBox checkBox_3 = new JCheckBox("Fizyka");
		checkBox_3.setBounds(159, 67, 97, 23);
		desktopPane.add(checkBox_3);
		
		final JCheckBox checkBox_4 = new JCheckBox("Chemia");
		checkBox_4.setBounds(159, 100, 97, 23);
		desktopPane.add(checkBox_4);
		
		final JCheckBox checkBox_5 = new JCheckBox("Biologia");
		checkBox_5.setBounds(159, 136, 97, 23);
		desktopPane.add(checkBox_5);
		
		final JCheckBox checkBox_6 = new JCheckBox("Angielski");
		checkBox_6.setBounds(20, 172, 97, 23);
		desktopPane.add(checkBox_6);
		
		final JCheckBox checkBox_7 = new JCheckBox("Niemiecki");
		checkBox_7.setBounds(276, 67, 97, 23);
		desktopPane.add(checkBox_7);
		
		final JCheckBox checkBox_8 = new JCheckBox("Geografia");
		checkBox_8.setBounds(276, 100, 97, 23);
		desktopPane.add(checkBox_8);
		
		final JCheckBox checkBox_9 = new JCheckBox("Informatyka");
		checkBox_9.setBounds(276, 136, 97, 23);
		desktopPane.add(checkBox_9);
		
		final JCheckBox checkBox_10 = new JCheckBox("WoS");
		checkBox_10.setBounds(159, 172, 97, 23);
		desktopPane.add(checkBox_10);
		
		 final FileWriter out = new FileWriter("Prior.txt");
		
		JButton btnNewButton = new JButton("Zapisz");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
			closelButtonActionPerformed(e);
			Main.main(null);	
			try {
				
				
				
				if	(checkBox.isSelected()) {
					System.out.println("u0");
				
					out.write("0");
				}
				
				if	(checkBox_1.isSelected()) {
					System.out.println("1");
				
					out.write("1");
				}
				if	(checkBox_2.isSelected()) {
					System.out.println("u2");
				
					out.write("2");
				
				
				}
				if	(checkBox_3.isSelected()) {
					System.out.println("u3");
					out.write("3");
				}
			if	(checkBox_4.isSelected()) {
				System.out.println("u4");
				out.write("4");
			}
			if	(checkBox_5.isSelected()) {
				System.out.println("u5");
				out.write("5");
			}
			if	(checkBox_6.isSelected()) {
				System.out.println("u6");
				out.write("6");
			}
			if	(checkBox_7.isSelected()) {
				System.out.println("u7");
				out.write("7");
			}
			if	(checkBox_8.isSelected()) {
				System.out.println("u8");
				out.write("8");
				
			}
			if	(checkBox_9.isSelected()) {
				System.out.println("u9");
				out.write("9");
			}
			
			if	(checkBox_10.isSelected()) {
				out.write("a");	
				System.out.println("a");
			}
			
			out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			}
			
		});
		
		
		
		
		btnNewButton.setBounds(5, 204, 111, 39);
		desktopPane.add(btnNewButton);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closelButtonActionPerformed(e);
				 Main.main(null);
			}
		});
		btnAnuluj.setBounds(302, 204, 111, 39);
		desktopPane.add(btnAnuluj);
		
		
	}
}

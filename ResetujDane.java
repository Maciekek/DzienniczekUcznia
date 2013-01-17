import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;


public class ResetujDane extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetujDane frame = new ResetujDane();
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
	
	
	
	
	public ResetujDane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.menu);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JTextPane txtpnWybierzKtryPrzedmiot = new JTextPane();
		txtpnWybierzKtryPrzedmiot.setBackground(SystemColor.menu);
		txtpnWybierzKtryPrzedmiot.setForeground(SystemColor.desktop);
		txtpnWybierzKtryPrzedmiot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnWybierzKtryPrzedmiot.setText("Wybierz, kt\u00F3ry przedmiot chcesz zresetowa\u0107. Pami\u0119taj, utraconych danych nie odtworzysz!");
		txtpnWybierzKtryPrzedmiot.setBounds(29, 23, 353, 82);
		desktopPane.add(txtpnWybierzKtryPrzedmiot);
		
		 final JComboBox listaPrzedmiotow = new JComboBox();
		desktopPane.add(listaPrzedmiotow);
		listaPrzedmiotow.setEditable(true);
		listaPrzedmiotow.setBounds(39,116,343,30);
		listaPrzedmiotow.addItem("Matematyka");
		listaPrzedmiotow.addItem("Polski");
		listaPrzedmiotow.addItem("Historia");
		listaPrzedmiotow.addItem("Fizyka");
		listaPrzedmiotow.addItem("Chemia");
		listaPrzedmiotow.addItem("Biologia");
		listaPrzedmiotow.addItem("Angielski");
		listaPrzedmiotow.addItem("Niemiecki");
		listaPrzedmiotow.addItem("Geografia");
		listaPrzedmiotow.addItem("Informatyka");
		listaPrzedmiotow.addItem("WoS");
		
		JButton btnResetuj = new JButton("Resetuj!");
		btnResetuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String przedmiot = (String) listaPrzedmiotow.getSelectedItem();
					
					
					
					


					    Object[] options = { "Yes", "No" };
					    int n = JOptionPane.showOptionDialog(new JFrame(),
					            "Czy jesteœ pewien, ¿e chcesz usu¹æ dane z przedmiotu: "+ przedmiot +" ?", "Czy jesteœ pewnien?",
					            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					            options, options[1]);
					    if(n == JOptionPane.OK_OPTION){ // Afirmative
					      System.out.println("ok");
					      FileWriter out = new FileWriter(przedmiot+  "Opis.txt");
							FileWriter out1 = new FileWriter(przedmiot+".txt");
							closelButtonActionPerformed(e);
							Main.main(null);
					    }
					    if(n == JOptionPane.NO_OPTION){ // negative
					        System.out.println("no");
					        
					    }
					    if(n == JOptionPane.CLOSED_OPTION){ // closed the dialog
					        System.out.println("nie wiem");
					    }
			    
			        
			        

					
//					
				} catch (Exception bladPliku) {
					
				}
			}
		});
		btnResetuj.setBounds(141, 191, 132, 39);
		desktopPane.add(btnResetuj);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closelButtonActionPerformed(e);
				Main.main(null);
				
			}
		});
		btnAnuluj.setBounds(324, 211, 90, 30);
		desktopPane.add(btnAnuluj);
		
		
	}
}

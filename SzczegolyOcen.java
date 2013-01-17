import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SzczegolyOcen extends JFrame {
	static  boolean CzyEdytowalny = false;
	static boolean Edycja = false;
	
	static String przedmiot = null;
	private JPanel contentPane;
	private String btnNazwa = "Edytuj";
	private static JLabel lxlNazwaPrzedmiotu;
	private TextArea textArea;
	static boolean WidocznoscZapisu;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SzczegolyOcen frame = new SzczegolyOcen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void ZbudujGrafSzczegolyOcen() {
		
		setBounds(100, 200, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.menu);
		desktopPane.setBounds(0, 0, 434, 262);
		contentPane.add(desktopPane);
		
		JLabel lblSzczegyOcen = new JLabel("    Szczeg\u00F3\u0142y ocen");
		lblSzczegyOcen.setFont(new Font("Serif", Font.PLAIN, 50));
		lblSzczegyOcen.setBounds(0, -12, 434, 65);
		desktopPane.add(lblSzczegyOcen);
		
		JLabel lblPrzedmiot = new JLabel("Przedmiot:");
		lblPrzedmiot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrzedmiot.setBounds(10, 64, 85, 25);
		desktopPane.add(lblPrzedmiot);
		
		lxlNazwaPrzedmiotu = new JLabel("");
		lxlNazwaPrzedmiotu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lxlNazwaPrzedmiotu.setBounds(144, 64, 227, 25);
		desktopPane.add(lxlNazwaPrzedmiotu);
		
		textArea = new TextArea();
		textArea.setEditable(CzyEdytowalny);
		textArea.setBounds(20, 95, 404, 160);
		desktopPane.add(textArea);
		 
		JButton btnEdytuj = new JButton("Edytuj");
		 btnEdytuj.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent edytuj) {
		 		 
		 		closelButtonActionPerformed(edytuj);
		 		CzyEdytowalny = true;
		 		
		 		Edycja = true;
		 		if (Edycja = true)
			 			WidocznoscZapisu = true;
		 		//System.out.println(WidocznoscZapisu);
		 		SzczegolyOcen.main(null);
		 		//System.out.println(WidocznoscZapisu);
		 		
		 	}
		 });
		 btnEdytuj.setBounds(10, 262, 132, 39);
		 contentPane.add(btnEdytuj);
		 
		 JButton btnWyjdz = new JButton("Wyjdz");
		 btnWyjdz.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent Wyjdz) {
		 		closelButtonActionPerformed(Wyjdz);
				Main.main(null);
		 	}
		 });
		 btnWyjdz.setBounds(294, 262, 132, 39);
		 contentPane.add(btnWyjdz);
		 JButton btnZapiszZmiany = new JButton("Zapisz zmiany");
		 btnZapiszZmiany.setBounds(152, 262, 132, 39);
		 contentPane.add(btnZapiszZmiany);
		 btnZapiszZmiany.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent ZapiszZmiany) {
		 		try {	
		 		String NoweDane;
		 	 NoweDane = textArea.getText();
		 	// System.out.println(NoweDane);
		 	
				FileWriter out = new FileWriter(przedmiot+  "Opis.txt");
				out.write(NoweDane);
				out.close();
				CzyEdytowalny = false;
				Edycja = false;
				WidocznoscZapisu = false;
				closelButtonActionPerformed(ZapiszZmiany);
				Main.main(null);
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 		
		 	}
		 });
		 btnZapiszZmiany.setEnabled(WidocznoscZapisu);
		
		
		
		
	}
	
	
	public void closelButtonActionPerformed(java.awt.event.ActionEvent evt) {
	    this.dispose();
	}
	
	public void pokazOpis() {
		lxlNazwaPrzedmiotu.setText(przedmiot);
	}
	
	
	public void wyswietlZawartosc() throws IOException {
		przedmiot = Main.przedmiot;
		 
		BufferedReader br = new BufferedReader(new FileReader(przedmiot+"Opis.txt")); 
		String linia; 
		String tekst = ""; 
		while ((linia = br.readLine()) != null) { 
			tekst = tekst+linia+"\n"; 
		} 
		br.close(); 
		
		textArea.setText(tekst); 
		
	
	}
	
	
	
	public SzczegolyOcen() throws IOException {
		
		ZbudujGrafSzczegolyOcen();
		pokazOpis();
		wyswietlZawartosc();
			
		
		
}
}
	
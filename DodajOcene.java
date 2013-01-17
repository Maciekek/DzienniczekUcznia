import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.BackingStoreException;

import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;




public class DodajOcene extends JFrame {
	public boolean przelacznik = false;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSzczegol;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {					//utworzenie w¹tku dla interfejsu graficznego
			public void run() {
				try {
					DodajOcene frame = new DodajOcene();
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
	
	
	
	
	/* wyswietlenie kominukat: TRUE/FALSE, w zaleznosci od poprawnosci wpisanej wartosci*/
	public void wyswietlKomunikat(boolean error) {
		if (error == false) 
			JOptionPane.showMessageDialog(null, "Dodano pomyœlnie", "Good", JOptionPane.NO_OPTION);
		else 
		JOptionPane.showMessageDialog(null, "Wprowadz poprawnie liczbe", "Error", JOptionPane.NO_OPTION);
	}
	
	
	
	
	public void dodajOceneSzczegolowa(String NazwaPrzedmiotu,JTextField poletxt, JTextField txtSzczegol) throws IOException {
		
		boolean error=false;
		String przedmiot = NazwaPrzedmiotu;
		//System.out.println(przedmiot);
		String Ocena = poletxt.getText();
		int OcenaINT = Integer.parseInt(Ocena);
		try{
			FileReader in = new FileReader(przedmiot+"Opis.txt");
		}catch (Exception brakPliku){
			FileWriter out = new FileWriter(przedmiot+  "Opis.txt", true);
		}
		FileWriter out = new FileWriter(przedmiot+  "Opis.txt", true);
		
		String InformacjeDoZapisu = txtSzczegol.getText();
		if(OcenaINT > 0 && OcenaINT<=6){
		out.write("Ocena: \t" + Ocena + "\t \t\tOpis oceny: "+ InformacjeDoZapisu+"\t\t " + "\r");
		wyswietlKomunikat(error);
		out.close();
		closelButtonActionPerformed(null);
		Main.main(null);
		}
		else{
			error=true;
			wyswietlKomunikat(error);
		
		}
	}
	
	
	
	public DodajOcene() throws IOException {
		
		///setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Dodaj ocene");
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.WEST);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(SystemColor.menu);
		contentPane.add(desktopPane_1, BorderLayout.CENTER);
		
		final JComboBox listaPrzedmiotow = new JComboBox();
		desktopPane_1.add(listaPrzedmiotow);
		listaPrzedmiotow.setEditable(true);
		listaPrzedmiotow.setBounds(162,8,197,30);
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
		
		textField = new JTextField();
		textField.setBounds(162, 57, 41, 30);
		desktopPane_1.add(textField);
		textField.setColumns(10);
		
		JButton btnDodaj = new JButton("Zapisz!");
		btnDodaj.setBounds(5, 204, 111, 39);
		desktopPane_1.add(btnDodaj);
		
		
		
		
		listaPrzedmiotow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent zdarzenie) {
				String przedmiot = 	(String) listaPrzedmiotow.getSelectedItem();
				System.out.println(przedmiot);
			
			}
		});

			
		
		
//		
		
		
		JLabel lblWybierzPrzedmiot = new JLabel (
				"Wybierz przedmiot:");
		lblWybierzPrzedmiot.setBounds(5, 11, 111, 30);
		desktopPane_1.add(lblWybierzPrzedmiot);
		
		JLabel lblWprowadOceny = new JLabel("Wprowad\u017A oceny:");
		lblWprowadOceny.setBounds(5, 57, 111, 30);
		desktopPane_1.add(lblWprowadOceny);
		
		
		
		
		txtSzczegol = new JTextField();
		txtSzczegol.setBounds(162, 121, 197, 30);
		desktopPane_1.add(txtSzczegol);
		txtSzczegol.setColumns(10);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closelButtonActionPerformed(e);
				 Main.main(null);
			}
		});
		btnAnuluj.setBounds(302, 204, 111, 39);
		desktopPane_1.add(btnAnuluj);
		
		
		JLabel lblKrtkiOpis = new JLabel("Kr\u00F3tki opis:");
		lblKrtkiOpis.setBounds(5, 121, 111, 30);
		desktopPane_1.add(lblKrtkiOpis);
	
		
		
		
		
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent zdarzenieDodaj) {
				
				String przedmiot = 	(String) listaPrzedmiotow.getSelectedItem(); // zmienna przedmiot odpowiada wybrany przedmiot
				
				
				
				try {
				dodajOceneSzczegolowa(przedmiot, textField, txtSzczegol);
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				
				
				
			}

			
		});
		
		
		
		
	}
}

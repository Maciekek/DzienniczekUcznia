import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.Button;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.TextField;


public class Main extends JFrame {

	static JPanel contentPane;
	 static JButton btn_Mat;
	 static JButton btn_Pol;
	 static JButton btn_His;
	 static JButton btn_Fiz;
	 static JButton btn_Che;
	 static JButton btn_Bio;
	 static JButton btn_Ang;
	 static JButton btn_Niem;
	 static JButton btn_Geo;
	 static JButton btn_Inf;
	 static JButton btn_Wos;
	 static JButton lblPrzedmiot;
	public static boolean CzyWidoczna = true;
	static JLabel lblMatematyka;
	static String przedmiot;
	static JDesktopPane desktopPane;
	 static JLabel lblPolski;
	 static JLabel lblHistoria;
	 static JLabel lblFizyka;
	 static JLabel lblChemia;
	 static JLabel lblBiologia;
	 static JLabel lblAngielski;
	 static JLabel lblNiemiecki;
	 static JLabel lblGeografia;
	 static JLabel lblInformatyka;
	 static JLabel lblWos;
	
	
	/**Odpalenie calego interfejstu graf */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(CzyWidoczna);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
		public Main()  throws FileNotFoundException, IOException {
			
		
		ZbudujGraf();
		DodajOcene(desktopPane);
		ResetujDane(desktopPane);
		
		wyswietlOceny();
		ustawPriorytet();
		
	
		
	}


	
	/** zamkniêcie okna, bez wylaczenia aplikacji */
	public void closelButtonActionPerformed(java.awt.event.ActionEvent evt) {
	    this.dispose();
	}

	
	/**metoda odpowiedzialna za stworzenie grafiki z odpowiednim wypelnieniem pol i actionListenery */
	public void ZbudujGraf() throws IOException {
		 
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 0, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel labelGlowny = new JLabel("       Dzienniczek Ucznia");
		labelGlowny.setFont(new Font("Serif", Font.PLAIN, 50));	
		contentPane.add(labelGlowny, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		contentPane.add(label, BorderLayout.WEST);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.menu);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		
		
		
		
		
		lblMatematyka = new JLabel("Matematyka");
		lblMatematyka.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMatematyka.setBounds(10, 10, 113, 39);
		desktopPane.add(lblMatematyka);
		
		
		
		
		
		
		 lblPolski = new JLabel("J\u0119zyk polski");
		lblPolski.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPolski.setBounds(10, 40, 113, 39);
		desktopPane.add(lblPolski);
		
		 lblHistoria = new JLabel("Historia");
		lblHistoria.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHistoria.setBounds(10, 70, 113, 39);
		desktopPane.add(lblHistoria);
		
		 lblFizyka = new JLabel("Fizyka");
		lblFizyka.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFizyka.setBounds(10, 100, 113, 39);
		desktopPane.add(lblFizyka);
		
		  lblChemia = new JLabel("Chemia");
		//lblChemia.setForeground(Color.BLACK);
		lblChemia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblChemia.setBounds(10, 130, 113, 39);
		desktopPane.add(lblChemia);
		
		 lblBiologia = new JLabel("Biologia");
		lblBiologia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBiologia.setBounds(10, 160, 113, 39);
		desktopPane.add(lblBiologia);
		
		 lblAngielski = new JLabel("Angielski");
		lblAngielski.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAngielski.setBounds(10, 190, 113, 39);
		desktopPane.add(lblAngielski);
		
		 lblNiemiecki = new JLabel("Niemiecki");
		lblNiemiecki.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNiemiecki.setBounds(10, 220, 113, 39);
		desktopPane.add(lblNiemiecki);
		
		 lblGeografia = new JLabel("Geografia");
		lblGeografia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGeografia.setBounds(10, 250, 113, 39);
		desktopPane.add(lblGeografia);
		
		 lblInformatyka = new JLabel("Informatyka");
		lblInformatyka.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInformatyka.setBounds(10, 280, 113, 39);
		desktopPane.add(lblInformatyka);
		
		 lblWos = new JLabel("WoS");
		lblWos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWos.setBounds(10, 310, 113, 39);
		desktopPane.add(lblWos);
		
		
		 btn_Mat = new JButton("");
		btn_Mat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Matematyka";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Mat.setOpaque(false);
		btn_Mat.setFocusPainted(false);
		btn_Mat.setContentAreaFilled(false);
		btn_Mat.setBorderPainted(false);
		btn_Mat.setBounds(252, 10, 285, 39);
		desktopPane.add(btn_Mat);
		
		
		
		
		 btn_Pol = new JButton("");
		
		btn_Pol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Polski";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Pol.setOpaque(false);
		btn_Pol.setFocusPainted(false);
		btn_Pol.setContentAreaFilled(false);
		btn_Pol.setBorderPainted(false);
		btn_Pol.setBounds(252, 40, 285, 39);
		desktopPane.add(btn_Pol);
		
		 btn_His = new JButton("");
		btn_His.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Historia";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_His.setOpaque(false);
		btn_His.setFocusPainted(false);
		btn_His.setContentAreaFilled(false);
		btn_His.setBorderPainted(false);
		btn_His.setBounds(252, 70, 285, 39);
		desktopPane.add(btn_His);
		
		 btn_Fiz = new JButton("");
		btn_Fiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Fizyka";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Fiz.setOpaque(false);
		btn_Fiz.setFocusPainted(false);
		btn_Fiz.setContentAreaFilled(false);
		btn_Fiz.setBorderPainted(false);
		btn_Fiz.setBounds(252, 100, 285, 39);
		desktopPane.add(btn_Fiz);
		
		 btn_Che = new JButton("");
		btn_Che.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Chemia";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Che.setOpaque(false);
		btn_Che.setFocusPainted(false);
		btn_Che.setContentAreaFilled(false);
		btn_Che.setBorderPainted(false);
		btn_Che.setBounds(252, 130, 285, 39);
		desktopPane.add(btn_Che);
		
		 btn_Bio = new JButton("");
		btn_Bio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Biologia";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Bio.setOpaque(false);
		btn_Bio.setFocusPainted(false);
		btn_Bio.setContentAreaFilled(false);
		btn_Bio.setBorderPainted(false);
		btn_Bio.setBounds(252, 160, 285, 39);
		desktopPane.add(btn_Bio);
		
		 btn_Ang = new JButton("");
		btn_Ang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Angielski";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Ang.setOpaque(false);
		btn_Ang.setFocusPainted(false);
		btn_Ang.setContentAreaFilled(false);
		btn_Ang.setBorderPainted(false);
		btn_Ang.setBounds(252, 190, 285, 39);
		desktopPane.add(btn_Ang);
		
		 btn_Niem = new JButton("");
		btn_Niem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Niemiecki";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Niem.setOpaque(false);
		btn_Niem.setFocusPainted(false);
		btn_Niem.setContentAreaFilled(false);
		btn_Niem.setBorderPainted(false);
		btn_Niem.setBounds(252, 220, 285, 39);
		desktopPane.add(btn_Niem);
		
		 btn_Geo = new JButton("");
		btn_Geo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Geografia";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Geo.setOpaque(false);
		btn_Geo.setFocusPainted(false);
		btn_Geo.setContentAreaFilled(false);
		btn_Geo.setBorderPainted(false);
		btn_Geo.setBounds(252, 250, 285, 39);
		desktopPane.add(btn_Geo);
		
		 btn_Inf = new JButton("");
		btn_Inf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "Informatyka";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Inf.setOpaque(false);
		btn_Inf.setFocusPainted(false);
		btn_Inf.setContentAreaFilled(false);
		btn_Inf.setBorderPainted(false);
		btn_Inf.setBounds(252, 280, 285, 39);
		desktopPane.add(btn_Inf);
		
		btn_Wos = new JButton("");
		btn_Wos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				przedmiot = "WoS";
				SzczegolyOcen.main(null);
				closelButtonActionPerformed(e);
			}
		});
		btn_Wos.setOpaque(false);
		btn_Wos.setFocusPainted(false);
		btn_Wos.setContentAreaFilled(false);
		btn_Wos.setBorderPainted(false);
		btn_Wos.setBounds(252, 310, 285, 39);
		desktopPane.add(btn_Wos);
		
		
		
		
		
		
	}
	
	
	/**metoda odpowiedzialna za nadanie priorytetów odpowiednim przedmiotom przez uzytkownika */
	public static void ustawPriorytet( ) {
		
			try{
				char b;
				FileInputStream fis  = new FileInputStream("Prior.txt");
					
					
				 while (fis.available() > 0) {
		             b = (char) fis.read();
		             String a = Character.toString(b);
		            // System.out.print(a);
		           
		             			
					
					//System.out.println("a to: " + a);
					
					if (a.equals("0")) {
						
						lblMatematyka.setForeground(Color.RED);
						//System.out.println("jestem");
						}
						if (a.equals("1")) {
							lblPolski.setForeground(Color.RED);
						}
						if (a.equals("2")) {
							lblHistoria.setForeground(Color.RED);
						}
						if (a.equals("3")) {
							lblFizyka.setForeground(Color.RED);
						}
						if (a.equals("4")) {
							lblChemia.setForeground(Color.RED);
							
						}
						if (a.equals("5")) {
							lblBiologia.setForeground(Color.RED);
						}
						
						if (a.equals("6")) {
							lblAngielski.setForeground(Color.RED);
						}
						
						if (a.equals("7")) {
							lblNiemiecki.setForeground(Color.RED);
						}
						
						if (a.equals("8")) {
							lblGeografia.setForeground(Color.RED);
						}
						
						if (a.equals("9")) {
							lblInformatyka.setForeground(Color.RED);
						}
						
						if (a.equals("a")) {
							lblWos.setForeground(Color.RED);
						}
						
				 }	
				
			}catch (Exception brakPliku){}
			
		
				
	}
	
	
	
	

	/*Metoda odpowiedzialna za wyswietlanie ocen z pliku do odpowiednich pol textowych */
	public void wyswietlOceny() throws IOException {
		
		String przedmiot = null;
		String nazwaPrzedmiotu = null;
		int i;
		
		for ( i=0;i<11;i++) {
			try{
			
			if (i==0) {
				
			  
			  przedmiot = "Matematyka";
			 lblPrzedmiot = btn_Mat;
			 
			}
			
			if (i==1) {
				
			
				przedmiot = "Polski";
				lblPrzedmiot = btn_Pol;
			}
			if (i==2) {
				przedmiot = "Historia";
				lblPrzedmiot = btn_His;
			}
			if (i==3) {
				przedmiot = "Fizyka";
				lblPrzedmiot = btn_Fiz;
			}
			if (i==4) {
				przedmiot = "Chemia";
				lblPrzedmiot = btn_Che;
			}
			if (i==5) {
				przedmiot = "Biologia";
				lblPrzedmiot = btn_Bio;
			}
			
			if (i==6) {
				przedmiot = "Angielski";
				lblPrzedmiot = btn_Ang;
			}
			
			if (i==7) {
				przedmiot = "Niemiecki";
				lblPrzedmiot = btn_Niem;
			}
			
			if (i==8) {
				przedmiot = "Geografia";
				lblPrzedmiot = btn_Geo;
			}
			
			if (i==9) {
				przedmiot = "Informatyka";
				lblPrzedmiot = btn_Inf;
			}
			
			if (i==10) {
				przedmiot = "WoS";
				lblPrzedmiot = btn_Wos;
			}
			
			
			FileInputStream fis = new FileInputStream(przedmiot+"Opis.txt");
	          char znak;
	          String pamiecOcen="";
	          String znakString = "";
	         
	          while (fis.available() > 0) {
	        	  
	        	      znak = (char) fis.read();
	        	      znakString = Character.toString(znak);
	                 //System.out.println(znakString);
	                 if (znakString.equals ("1") || znakString.equals("2") ||znakString.equals("3") ||
	                		 znakString.equals("4") || znakString.equals("5") || znakString.equals("6")) { 
	                	 		pamiecOcen =  pamiecOcen +" "+ znakString;
	                	 		lblPrzedmiot.setText(pamiecOcen);
	               
	                 }
	          }
	         fis.close();
			}catch(Exception brakPliku){
				brakPliku.printStackTrace();
				
			}	
		}
	
}

	
	void ResetujDane(JDesktopPane a) {
		JDesktopPane desktopPane = a;
		JButton btnResetujDane = new JButton("Resetuj Dane");
		btnResetujDane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closelButtonActionPerformed(e);
				ResetujDane.main(null);
			}
			
		});
		btnResetujDane.setBounds(432, 520, 132, 39);
		desktopPane.add(btnResetujDane);
		
	}
	
	/*Przycisk Dodaj Ocene wywo³uje nowe okienko */
	void DodajOcene(JDesktopPane a) {
		
			JDesktopPane desktopPane = a;
			final JButton btnDodajOcene = new JButton("Dodaj ocen\u0119");
			btnDodajOcene.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent akcja) {
			if(akcja.getSource() == btnDodajOcene) {
					closelButtonActionPerformed(akcja);
					
					DodajOcene.main(null);
					
				
				
			}
		}
	});

			
	btnDodajOcene.setBounds(10, 399, 132, 39);
	
	desktopPane.add(btnDodajOcene);
	
	JButton btnPrio = new JButton("Ustaw priorytet");
	btnPrio.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//lblChemia.setForeground(Color.RED);
			//UstawPriorytet ustawPriorytet = new UstawPriorytet();
			closelButtonActionPerformed(e);
			UstawPriorytet.main(null);
		}
	});
	btnPrio.setBounds(10, 449, 132, 39);
	desktopPane.add(btnPrio);
	
			
}
	
	


}




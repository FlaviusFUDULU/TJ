package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visual.angajat.ActualizareAngajat;
import visual.angajat.AdaugareAngajat;
import visual.angajat.AfisareDinFirma;
import visual.angajat.AfisareDupaCurs;
import visual.angajat.AfisareDupaVecime;
import visual.angajat.CautareAngajat;
import visual.angajat.StergereAngajat;
import visual.curs.AdaugareCurs;
import visual.curs.CautareCurs;
import visual.curs.EditareCurs;
import visual.curs.StergereCurs;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JList;
import java.awt.List;

public class MainApp extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
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
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 408);
		getContentPane().setLayout(null);
		
		JButton btnAdaugare = new JButton("Adaugare");
		btnAdaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugareAngajat frame = new AdaugareAngajat();
				frame.setVisible(true);
			}
		});
		btnAdaugare.setBounds(114, 54, 97, 25);
		getContentPane().add(btnAdaugare);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CautareAngajat frameCautare = new CautareAngajat();
				frameCautare.setVisible(true);
			}
		});
		btnCautare.setBounds(114, 92, 97, 25);
		getContentPane().add(btnCautare);
		
		JButton btnStergere = new JButton("Stergere");
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StergereAngajat frameStergere = new StergereAngajat();
				frameStergere.setVisible(true);
			}
		});
		btnStergere.setBounds(114, 132, 97, 25);
		getContentPane().add(btnStergere);
		
		JButton btnActualizare = new JButton("Actualizare");
		btnActualizare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizareAngajat frameActualizare = new ActualizareAngajat();
				frameActualizare.setVisible(true);
			}
		});
		btnActualizare.setBounds(114, 170, 97, 25);
		getContentPane().add(btnActualizare);
		
		JButton btnAfisareTotiAngajatii = new JButton("Afisare toti angajatii din firma");
		btnAfisareTotiAngajatii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfisareDinFirma frameDinFirma = new AfisareDinFirma();
				frameDinFirma.setVisible(true);
			}
		});
		btnAfisareTotiAngajatii.setBounds(57, 208, 231, 25);
		getContentPane().add(btnAfisareTotiAngajatii);
		
		JButton btnAfisareTotiAngajatii_1 = new JButton("Afisare toti angajatii dupa vechime");
		btnAfisareTotiAngajatii_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfisareDupaVecime frameDupaVechime = new AfisareDupaVecime();
				frameDupaVechime.setVisible(true);
			}
		});
		btnAfisareTotiAngajatii_1.setBounds(57, 246, 231, 25);
		getContentPane().add(btnAfisareTotiAngajatii_1);
		
		JButton btnAfisareTotiAngajatii_2 = new JButton("Afisare toti angajatii cu un anumit curs");
		btnAfisareTotiAngajatii_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfisareDupaCurs frameDupaCurs = new AfisareDupaCurs();
				frameDupaCurs.setVisible(true);
			}
		});
		btnAfisareTotiAngajatii_2.setBounds(50, 284, 253, 25);
		getContentPane().add(btnAfisareTotiAngajatii_2);
		
		Label lblAngajati = new Label("Angajati");
		
		lblAngajati.setBounds(114, 0, 104, 47);
		getContentPane().add(lblAngajati);
		lblAngajati.setFont (lblAngajati.getFont().deriveFont(24.0f));
		
		JButton btnAdaugare_1 = new JButton("Adaugare");
		btnAdaugare_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugareCurs frameAdCurs = new AdaugareCurs();
				frameAdCurs.setVisible(true);
			}
		});
		btnAdaugare_1.setBounds(422, 54, 97, 25);
		getContentPane().add(btnAdaugare_1);
		
		JButton btnCautare_1 = new JButton("Cautare");
		btnCautare_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CautareCurs frameCursCautare = new CautareCurs();
				frameCursCautare.setVisible(true);
			}
		});
		btnCautare_1.setBounds(422, 92, 97, 25);
		getContentPane().add(btnCautare_1);
		
		JButton btnStergere_1 = new JButton("Stergere");
		btnStergere_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StergereCurs frameCursStergere = new StergereCurs();
				frameCursStergere.setVisible(true);
			}
		});
		btnStergere_1.setBounds(422, 132, 97, 25);
		getContentPane().add(btnStergere_1);
		
		JButton btnActualizare_1 = new JButton("Actualizare");
		btnActualizare_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditareCurs frameCursEditare = new EditareCurs();
				frameCursEditare.setVisible(true);
			}
		});
		btnActualizare_1.setBounds(422, 170, 97, 25);
		getContentPane().add(btnActualizare_1);
		
		Label label = new Label("Cursuri");
		label.setBounds(427, 0, 104, 47);
		getContentPane().add(label);
		label.setFont(label.getFont().deriveFont(24f));
	}
}

package visual.angajat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backend.Angajati;
import backend.OperatiiBD;

public class StergereAngajat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StergereAngajat frame = new StergereAngajat();
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
	public StergereAngajat() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeDeCautat = new JLabel("Nume de cautat:");
		lblNumeDeCautat.setBounds(12, 25, 102, 16);
		contentPane.add(lblNumeDeCautat);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(115, 25, 127, 22);
		contentPane.add(textPane);

		JLabel lblNume = new JLabel("Nume:");
		lblNume.setBounds(12, 92, 230, 16);
		contentPane.add(lblNume);
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setBounds(12, 124, 230, 16);
		contentPane.add(lblFirma);
		
		JLabel lblDataAngajarii = new JLabel("Data Angajarii");
		lblDataAngajarii.setBounds(12, 182, 222, 16);
		contentPane.add(lblDataAngajarii);
		
		JLabel lblFunctia = new JLabel("Functia");
		lblFunctia.setBounds(12, 153, 230, 16);
		contentPane.add(lblFunctia);

		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Angajati angajat2 = db.cautareAngajat(textPane.getText());
				db.stergereAngajat(angajat2.getNume());
			}
		});
		btnSterge.setBounds(12, 211, 230, 25);
		contentPane.add(btnSterge);
		btnSterge.setVisible(false);
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Angajati angajat = db.cautareAngajat(textPane.getText());
				lblNume.setText("Nume: " + angajat.getNume());
				lblFirma.setText("Firma: " + angajat.getFirma());
				lblFunctia.setText("Functia: " + angajat.getFunctie());
				lblDataAngajarii.setText("Data angajarii: " + angajat.getData_angajarii().toString());
				btnSterge.setVisible(true);
			}
		});
		btnCauta.setBounds(12, 54, 230, 25);
		contentPane.add(btnCauta);
		
		
	}

}

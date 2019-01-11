package visual.angajat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backend.Angajati;
import backend.OperatiiBD;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CautareAngajat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CautareAngajat frame = new CautareAngajat();
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
	public CautareAngajat() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 277);
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
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Angajati angajat = db.cautareAngajat(textPane.getText());
				lblNume.setText("Nume: " + angajat.getNume());
				lblFirma.setText("Firma: " + angajat.getFirma());
				lblFunctia.setText("Functia: " + angajat.getFunctie());
				lblDataAngajarii.setText("Data angajarii: " + angajat.getData_angajarii().toString());
			}
		});
		btnCauta.setBounds(12, 54, 230, 25);
		contentPane.add(btnCauta);
	}
}

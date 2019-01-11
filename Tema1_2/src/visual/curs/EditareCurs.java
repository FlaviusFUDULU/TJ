package visual.curs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backend.Angajati;
import backend.Curs;
import backend.OperatiiBD;

public class EditareCurs extends JFrame {
	private JTextField textFieldIdAng;
	private JTextField textFieldDenumire;
	private JTextField textFieldNrOre;
	private JTextField textFieldValoare;
	private JPanel contentPane;
	private JTextField textFieldAnul;
	private JTextField textFieldDenumireCurs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditareCurs frame = new EditareCurs();
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
	public EditareCurs() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 439);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Angajat");
		lblNewLabel.setBounds(24, 132, 79, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFirma = new JLabel("Denumire:");
		lblFirma.setBounds(24, 157, 79, 16);
		getContentPane().add(lblFirma);
		
		JLabel lblFunctia = new JLabel("Numar Ore:");
		lblFunctia.setBounds(24, 186, 79, 16);
		getContentPane().add(lblFunctia);
		
		JLabel lblDataAngajarii = new JLabel("Valoare:");
		lblDataAngajarii.setBounds(34, 215, 69, 16);
		getContentPane().add(lblDataAngajarii);
		
		textFieldIdAng = new JTextField();
		textFieldIdAng.setBounds(104, 126, 116, 22);
		getContentPane().add(textFieldIdAng);
		textFieldIdAng.setColumns(10);
		
		textFieldDenumire = new JTextField();
		textFieldDenumire.setBounds(104, 154, 116, 22);
		getContentPane().add(textFieldDenumire);
		textFieldDenumire.setColumns(10);
		
		textFieldNrOre = new JTextField();
		textFieldNrOre.setBounds(104, 183, 116, 22);
		getContentPane().add(textFieldNrOre);
		textFieldNrOre.setColumns(10);
		
		textFieldValoare = new JTextField();
		textFieldValoare.setBounds(104, 209, 116, 22);
		getContentPane().add(textFieldValoare);
		textFieldValoare.setColumns(10);
		
		JLabel lblDiplomaDeAbsolvire = new JLabel("Diploma de absolvire");
		lblDiplomaDeAbsolvire.setBounds(12, 244, 137, 16);
		getContentPane().add(lblDiplomaDeAbsolvire);
		
		JRadioButton rdbtnDa = new JRadioButton("DA");
		rdbtnDa.setBounds(12, 269, 50, 25);
		getContentPane().add(rdbtnDa);
		
		JRadioButton rdbtnNu = new JRadioButton("NU");
		rdbtnNu.setBounds(66, 269, 50, 25);
		getContentPane().add(rdbtnNu);
		
		JLabel lblAnul = new JLabel("Anul");
		lblAnul.setBounds(24, 326, 56, 16);
		getContentPane().add(lblAnul);
		
		textFieldAnul = new JTextField();
		textFieldAnul.setBounds(104, 323, 116, 22);
		getContentPane().add(textFieldAnul);
		textFieldAnul.setColumns(10);
		
		JButton btnSalveaza = new JButton("Salveaza");
		btnSalveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_and = Integer.parseInt(textFieldIdAng.getText());
				String denumire = textFieldDenumire.getText();
				int nr_ore = Integer.parseInt(textFieldNrOre.getText());
				float valoare = Float.parseFloat(textFieldValoare.getText());
				String diploma = null;
				if(rdbtnNu.isSelected()) {
					diploma = "n";
				}
				else if (rdbtnDa.isSelected()){
					diploma = "d";
				}
				int an = Integer.parseInt(textFieldAnul.getText());
				db.actualizareCurs(id_and,denumire,nr_ore,valoare,diploma,an,textFieldDenumireCurs.getText());
			}
		});
		btnSalveaza.setBounds(12, 355, 208, 25);
		getContentPane().add(btnSalveaza);
		
		JLabel lblDenumireCurs = new JLabel("Denumire curs");
		lblDenumireCurs.setBounds(24, 37, 92, 16);
		getContentPane().add(lblDenumireCurs);
		
		textFieldDenumireCurs = new JTextField();
		textFieldDenumireCurs.setBounds(128, 34, 116, 22);
		getContentPane().add(textFieldDenumireCurs);
		textFieldDenumireCurs.setColumns(10);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curs curs = db.cautareCurs(textFieldDenumireCurs.getText());
				textFieldIdAng.setText(curs.getId_angajat());
				textFieldDenumire.setText(curs.getDenumire());
				textFieldNrOre.setText(Integer.toString(curs.getNumar_ore()));
				textFieldValoare.setText(Float.toString(curs.getValoare()));
				if (curs.getDiploma_de_absolvire().equalsIgnoreCase("d")) {
					rdbtnDa.setSelected(true);
					rdbtnNu.setSelected(false);
				}
				else if (curs.getDiploma_de_absolvire().equalsIgnoreCase("n")) {
					rdbtnNu.setSelected(true);
					rdbtnDa.setSelected(false);
				}
				textFieldAnul.setText(Integer.toString(curs.getAnul()));
				
				textFieldIdAng.setEnabled(true);
				textFieldDenumire.setEnabled(true);
				textFieldNrOre.setEnabled(true);
				textFieldValoare.setEnabled(true);
				rdbtnNu.setEnabled(true);
				rdbtnDa.setEnabled(true);
				textFieldAnul.setEnabled(true);
			}
		});
		btnCautare.setBounds(24, 73, 220, 25);
		getContentPane().add(btnCautare);
		
		textFieldIdAng.setEnabled(false);
		textFieldDenumire.setEnabled(false);
		textFieldNrOre.setEnabled(false);
		textFieldValoare.setEnabled(false);
		rdbtnNu.setEnabled(false);
		rdbtnDa.setEnabled(false);
		textFieldAnul.setEnabled(false);
	}
}

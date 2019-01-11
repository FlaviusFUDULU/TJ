package visual.curs;

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
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backend.OperatiiBD;
import javax.swing.JRadioButton;

public class AdaugareCurs extends JFrame {
	private JTextField textFieldIdAng;
	private JTextField textFieldDenumire;
	private JTextField textFieldNrOre;
	private JTextField textFieldValoare;
	private JPanel contentPane;
	private JTextField textFieldAnul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugareCurs frame = new AdaugareCurs();
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
	public AdaugareCurs() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 272, 347);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Angajat");
		lblNewLabel.setBounds(24, 13, 79, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFirma = new JLabel("Denumire:");
		lblFirma.setBounds(24, 42, 79, 16);
		getContentPane().add(lblFirma);
		
		JLabel lblFunctia = new JLabel("Numar Ore:");
		lblFunctia.setBounds(24, 74, 79, 16);
		getContentPane().add(lblFunctia);
		
		JLabel lblDataAngajarii = new JLabel("Valoare:");
		lblDataAngajarii.setBounds(34, 103, 69, 16);
		getContentPane().add(lblDataAngajarii);
		
		textFieldIdAng = new JTextField();
		textFieldIdAng.setBounds(104, 10, 116, 22);
		getContentPane().add(textFieldIdAng);
		textFieldIdAng.setColumns(10);
		
		textFieldDenumire = new JTextField();
		textFieldDenumire.setBounds(104, 42, 116, 22);
		getContentPane().add(textFieldDenumire);
		textFieldDenumire.setColumns(10);
		
		textFieldNrOre = new JTextField();
		textFieldNrOre.setBounds(104, 71, 116, 22);
		getContentPane().add(textFieldNrOre);
		textFieldNrOre.setColumns(10);
		
		textFieldValoare = new JTextField();
		textFieldValoare.setBounds(104, 103, 116, 22);
		getContentPane().add(textFieldValoare);
		textFieldValoare.setColumns(10);
		
		JLabel lblDiplomaDeAbsolvire = new JLabel("Diploma de absolvire");
		lblDiplomaDeAbsolvire.setBounds(12, 148, 137, 16);
		getContentPane().add(lblDiplomaDeAbsolvire);
		
		JRadioButton rdbtnDa = new JRadioButton("DA");
		rdbtnDa.setBounds(8, 173, 50, 25);
		getContentPane().add(rdbtnDa);
		
		JRadioButton rdbtnNu = new JRadioButton("NU");
		rdbtnNu.setBounds(64, 173, 50, 25);
		getContentPane().add(rdbtnNu);
		
		JLabel lblAnul = new JLabel("Anul");
		lblAnul.setBounds(24, 210, 56, 16);
		getContentPane().add(lblAnul);
		
		textFieldAnul = new JTextField();
		textFieldAnul.setBounds(104, 207, 116, 22);
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
				db.insertCurs(id_and,denumire,nr_ore,diploma,an,valoare);
			}
		});
		btnSalveaza.setBounds(12, 255, 208, 25);
		getContentPane().add(btnSalveaza);
	}
}

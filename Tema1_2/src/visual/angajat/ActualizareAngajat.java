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

public class ActualizareAngajat extends JFrame {
	private JTextField textFieldNume;
	private JTextField textFieldFirma;
	private JTextField textFieldFuctia;
	private JTextField textFieldData;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizareAngajat frame = new ActualizareAngajat();
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
	public ActualizareAngajat() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 266, 359);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume: ");
		lblNewLabel.setBounds(48, 134, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFirma = new JLabel("Firma: ");
		lblFirma.setBounds(48, 163, 56, 16);
		getContentPane().add(lblFirma);
		
		JLabel lblFunctia = new JLabel("Functia:");
		lblFunctia.setBounds(48, 195, 56, 16);
		getContentPane().add(lblFunctia);
		
		JLabel lblDataAngajarii = new JLabel("Data Angajarii");
		lblDataAngajarii.setBounds(12, 221, 91, 16);
		getContentPane().add(lblDataAngajarii);
		
		textFieldNume = new JTextField();
		textFieldNume.setBounds(105, 131, 116, 22);
		getContentPane().add(textFieldNume);
		textFieldNume.setColumns(10);
		
		textFieldFirma = new JTextField();
		textFieldFirma.setBounds(105, 163, 116, 22);
		getContentPane().add(textFieldFirma);
		textFieldFirma.setColumns(10);
		
		textFieldFuctia = new JTextField();
		textFieldFuctia.setBounds(105, 192, 116, 22);
		getContentPane().add(textFieldFuctia);
		textFieldFuctia.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(104, 221, 116, 22);
		getContentPane().add(textFieldData);
		textFieldData.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(105, 10, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSalveaza = new JButton("Salveaza");
		btnSalveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nume = textFieldNume.getText();
				String firma = textFieldFirma.getText();
				String functia = textFieldFuctia.getText();
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				Date data = null;
				try {
					data =  (Date) sd.parse(textFieldData.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				db.actualizareAngajat(nume,firma,functia,data,textField.getText());
			}
		});
		btnSalveaza.setBounds(12, 256, 208, 25);
		getContentPane().add(btnSalveaza);
		
		JLabel lblNumeDeCautat = new JLabel("Nume de cautat:");
		lblNumeDeCautat.setBounds(12, 13, 95, 16);
		getContentPane().add(lblNumeDeCautat);
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Angajati angajat = db.cautareAngajat(textField.getText());
				textFieldNume.setText(angajat.getNume());
				textFieldFirma.setText(angajat.getFirma());
				textFieldFuctia.setText(angajat.getFunctie());
				textFieldData.setText(angajat.getData_angajarii().toString());
				
				textFieldNume.setEnabled(true);
				textFieldFirma.setEnabled(true);
				textFieldFuctia.setEnabled(true);
				textFieldData.setEnabled(true);
			}
		});
		btnCauta.setBounds(12, 50, 209, 25);
		getContentPane().add(btnCauta);
		
		textFieldNume.setEnabled(false);
		textFieldFirma.setEnabled(false);
		textFieldFuctia.setEnabled(false);
		textFieldData.setEnabled(false);
	}
}

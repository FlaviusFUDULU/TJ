package visual.angajat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backend.OperatiiBD;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;


public class AdaugareAngajat extends JFrame {
	private JTextField textFieldNume;
	private JTextField textFieldFirma;
	private JTextField textFieldFuctia;
	private JTextField textFieldData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugareAngajat frame = new AdaugareAngajat();
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
	public AdaugareAngajat() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 272, 251);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume: ");
		lblNewLabel.setBounds(47, 13, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFirma = new JLabel("Firma: ");
		lblFirma.setBounds(47, 42, 56, 16);
		getContentPane().add(lblFirma);
		
		JLabel lblFunctia = new JLabel("Functia:");
		lblFunctia.setBounds(47, 74, 56, 16);
		getContentPane().add(lblFunctia);
		
		JLabel lblDataAngajarii = new JLabel("Data Angajarii");
		lblDataAngajarii.setBounds(12, 103, 91, 16);
		getContentPane().add(lblDataAngajarii);
		
		textFieldNume = new JTextField();
		textFieldNume.setBounds(104, 10, 116, 22);
		getContentPane().add(textFieldNume);
		textFieldNume.setColumns(10);
		
		textFieldFirma = new JTextField();
		textFieldFirma.setBounds(104, 42, 116, 22);
		getContentPane().add(textFieldFirma);
		textFieldFirma.setColumns(10);
		
		textFieldFuctia = new JTextField();
		textFieldFuctia.setBounds(104, 71, 116, 22);
		getContentPane().add(textFieldFuctia);
		textFieldFuctia.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(104, 103, 116, 22);
		getContentPane().add(textFieldData);
		textFieldData.setColumns(10);
		
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
				db.insertAngajat(nume,firma,functia,data);
			}
		});
		btnSalveaza.setBounds(12, 149, 208, 25);
		getContentPane().add(btnSalveaza);
	}
}

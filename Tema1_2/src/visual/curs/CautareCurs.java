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

import backend.Curs;
import backend.OperatiiBD;

public class CautareCurs extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldDenumireCurs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CautareCurs frame = new CautareCurs();
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
	public CautareCurs() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 338);
		getContentPane().setLayout(null);
		
		JLabel lblIdAng = new JLabel("ID Angajat: ");
		lblIdAng.setBounds(24, 132, 242, 16);
		getContentPane().add(lblIdAng);
		
		JLabel lblDenumire = new JLabel("Denumire: ");
		lblDenumire.setBounds(24, 157, 242, 16);
		getContentPane().add(lblDenumire);
		
		JLabel lblNrOre = new JLabel("Numar Ore: ");
		lblNrOre.setBounds(24, 186, 242, 16);
		getContentPane().add(lblNrOre);
		
		JLabel lblValoare = new JLabel("Valoare: ");
		lblValoare.setBounds(24, 215, 242, 16);
		getContentPane().add(lblValoare);
		
		JLabel lblDiplomaDeAbsolvire = new JLabel("Diploma de absolvire: ");
		lblDiplomaDeAbsolvire.setBounds(24, 244, 242, 16);
		getContentPane().add(lblDiplomaDeAbsolvire);
		
		JLabel lblAnul = new JLabel("Anul: ");
		lblAnul.setBounds(24, 266, 242, 16);
		getContentPane().add(lblAnul);
		
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
				lblIdAng.setText(lblIdAng.getText() + curs.getId_angajat());
				lblDenumire.setText(lblDenumire.getText() + curs.getDenumire());
				lblNrOre.setText(lblNrOre.getText() + Integer.toString(curs.getNumar_ore()));
				lblValoare.setText(lblValoare.getText() + Float.toString(curs.getValoare()));
				if (curs.getDiploma_de_absolvire().equalsIgnoreCase("d")) {
					lblDiplomaDeAbsolvire.setText(lblDiplomaDeAbsolvire.getText() + "DA");
				}
				else if (curs.getDiploma_de_absolvire().equalsIgnoreCase("n")) {
					lblDiplomaDeAbsolvire.setText(lblDiplomaDeAbsolvire.getText() + "NU");
				}
				lblAnul.setText(lblAnul.getText() + Integer.toString(curs.getAnul()));
			}
		});
		btnCautare.setBounds(24, 73, 220, 25);
		getContentPane().add(btnCautare);
	}

}

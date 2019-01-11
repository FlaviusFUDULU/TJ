package visual.angajat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backend.Angajati;
import backend.OperatiiBD;

public class AfisareDupaVecime extends JFrame {
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfisareDupaVecime frame = new AfisareDupaVecime();
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
	public AfisareDupaVecime() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		DefaultListModel model = new DefaultListModel();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList(model);
		list.setBounds(12, 50, 776, 190);
		contentPane.add(list);
		
		JLabel lblFirma = new JLabel("Vechime:");
		lblFirma.setBounds(12, 13, 56, 16);
		contentPane.add(lblFirma);
		
		textField = new JTextField();
		textField.setBounds(80, 10, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCautaAngajati = new JButton("Cauta Angajati");
		btnCautaAngajati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Angajati> listaAng = db.afisareVechimeMaiMareDe(Integer.parseInt(textField.getText()));
				model.removeAllElements();
				int i =0;
				for (Angajati ang : listaAng) {
					model.add(i, ang.toString());
					i++;
				}
			}
		});
		btnCautaAngajati.setBounds(222, 9, 128, 25);
		contentPane.add(btnCautaAngajati);
	}

}

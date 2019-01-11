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

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AfisareDinFirma extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfisareDinFirma frame = new AfisareDinFirma();
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
	public AfisareDinFirma() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD) context.getBean("operatiiJDBC");
		
		DefaultListModel model = new DefaultListModel();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 816, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList(model);
		list.setBounds(12, 50, 774, 190);
		contentPane.add(list);
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setBounds(12, 13, 56, 16);
		contentPane.add(lblFirma);
		
		textField = new JTextField();
		textField.setBounds(80, 10, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCautaAngajati = new JButton("Cauta Angajati");
		btnCautaAngajati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				List<Angajati> listaAng = db.afisareAndDinFirma(textField.getText());
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

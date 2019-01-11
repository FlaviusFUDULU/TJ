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

public class AfisareDupaCurs extends JFrame {
	private JTextField textField;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfisareDupaCurs frame = new AfisareDupaCurs();
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
	public AfisareDupaCurs() {
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
		
		JLabel lblFirma = new JLabel("Curs:");
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
				List<Angajati> listaAng = db.afisareDupaCurs(textField.getText());
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

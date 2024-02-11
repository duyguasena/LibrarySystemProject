package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddMenu extends JFrame implements ActionListener{
	
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5;
	private JTextField txt1, txt2, txt3, txt4, txt5;
	private JButton btn1;
	
	public AddMenu() {
		
		super("Ekleme Sayfası");
		setLayout(null);
		
		lbl1 = new JLabel("Eklemek Istediginiz Kitabın Adını Giriniz:");
		lbl2 = new JLabel("Eklemek Istediginiz Kitabın Yazarını Giriniz:");
		lbl3 = new JLabel("Eklemek Istediginiz Kitabın Kategorisini Giriniz:");
		lbl4 = new JLabel("Eklemek Istediginiz Kitabın Yılını Giriniz:");
		lbl5 = new JLabel("Eklemek Istediginiz Kitabın Ücretini Giriniz:");
		txt1 = new JTextField();
		txt2 = new JTextField();
		txt3 = new JTextField();
		txt4 = new JTextField();
		txt5 = new JTextField();
		btn1 = new JButton("Kaydet");
		
		lbl1.setBounds(50, 50, 270, 50);
		txt1.setBounds(350, 60, 130, 30);
		lbl2.setBounds(50, 90, 270, 50);
		txt2.setBounds(350, 100, 130, 30);
		lbl3.setBounds(50, 130, 270, 50);
		txt3.setBounds(350, 140, 130, 30);
		lbl4.setBounds(50, 170, 270, 50);
		txt4.setBounds(350, 180, 130, 30);
		lbl5.setBounds(50, 210, 270, 50);
		txt5.setBounds(350, 220, 130, 30);
		btn1.setBounds(390, 260, 90, 30);
		
		btn1.addActionListener(this);
		
		add(lbl1);
		add(txt1);
		add(lbl2);
		add(txt2);
		add(lbl3);
		add(txt3);
		add(lbl4);
		add(txt4);
		add(lbl5);
		add(txt5);
		add(btn1);
		
		setVisible(true);
		setSize(570,400);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1) {
			
			String title = txt1.getText();
			String author = txt2.getText();
			String category = txt3.getText();
			String year = txt4.getText();
			String price = txt5.getText();
			
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
			txt5.setText("");
			
			FileOperation fileIslemler = new FileOperation(title, author, category, year, price);
			
			try {
				fileIslemler.writerFile();
				JOptionPane.showMessageDialog(this, "Kitabınız Sisteme Kaydedilmiştir.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
	}
		
}



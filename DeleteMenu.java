package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteMenu extends JFrame implements ActionListener{
	
	private JLabel lbl1;
	private JTextField txt1;
	private JButton btn1;
	
	public DeleteMenu() {
		super("Silme Sayfası");
		setLayout(null);
		
		lbl1 = new JLabel("Silmek Istediginiz Kitabin Adini Giriniz:");
		txt1 = new JTextField();
		btn1 = new JButton("Sil");
		
		lbl1.setBounds(50, 50, 220, 50);
		txt1.setBounds(280, 60, 130, 30);
		btn1.setBounds(340, 110, 70, 30);
		
		btn1.addActionListener(this);
		
		add(lbl1);
		add(txt1);
		add(btn1);
		
		setVisible(true);
		setSize(460,270);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btn1) {
			
			String title = txt1.getText();
			
			FileOperation fileIslemler = new FileOperation(title, "", "", "", "");
			try {
				fileIslemler.deleteData();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}

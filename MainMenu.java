package Model;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements ActionListener{
	
	private JButton btn1,btn2,btn3,btn4,btn5,btn6;
	private JPanel pnl1;
	private JLabel lbl1;
	
	
	public MainMenu() {
		super("Kitap Otomasyon Sistemi");
		setLayout(null);
		
		pnl1=new JPanel();
		
		lbl1=new JLabel();
		Icon icon=new ImageIcon(getClass().getResource("Kütüphane.png"));
		lbl1.setIcon(icon);
		lbl1.setBounds(160, 30, 350, 300);
		
		btn1 = new JButton("Listele");
		btn2 = new JButton("Ara");
		btn3 = new JButton("Ekle");
		btn4 = new JButton("Sil");
		btn5 = new JButton("Güncelle");
		btn6 = new JButton("Çıkış");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		
		pnl1.add(btn1);
		pnl1.add(btn2);
		pnl1.add(btn3);
		pnl1.add(btn4);
		pnl1.add(btn5);
		pnl1.add(btn6);
		pnl1.setLayout(new GridLayout(2, 3, 15, 15));
		pnl1.setBounds(40, 350, 600, 300);
		
		add(lbl1);
		add(pnl1);
		
		setVisible(true);
		setSize(700,700);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new MainMenu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			new ListMenu();
		}
		if(e.getSource() == btn2) {
			new SearchMenu();
		}
		if(e.getSource() == btn3) {
			new AddMenu();
		}
		if(e.getSource() == btn4) {
			new DeleteMenu();
		}
		if(e.getSource() == btn5) {
			new UpdateMenu();
		}
		if(e.getSource() == btn6) {
			System.exit(0);
		}
		
		
	}

}

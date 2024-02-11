package Model;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListMenu extends JFrame implements ActionListener{

	private TextArea txt;
	private JButton btn1;
	
	public ListMenu() {
		super("Listeleme Sayfası");
		setLayout(new BorderLayout());
		
		txt = new TextArea();
		btn1 = new JButton("Listele");
		
		btn1.addActionListener(this);
		
		add(txt, BorderLayout.CENTER);
		add(btn1, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(600,600);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
if(e.getSource() == btn1) {
			
			FileOperation fileIslemler = new FileOperation("", "", "", "", "");
			StringBuilder builder = new StringBuilder();
			
			try {
				builder= fileIslemler.getData();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			txt.setText(builder.toString());
			
		}
		
	}
}

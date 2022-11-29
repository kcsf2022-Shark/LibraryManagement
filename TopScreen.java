import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopScreen extends JFrame implements ActionListener{
	private Container cntnr;
	public JButton lendBtn, returnBtn, serchBtn, stopBtn;
	private Shark s;
	TopScreen(){
		super("Top���");
		super.setUndecorated(true);
		super.setResizable(false);
		//FullScreen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
		//�z�u
		cntnr = getContentPane();
		cntnr.setLayout(new GridLayout(2, 2));
		lendBtn = new JButton("�{���؂��");
		lendBtn.setMargin(new Insets(10, 10, 10, 10));
		returnBtn = new JButton("�{��ԋp����");
		serchBtn = new JButton("�{����������");
		stopBtn = new JButton("�I������");
		cntnr.add(lendBtn);
		cntnr.add(returnBtn);
		cntnr.add(serchBtn);
		cntnr.add(stopBtn);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lendBtn.addActionListener(this);
		returnBtn.addActionListener(this);
		serchBtn.addActionListener(this);
		stopBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		s = new Shark();
		if(e.getSource() == lendBtn){
			s.visibleControl(3);
		}else if(e.getSource() == returnBtn){
			s.visibleControl(2);
		}else if(e.getSource() == serchBtn){
			s.visibleControl(5);
		}else if(e.getSource() == stopBtn){
			System.exit(0);
		}else{
			return;
		}
	}
}
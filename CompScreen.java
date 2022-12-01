import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompScreen extends JFrame implements ActionListener{
	private Container cntnr;
	private JButton button;
	private JLabel label;
	private JPanel bPanel, lPanel, p1, p2, p3;
	
	private Shark s;
	CompScreen(){
		super("�������");
		super.setUndecorated(true);
		super.setResizable(false);
		//FullScreen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
		
		cntnr = getContentPane();
		cntnr.setLayout(new GridLayout(5, 1));
		bPanel = new JPanel();
		lPanel = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		label = new JLabel("�������������܂����B");
		label.setFont(new Font("Ariai",Font.PLAIN, 70));
   	    button = new JButton("TOP��ʂ�");
		button.setFont(new Font("Ariai",Font.PLAIN, 40));
		button.addActionListener(this);
	    
		bPanel.add(button);
		lPanel.add(label);
	    cntnr.add(p1);
		cntnr.add(lPanel);
		cntnr.add(p2);
		cntnr.add(bPanel);
		cntnr.add(p3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
	 	s = new Shark();
		if(e.getSource() == button){
            s.visibleControl(1);
        }
	}
}
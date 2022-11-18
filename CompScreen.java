import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompScreen extends JFrame implements ActionListener{
	private Container cntnr;
	private JButton button;
	private JLabel label;
	
	private Shark s;
	private boolean pre = true;
	CompScreen(){
		super("äÆóπâÊñ ");
		super.setUndecorated(true);
		super.setResizable(false);
		compPre();
	}
	public void compPre(){
		if(pre){
			//FullScreen
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			gd.setFullScreenWindow(this);
			
			cntnr = getContentPane();
			cntnr.setLayout(new FlowLayout());
			label = new JLabel("èàóùÇ™äÆóπÇµÇ‹ÇµÇΩÅB");
			label.setFont(new Font("Ariai",Font.PLAIN, 28)); 
   		     button = new JButton("TOPâÊñ Ç÷");
			//button.addActionListener(new CompEvent());
	        cntnr.add(label);
	        cntnr.add(button);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			pre = false;
			this.setVisible(false);
		}
	}
	
	public void actionPerformed(ActionEvent e){
	 	s = new Shark();
		if(e.getSource() == button){
            s.visibleControl(1);
        }
	}
}
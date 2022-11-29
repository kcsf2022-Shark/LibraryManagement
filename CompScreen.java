import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompScreen extends JFrame implements ActionListener{
	private Container cntnr;
	private JButton button;
	private JLabel label;
	
	private Shark s;
	CompScreen(){
		super("完了画面");
		super.setUndecorated(true);
		super.setResizable(false);
		//FullScreen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
		
		cntnr = getContentPane();
		cntnr.setLayout(new FlowLayout());
		label = new JLabel("処理が完了しました。");
		label.setFont(new Font("Ariai",Font.PLAIN, 28)); 
   	    button = new JButton("TOP画面へ");
		button.addActionListener(this);
	    cntnr.add(label);
	    cntnr.add(button);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
	 	s = new Shark();
		if(e.getSource() == button){
            s.visibleControl(1);
        }
	}
}
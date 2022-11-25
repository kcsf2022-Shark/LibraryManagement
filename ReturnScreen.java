import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ReturnScreen extends JFrame{
	private Container cntnr;
	private JButton topBtn, returnBtn, lendBtn, userConfirm, bookConfirm, submit;
	private JTextField userText, bookText;
	private JList lendNow, returnSche;
	private JLabel modeLbl, userLbl, bookLbl;
	private JPanel p1, p2, p3, p4, p5, p6, btnPanel, panelP;
	
	private Shark s;
	private DBManager db;
	private boolean pre = true;
	
	ReturnScreen(){
		super("ï‘ãpâÊñ ");
		super.setUndecorated(true);
		super.setResizable(false);
		
		String[] s1 = {"                           ","","","","","","","","","",""};
			//FullScreen
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			gd.setFullScreenWindow(this);
			//Container
			cntnr = getContentPane();
			cntnr.setLayout(new GridLayout(2, 1));
			//Panel
			p1 = new JPanel();
			p2 = new JPanel();
			p3 = new JPanel(new FlowLayout());
			p4 = new JPanel(new FlowLayout());
			p5 = new JPanel(new BorderLayout());
			p6 = new JPanel(new BorderLayout());
			btnPanel = new JPanel(new GridLayout(1, 2));
			panelP = new JPanel(new GridLayout(3, 1));
			//Button
			topBtn = new JButton("Top");
			lendBtn = new JButton("éÿÇËÇÈ");
			returnBtn = new JButton("ï‘Ç∑");
			userConfirm = new JButton("ämíË");
			bookConfirm = new JButton("ämíË");
			submit = new JButton("ï‘ãp");
			
			returnBtn.setEnabled(false);
			//TextField
			userText = new JTextField(5);
			bookText = new JTextField(5);
			//List
			lendNow = new JList<String>(s1);
			returnSche = new JList<String>(s1);
			//Label
			modeLbl = new JLabel("ñ{Çï‘ãpÇ∑ÇÈ");
			userLbl = new JLabel("ÉÜÅ[ÉU:");
			bookLbl = new JLabel("ñ{:");
			
			p1.add(topBtn);
			p1.add(modeLbl);
			btnPanel.add(lendBtn);
			btnPanel.add(returnBtn);
			p1.add(btnPanel);
			p5.add("West", userLbl);
			p5.add("Center", userText);
			p5.add("East", userConfirm);
			p6.add("West", bookLbl);
			p6.add("Center", bookText);
			p6.add("East", bookConfirm);
			p2.add(p5);
			p2.add(p6);
			p3.add(lendNow);
			p3.add(returnSche);
			p4.add(submit);
			panelP.add(p1);
			panelP.add(p2);
			panelP.add(p4);
			cntnr.add(panelP);
			cntnr.add(p3);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e){
	 	s = new Shark();
		if(e.getSource()== topBtn){
			s.visibleControl(this, 1);
		}
		if(e.getSource()== lendBtn){
		 	s.visibleControl(this, 3);
		}
		if(e.getSource()== userConfirm){
			DBManager db = new DBManager();
			if(returnSche == null){
		  		userText.setEnabled(false);
				userConfirm.setEnabled(false);
				bookText.setEnabled(true);
				bookConfirm.setEnabled(true);
			}
		}
		if(e.getSource()==bookConfirm){
	    DBManager db = new DBManager();
		   
	
		}
		if(e.getSource()==submit){
	    
	    
		}
	}
}
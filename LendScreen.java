import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LendScreen extends JFrame implements ActionListener{
	private Container cntnr;
	public JButton topBtn, returnBtn, lendBtn, userConfirm, bookConfirm, submit;
	public JTextField userText, bookText;
	private JTextField lendUser, lendBook, lendCategory;
	private JLabel modeLbl, userLbl, bookLbl, userName, bookName, bookCategory;
	private JPanel p1, p2, p3, p4, p5, p6, btnPanel, panelP;
	
	
	private Shark s;
	private DBManager db;
	private boolean bool;
	
	LendScreen(){
		super("貸出画面");
		super.setUndecorated(true);
		super.setResizable(false);
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
		lendBtn = new JButton("借りる");
		returnBtn = new JButton("返す");
		userConfirm = new JButton("確定");
		bookConfirm = new JButton("確定");
		submit = new JButton("貸出");
		
		lendBtn.setEnabled(false);	
		bookConfirm.setEnabled(false);
		submit.setEnabled(false);
		//TextField
		userText = new JTextField(5);
		bookText = new JTextField(5);
		bookText.setEnabled(false);
		lendUser = new JTextField(10);
		lendBook = new JTextField(10);
		lendCategory = new JTextField(10);
		
		//Label
		modeLbl = new JLabel("本を借りる");
		userLbl = new JLabel("ユーザ:");
		bookLbl = new JLabel("本:");
		userName = new JLabel("借りる人");
		bookName = new JLabel("本のタイトル");
		bookCategory = new JLabel("カテゴリー");
		
		
		topBtn.addActionListener(this);
		returnBtn.addActionListener(this);
		userConfirm.addActionListener(this);
		bookConfirm.addActionListener(this);
		submit.addActionListener(this);
		
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
		p3.add(userName);
		p3.add(lendUser);
		p3.add(bookName);
		p3.add(lendBook);
		p3.add(bookCategory);
		p3.add(lendCategory);
		p4.add(submit);
		panelP.add(p1);
		panelP.add(p2);
		panelP.add(p3);
		cntnr.add(panelP);
		cntnr.add(p4);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		s = new Shark();
		db = new DBManager();
		if(e.getSource() == topBtn){
			s.visibleControl(1);
		}
		if(e.getSource() == returnBtn){
			s.visibleControl(2);
		}
		if(e.getSource() == userConfirm){
			bool = db.serchUser(Integer.parseInt(userText.getText()));
			if(bool == true){
				userConfirm.setEnabled(false);
				bookConfirm.setEnabled(true);
				userText.setEnabled(false);
				bookText.setEnabled(true);
			}
		}
		if(e.getSource() == bookConfirm){
			bool = db.serchBook(Integer.parseInt(bookText.getText()));
			if(bool == true){
				bookConfirm.setEnabled(false);
				bookText.setEnabled(false);
				submit.setEnabled(true);
			}
		}
		if(e.getSource() == submit){
			db.lendBook(Integer.parseInt(userText.getText()), Integer.parseInt(bookText.getText()));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			s.visibleControl(4);
		}
	}
}
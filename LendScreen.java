import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LendScreen extends JFrame implements ActionListener{
	private Container cntnr;
	public JButton topBtn, returnBtn, lendBtn, userConfirm, bookConfirm, submit;
	public JTextField userText, bookText;
	private JTextField lendUser, lendBook, lendCategory;
	private JLabel modeLbl, userLbl, bookLbl, userName, bookName, bookCategory;
	private JPanel p1, p2, p3, p4, p5, p6, btnPanel, panelP, pName, pBook, pCate;

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
		p3 = new JPanel(new GridLayout(3, 1));
		p4 = new JPanel(new FlowLayout());
		p5 = new JPanel(new BorderLayout());
		p6 = new JPanel(new BorderLayout());
		btnPanel = new JPanel(new GridLayout(1, 2));
		panelP = new JPanel(new GridLayout(3, 1));
		pName = new JPanel(new FlowLayout());
		pBook = new JPanel(new FlowLayout());
		pCate = new JPanel(new FlowLayout());
		//Button
		topBtn = new JButton("Top");
		lendBtn = new JButton("借りる");
		returnBtn = new JButton("返す");
		userConfirm = new JButton("確定");
		bookConfirm = new JButton("確定");
		submit = new JButton("貸出");
		topBtn.setFont(new Font("Ariai",Font.PLAIN, 40));
		lendBtn.setFont(new Font("Ariai",Font.PLAIN, 40));
		returnBtn.setFont(new Font("Ariai",Font.PLAIN, 40));
		userConfirm.setFont(new Font("Ariai",Font.PLAIN, 40));
		bookConfirm.setFont(new Font("Ariai",Font.PLAIN, 40));
		submit.setFont(new Font("Ariai",Font.PLAIN, 55));
		
		lendBtn.setEnabled(false);	
		bookConfirm.setEnabled(false);
		submit.setEnabled(false);
		//TextField
		userText = new JTextField(5);
		bookText = new JTextField(5);
		bookText.setEnabled(false);
		lendUser = new JTextField(20);
		lendBook = new JTextField(20);
		lendCategory = new JTextField(20);
		
		lendUser.setEnabled(false);
		lendBook.setEnabled(false);
		lendCategory.setEnabled(false);
		
		userText.setFont(new Font("Ariai",Font.PLAIN, 40));
		bookText.setFont(new Font("Ariai",Font.PLAIN, 40));
		lendUser.setFont(new Font("Ariai",Font.PLAIN, 40));
		lendBook.setFont(new Font("Ariai",Font.PLAIN, 40));
		lendCategory.setFont(new Font("Ariai",Font.PLAIN, 40));
		
		//Label
		modeLbl = new JLabel("　　本を借りる　　");
		userLbl = new JLabel("ユーザ：");
		bookLbl = new JLabel("　　　　本：");
		userName = new JLabel("　　借りる人：");
		bookName = new JLabel("本のタイトル：");
		bookCategory = new JLabel("　カテゴリー：");
		modeLbl.setFont(new Font("Ariai",Font.PLAIN, 40));
		userLbl.setFont(new Font("Ariai",Font.PLAIN, 40));
		bookLbl.setFont(new Font("Ariai",Font.PLAIN, 40));
		userName.setFont(new Font("Ariai",Font.PLAIN, 40));
		bookName.setFont(new Font("Ariai",Font.PLAIN, 40));
		bookCategory.setFont(new Font("Ariai",Font.PLAIN, 40));
		
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
		pName.add(userName);
		pName.add(lendUser);
		pBook.add(bookName);
		pBook.add(lendBook);
		pCate.add(bookCategory);
		pCate.add(lendCategory);
		p3.add(pName);
		p3.add(pBook);
		p3.add(pCate);
		p4.add(submit);
		panelP.add(p1);
		panelP.add(p2);
		panelP.add(p3);
		cntnr.add(panelP);
		cntnr.add(p4);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		String u;
		s = new Shark();
		db = new DBManager();
		if(e.getSource() == topBtn){
			s.visibleControl(1);
		}
		if(e.getSource() == returnBtn){
			s.visibleControl(2);
		}
		if(e.getSource() == userConfirm){
			u = db.serchUser(Integer.parseInt(userText.getText()));
			lendUser.setText(u);
			if(u.contains(" ") == true){
				userConfirm.setEnabled(false);
				bookConfirm.setEnabled(true);
				userText.setEnabled(false);
				bookText.setEnabled(true);
			}
		}
		if(e.getSource() == bookConfirm){
			ArrayList<String> list = db.serchBook(Integer.parseInt(bookText.getText()));
			lendBook.setText(list.get(0));
			lendCategory.setText(list.get(1));
			list.add("a");
			if(list.get(0).equals("見つかりません") != true){
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
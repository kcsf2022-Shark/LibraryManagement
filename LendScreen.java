import javax.swing.*;
import java.awt.*;

public class LendScreen extends JFrame{
	private Container cntnr;
	public JButton topBtn, returnBtn, lendBtn, userConfirm, bookConfirm, submit;
	public JTextField userText, bookText;
	public JList lendSche, lendConf;
	private JLabel modeLbl, userLbl, bookLbl;
	private JPanel p1, p2, p3, p4, p5, p6, btnPanel, panelP;
	LendScreen(){
		super("貸出画面");
		super.setUndecorated(true);
		super.setResizable(false);
	}
	public void lendPre(LendScreen ls){
		
		String[] s1 = {"aaaaaaaaaaa","aaaaaaaaaaaaaa","aaaaaaaa","aa","a","aaaaaa","aaa"};
		
		//FullScreen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(ls);
		//Container
		cntnr = getContentPane();
		cntnr.setLayout(new GridLayout(2, 1));
		//Panel
		p1 = new JPanel(/*new GridLayout(1, 3)*/);
		p2 = new JPanel(/*new GridLayout(1, 2)*/);
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
		//TextField
		userText = new JTextField(5);
		bookText = new JTextField(5);
		bookText.setEnabled(false);
		//List
		lendSche = new JList<String>(s1);
		lendConf = new JList<String>(s1);
		//Label
		modeLbl = new JLabel("本を借りる");
		userLbl = new JLabel("ユーザ:");
		bookLbl = new JLabel("本:");
		
		
		topBtn.addActionListener(new LendEvent());
		returnBtn.addActionListener(new LendEvent());
		userConfirm.addActionListener(new LendEvent());
		bookConfirm.addActionListener(new LendEvent());
		submit.addActionListener(new LendEvent());
		
		/*
		lendSche.setVisibleRowCount(0);
		lendSche.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		*/
		
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
		p3.add(lendSche);
		p3.add(lendConf);
		p4.add(submit);
		panelP.add(p1);
		panelP.add(p2);
		panelP.add(p4);
		cntnr.add(panelP);
		cntnr.add(p3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopScreen extends JFrame implements ActionListener{
	private Container cntnr;
	public JButton lendBtn, returnBtn, serchBtn, stopBtn;
	private Shark s;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21;
	TopScreen(){
		super("Top画面");
		super.setUndecorated(true);
		super.setResizable(false);
		//FullScreen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
		//配置
		cntnr = getContentPane();
		cntnr.setLayout(new GridLayout(5, 5));
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p9 = new JPanel();
		p10 = new JPanel();
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		p15 = new JPanel();
		p16 = new JPanel();
		p17 = new JPanel();
		p18 = new JPanel();
		p19 = new JPanel();
		p20 = new JPanel();
		p21 = new JPanel();
		lendBtn = new JButton("本を借りる");
		returnBtn = new JButton("本を返却する");
		serchBtn = new JButton("本を検索する");
		stopBtn = new JButton("終了する");
		lendBtn.setFont(new Font("Ariai",Font.PLAIN, 40));
		returnBtn.setFont(new Font("Ariai",Font.PLAIN, 40));
		serchBtn.setFont(new Font("Ariai",Font.PLAIN, 40));
		stopBtn.setFont(new Font("Ariai",Font.PLAIN, 40));
		cntnr.add(p1);
		cntnr.add(p2);
		cntnr.add(p3);
		cntnr.add(p4);
		cntnr.add(p5);
		
		cntnr.add(p6);
		cntnr.add(lendBtn);
		cntnr.add(p7);
		cntnr.add(returnBtn);
		cntnr.add(p8);
		
		cntnr.add(p9);
		cntnr.add(p10);
		cntnr.add(p11);
		cntnr.add(p12);
		cntnr.add(p13);
		
		cntnr.add(p14);
		cntnr.add(serchBtn);
		cntnr.add(p15);
		cntnr.add(stopBtn);
		cntnr.add(p16);
		
		cntnr.add(p17);
		cntnr.add(p18);
		cntnr.add(p19);
		cntnr.add(p20);
		cntnr.add(p21);
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
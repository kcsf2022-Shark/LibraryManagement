import javax.swing.*;
import java.awt.*;

public class TopScreen extends JFrame{
	private Container cntnr;
	public JButton lendBtn, returnBtn, serchBtn, stopBtn;
	TopScreen(){
		super("Top画面");
		super.setUndecorated(true);
		super.setResizable(false);
	}
	public void topPre(TopScreen ts){
		//フルスクリーン
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(ts);
		//配置
		cntnr = getContentPane();
		cntnr.setLayout(new GridLayout(2, 2));
		lendBtn = new JButton("本を借りる");
		lendBtn.setMargin(new Insets(10, 10, 10, 10));
		returnBtn = new JButton("本を返却する");
		serchBtn = new JButton("本を検索する");
		stopBtn = new JButton("終了する");
		cntnr.add(lendBtn);
		cntnr.add(returnBtn);
		cntnr.add(serchBtn);
		cntnr.add(stopBtn);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lendBtn.addActionListener(new TopEvent());
		returnBtn.addActionListener(new TopEvent());
		serchBtn.addActionListener(new TopEvent());
		stopBtn.addActionListener(new TopEvent());
	}
}
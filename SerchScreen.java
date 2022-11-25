import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SerchScreen extends JFrame implements ActionListener{
	private Container cntnr;
	private JButton topBtn, serchBtn;
	private JLabel modeLbl, nameLbl, categoryLbl, stockLbl;
	private JTextField serchText;
	private JList nameList, categoryList, stockList;
	private JPanel p1, p2, p3, p4;
	
	private Shark s;
	
	SerchScreen(){
		super("検索画面");
		super.setUndecorated(true);
		super.setResizable(false);
		String[] s1 = {"                      ","","","","","","","",""};
		//FullScreen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
		//Container
		cntnr = getContentPane();
		cntnr.setLayout(new GridLayout(2, 1));
		//Panel
		p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new FlowLayout());
		p3 = new JPanel(new GridLayout(2, 3));
		p4 = new JPanel(new GridLayout(2, 1));
		//Button
		topBtn = new JButton("Top");
		serchBtn = new JButton("検索");
		//Label
		modeLbl = new JLabel("検索モード");
		nameLbl = new JLabel("タイトル");
		categoryLbl = new JLabel("カテゴリ");
		stockLbl = new JLabel("在庫");
		//TextField
		serchText = new JTextField(20);
		//List
		nameList = new JList<String>(s1);
		categoryList = new JList<String>(s1);
		stockList = new JList<String>(s1);
		
		topBtn.addActionListener(this);
		serchBtn.addActionListener(this);
		
		p1.add(topBtn);
		p1.add(modeLbl);
		p2.add(serchText);
		p2.add(serchBtn);
		p3.add(nameLbl);
		p3.add(categoryLbl);
		p3.add(stockLbl);
		p3.add(nameList);
		p3.add(categoryList);
		p3.add(stockList);
		p4.add(p1);
		p4.add(p2);
		cntnr.add(p4);
		cntnr.add(p3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e){
		s = new Shark();
        if(e.getSource() == topBtn){
			s.visibleControl(1);
		}else if(e.getSource() == serchBtn){
		 	DBManager db= new DBManager();
            List<String>  returnserchBookName = db.serchBookName(serchText.getText());
			nameList.setListData(returnserchBookName.toArray());
            List<String>  returnserchBookCategory = db.serchBookCategory(serchText.getText());
			categoryList.setListData(returnserchBookCategory.toArray());
            List<Integer>  returnserchBookStock = db.serchBookStock(serchText.getText());
			stockList.setListData(returnserchBookStock.toArray());
        }
    }
}
import java.awt.event.*;

public class LendEvent extends LendScreen implements ActionListener{
	private Shark s;
	private DBManager db;
	private boolean bool;
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
			}
		}
		if(e.getSource() == submit){
			db.lend(Integer.parseInt(userText.getText()), Integer.parseInt(bookText.getText()));
		}
	}
}
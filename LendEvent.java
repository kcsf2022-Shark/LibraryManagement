import java.awt.event.*;

public class LendEvent extends LendScreen implements ActionListener{
	private Shark s;
	public void actionPerformed(ActionEvent e){
		s = new Shark();
		if(e.getSource() == topBtn){
			s.visibleControl(1);
		}
		if(e.getSource() == returnBtn){
			s.visibleControl(2);
		}
		if(e.getSource() == userConfirm){
			
		}
		if(e.getSource() == bookConfirm){
			
		}
		if(e.getSource() == submit){
			
		}
	}
}
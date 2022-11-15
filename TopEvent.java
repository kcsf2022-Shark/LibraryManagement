import java.awt.event.*;

public class TopEvent extends TopScreen implements ActionListener{
	private Shark s;
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
import java.awt.event.*;

public class CompEvent extends CompScreen implements ActionListener{
	private Shark s;	
	public void actionPerformed(ActionEvent e){
	 	s = new Shark();
		if(e.getSource() == button){
            s.visibleControl(1);
        }
	}
}
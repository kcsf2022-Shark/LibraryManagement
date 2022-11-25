import javax.swing.JFrame;

public class Shark{
	
	private static TopScreen ts;
	private static ReturnScreen rs;
	private static LendScreen ls;
	private static CompScreen cs;
	private static SerchScreen ss;
	public static void main(String[] args){
		DBManager db = new DBManager();
		rs = new ReturnScreen();
		ls = new LendScreen();
		cs = new CompScreen();
		ss = new SerchScreen();
		ts = new TopScreen();
	}
	
	public static void visibleControl(JFrame f, int i){
		f.setVisible(false);
		if(i == 1){
			ts.setVisible(true);
		}else if(i == 2){
			rs.setVisible(true);
		}else if(i == 3){
			ls.setVisible(true);
		}else if(i == 4){
			cs.setVisible(true);
		}else if(i == 5){
			ss.setVisible(true);
		}else{
			return;
		}
	}
	
	public void createInstance(int i){
		if(i == 1){
			ts = new TopScreen();
		}else if(i == 2){
			rs = new ReturnScreen();
		}else if(i == 3){
			ls = new LendScreen();
		}else if(i == 4){
			cs = new CompScreen();
		}else if(i == 5){
			ss = new SerchScreen();
		}else{
			return;
		}
	}
}

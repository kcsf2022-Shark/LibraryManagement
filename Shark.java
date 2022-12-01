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
		rs.setVisible(false);
		ls = new LendScreen();
		ls.setVisible(false);
		cs = new CompScreen();
		cs.setVisible(false);
		ss = new SerchScreen();
		ss.setVisible(false);
		ts = new TopScreen();

	}
	
	public static void visibleControl(int i){
		rs.setVisible(false);
		ls.setVisible(false);
		cs.setVisible(false);
		ss.setVisible(false);
		ts.setVisible(false);
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
public class Shark{
	
	private static TopScreen ts;
	private static ReturnScreen rs;
	private static LendScreen ls;
	private static CompScreen cs;
	private static SerchScreen ss;
	public static void main(String[] args){
		DBManager db = new DBManager();
		ts = new TopScreen();
		rs = new ReturnScreen();
		ls = new LendScreen();
		cs = new CompScreen();
		ss = new SerchScreen();
		
		rs.returnPre(rs);
	}
	
	public void visibleControl(int i){
		ts.setVisible(false);
		rs.setVisible(false);
		ls.setVisible(false);
		cs.setVisible(false);
		ss.setVisible(false);
		if(i == 1){
			ts.topPre(ts);
		}else if(i == 2){
			rs.returnPre(rs);
		}else if(i == 3){
			ls.lendPre(ls);
		}else if(i == 4){
			cs.compPre(cs);
		}else if(i == 5){
			ss.serchPre(ss);
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

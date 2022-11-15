public class Shark extends Thread{
	
	private static TopScreen ts;
	private static ReturnScreen rs;
	private static LendScreen ls;
	private static CompScreen cs;
	private static SerchScreen ss;
	public static void main(String[] args){
		Shark s = new Shark();
		s.start();
		
		
		ts.setVisible(true);
		
	}
	
	public void run(){
		ts = new TopScreen();
		rs = new ReturnScreen();
		ls = new LendScreen();
		cs = new CompScreen();
		ss = new SerchScreen();
		
		ts.topPre(ts);
		rs.returnPre(rs);
		ls.lendPre(ls);
		cs.compPre(cs);
		ss.serchPre(ss);
	}
	
	public void visibleControl(int i){
		ts.setVisible(false);
		rs.setVisible(false);
		ls.setVisible(false);
		cs.setVisible(false);
		ss.setVisible(false);
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

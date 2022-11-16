import java.sql.*;
import java.util.Date;
import java.util.Calendar;

public class DBManager{
	private static final String URL = "jdbc:mySQL://localhost/shark";
	private static final String NAME = "root";
	private static final String PASS = "kcsf";
	private static Connection con;
	private static Statement stmt;
	private static ResultSet result;
	private Date nowDate, returnSche;
	private Calendar calendar;
	
	DBManager(){
		try{
			con = DriverManager.getConnection(URL,NAME,PASS);
			stmt = con.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public boolean serchUser(int user){
		try{
			result = stmt.executeQuery("SELECT user_id FROM  user WHERE user_id = " + user + ";");
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean serchBook(int book){
		try{
			result = stmt.executeQuery("SELECT book_id FROM book_manager WHERE book_id = " + book + ";");
			return true;
		}catch(SQLException e){
			//e.printStackTrace();
		}
		return false;
	}
	public void lend(int user, int book){
		String stock = "";
		nowDate = new Date();//現在時刻を取得
		calendar = Calendar.getInstance();
		calendar.setTime(nowDate);//カレンダーにnowDateの時刻を入れる
		calendar.add(Calendar.DAY_OF_MONTH, 7);//７日加算
		returnSche = calendar.getTime();//加算後の時刻を入れる
		try{
			//borrow_user表に図書貸出情報を追加する
			result = stmt.executeQuery("SELECT stock FROM book_manager WHERE book_id = " + book + ";");
			int i = result.getInt("stock");
			if(0 < i){
				stmt.executeUpdate("UPDATE book_manager SET stock = " + (i - 1) + ";");
				stmt.executeUpdate("INSERT INTO borrow_user VALUES(" +
									user + "," + book + "," + nowDate + "," + returnSche + ");");
			}else{
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
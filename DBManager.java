import java.sql.*;
import java.util.Date;
import java.util.Calendar;

public class DBManager{
	private static final String URL = "jdbc:mySQL://localhost/r3";
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
	public String serchUser(int user){
		try{
			result = stmt.executeQuery("SELECT user_name FROM  user WHERE user_id = " + user + ";");
			return result.getString("user_name");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "";
	}
	public String serchBook(int book){
		try{
			result = stmt.executeQuery("SELECT book_name FROM book_manager WHERE book_id = " + book + ";");
			return result.getString("book_name");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "";
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
			stmt.executeUpdate("INSERT INTO borrow_user VALUES(" +
								user + "," + book + "," + nowDate + "," + returnSche + ");");
			//
			result = stmt.executeQuery("SELECT 
			stmt.executeUpdate("UPDATE book_manager SET stock = 
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
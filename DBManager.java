import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

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
		//�R���X�g���N�^
		try{
			con = DriverManager.getConnection(URL,NAME,PASS);
			stmt = con.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public String serchUser(int user){
		//�ݏo��ʂ�userConfirm�������ɌĂяo�����
		try{
			result = stmt.executeQuery("SELECT user_name FROM  user WHERE user_id = " + user + ";");
			if(result.next()){
				String u = result.getString("user_name");
				if(u.equals("")){
					return "���[�U�[��������܂���B";
				}else{
					return u;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "���[�U�[��������܂���B";
	}
	
	public ArrayList<String> serchBook(int book){
		//�ݏo��ʂ�bookConfirm�������ɌĂяo�����
		ArrayList<String> list = new ArrayList<>();
		try{
			result = stmt.executeQuery("SELECT book_id, book_name, category FROM book_manager WHERE book_id = " + book + ";");
			if(result.next()){
				if(result.getString("book_id").equals("")){
					list.add("������܂���");
					list.add("������܂���");
				}else{
					list.add(result.getString("book_name"));
					list.add(result.getString("category"));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void lendBook(int user, int book){
		//�ݏo��ʂ�submit�������ɌĂяo�����
		int i = 0;
		
		try{
			//borrow_user�\�ɐ}���ݏo����ǉ�����
			result = stmt.executeQuery("SELECT stock FROM book_manager WHERE book_id = " + book + ";");
			if(result.next()){
				i = result.getInt("stock");
			}
			if(0 < i){
				stmt.executeUpdate("UPDATE book_manager SET stock = " + (i - 1) + " WHERE book_id = " + book + ";");
				stmt.executeUpdate("INSERT INTO borrow_user VALUES(" + user + "," + book + ");");
			}else{
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean userPossesion(int user, int book){
		//�ԋp��ʂ�bookConfirm�������ɌĂяo�����
		try{
			result = stmt.executeQuery("SELECT book_id FROM borrow_user WHERE user_id = " + user + " and book_id = " + book + ";");
			if(result.next()){
				if(result.getString("book_id").equals("")){
					return false;
				}else{
					return true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void returnBook(List<Integer> list){
		//�ԋp��ʂ�submit�������ɌĂяo�����
		int cnt = 0;
		try{
			for(int i : list){
				stmt.executeUpdate("DELETE FROM borrow_user WHERE book_id = " + i + ";");
			}
			for(int i : list){
				result = stmt.executeQuery("SELECT stock FROM book_manager WHERE book_id = " + i + ";");
				if(result.next()){
					cnt = result.getInt("stock") + 1;
				}
				stmt.executeUpdate("UPDATE book_manager SET stock = " + cnt + " WHERE book_id = " + i + ";");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<String> returnSche(int user){
		//�ԋp��ʂ�userConfirm�������ɌĂяo�����
		List<String> nameList = new ArrayList<String>();
		try{
			
			result = stmt.executeQuery("SELECT bu.user_id, bu.book_id, bm.book_name FROM borrow_user AS bu, book_manager AS bm WHERE bu.book_id = bm.book_id AND bu.user_id = " + user + ";");
			while(result.next()){
				nameList.add(result.getString("book_name"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return nameList;
	}
	
	public List<String> serchBookName(String name){
		//�����{�^����serchBtn�������ɌĂяo�����
		List<String> nameList = new ArrayList<>();
		try{
			result = stmt.executeQuery("SELECT book_name FROM book_manager WHERE book_name LIKE '%" + name + "%';");
			while(result.next()){
				nameList.add(result.getString("book_name"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return nameList;
	}
	
	public List<String> serchBookCategory(String name){
		//�����{�^����serchBtn�������ɌĂяo�����
		List<String> categoryList = new ArrayList<>();
		try{
			result = stmt.executeQuery("SELECT category FROM book_manager WHERE book_name LIKE '%" + name + "%';");
			while(result.next()){
				categoryList.add(result.getString("category"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return categoryList;
	}
	
	public List<Integer> serchBookStock(String name){
		//�����{�^����serchBtn�������ɌĂяo�����
		List<Integer> stockList = new ArrayList<>();
		try{
			result = stmt.executeQuery("SELECT stock FROM book_manager WHERE book_name LIKE '%" + name + "%';");
			while(result.next()){
				stockList.add(result.getInt("stock"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return stockList;
	}
}
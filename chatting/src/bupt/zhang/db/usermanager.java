package bupt.zhang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 管理用户的数据库方法
 * @author Xieyu
 *
 */
public class usermanager {
	//申明一些必备对象
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
   
	//初始化
	public usermanager(){
		conn=null;
		ps=null;
		rs=null;
	}
	
	//定义一个函数返回到的数据库的连接
	public Connection getConnection(){
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//2.建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanager",
					"root","z8966597");
			long end=System.currentTimeMillis();
			System.out.println("建立连接用时:"+(end-start)+"ms");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//在数据库中查找账号密码是否存在
	public boolean select(Connection conn,String username,String pwd){
		boolean result=false;
		String sql="select username,password from user where username=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString(1);
				String password=rs.getString(2);
				if(name.equals(username)&&password.equals(pwd)) result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//在数据库中查找账号是否存在
		public boolean select(Connection conn,String username){
			boolean result=false;
			String sql="select username,password from user where username=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, username);
				rs=ps.executeQuery();
				while(rs.next()){
					String name=rs.getString(1);;
					if(name.equals(username)) result=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {
						rs.close();	
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		}
	
	//将登陆过程封装进该方法
	public void login_check(String username,String password){
		usermanager user=new usermanager();
		Connection conn=user.getConnection();
		boolean result=false;
		result=user.select(conn, username, password);
		if(result) System.out.println("登陆成功");
		else System.out.println("账号或密码有误");
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//将注册过程封装进该方法
	public String register_check(String username){
		usermanager user=new usermanager();
		Connection conn=user.getConnection();
		boolean result=false;
		result=user.select(conn, username);
		if(result) return "用户名已经存在";
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "注册成功";
	}
	
	public void insert(String username,String password,String nickname){
		usermanager user=new usermanager();
		Connection conn=user.getConnection();
		String sql="insert into user from";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}

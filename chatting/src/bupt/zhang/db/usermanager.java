package bupt.zhang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * �����û������ݿⷽ��
 * @author Xieyu
 *
 */
public class usermanager {
	//����һЩ�ر�����
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
   
	//��ʼ��
	public usermanager(){
		conn=null;
		ps=null;
		rs=null;
	}
	
	//����һ���������ص������ݿ������
	public Connection getConnection(){
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//2.��������
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanager",
					"root","z8966597");
			long end=System.currentTimeMillis();
			System.out.println("����������ʱ:"+(end-start)+"ms");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//�����ݿ��в����˺������Ƿ����
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
	
	//�����ݿ��в����˺��Ƿ����
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
	
	//����½���̷�װ���÷���
	public void login_check(String username,String password){
		usermanager user=new usermanager();
		Connection conn=user.getConnection();
		boolean result=false;
		result=user.select(conn, username, password);
		if(result) System.out.println("��½�ɹ�");
		else System.out.println("�˺Ż���������");
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//��ע����̷�װ���÷���
	public String register_check(String username){
		usermanager user=new usermanager();
		Connection conn=user.getConnection();
		boolean result=false;
		result=user.select(conn, username);
		if(result) return "�û����Ѿ�����";
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "ע��ɹ�";
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

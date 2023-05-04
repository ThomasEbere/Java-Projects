package database;

import database.RandomNo;
import java.sql.Connection;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apps.BlogClass;
import apps.Users;

public class BlogDatabase {
	RandomNo random= new RandomNo();


	public Connection database() throws ClassNotFoundException, SQLException
	{
		String myDriver="com.mysql.cj.jdbc.Driver";
		
		Class.forName(myDriver);
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Blog","root","");
		return conn;
	}
	
	public int insertData(BlogClass blog) throws ClassNotFoundException, SQLException
	{
		int result=0;
		
		String INSERT_ITEM="INSERT INTO blog(bloguuid, blogTitle,blogArthur, blogContent,blogLikeCount, blogComment,blogDate) value(?,?,?,?,?,?,?)";
		
		PreparedStatement preparestatement=database().prepareStatement(INSERT_ITEM);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getTime());
		
		
		preparestatement.setInt(1, random.randomNo() );
		preparestatement.setString(2,blog.getBlogTitle());
		preparestatement.setString(3,blog.getBlogArthur());
		preparestatement.setString(4, blog.getBlogContent());
		preparestatement.setInt(5, blog.getBlogLikeCount());
		preparestatement.setString(6, blog.getBlogComments());
		preparestatement.setDate(7, sqlDate);


		result=preparestatement.executeUpdate();
		return result;
	}
	
	public List<BlogClass> getAllItem() throws ClassNotFoundException, SQLException
	{
		ArrayList<BlogClass> blogs=new ArrayList<>();
		
		String GET_ONE_ITEM="SELECT * FROM blog";
		PreparedStatement preparestatement=database().prepareStatement(GET_ONE_ITEM);
				
		ResultSet rs= preparestatement.executeQuery();
		
		while(rs.next())
		{
			BlogClass blog = new BlogClass();
			
			blog.setBlogid(rs.getInt(1));
			blog.setBloguuid(rs.getInt(2));
			blog.setBlogTitle(rs.getString(3));
			blog.setBlogArthur(rs.getString(4));
			blog.setBlogContent(rs.getString(5));
			blog.setBlogLikeCount(rs.getInt(6));
			blog.setBlogComments(rs.getString(7));
			blog.setBlogDate(rs.getDate(8));
			
			blogs.add(blog);
		}
		return blogs;
	}
	
	public List<BlogClass> getarticle(int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<BlogClass> blogs=new ArrayList<>();
		
		String GET_ONE_ITEM="SELECT * FROM blog where id=?";
		PreparedStatement preparestatement=database().prepareStatement(GET_ONE_ITEM);
		
		preparestatement.setInt(1,id);
		
		ResultSet rs= preparestatement.executeQuery();
		
		while(rs.next())
		{
			BlogClass blog = new BlogClass();
			
			blog.setBlogid(rs.getInt(1));
			blog.setBloguuid(rs.getInt(2));
			blog.setBlogTitle(rs.getString(3));
			blog.setBlogArthur(rs.getString(4));
			blog.setBlogContent(rs.getString(5));
			blog.setBlogLikeCount(rs.getInt(6));
			blog.setBlogComments(rs.getString(7));
			blog.setBlogDate(rs.getDate(8));
			
			blogs.add(blog);
		}
		return blogs;
		
	}

	public int createUser(Users user) throws ClassNotFoundException, SQLException
	{
		int result=0;
		
		String INSERT_ITEM="INSERT INTO users(useruuid, firstName, lastName, email, password) value(?,?,?,?,?)";
		
		PreparedStatement preparestatement=database().prepareStatement(INSERT_ITEM);
		
		preparestatement.setInt(1,random.randomNo());
		preparestatement.setString(2,user.getFirstName());
		preparestatement.setString(3,user.getLastName());
		preparestatement.setString(4, user.getEmail());
		preparestatement.setString(5, user.getPassword());

		result=preparestatement.executeUpdate();
		return result;
	}
	
	public List<Users> getUser(String email) throws ClassNotFoundException, SQLException
	{
		ArrayList<Users> users=new ArrayList<>();
		
		String GET_User="SELECT * FROM users where email=?";
		PreparedStatement preparestatement=database().prepareStatement(GET_User);
		
		preparestatement.setString(1,email);
		
		ResultSet rs= preparestatement.executeQuery();
		
		while(rs.next())
		{
			Users user = new Users();
			
			user.setUseruuid(rs.getInt(2));
			user.setFirstName(rs.getString(3));
			user.setLastName(rs.getString(4));
			user.setEmail(rs.getString(5));
			user.setPassword(rs.getString(6));
			users.add(user);
		}
		return users;
		
	}
	
	public List<BlogClass> getLatestBlog(String blogArthur) throws ClassNotFoundException, SQLException
	{
		ArrayList<BlogClass> blog=new ArrayList<>();
		
		String GET_User="SELECT * FROM blog where blogArthur=?";
		PreparedStatement preparestatement=database().prepareStatement(GET_User);
		
		preparestatement.setString(1,blogArthur);
		
		ResultSet rs= preparestatement.executeQuery();
		
		while(rs.next())
		{
			BlogClass blogs = new BlogClass();
			
			
			blogs.setBlogid(rs.getInt(1));
			blogs.setBloguuid(rs.getInt(2));
			blogs.setBlogTitle(rs.getString(3));
			blogs.setBlogArthur(rs.getString(4));
			blogs.setBlogContent(rs.getString(5));
			blogs.setBlogLikeCount(rs.getInt(6));
			blogs.setBlogComments(rs.getString(7));
			blogs.setBlogDate(rs.getDate(8));
			
			blog.add(blogs);
		}
		return blog;
		
	}
	
	public int updateBlog(BlogClass blog, int id) throws ClassNotFoundException, SQLException
	{
		int result=0;
		String updateRecords= "Update blog set blogTitle=?, blogArthur=?, blogContent=?, blogDate=? where Trim(id=?)";

		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getTime());
		PreparedStatement preparestatement=database().prepareStatement(updateRecords);
		
		preparestatement.setString(1, blog.getBlogTitle());
		preparestatement.setString(2, blog.getBlogArthur());
		preparestatement.setString(3, blog.getBlogContent());
		preparestatement.setDate(4,sqlDate);
		preparestatement.setInt(5, id);
		preparestatement.executeUpdate();
		return result;
	}
	
	public void deleteitem(int id) throws ClassNotFoundException, SQLException 
	{
		String deleteItem="DELETE FROM blog WHERE TRIM(id=?)";
		
		PreparedStatement preparestatement=database().prepareStatement(deleteItem);
		
		preparestatement.setInt(1, id);
		preparestatement.executeUpdate();		
	}
	
	public int updateBlogLike(int newLike, int id) throws ClassNotFoundException, SQLException
	{
		int result=0;
		String updateLikeRecords= "Update blog set blogLikeCount=? where Trim(id=?)";

		
		PreparedStatement preparestatement=database().prepareStatement(updateLikeRecords);
		
		preparestatement.setInt(1, newLike);
		preparestatement.setInt(2, id);
		preparestatement.executeUpdate();
		return result;
	}
	
	public int insertlikes(int blogid,int userid) throws ClassNotFoundException, SQLException
	{
		int result=0;
		
		String INSERT_ITEM="INSERT INTO likes(bloguuid, useruuid) value(?,?)";
		
		PreparedStatement preparestatement=database().prepareStatement(INSERT_ITEM);
		preparestatement.setInt(1, blogid);
		preparestatement.setInt(2,userid);
		result=preparestatement.executeUpdate();
		return result;
	}
	
	public String getblogid(int userid) throws ClassNotFoundException, SQLException {
//		List<String> sids = new ArrayList<String>();
		
		String getblogids="SELECT * FROM likes where useruuid=?";
		String sids="";
		PreparedStatement preparestatement=database().prepareStatement(getblogids);
		preparestatement.setInt(1,userid);
		ResultSet rs= preparestatement.executeQuery();
		while(rs.next()) {
			  sids=rs.getString(2);
		}
		return sids;
	}
	
	public void deletelike(int userid) throws ClassNotFoundException, SQLException 
	{
		String deleteItem="DELETE FROM likes WHERE TRIM(useruuid=?)";
		
		PreparedStatement preparestatement=database().prepareStatement(deleteItem);
		
		preparestatement.setInt(1, userid);
		preparestatement.executeUpdate();		
	} 
	
	public String getFirstName(int userid) throws ClassNotFoundException, SQLException {
//		List<String> sids = new ArrayList<String>();
		
		String getuserdetails="SELECT * FROM users where useruuid=?";
		String sids="";
		PreparedStatement preparestatement=database().prepareStatement(getuserdetails);
		preparestatement.setInt(1,userid);
		ResultSet rs= preparestatement.executeQuery();
		while(rs.next()) {
			  sids=rs.getString(3);
		}
		return sids;
	}
}

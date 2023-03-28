package database;

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

	public Connection database() throws ClassNotFoundException, SQLException
	{
		String myDriver="com.mysql.cj.jdbc.Driver";
		
		Class.forName(myDriver);
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Blog","root", "Prick123$");
		return conn;
	}
	
	public int insertData(BlogClass blog) throws ClassNotFoundException, SQLException
	{
		int result=0;
		
		String INSERT_ITEM="INSERT INTO blog(blogTitle,blogArthur, blogContent,blogLikeCount, blogComment,blogDate) value(?,?,?,?,?,?)";
		
		PreparedStatement preparestatement=database().prepareStatement(INSERT_ITEM);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getTime());
		
		preparestatement.setString(1,blog.getBlogTitle());
		preparestatement.setString(2,blog.getBlogArthur());
		preparestatement.setString(3, blog.getBlogContent());
		preparestatement.setInt(4, blog.getBlogLikeCount());
		preparestatement.setString(5, blog.getBlogComments());
		preparestatement.setDate(6, sqlDate);


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
			blog.setBlogTitle(rs.getString(2));
			blog.setBlogArthur(rs.getString(3));
			blog.setBlogContent(rs.getString(4));
			blog.setBlogLikeCount(rs.getInt(5));
			blog.setBlogComments(rs.getString(6));
			blog.setBlogDate(rs.getDate(7));
			
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
			blog.setBlogTitle(rs.getString(2));
			blog.setBlogArthur(rs.getString(3));
			blog.setBlogContent(rs.getString(4));
			blog.setBlogLikeCount(rs.getInt(5));
			blog.setBlogComments(rs.getString(6));
			blog.setBlogDate(rs.getDate(7));
			
			blogs.add(blog);
		}
		return blogs;
		
	}

	public int createUser(Users user) throws ClassNotFoundException, SQLException
	{
		int result=0;
		
		String INSERT_ITEM="INSERT INTO users(firstName, lastName, email, password) value(?,?,?,?)";
		
		PreparedStatement preparestatement=database().prepareStatement(INSERT_ITEM);
		
		preparestatement.setString(1,user.getFirstName());
		preparestatement.setString(2,user.getLastName());
		preparestatement.setString(3, user.getEmail());
		preparestatement.setString(4, user.getPassword());

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
			
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
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
			blogs.setBlogTitle(rs.getString(2));
			blogs.setBlogArthur(rs.getString(3));
			blogs.setBlogContent(rs.getString(4));
			blogs.setBlogLikeCount(rs.getInt(5));
			blogs.setBlogComments(rs.getString(6));
			blogs.setBlogDate(rs.getDate(7));
			
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
	
	
}
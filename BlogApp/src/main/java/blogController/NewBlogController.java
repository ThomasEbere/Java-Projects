package blogController;

import java.sql.SQLException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import apps.BlogClass;
import apps.Users;
import database.BlogDatabase;

@Controller
public class NewBlogController {

	private BlogDatabase dataConnection = new BlogDatabase();
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/createblog")
	public String createblog(@ModelAttribute("blog") BlogClass blog, BindingResult result, HttpSession session,RedirectAttributes redirectAttributes,String createBlog,Model model)
	{
		
		if(session.getAttribute("FirstName")!=null) {
			String title= (String) session.getAttribute("FirstName");
			model.addAttribute("firstname", title);
			return "createblog";
		}
		
		createBlog="http://localhost:8021/BlogApp/createblog";
		redirectAttributes.addFlashAttribute("mapping1Form", createBlog);
		return "redirect:/userlogin";
	}
	
	@RequestMapping("/getblog")
	public String blogData(@ModelAttribute("blog") BlogClass blog, BindingResult result) throws ClassNotFoundException, SQLException
	{
		dataConnection.insertData(blog);
		return "successpage";
	}
	
	@RequestMapping("/showallblog")
	public String showAllBlogs(Model model) throws ClassNotFoundException, SQLException
	{
		List<BlogClass>blogs=dataConnection.getAllItem();
		model.addAttribute("blogs", blogs);
		return "blogdetails";
	}
	
	@RequestMapping("/showblog/{roll}")
	public String showblogs(@PathVariable int roll, Model model) throws ClassNotFoundException, SQLException
	{
		List<BlogClass>blogs=dataConnection.getarticle(roll);
		model.addAttribute("blogs", blogs);
		return "blogdetail";
	}
	
	@RequestMapping("/viewblog")
	public String getUserBlogs(Model model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		String BlogArthur= (String) session.getAttribute("FirstName");
		
		List<BlogClass>blogs=dataConnection.getLatestBlog(BlogArthur);
		BlogClass singleBlog=blogs.get(blogs.size()-1);
		model.addAttribute("blogs", singleBlog);
		return "viewPersonalBlog";
	}
	
	@RequestMapping("/editblog")
	public String editBlog(@ModelAttribute("blog") BlogClass blog, BindingResult result,Model model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		String BlogArthur= (String) session.getAttribute("FirstName");
		
		List<BlogClass>blogs=dataConnection.getLatestBlog(BlogArthur);
		BlogClass singleBlog=blogs.get(blogs.size()-1);
		model.addAttribute("blogs", singleBlog);
		return "editblog";
	}
	
	@RequestMapping("/updateblog")
	public String update(@ModelAttribute("blog") BlogClass blog, BindingResult result,Model model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		String BlogArthur= (String) session.getAttribute("FirstName");
		
		List<BlogClass>blogs=dataConnection.getLatestBlog(BlogArthur);
		BlogClass singleBlog=blogs.get(blogs.size()-1);
		
		dataConnection.updateBlog(blog, singleBlog.getBlogid());
		model.addAttribute("blogs", singleBlog);
		return "redirect:/viewblog";
	}
	
	@RequestMapping("/seemyblog")
	public String seeMyBlogs(@ModelAttribute("blog") BlogClass blog, BindingResult result,Model model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		String BlogArthur= (String) session.getAttribute("FirstName");
		
		List<BlogClass>blogs=dataConnection.getLatestBlog(BlogArthur);
		model.addAttribute("blogs", blogs);
		return "seemyblog";
	}
	
	@RequestMapping("/editmyblog/{roll}")
	public String editMyBlog(@PathVariable int roll,@ModelAttribute("blog") BlogClass blog, BindingResult result, Model model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		String BlogArthur= (String) session.getAttribute("FirstName");
		
		List<BlogClass>blogs=dataConnection.getarticle(roll);
						
		
		model.addAttribute("blogs", blogs);
		return "editblog";
	}
	
	@RequestMapping("/delete/{roll}")
	public String deleteMyBlog(@PathVariable int roll,@ModelAttribute("blog") BlogClass blog, BindingResult result, Model model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		String BlogArthur= (String) session.getAttribute("FirstName");
		
		dataConnection.deleteitem(roll);
						
		return "redirect:/seemyblog";
	}
	
	
}

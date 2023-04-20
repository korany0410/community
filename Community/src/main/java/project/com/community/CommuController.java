package project.com.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdvertisementDAO;
import dao.CommentDAO;
import dao.PostDAO;
import dao.UserDAO;
import dao.User_CommentDAO;
import dao.User_PostDAO;

@Controller
public class CommuController {

	AdvertisementDAO advertisement_dao;
	CommentDAO comment_dao;
	PostDAO post_dao;
	User_CommentDAO user_comment_dao;
	User_PostDAO user_post_dao;
	UserDAO user_dao;

	@Autowired // 자동주입 : spring으로부터 자동생성이 가능한 객체를 new없이 알아서 생성해 준다.
	HttpServletRequest request;

	public CommuController(AdvertisementDAO advertisement_dao, CommentDAO comment_dao, PostDAO post_dao,
			User_CommentDAO user_comment_dao, User_PostDAO user_post_dao, UserDAO user_dao) {
		// TODO Auto-generated constructor stub
		this.advertisement_dao = advertisement_dao;
		this.comment_dao = comment_dao;
		this.post_dao = post_dao;
		this.user_comment_dao = user_comment_dao;
		this.user_post_dao = user_post_dao;
		this.user_dao = user_dao;
	}

	@RequestMapping(value = { "/", "main_screen.do" })
	public String main_screen() {
		
		System.out.println("a");
		return "/WEB-INF/views/commu/main_screen.jsp";
	}
}

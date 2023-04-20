package project.com.community;

import org.springframework.stereotype.Controller;

import dao.UserDAO;

@Controller
public class UserController {

	UserDAO userdao;

	public UserController(UserDAO userdao) {
		// TODO Auto-generated constructor stub
		this.userdao = userdao;
	}
}

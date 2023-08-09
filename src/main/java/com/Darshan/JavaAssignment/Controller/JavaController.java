package com.Darshan.JavaAssignment.Controller;

import java.util.List;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Darshan.JavaAssignment.Model.UserLogin;
import com.Darshan.JavaAssignment.Model.Users;
import com.Darshan.JavaAssignment.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.servlet.http.HttpSession;

@Controller
public class JavaController {

	@Autowired
	UserService us;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("login.jsp");
		return mv;
	}

	@GetMapping("/dashboard")
	public ModelAndView getDashboard(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("token") != "error" && session.getAttribute("token") != null) {
//			session.setAttribute("token", res);
			mv.setViewName("dashboard.jsp");
			List<Users> usr = us.getUsers(session);
			mv.addObject("employees", usr);
		} else {
			mv.setViewName("redirect:/");
		}

		return mv;
	}

	@PostMapping("/login")
	public ModelAndView authenticated(@RequestParam String login_id, @RequestParam String password, HttpSession session)
			throws JsonMappingException, JsonProcessingException {
		UserLogin ul = new UserLogin();

		ul.setLogin_id(login_id);
		ul.setPassword(password);
		String res = us.getToken(ul);

		ModelAndView mv = new ModelAndView();

		if (res != "error") {
			session.setAttribute("token", res);
			mv.setViewName("redirect:/dashboard");
		} else {
			mv.setViewName("redirect:/");
		}

		return mv;
	}

	@GetMapping("/create")
	public ModelAndView getForm(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") != "error" && session.getAttribute("token") != null) {
			mv.setViewName("userDetail.jsp");
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}

	@PostMapping("/add")
	public ModelAndView submitForm(Users e, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") != "error") {
			String response = us.createUser(e, session);
			System.out.println(response);
			if (response == "created") {
				mv.setViewName("redirect:/dashboard");
			} else {
				mv.setViewName("redirect:/");
			}

		} else {
			mv.setViewName("redirect:/");
		}

		return mv;
	}

	@GetMapping("edit/{uuid}")
	public ModelAndView getUpdateForm(@PathVariable String uuid, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") != "error" && session.getAttribute("token") != null) {
			List<Users> users = us.getUsers(session);
			Users user = null;
			for (Users usr : users) {
				if (uuid.equals(usr.getUuid())) {
					user = usr;
				}
			}
			mv.setViewName("../updateDetail.jsp");
			mv.addObject("detail", user);
		} else {
			mv.setViewName("redirect:/");
		}

		return mv;
	}

	@PostMapping("/update/{uuid}")
	public ModelAndView updateDetail(Users user, @PathVariable String uuid, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user);
		user.setUuid(null);
		System.out.println(user.toString());
		if (session.getAttribute("token") != "error" && session.getAttribute("token") != null) {
			String res = us.updateUser(uuid, user, session);
			if (res == "success") {
				mv.setViewName("redirect:/dashboard");
			}
		} else {
			mv.setViewName("redirect:/");
		}

		return mv;
	}

	@GetMapping("/delete/{uuid}")
	public ModelAndView deleteEmp(@PathVariable String uuid, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") != "error" && session.getAttribute("token") != null) {
			String res = us.deleteUser(uuid, session);
			if (res != null) {
				mv.setViewName("redirect:/dashboard");
			} else {
				mv.setViewName("redirect:/");
			}
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}

}

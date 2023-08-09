package com.Darshan.JavaAssignment.Service;

import java.util.List;

import com.Darshan.JavaAssignment.Model.UserLogin;
import com.Darshan.JavaAssignment.Model.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.servlet.http.HttpSession;

public interface UserService {

//	public Users[] getUser();
	public String getToken(UserLogin ul);
	public List<Users> getUsers(HttpSession session) ;
	public String createUser(Users user,HttpSession session);
	public String deleteUser(String uuid, HttpSession session);
	public String updateUser(String uuid, Users user,HttpSession session);
}

package org.jsp.hibernatespringwebapp.service;

import org.jsp.hibernatespringwebapp.dao.UserDAO;
import org.jsp.hibernatespringwebapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDAO dao;
	
	public void saveUser(UserDTO dto) 
	{
		dao.saveUser(dto);
	}

	public boolean authenticateUser(String username, String password) {
		return dao.authenticateUser(username,password);
	}

	@Override
	public UserDTO getUser(String username, String password) {
		return dao.getUser(username,password);
	}

}

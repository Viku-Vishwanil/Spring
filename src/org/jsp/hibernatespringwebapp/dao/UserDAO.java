package org.jsp.hibernatespringwebapp.dao;

import org.jsp.hibernatespringwebapp.dto.UserDTO;

public interface UserDAO 
{

	void saveUser(UserDTO dto);

	boolean authenticateUser(String username, String password);

	UserDTO getUser(String username, String password);

}

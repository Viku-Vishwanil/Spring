package org.jsp.hibernatespringwebapp.service;

import org.jsp.hibernatespringwebapp.dto.UserDTO;

public interface UserService {

	void saveUser(UserDTO dto);

	boolean authenticateUser(String username, String password);

	UserDTO getUser(String username, String password);

}

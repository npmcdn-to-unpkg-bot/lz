package sk.liptovzije.service;

import java.util.List;

import sk.liptovzije.model.User;
import sk.liptovzije.model.UserCredentials;


public interface IUserService {

	User authenticate(final UserCredentials credentials);

	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}

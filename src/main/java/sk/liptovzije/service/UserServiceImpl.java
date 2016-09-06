package sk.liptovzije.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.liptovzije.model.User;
import sk.liptovzije.model.UserCredentials;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getCredentials().getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getCredentials().getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	public User authenticate(final UserCredentials credentials) {
		User result = null;

		for(User user: users) {
			if(user.getCredentials().equals(credentials)){
				result = user;
				break;
			}
		}

		return result;
	}
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();

		users.add(new User(counter.incrementAndGet(), "Jan", "Husenica", null, null, new UserCredentials("sanka", "mojeHeslo")));
		users.add(new User(counter.incrementAndGet(), "Tomas", "Csaszari", null, null, new UserCredentials("toso", "heslo")));

		return users;
	}

}

package UserInterface;

import dao.MySqlUserDao;
import dao.UserDao;
import entity.User;

public class Main {

	public static void main(String[] args) {
		UserDao userDao = new MySqlUserDao("jdbc:mysql://localhost:3306/warsztaty2", "coderslab", "root");
	
		User user = new User();
		user.setEmail("andrzej@Samoillo");
		user.setName("Andrzej");
		user.setSurname("Samoillo");
		user.setPassword("password");
		user.setUserGroupId(1);
		
		userDao.insert(user);
		System.out.println(user);
		
		System.out.println(userDao.findAll());
		
		User user1 = new User(1, "sample", "sample", "sample", "sample", 2);
		userDao.update(user1);
	}

}
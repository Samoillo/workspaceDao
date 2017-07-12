package dao;

import java.util.List;

import entity.User;

public interface UserDao {

	User insert(User user);

	List<User> findAll(); // do zaimplementowania
	
	void update(User user); // do zaimplementowania

}
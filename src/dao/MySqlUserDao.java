package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class MySqlUserDao implements UserDao {
	
	private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM users";
	private static final String INSERT_USER_QUERY = 
			"INSERT INTO users(name, surname,email,password,user_group_id) VALUES (?,?,?,?,?)";
	private static final String UPDATE_USER_QUERY = 
			"UPDATE	users SET name = ? , surname = ?, email = ?, password = ?, user_group_id =? WHERE	id = ?";
	
	private final String jdbcUrl;
	private final String password;
	private final String user;

	public MySqlUserDao(String jdbcUrl, String password, String user) {
		this.jdbcUrl = jdbcUrl;
		this.password = password;
		this.user = user;
	}
	
	private Connection createConnection() throws SQLException{
		return DriverManager.getConnection(jdbcUrl,user,password);
	}

	@Override
	public User insert(User user) {
		try (Connection connection = createConnection();
		PreparedStatement insertStm = connection.prepareStatement(INSERT_USER_QUERY,
				PreparedStatement.RETURN_GENERATED_KEYS)){

			insertStm.setString(1, user.getName());
			insertStm.setString(2, user.getSurname());
			insertStm.setString(3, user.getEmail());
			insertStm.setString(4, user.getPassword());
			insertStm.setInt(5, user.getUserGroupId());
			int result = insertStm.executeUpdate();
			
			if (result != 1) {
				throw new RuntimeException("Execute update returned " + result);
			}
			
			try(ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
				if(generatedKeys.first()){
					user.setId(generatedKeys.getInt(1));
					return user;
				}else{
					throw new RuntimeException("Generated key was not found");
				}
				
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> userList = new ArrayList<>();
		try (Connection connection = createConnection();
				PreparedStatement findStm = connection.prepareStatement(FIND_ALL_USERS_QUERY);
				ResultSet resultSet = findStm.executeQuery() ){

					while (resultSet.next()){
						User userToAdd = new User();
						userToAdd.setId(resultSet.getInt("id"));
						userToAdd.setName(resultSet.getString("name"));
						userToAdd.setEmail(resultSet.getString("email"));
						userToAdd.setPassword(resultSet.getString("password"));
						userToAdd.setUserGroupId(resultSet.getInt("user_group_id"));
						userList.add(userToAdd);
					}

				} catch (Exception e) {
					System.out.println("Something wrong");
				}
		return userList;
				
	}

	@Override
	public void update(User user) {
			
			try (Connection connection = createConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY);) {
				statement.setInt(6, user.getId());
				statement.setString(1, user.getName());
				statement.setString(2, user.getSurname());
				statement.setString(3, user.getEmail());
				statement.setString(4, user.getPassword());
				statement.setInt(5, user.getUserGroupId());
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			
		}
		
	}

}
package gmo.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import gmo.springmvc.model.Login;

public class LoginDaoImpl implements LoginDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(Login login) {
	int insertedRows = 0;  
	Login user = validateLogin(login);  
	if(user == null) {
	    String sql = "insert into loginAccounts values(?,?)";
	
	    insertedRows = jdbcTemplate.update(sql, new Object[] { login.getUsername(), login.getPassword() });
	}
	return insertedRows;
  }

  public Login validateLogin(Login login) {
    String sql = "select * from loginAccounts where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
    List<Login> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }
  
  public boolean isLoginUserExists(Login login) {
	    String sql = "select * from loginAccounts where username='" + login.getUsername() + "'";
	    List<Login> users = jdbcTemplate.query(sql, new UserMapper());
	    boolean userExists = users.size() > 0 ? true : false;	
	    return userExists;
	  }

}

class UserMapper implements RowMapper<Login> {

  public Login mapRow(ResultSet rs, int arg1) throws SQLException {
	Login login = new Login();

	login.setUsername(rs.getString("username"));
	login.setPassword(rs.getString("password"));

    return login;
  }
}
package Persistance;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import Model.MapperMasina;
import Model.MapperUser;
import Model.Masina;
import Model.User;

public class OperatiiBD {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}	

	public User verificaUtilizator(String utilizator, String parola) {
		String SQL = "SELECT * FROM utilizatori WHERE nume = ? AND parola = ?";
		User user = (User) jdbcTemplateObject.queryForObject(SQL, new Object[] { utilizator, parola }, new MapperUser());
		return user;
	}
	
	public User getUserById(int id) {
		String SQL = "SELECT * FROM utilizatori WHERE id = ?";
		User user = (User) jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new MapperUser());
		return user;
	}
	
	public List<Masina> getAllCars() {
		String SQL = "select * from masini3";
		List<Masina> masini = jdbcTemplateObject.query(SQL, new MapperMasina());
		return masini;
	}
}

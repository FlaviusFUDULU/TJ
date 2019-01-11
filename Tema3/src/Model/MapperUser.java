package Model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUser implements RowMapper{

	public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
		User user = new User();
		user.setNume(rs.getString("nume"));
		user.setId(rs.getInt("id"));
		user.setParola(rs.getString("parola"));
		user.setUtilizator(rs.getString("utilizator"));
		user.setNivel_de_acces(rs.getInt("nivel_de_acces"));				
		return user;
	}

}

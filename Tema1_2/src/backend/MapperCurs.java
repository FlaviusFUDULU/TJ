package backend;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCurs implements RowMapper<Curs>{

	public Curs mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Curs curs = new Curs();
		curs.setId_angajat(rs.getString("id_angajat"));
		curs.setDenumire(rs.getString("denumire"));
		curs.setNumar_ore(rs.getInt("numar_ore"));
		curs.setValoare(rs.getFloat("valoare"));	
		curs.setDiploma_de_absolvire(rs.getString("diploma_de_absolvire"));
		curs.setAnul(rs.getInt("anul"));		
		return curs;
	}

}

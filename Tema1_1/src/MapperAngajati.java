import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperAngajati implements RowMapper<Angajati>{

	public Angajati mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Angajati angajat = new Angajati();
		angajat.setNume(rs.getString("nume"));
		angajat.setFunctie(rs.getString("functia"));
		angajat.setFirma(rs.getString("firma"));
		angajat.setData_angajarii(rs.getDate("data_angajarii"));		
		return angajat;
	}

}

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMasini implements RowMapper<Masini>{

	public Masini mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Masini masina = new Masini();
		masina.setNrInmatriculare(rs.getString("Nr_inmatriculare"));
		masina.setMarca(rs.getString("Marca"));
		masina.setAnulFabricatiei(rs.getInt("Anul_Fabricatiei"));
		masina.setCuloare(rs.getString("Culoare"));
		masina.setNrKm(rs.getInt("Nr_Km"));
		
		return masina;
	}

}

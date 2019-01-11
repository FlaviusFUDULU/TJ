package Model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMasina implements RowMapper{

	public Masina mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Masina masina = new Masina();
		masina.setNr_inmatriculare(rs.getString("nr_inmatriculare"));
		masina.setMarca(rs.getString("marca"));
		masina.setModelul(rs.getString("modelul"));
		masina.setCuloarea(rs.getString("culoarea"));
		masina.setAnul_fabricatiei(rs.getInt("anul_fabricatiei"));
		masina.setCapacitatea_cilindrica(rs.getInt("capacitatea_cilindrica"));
		masina.setTipul_de_combustibil(rs.getString("tipul_de_combustibil"));
		masina.setPutere(rs.getInt("putere"));
		masina.setCuplu(rs.getInt("cuplul"));
		masina.setVolumul_portbagajului(rs.getFloat("volumul_portbagajului"));
		masina.setPretul(rs.getInt("pretul"));
		return masina;
	}
}

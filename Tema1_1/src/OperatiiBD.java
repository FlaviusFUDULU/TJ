import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OperatiiBD {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}	

	public void insertAngajat(String nume, String firma, String functia, java.util.Date data) {
		String SQL = "insert into angajati(nume, firma, functia, data_angajarii) values(?, ?, ?, ?)";
		jdbcTemplateObject.update( SQL, nume, firma, functia, data);	
	}

	public Angajati cautareAngajat(String nume) {
		String SQL = "select * from angajati where nume = ?";
		Angajati angajat = jdbcTemplateObject.queryForObject(SQL, new Object[] { nume }, new MapperAngajati());
		return angajat;		
	}

	public void stergereAngajat(String numeDeSters) {
		String SQL = "delete from angajati where nume = ?";
		jdbcTemplateObject.update(SQL, numeDeSters);				
	}

	public List<Angajati> afisareAndDinFirma(String numeFirma) {
		String SQL = "select * from angajati where firma = ?";
		List<Angajati> angajati = jdbcTemplateObject.query(SQL, new Object[] { numeFirma }, new MapperAngajati());
		return angajati;	
	}

	public void actualizareAngajat(String numeDeActualizat2, String firmaDeActualizat, String functiaDeActualizat,
			java.util.Date dataDeActualizat, String numeDeActualizat) {
		String SQL = "UPDATE angajati SET nume = ?, firma= ?, functia = ?, data_angajarii =? WHERE nume = ?";
		jdbcTemplateObject.update( SQL, numeDeActualizat2, firmaDeActualizat, functiaDeActualizat, dataDeActualizat, numeDeActualizat);
	}

	public List<Angajati> afisareVechimeMaiMareDe(int numarDeAni) {
		String SQL = "SELECT * FROM angajati WHERE DATEDIFF(YEAR, data_angajarii, GetDate()) >= ?";
		List<Angajati> angajati = jdbcTemplateObject.query(SQL, new Object[] { numarDeAni }, new MapperAngajati());
		return angajati;
	}

	public List<Angajati> afisareDupaCurs(String denumireCurs) {
		String SQL = "SELECT ang.* FROM angajati as ang JOIN cursuri as cu ON ang.id = cu.id_angajat WHERE cu.denumire = ?";
		List<Angajati> angajati = jdbcTemplateObject.query(SQL, new Object[] { denumireCurs }, new MapperAngajati());
		return angajati;
	}

	public void insertCurs(String id_angajat, String denumire, int numar_ore, String diploma_de_absolvire, int anul, float valoare) {
		String SQL = "insert into cursuri(id_angajat, denumire, numar_ore, diploma_de_absolvire,anul,valoare) values(?, ?, ?, ?,?,?)";
		jdbcTemplateObject.update( SQL, id_angajat, denumire, numar_ore, diploma_de_absolvire,anul,valoare);
	}

	public Curs cautareCurs(String denumireDeCautatat) {
		String SQL = "select * from cursuri where denumire = ?";
		Curs curs = jdbcTemplateObject.queryForObject(SQL, new Object[] { denumireDeCautatat }, new MapperCurs());
		return curs;	
	}

	public void stergereCurs(String denumireDeSters) {
		String SQL = "delete from cursuri where denumire = ?";
		jdbcTemplateObject.update(SQL, denumireDeSters);			
	}

	public void actualizareCurs(String id_angajat2, String denumire2, int numar_ore2, float valoare2, 
			String diploma_de_absolvire2, int anul2, String denumireDeActualizat) {
		String SQL = "UPDATE cursuri SET id_angajat = ?, denumire= ?, numar_ore = ?, valoare =? ,diploma_de_absolvire =?,  anul= ? WHERE denumire = ?";
		jdbcTemplateObject.update( SQL, id_angajat2, denumire2, valoare2, numar_ore2, diploma_de_absolvire2, anul2,denumireDeActualizat);
	}

}

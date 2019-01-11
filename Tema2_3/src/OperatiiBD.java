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
	
	public void insertMasina(String nr_inmatriculare, String marca, int anul_fabricatiei, String culoare, int nr_km)
	{
		String SQL = "insert into masini(nr_inmatriculare, marca, anul_fabricatiei, culoare, nr_km) values(?, ?, ?, ?, ?)";
		jdbcTemplateObject.update( SQL, nr_inmatriculare, marca, anul_fabricatiei, culoare, nr_km);	
	}
	
	public void deleteMasina(String nr_inmatriculare)
	{
		String SQL = "delete from masini where nr_inmatriculare = ?";
		jdbcTemplateObject.update(SQL, nr_inmatriculare);		
	}
	
	public Masini getMasini(String nr_inmatriculare) 
	{
		String SQL = "select * from masini where nr_inmatriculare = ?";
		Masini masina = jdbcTemplateObject.queryForObject(SQL, new Object[] { nr_inmatriculare }, new MapperMasini());
		return masina;
	}
	
	public List<Masini> getMasini5ani()
	{		
		int an = Calendar.getInstance().get(Calendar.YEAR);
		String SQL = "Select * from masini where (? - anul_fabricatiei) < 5";
		List<Masini> masini = jdbcTemplateObject.query(SQL, new Object[]{ an }, new MapperMasini());
		
		return masini;
	}
	
	public List<Masini> getMarcaMasini(String marca)
	{		
		String SQL = "Select * from masini where marca = ?";
		List<Masini> masina = jdbcTemplateObject.query(SQL, new Object[] { marca }, new MapperMasini());
		return masina;
	}
	
	public int  getNrMasini()
	{		
		String SQL = "Select * from masini where Nr_Km < 100000";
		List<Masini> masini = jdbcTemplateObject.query(SQL, new MapperMasini());

		if(masini != null)
			return masini.size();
		else
			return 0 ;
	}
	
	public Masini getNrInmatriculareMasini(String nr_inmatriculare) 
	{
		String SQL = "select * from masini where Nr_inmatriculare = ?";
		Masini masini = jdbcTemplateObject.queryForObject(SQL, new Object[] { nr_inmatriculare }, new MapperMasini());
		
		return masini;
	}
	
	public List<Masini> getListaMasini() {
		String SQL = "select * from masini";
		List<Masini> masini = jdbcTemplateObject.query(SQL, new MapperMasini());
		return masini;
	}

}

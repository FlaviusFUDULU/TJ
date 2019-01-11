package Model;
import java.util.Date;

public class User {

	int id;


	public void setId(int id) {
		this.id = id;
	}
	String nume;
	String utilizator;
	String parola;
	int nivel_de_acces;
	
	public User() {}
	
	public User(int id, String nume, String utilizator, String parola, int nivel_de_acces) {
		super();
		this.id = id;
		this.nume = nume;
		this.utilizator = utilizator;
		this.parola = parola;
		this.nivel_de_acces = nivel_de_acces;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getUtilizator() {
		return utilizator;
	}
	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public int getNivel_de_acces() {
		return nivel_de_acces;
	}
	public void setNivel_de_acces(int nivel_de_acces) {
		this.nivel_de_acces = nivel_de_acces;
	}

	public int getId() {
		return id;
	}
}

import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Utilizadores extends Cache{
   
	// Variáveis de instância ---------------------------------- - - - - - - - - -
	
	private char genero;
    private String nome, email, password, morada;
    private GregorianCalendar datanascimento;
    ArrayList<Cache> actividades;
	ArrayList<Utilizadores> redeamigos;
	public char getGenero() {
		return genero;
	}
	
	
	
	// Geters e Seters -------------------------------------- - - - - - - - - - - 
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMorada() {
		return morada;
	}
	public void setMorada(String morada) {
		this.morada = morada;
	}
	public GregorianCalendar getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(GregorianCalendar datanascimento) {
		this.datanascimento = datanascimento;
	}
	public ArrayList<Cache> getActividades() {
		return actividades;
	}
	public void setActividades(ArrayList<Cache> actividades) {
		this.actividades = actividades;
	}
	public ArrayList<Utilizadores> getRedeamigos() {
		return redeamigos;
	}
	public void setRedeamigos(ArrayList<Utilizadores> redeamigos) {
		this.redeamigos = redeamigos;
	}	

	
    
    }
package gw.desafio.dominio;

public class Telefone {
	private int idUsuario;
	private int ddd;
	private String numero;
	
	public Telefone(int ddd, String numero) {
		this.ddd=ddd;
		this.numero=numero;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}

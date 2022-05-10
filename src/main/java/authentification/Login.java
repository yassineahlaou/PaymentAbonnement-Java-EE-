package authentification;

import java.io.Serializable;

public class Login implements Serializable {

	public Login(String nomComplet, String password) {
		super();
		this.nomComplet = nomComplet;
		this.password = password;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String nomComplet, String password, boolean st) {
		super();
		this.nomComplet = nomComplet;
		this.password = password;
		this.st = st;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSt() {
		return st;
	}
	public void setSt(boolean st) {
		this.st = st;
	}
	private String  nomComplet;
	private String password;
	private boolean st;

}

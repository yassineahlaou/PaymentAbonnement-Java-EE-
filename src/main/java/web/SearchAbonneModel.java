package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gestion.Abonne;



public class SearchAbonneModel implements Serializable {
	
	
	public SearchAbonneModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SearchAbonneModel(String keyword, String error, String mode, Abonne a, List<Abonne> abonnes) {
		super();
		this.keyword = keyword;
		this.error = error;
		this.mode = mode;
		this.a = a;
		this.abonnes = abonnes;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public Abonne getA() {
		return a;
	}


	public void setA(Abonne a) {
		this.a = a;
	}


	public List<Abonne> getAbonnes() {
		return abonnes;
	}


	public void setAbonnes(List<Abonne> abonnes) {
		this.abonnes = abonnes;
	}


	private String  keyword;
	private String error;
	private String mode ="add";
	
	
	private Abonne a = new Abonne();
	
	
	private List <Abonne> abonnes = new ArrayList <Abonne>();


}

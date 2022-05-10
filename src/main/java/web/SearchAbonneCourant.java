package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gestion.Abonne;

public class SearchAbonneCourant implements Serializable{
	private Abonne a = new Abonne();
	private List <Abonne> abonnes = new ArrayList <Abonne>();
	public SearchAbonneCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchAbonneCourant(Abonne a, List<Abonne> abonnes) {
		super();
		this.a = a;
		this.abonnes = abonnes;
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

}

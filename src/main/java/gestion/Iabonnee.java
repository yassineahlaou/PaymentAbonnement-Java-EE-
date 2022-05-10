package gestion;

import java.util.List;

public interface Iabonnee {
	public void addAbonne (Abonne a);
	public  List<Abonne> listAbonnes();
	public  List<Abonne> Abonneperkw(String kw);
	public  Abonne getAbonne(String nomComplet);
	public void updateAbonne (Abonne a);
	public void deleteAbonne (String nomComplet);

}
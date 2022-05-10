package gestion;

import java.util.List;

public interface IabonneCourant {
	public void updateAbonneCourant (Abonne a);
	public  List<Abonne> listAbonnes();
	public  Abonne getAbonne(String nomComplet);

}

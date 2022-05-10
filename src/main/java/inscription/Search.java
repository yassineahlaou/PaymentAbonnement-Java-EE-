package inscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import authentification.ConnectionMySql;
import gestion.Abonne;

public class Search {
	public boolean search(Abonne a)   {
		
		 boolean status = false;
		 Connection cnx1 = null;
		
		 //etablir la conexion a la base de données
		
		PreparedStatement prepered1 = null;
		
		try {
			 cnx1 = ConnectionMySql.getConn();
			 String sql1 = "select * from abonnes where nomComplet = ? " ; //la requete
				
			
			
			 prepered1 = cnx1.prepareStatement(sql1);
			prepered1.setString(1, a.getNomComplet());
			
			
			ResultSet result = prepered1.executeQuery();
	        status = result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

		
		
		

	}
}
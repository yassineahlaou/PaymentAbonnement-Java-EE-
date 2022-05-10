package inscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import authentification.ConnectionMySql;
import gestion.Abonne;



public class SignSql {
	
		
	
	public void sign(Abonne a) {
		Connection cnx = null;//etablir la conexion a la base de données
		
		cnx = ConnectionMySql.getConn();
		
		ResultSet result = null;// afficher le resultat
		PreparedStatement prepered = null;//Execution de la requete
		
		String sql = "INSERT INTO  abonnes (nomComplet, email, password, phone) values (? , ? , ? , ?) "; //la requete
	   
		try {
			
			
			prepered = cnx.prepareStatement(sql);
			prepered.setString(1, a.getNomComplet() );
			
			prepered.setString(2, a.getEmail() );
			prepered.setString(3, a.getPassword());
			prepered.setString(4, a.getPhone());
			
			prepered.executeUpdate();
			prepered.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}

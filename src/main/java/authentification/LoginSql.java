package authentification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gestion.Abonne;
import gestion.BeanException;


public class LoginSql {
	
	
	public Abonne connect(String nomC , String pass)   {
		
		 boolean status = false;
		 Connection cnx = null;
		 Abonne ab  = null;
		
		 //etablir la conexion a la base de données
		
		PreparedStatement prepered = null;
		
		try {
			 cnx = ConnectionMySql.getConn();
			 String sql = "select * from abonnes where nomComplet = ? and password = ?" ; //la requete
				
			
			
			 prepered = cnx.prepareStatement(sql);
			prepered.setString(1, nomC);
			prepered.setString(2, pass);
			
			ResultSet result = prepered.executeQuery();
	        
	        if(result.next()){
                ab = new Abonne();
               try {
				ab.setNomComplet(result.getString("nomComplet"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
			
			}
                
              try {
				ab.setPassword(result.getString("password"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             try {
				ab.setEmail(result.getString("email"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             try {
				ab.setPhone(result.getString("phone"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             ab.setMontant(result.getDouble("montant"));
             try {
				ab.setCardNumber(result.getLong("cardNumber"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             try {
				ab.setDateExpiration(result.getString("dateExpiration"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             ab.setCvv(result.getInt("cvv"));
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;

		
		
		
		
	}
	 
}

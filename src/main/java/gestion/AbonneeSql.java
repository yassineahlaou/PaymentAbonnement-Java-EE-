package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import authentification.ConnectionMySql;


//Mapping objet relationel
//en utilisant --hibernate-- tout cela peur ce faire en 2 3 lignes
public class AbonneeSql implements Iabonnee {

	@Override
	public List<Abonne> listAbonnes() {
		// TODO Auto-generated method stub
		List<Abonne> abonnes = new ArrayList<Abonne>();
		Connection cnx = ConnectionMySql.getConn();
		try {
			PreparedStatement prepered = cnx.prepareStatement("select * from abonnes ");
			ResultSet rs = prepered.executeQuery();
			while (rs.next())
			{
				Abonne a = new Abonne();
				try {
					a.setNomComplet(rs.getString("nomComplet"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					a.setEmail(rs.getString("email"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					a.setPassword(rs.getString("password"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					a.setPhone(rs.getString("phone"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				a.setMontant(rs.getDouble("montant"));
				try {
					a.setCardNumber(rs.getLong("cardNumber"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					a.setDateExpiration(rs.getString("dateExpiration"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setCvv(rs.getInt("cvv"));
				a.setSolde(rs.getDouble("solde"));
				abonnes.add(a);
			}
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return abonnes;
	}

	@Override
	public List<Abonne> Abonneperkw(String kw) {
		// TODO Auto-generated method stub
		List<Abonne> abonnes = new ArrayList<Abonne>();
		Connection cnx = ConnectionMySql.getConn();
		try {
			PreparedStatement prepered = cnx.prepareStatement("select * from abonnes where nomComplet Like ? ");
			prepered.setString(1, "%"+kw+"%");
			ResultSet rs = prepered.executeQuery();
			while (rs.next())
			{
				Abonne a = new Abonne();
				try {
					a.setNomComplet(rs.getString("nomComplet"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					a.setEmail(rs.getString("email"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					a.setPassword(rs.getString("password"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					a.setPhone(rs.getString("phone"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				a.setMontant(rs.getDouble("montant"));
				try {
					a.setCardNumber(rs.getLong("cardNumber"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					a.setDateExpiration(rs.getString("dateExpiration"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
				a.setCvv(rs.getInt("cvv"));
				a.setSolde(rs.getDouble("solde"));
				abonnes.add(a);
			}
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return abonnes;
	}

	@Override
	public Abonne getAbonne(String nomComplet) {
		// TODO Auto-generated method stub
		Abonne a = null;
		Connection cnx = ConnectionMySql.getConn();
		try {
			
			PreparedStatement prepered = cnx.prepareStatement("select * from abonnes where nomComplet =  ? ");
			prepered.setString(1, nomComplet);
			ResultSet rs = prepered.executeQuery();
			if (rs.next())
			{
				
				
				a = new Abonne();
				try {
					a.setNomComplet(rs.getString("nomComplet"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					a.setEmail(rs.getString("email"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					a.setPassword(rs.getString("password"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					a.setPhone(rs.getString("phone"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setMontant(rs.getDouble("montant"));
				//a.setCardNumber(rs.getInt("cardNumber"));
				//a.setDateExpiration(rs.getString("dateExpiration"));
				//a.setCvv(rs.getInt("cvv"));
				
			}
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (a == null) {
			throw new RuntimeException("Abonné non trouvé");
		}
		return a;
	}

	@Override
	public void updateAbonne(Abonne a) {
		// TODO Auto-generated method stub
		Connection cnx = ConnectionMySql.getConn();
		try {
			PreparedStatement prepered = cnx.prepareStatement("UPDATE   abonnes SET  email = ? , password = ? ,  phone = ? , montant = ?  where nomComplet  = ?");
			prepered.setString(5, a.getNomComplet());
			
			prepered.setString(1, a.getEmail());
			prepered.setString(2, a.getPassword());
			prepered.setString(3, a.getPhone());
			prepered.setDouble(4, a.getMontant());
			
			prepered.executeUpdate();
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteAbonne(String nomComplet) {
		// TODO Auto-generated method stub
		
		Connection cnx = ConnectionMySql.getConn();
		try {
			PreparedStatement prepered = cnx.prepareStatement("DELETE from abonnes where nomComplet = ?");
			prepered.setString(1, nomComplet);
			
			prepered.executeUpdate();
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addAbonne(Abonne a) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			Connection cnx = ConnectionMySql.getConn();
			try {
				PreparedStatement prepered = cnx.prepareStatement("INSERT INTO  abonnes (nomComplet , email, password, phone, montant) values (? , ? , ? , ?, ?)");
				prepered.setString(1, a.getNomComplet());
				prepered.setString(2, a.getEmail());
				prepered.setString(3, a.getPassword());
				prepered.setString(4, a.getPhone());
				prepered.setDouble(5, a.getMontant());
				prepered.executeUpdate();
				prepered.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	

	
	

}
package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import authentification.ConnectionMySql;

public class AbonneCourantSql implements IabonneCourant {

	@Override
	public void updateAbonneCourant(Abonne a) {
		// TODO Auto-generated method stub
		Connection cnx = ConnectionMySql.getConn();
		try {
			PreparedStatement prepered = cnx.prepareStatement("UPDATE   abonnes SET  montant = ? , cardNumber = ? , dateExpiration = ? ,  cvv = ? , solde = ?  where nomComplet  = ?");
			prepered.setString(6, a.getNomComplet());
			prepered.setDouble(1, a.getMontant() );
			prepered.setLong(2, a.getCardNumber());
			prepered.setString(3, a.getDateExpiration());
			prepered.setInt(4, a.getCvv());
			prepered.setDouble(5, a.getSolde());
			
			
			prepered.executeUpdate();
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Abonne> listAbonnes() {
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
					a.setCardNumber(rs.getInt("cardNumber"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					a.setDateExpiration(rs.getString("dateExpiration"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
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

}

package gestion;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Abonne implements Serializable{
	
	private String nomComplet;
	
	private String email;
	private String  password;
	private String phone;
	private double montant;
	private long cardNumber;
	private String dateExpiration;
	private int cvv;
	private double solde;
	
	
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet)  {
		
		this.nomComplet = nomComplet;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email)  {
		
		this.email = email;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password)  {
		
		this.password = password;
		
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone)  {
		
		this.phone = phone;
		
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long numC)  {
		
		this.cardNumber = numC;
		
	}
	public String getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(String dateExpiration)  {
		
		
		
			/*SimpleDateFormat formatt = new SimpleDateFormat("MM/YYYY");
			Date  ndate = new Date();  
			 String today = formatt.format(ndate) ;
			
			try {
				Date date1 = formatt.parse(dateExpiration);
			
			
				Date date2 = formatt.parse(today);
			
			if (date1.compareTo(date2) <= 0) {
				throw new BeanException("This card has expired");
			}
			else {
				this.dateExpiration = dateExpiration;
			}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
			this.dateExpiration = dateExpiration;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public Abonne(String nomComplet, String email, String password, String phone, double montant, long cardNumber,
			String dateExpiration, int cvv, double solde) {
		super();
		this.nomComplet = nomComplet;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.montant = montant;
		this.cardNumber = cardNumber;
		this.dateExpiration = dateExpiration;
		this.cvv = cvv;
		this.solde = solde;
	}
	public Abonne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

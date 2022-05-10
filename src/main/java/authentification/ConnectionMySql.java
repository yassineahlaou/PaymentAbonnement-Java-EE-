package authentification;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;



public class ConnectionMySql {
	Connection conn = null;
    public static Connection getConn(){
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
           
            //this line is to introduce our database that we have already created
            //Connection conn=DriverManager.getConnection("jdbc:mysql://en1ehf30yom7txe7.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/mvsxb2g170i27chr", "ic83y1lf6chwnywf", "dmc6swq4t98mmil1");
        	//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/gestionabonnee", "root", "");
        	Connection conn=DriverManager.getConnection("jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_6ca9ef10b560dd2", "bb3d3393c3c25c", "c190e58f");
        	return conn;

            	//don't do SQLExeption do just Exeption
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }


    }

	

}



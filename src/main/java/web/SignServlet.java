package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestion.Abonne;
import inscription.Search;
import inscription.Sign;
import inscription.SignSql;


@WebServlet("/inscription")
public class SignServlet extends HttpServlet  {
	
	private SignSql ss;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ss = new SignSql();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action  = request.getParameter("action");
		if (action.equals( "Sign In"))
		{
			int i = 0;
		
		String nomC = request.getParameter("nomComplet");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        Abonne a = new Abonne();
        
        
        Search sh = new Search();
        if (nomC.equals(""))
        {
        	request.setAttribute("error1", "Fullname field should not be empty");
			i=i+1;
        }
        else {
        	a.setNomComplet(nomC);
        	
        }
        if (email.equals("")) {
        	request.setAttribute("error2", "Email field should not be empty");
			i=i+1;
        }
        else {
        	a.setEmail(email);
        }
        if (password.equals("")) {
        	request.setAttribute("error3", "password field should not be empty");
			i=i+1;
        }
        else {
        	a.setPassword(password);
        }
        if (phone.equals("")) {
        	request.setAttribute("error4", "Phone field should not be empty");
			i=i+1;
        }
        else {
        	a.setPhone(phone);
        }
       
        
        if (sh.search(a)) {
        	request.setAttribute("error0", "This user already exists");
        	i = i +1;
        	
        }
        if (i == 0)
        {
        	ss.sign(a);
        	request.getRequestDispatcher("loginn.jsp").forward(request, response);
        	
        }
	}
		request.getRequestDispatcher("inscription.jsp").forward(request, response);
		
	}
	

}
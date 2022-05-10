package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authentification.Login;
import authentification.LoginSql;
import gestion.Abonne;



public class LoginServelet extends HttpServlet {
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//login = new LoginSql();
	}
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request.setAttribute("log", new Login());
			request.getRequestDispatcher("loginn.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomC = request.getParameter("nomComplet");
        String pass = request.getParameter("password");
        
        //boolean st = login.connect(loginnn);
        //loginnn.setSt(st);
        //request.setAttribute("log", loginnn);
        if (nomC.equals("admin") && pass.equals("admin")) {
		    //HttpSession session = request.getSession();
		    // session.setAttribute("username",username);
		    response.sendRedirect("AbonneView.jsp");
		}
        else {
        LoginSql login = new LoginSql();
        
        Abonne ab  = login.connect(nomC, pass);
        if(ab!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("logUser", ab);
                    response.sendRedirect("loginsuccess.jsp");
        }
        else
        {
        	request.setAttribute("echec", "SVP vérifiez vos infos");
        	request.getRequestDispatcher("loginn.jsp").forward(request, response);
        }
        }
        
        
       /* if (login.connect(loginnn)) {
		    //HttpSession session = request.getSession();
		    // session.setAttribute("username",username);
		    response.sendRedirect("BookView.jsp");
		} else {
			
			if (username.equals("") || password.equals("")) {
				request.getRequestDispatcher("fill.jsp").forward(request, response);
			}
			else {
		    //session.setAttribute("user", username);
	        request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
        */
        
      
	}

}

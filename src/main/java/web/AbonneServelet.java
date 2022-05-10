package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestion.Abonne;
import gestion.AbonneeSql;
import gestion.BeanException;


@WebServlet("/AbonneView")
public class AbonneServelet extends HttpServlet {
	private AbonneeSql gest;
	
	@Override
	public void init() throws ServletException {
		gest = new AbonneeSql();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SearchAbonneModel sb = new SearchAbonneModel();
		request.setAttribute("sm", sb);
		String action  = request.getParameter("action");
		if (action != null)
		{
			if (action.equals("Search"))
			{
				String key = request.getParameter("keyword");
				sb.setKeyword(key);
				List<Abonne> abonnes = gest.Abonneperkw(sb.getKeyword());
				sb.setAbonnes(abonnes);
				
			}
			else if (action.equals("Delete"))
			{
				
					String nomC = request.getParameter("nomComplet");
					gest.deleteAbonne(nomC);
					sb.setAbonnes(gest.listAbonnes());
				
			}
			else if (action.equals("Edit")) {
				String nomC = request.getParameter("nomComplet");
				Abonne a = gest.getAbonne(nomC);
				sb.setA(a);
				sb.setMode("edit");
				
				sb.setAbonnes(gest.listAbonnes());
				
				
				
			}
			else if (action.equals("Save"))
			{
				int j=0;
				try {
				
					String nomC = request.getParameter("nomComplet");
				
				
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					String phone = request.getParameter("phone");
					
					double amo =  Double.parseDouble(request.getParameter("montant"));
					String mo =  String.valueOf(amo);
					
					String mod = request.getParameter("mode");
					if (!nomC.equals("")) {
						sb.getA().setNomComplet(nomC);
					}
					else {
						request.setAttribute("error1", "Fullname should not be empty");
						j=j+1;
					}
					if (!email.equals(""))
					{
					sb.getA().setEmail(email);
					}
					else {
						request.setAttribute("error2", "Email should not be empty");
						j=j+1;
					}
					if (!password.equals(""))
					{
					sb.getA().setPassword(password);
					}
					else {
						request.setAttribute("error3", "Password should not be empty");
						j=j+1;
					}
					if (!phone.equals(""))
					{
					sb.getA().setPhone(phone);
					}
					else {
						request.setAttribute("error4", "Phone should not be empty");
						j=j+1;
					}
					if (!mo.equals(""))
					{
						sb.getA().setMontant(amo);
					}
					else {
						request.setAttribute("error5", "Amount should not be empty");
						j=j+1;
					}
					
					if (j == 0)
					{
					sb.setMode(mod);
					if (sb.getMode().equals("add"))
					{
					gest.addAbonne(sb.getA());
					
					sb.setAbonnes(gest.listAbonnes());
					request.setAttribute("success1", "Abonné a été ajouté");
					}
					else if (sb.getMode().equals("edit")) {
						
						gest.updateAbonne(sb.getA());
						
						sb.setAbonnes(gest.listAbonnes());
						request.setAttribute("success2", "Abonné a été modifié");
					}
					}
					
					
					
					
				}
				catch (Exception e)
				{
					sb.setError(e.getMessage());
					
				}
				
			}
			
					
		}
		
		
		request.getRequestDispatcher("AbonneView.jsp").forward(request, response);
	}
	



}

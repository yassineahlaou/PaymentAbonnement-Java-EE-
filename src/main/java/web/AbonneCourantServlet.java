package web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import gestion.Abonne;
import gestion.AbonneCourantSql;
import gestion.BeanException;

@WebServlet("/loginsuccess")
public class AbonneCourantServlet extends HttpServlet{
	private AbonneCourantSql abc;
	@Override
	public void init() throws ServletException {
		abc = new AbonneCourantSql();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SearchAbonneCourant sb = new SearchAbonneCourant();
		request.setAttribute("sm", sb);
		String action  = request.getParameter("action");
		
		if (action.equals("Valider")) {
			int i = 0;
			String nomC = request.getParameter("nomComplet");
			String email = request.getParameter("email");
			Abonne a = abc.getAbonne(nomC);
			sb.setA(a);
			try { 
			long numC = Long.parseLong(request.getParameter("cardNumber"));
			String test1 =  String.valueOf(numC);
			String date = request.getParameter("dateExpiration");
			int cv = Integer.parseInt(request.getParameter("cvv"));
			String test2 =  String.valueOf(cv);
			double sol = Double.parseDouble(request.getParameter("solde"));
			String so =  String.valueOf(sol);
			double amo =  Double.parseDouble(request.getParameter("montant"));
			
			if (amo == 0)
			{
				request.setAttribute("error0", "You have nothing to pay. You're all set!!");
				i = i+1;
			}
			else
			{
			
			if ( test1.length() == 16 )
			{
				sb.getA().setCardNumber(numC);
			}
			else
			{
				request.setAttribute("error1", "Card Number must be 16 digits");
				i = i +1;
			}
			if (!date.equals(""))
			{
				SimpleDateFormat formatt = new SimpleDateFormat("MM/YYYY");
				Date  ndate = new Date();  
				 String today = formatt.format(ndate) ;
				
				
					
					try {
						Date date1 = formatt.parse(date);
						Date date2 = formatt.parse(today);
						if (date1.compareTo(date2) > 0) {
							sb.getA().setDateExpiration(date);
						}
						else
						{
							request.setAttribute("error2", "This card has expired");
							i=i+1;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						
					}
				
				
					
				
				
			}
			else {
				request.setAttribute("error3", "Date field should not be empty");
				i=i+1;
			}
				if (test2.length() == 3)
				{
				
				sb.getA().setCvv(cv);
				}
				else {
					request.setAttribute("error4", "CVV should  be 3 digits");
					i=i+1;
				}
				if (!so.equals(""))
				{
		


							if (amo <= sol) {
								sol = sol - amo;
								sb.getA().setMontant(0);
								sb.getA().setSolde(sol);
								
								
							}
							else
							{
								request.setAttribute("error5", "Your card balance is not enough to make this operation");
								i=i+1;
							}
		
					
				}
				else {
					request.setAttribute("error6", "Balance field should not be empty");
					i=i+1;
				}
			}
				if (i == 0)
				{
					
					
				abc.updateAbonneCourant(sb.getA());
				sb.setAbonnes(abc.listAbonnes());

				try {
			String path = request.getServletContext().getRealPath("/WEB-INF/Invoice.pdf");
			Document document = new Document();	
			
				PdfWriter.getInstance(document, new FileOutputStream(path));
				
					document.open();
				Paragraph para = new Paragraph("hi you me");
				Paragraph tab = new Paragraph("hi you me");
				/*document.add(tab);
				document.add(para);*/
				
				
				float col = 280f;
				float columnwidth[] = {col , col};
				PdfPTable table = new PdfPTable(2);
				BaseFont bf = BaseFont.createFont(
		                BaseFont.TIMES_ROMAN,
		                BaseFont.CP1252,
		                BaseFont.EMBEDDED);
		        Font font = new Font(bf, 12);
		        BaseFont bf1 = BaseFont.createFont( 
		        		BaseFont.TIMES_ROMAN,
		                BaseFont.CP1252,
		                BaseFont.EMBEDDED);
		        Font font1 = new Font( bf, 10, Font.BOLD);
		        
		        
				
				table.setWidthPercentage(columnwidth, PageSize.A4);
				PdfPCell c1 = new PdfPCell(new Phrase("INVOICE" , font));
				c1.setBackgroundColor(BaseColor.CYAN);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setBorder(0);
				c1.setPaddingTop(30f);
				c1.setPaddingBottom(30f);
				
				
				PdfPCell c2 = new PdfPCell(new Phrase("YassPay\n85000 Safi\n0691009722"));
				c2.setBackgroundColor(BaseColor.CYAN);
				
				c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
				c2.setBorder(0);
				c2.setPaddingTop(30f);
				c2.setPaddingBottom(30f);
				c2.setPaddingRight(10f);
				table.addCell(c1);
				table.addCell(c2);
				
				
				document.add(table);
				
				float cowidth[] = {80,300,100,80};
				PdfPTable table1 = new PdfPTable(4);
				table1.setWidthPercentage(cowidth, PageSize.A4);
				PdfPCell c3 = new PdfPCell(new Phrase("Costumer Information" , font1));
				c3.setColspan(4);
				c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				c3.setPaddingTop(30f);
				c3.setPaddingBottom(30f);
				PdfPCell c4 = new PdfPCell(new Phrase("Name" ,font1));
				
				c4.setPaddingTop(30f);
				c4.setPaddingBottom(30f);
				c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c4.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell c5 = new PdfPCell(new Phrase(nomC));
				
				c5.setPaddingTop(30f);
				c5.setPaddingBottom(30f);
				c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell c6 = new PdfPCell(new Phrase("Invoice No" , font1));
				
				c6.setPaddingTop(30f);
				c6.setPaddingBottom(30f);
				c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c6.setHorizontalAlignment(Element.ALIGN_CENTER);
				int randomInt = (int)(Math.random()*10000 + 1);
				Integer in = new Integer(randomInt);
				PdfPCell c7 = new PdfPCell(new Phrase(in.toString()));
				
				c7.setPaddingTop(30f);
				c7.setPaddingBottom(30f);
				c7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c7.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell c8 = new PdfPCell(new Phrase("Montant" , font1));
				c8.setPaddingTop(30f);
				c8.setPaddingBottom(30f);
				c8.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c8.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell c9 = new PdfPCell(new Phrase(String.valueOf(amo) , font1));
				c9.setPaddingTop(30f);
				c9.setPaddingBottom(30f);
				c9.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c9.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell c10 = new PdfPCell(new Phrase("Date" , font1));
				c10.setPaddingTop(30f);
				c10.setPaddingBottom(30f);
				c10.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c10.setHorizontalAlignment(Element.ALIGN_CENTER);
				SimpleDateFormat formattt = new SimpleDateFormat("dd/MM/YYYY");
				Date   newdate = new Date();  
				 String todayy = formattt.format(newdate) ;
				
				
				PdfPCell c11= new PdfPCell(new Phrase(todayy));
				c11.setPaddingTop(30f);
				c11.setPaddingBottom(30f);
				c11.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c11.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell c12= new PdfPCell(new Phrase("Card Number Used" , font1));
				c12.setPaddingTop(30f);
				c12.setPaddingBottom(30f);
				c12.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c12.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				
				
				PdfPCell c13= new PdfPCell(new Phrase(String.valueOf(numC)));
				
				c13.setColspan(3);
				c13.setPaddingTop(30f);
				c13.setPaddingBottom(30f);
				c13.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c13.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(c3);
				table1.addCell(c4);
				table1.addCell(c5);
				table1.addCell(c6);
				table1.addCell(c7);
				table1.addCell(c8);
				table1.addCell(c9);
				table1.addCell(c10);
				
				table1.addCell(c11);
				table1.addCell(c12);
				table1.addCell(c13);
				document.add(table1);
				Paragraph signitu = new Paragraph("Signatory", font1);
				signitu.setAlignment(Element.ALIGN_RIGHT);
				document.add(signitu);
				
				
				
				
			
			
			
			
			
			
			

			document.close();
			System.out.print("nice");
			
				}
				catch(Exception e)
				{
			e.printStackTrace();
			
			}
				Properties properties =  new Properties();
				properties.put("mail.smtp.auth", true);
				properties.put("mail.smtp.host", "smtp.gmail.com");
				properties.put("mail.smtp.port", 587);
				properties.put("mail.smtp.starttls.enable", true);
				properties.put("mail.transport.protocol", "smtp");
				
				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("yassineahlaou@gmail.com", "portorico07");
						
					}
					
					
				});
				
				MimeMessage message = new MimeMessage(session);
				
				try {
					message.setSubject("Payment Invoice");
					
					Address addressto = new InternetAddress(email);
					message.setRecipient(Message.RecipientType.TO, addressto);
					MimeMultipart multipart = new MimeMultipart();
					MimeBodyPart attachment = new MimeBodyPart();
					try {
						String pathh = request.getServletContext().getRealPath("/WEB-INF/Invoice.pdf");
						attachment.attachFile(new File(pathh));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent("<h1> Hello dear Client, Here is your invoice for your payment . Have a good day !</h1>", "text/html");
					multipart.addBodyPart(messageBodyPart);
					multipart.addBodyPart(attachment);
					message.setContent(multipart);
					Transport.send(message);
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.getRequestDispatcher("validatesuccess.jsp").forward(request, response);
				}
			
				
			
			
			}
			catch (NumberFormatException nfe) {
				  // Handle the condition when str is not a number.
				}
			
			
			
			
			
			
			
			
		}
		request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
	}

}

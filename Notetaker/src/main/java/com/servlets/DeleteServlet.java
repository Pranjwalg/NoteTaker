package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.myapp.Note;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {
		
		try {
			  int id= Integer.parseInt(request.getParameter("id").trim());
			     Session session=FactoryProvider.getFactory().openSession();
			     Note note=  session.get(Note.class, id);
			           Transaction transaction= session.beginTransaction();
			     session.delete(note);
                      transaction.commit();
			     session.close();
			     response.sendRedirect("showallnotes.jsp");
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	
	

}

package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.myapp.Note;

/**
 * Servlet implementation class Editservlet
 */
public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			   String title=request.getParameter("title");
			  String content=request.getParameter("content");
			  Session session=FactoryProvider.getFactory().openSession();
			   Transaction transaction=session.beginTransaction();
			
	int id=Integer.parseInt(request.getParameter("id"));
	
	
Note note=  session.get(Note.class,id);
			

note.setTitle(title);
note.setContent(content);
note.setAdddate(new Date());


transaction.commit();
			session.close();
			response.sendRedirect("showallnotes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}

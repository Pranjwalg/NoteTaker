package com.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.NTextType;

import com.helper.FactoryProvider;
import com.myapp.Note;

public class Savenote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Savenote() {
        super();
        
    }

	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			   String title=request.getParameter("title");
			  String content=request.getParameter("content");
			
			
	Note note=new Note();
	 note.setId(new Random().nextInt(10000));
	 note.setTitle(title);
	 note.setContent(content);
	 note.setAdddate(new Date());

	  
	   Session session=FactoryProvider.getFactory().openSession();
	   Transaction transaction=session.beginTransaction();
       session.save(note);

 transaction.commit();
		session.close();
		
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<h1 style='color:green;text-align:center;margin-top:35px'>data added successfully</h1>");
		
		

		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

}

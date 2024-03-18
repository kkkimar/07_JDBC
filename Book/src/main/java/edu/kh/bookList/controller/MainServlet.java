package edu.kh.bookList.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			String path = "/WEB-INF/views/main.jsp";
			
			// main.jsp로 포워드
			req.getRequestDispatcher(path).forward(req, resp);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
}

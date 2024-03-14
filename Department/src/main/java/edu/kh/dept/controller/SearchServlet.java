package edu.kh.dept.controller;

import java.io.IOException;

import edu.kh.dept.model.service.DepartmentService;
import edu.kh.dept.model.service.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/department/search")
public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			String keyword = req.getParameter("keyword"); //검색어
			
			// forward할 jsp 경로
			String path = "/WEB-INF/views/search.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			

				

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}

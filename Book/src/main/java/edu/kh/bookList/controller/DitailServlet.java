package edu.kh.bookList.controller;

import java.io.IOException;
import java.sql.SQLException;

import edu.kh.bookList.model.dto.BookList;
import edu.kh.bookList.model.service.BookListService;
import edu.kh.bookList.model.service.BookListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/detail")
public class DitailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BookListService service = new BookListServiceImpl();
		
		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		
		try {
			BookList bookList = service.selectOne(bookNo);
			
			if(bookList !=null) {
				req.setAttribute("bookList", bookList);
				String path = "/WEB-INF/views/detail.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

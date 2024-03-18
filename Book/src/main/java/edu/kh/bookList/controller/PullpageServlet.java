package edu.kh.bookList.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dto.BookList;
import edu.kh.bookList.model.service.BookListService;
import edu.kh.bookList.model.service.BookListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/sellectAll")
public class PullpageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BookListService service = new BookListServiceImpl();
		
		//모든 도서 조회
		try {
			
			List<BookList> bookList = service.sellectAll();
			
			req.setAttribute("bookList", bookList);
			
			String path = "/WEB-INF/views/sellectAll.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}

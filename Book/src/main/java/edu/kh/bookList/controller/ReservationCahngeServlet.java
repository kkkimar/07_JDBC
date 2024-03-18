package edu.kh.bookList.controller;

import java.io.IOException;
import java.sql.SQLException;

import edu.kh.bookList.model.service.BookListService;
import edu.kh.bookList.model.service.BookListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookList/changeReservation")
public class ReservationCahngeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//파라미터 얻기
		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		String bookReservation = req.getParameter("reservation");
		
		BookListService service = new BookListServiceImpl();
		
		try {
			
			int result = service.changeReservation(bookNo,bookReservation);

			resp.sendRedirect("/book/detail?bookNo="+bookNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

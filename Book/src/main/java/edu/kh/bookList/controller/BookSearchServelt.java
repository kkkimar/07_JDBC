package edu.kh.bookList.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.bookList.model.dto.BookList;
import edu.kh.bookList.model.service.BookListService;
import edu.kh.bookList.model.service.BookListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/book/search")
public class BookSearchServelt extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			String keyword = req.getParameter("keyword");
			
			BookListService service = new BookListServiceImpl();
			
			List<BookList> bookList = service.searchBook(keyword);
			
			//조회 결과
			String message = null;
			HttpSession session = req.getSession();
			
			//조회 결과 scop에 세팅
			req.setAttribute("bookList", bookList);
			
			if(bookList.isEmpty()) {//조회 실패
				message = "도서 목록에 해당 검색어가 없습니다";
			}else {
				message = "도서 목록 조회 성공";
			}
			
			session.setAttribute("message", message);
			
			String path = "/WEB-INF/views/search.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
}

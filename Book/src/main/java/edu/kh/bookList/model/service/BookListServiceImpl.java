package edu.kh.bookList.model.service;

import static edu.kh.bookList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dao.BookListDAO;
import edu.kh.bookList.model.dao.BookListDAOImpl;
import edu.kh.bookList.model.dto.BookList;

public class BookListServiceImpl implements BookListService {
	
	//dao 객체 생성
	BookListDAO dao = new BookListDAOImpl();
	

	// 도서 검색
	@Override
	public List<BookList> searchBook(String keyword) throws SQLException {

		Connection conn = getConnection();
		
		List<BookList> bookList = dao.searchBook(conn,keyword);
		
		close(conn);
		
		
		return bookList;
	}//searchBook
	
	
	// 모든 도서 조회
	@Override
	public List<BookList> sellectAll() throws SQLException {
		
		Connection conn = getConnection();
		
		List<BookList> bookList = dao.selectAll(conn);
		
		close(conn);
		
		return bookList;
	}//sellectAll
	
	// 도서 상세 조회
	@Override
	public BookList selectOne(int bookNo) throws SQLException {
		
		Connection conn = getConnection();
		
		BookList bookList = dao.selectOne(conn,bookNo);
		
		return bookList;
		
	}//selectOne
	
	
	//도서 예약
	@Override
	public int changeReservation(int bookNo, String bookReservation) throws SQLException {

		Connection conn = getConnection();
		
		int result = dao.changeReservation(conn,bookNo,bookReservation);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}//changeReservation
	
	
}

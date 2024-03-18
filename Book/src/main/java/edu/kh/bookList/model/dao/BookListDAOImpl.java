package edu.kh.bookList.model.dao;

import static edu.kh.bookList.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.bookList.model.dto.BookList;


public class BookListDAOImpl implements BookListDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	//기본 생성자
	public BookListDAOImpl() {
		
		try {
			
			prop = new Properties();
			String path = BookListDAOImpl.class.getResource("/edu/kh/bookList/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//도서 검색
	@Override
	public List<BookList> searchBook(Connection conn, String keyword) throws SQLException {

		List<BookList> bookList = new ArrayList<BookList>();
		
		try {
			
			
			String sql = prop.getProperty("searchBook");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int bookNo = rs.getInt("BOOK_NO");
				String bookTitle = rs.getString("BOOK_TITLE");
				String bookReservation = rs.getString("BOOK_RESERVATION");
				
				BookList book = new BookList(bookNo, bookTitle, bookReservation);
				
				bookList.add(book);
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return bookList;
	}//searchBook
	
	//도서 전체 조회
	@Override
	public List<BookList> selectAll(Connection conn) throws SQLException {
		
		List<BookList> bookList = new ArrayList<BookList>();
		
		try {
			
			String sql = prop.getProperty("sellectAll");
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int bookNo = rs.getInt("BOOK_NO");
				String bookTitle = rs.getString("BOOK_TITLE");
				String bookIntro = rs.getString("BOOK_INTRO");
				String bookReservation = rs.getString("BOOK_RESERVATION");
				
				BookList book = new BookList(bookNo, bookTitle, bookIntro, bookReservation);
				
				bookList.add(book);
				
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		return bookList;
	}//selectAll
	

	//도서 상세
	@Override
	public BookList selectOne(Connection conn, int bookNo) throws SQLException {

		BookList bookList = null;
		
		try {
			
			String sql = prop.getProperty("selectOne");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				bookList = new BookList();
				bookList.setBookNo(rs.getInt("BOOK_NO"));
				bookList.setBookTitle(rs.getString("BOOK_TITLE"));
				bookList.setBookReservation(rs.getString("BOOK_RESERVATION"));
				bookList.setBookInto(rs.getString("BOOK_INTRO"));
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return bookList;
		
		
	}//selectOne
	
	
	// 도서 예약
	@Override
	public int changeReservation(Connection conn, int bookNo, String bookReservation) throws SQLException {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("changeReservation");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bookReservation);
			pstmt.setInt(2, bookNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		
		return result;
	}
	
	
	
}

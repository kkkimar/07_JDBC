package edu.kh.bookList.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dto.BookList;

public interface BookListDAO {

	
	/** 도서 검색
	 * @param conn
	 * @param keyword
	 * @return BookList
	 */
	List<BookList> searchBook(Connection conn, String keyword) throws SQLException;

	/** 도서 전체 조회
	 * @param conn
	 * @return BookList
	 * @throws SQLException
	 */
	List<BookList> selectAll(Connection conn) throws SQLException;

	
	
	/** 도서 상세 조회
	 * @param conn
	 * @param bookNo
	 * @return
	 * @throws SQLException
	 */
	BookList selectOne(Connection conn, int bookNo)throws SQLException;
	

	/** 도서 예약
	 * @param conn
	 * @param bookNo
	 * @param bookReservation
	 * @return
	 */
	int changeReservation(Connection conn, int bookNo, String bookReservation) throws SQLException;

	
	
	

}

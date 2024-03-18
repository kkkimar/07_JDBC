package edu.kh.bookList.model.service;

import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dto.BookList;

public interface BookListService {

	/** 도서 검색
	 * @param keyword
	 * @return bookList
	 * @throws SQLException
	 */
	List<BookList> searchBook(String keyword) throws SQLException;

	/** 모든 도서 조회
	 * @return bookList
	 * @throws SQLException
	 */
	List<BookList> sellectAll() throws SQLException;

	
	/** 상세 조회
	 * @param bookNo
	 * @return bookList
	 * @throws SQLException
	 */
	BookList selectOne(int bookNo) throws SQLException;

	/** 도서 예약
	 * @param bookNo
	 * @param bookReservation
	 * @return result
	 */
	int changeReservation(int bookNo, String bookReservation) throws SQLException;

}

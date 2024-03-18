package edu.kh.bookList.model.dto;

public class BookList {

	private int bookNo;
	private String bookTitle;
	private String bookInto;
	private String bookReservation;
	
	
	//기본 생성자
	public BookList() {
	}


	//매개변수 생성자
	public BookList(int bookNo, String bookTitle, String bookInto, String bookReservation) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookInto = bookInto;
		this.bookReservation = bookReservation;
	}
	
	

  //매개변수 생성자
	public BookList(int bookNo, String bookTitle, String bookReservation) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookReservation = bookReservation;
	}


	//getter/setter
	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookInto() {
		return bookInto;
	}


	public void setBookInto(String bookInto) {
		this.bookInto = bookInto;
	}


	public String getBookReservation() {
		return bookReservation;
	}


	public void setBookReservation(String bookReservation) {
		this.bookReservation = bookReservation;
	}


	@Override
	public String toString() {
		return "BookList [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookInto=" + bookInto + ", bookReservation="
				+ bookReservation + "]";
	}
	
	

	
	
}

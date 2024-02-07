package vo;

public class Book {
	//멤버 변수
	private String bookID;
	private String bookTitle;
	private String bookAuthor;
	private boolean bookAvalible;
	
	//기본 생성자
	public Book() {
		super();
	}

	// 생성자
	public Book(String bookID, String bookTitle, String bookAuthor, boolean bookAvalible) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookAvalible = bookAvalible;
	}
	
	//getter, setter
	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public boolean isBookAvalible() {
		return bookAvalible;
	}

	public void setBookAvalible(boolean bookAvalible) {
		this.bookAvalible = bookAvalible;
	}
	
	//일반메서드
	@Override
	public String toString() {
		if (bookAvalible == true) 
			return "책 아이디 : " + bookID + ", 책 제목 : " + bookTitle + ", 책 저자 : " + bookAuthor + ", 대출 가능 여부 : 가능";
		else return "책 아이디 : " + bookID + ", 책 제목 : " + bookTitle + ", 책 저자 : " + bookAuthor + ", 대출 가능 여부 : 불가능";
		
	}
		
	
}

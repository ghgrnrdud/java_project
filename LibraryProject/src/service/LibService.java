package service;



import vo.Book;
import vo.Customer;

public interface LibService {
	
	/**
	 * 전달받은 Customer객체를 리스트에 추가저장한다.
	 * @param customer 리스트에 추가할 Customer객체
	 * @return 회원가입 완료되면 true, 안되면 false
	 */
	public boolean insert(Customer customer);
	
	/**
	 * 전달받은 번호를 리스트에서 검색한다. 
	 * @param id 검색할 회원 번호
	 * @return 있으면 회원 정보, 없으면 null
	 */
	public Customer searchCustomer(String id);
	
	/**
	 * 회원 이름과 대출중 책을 전달받아 수정한다.
	 * @param customer 수정할 회원 이름과 대출중인 책(반납했으면 반납)
	 * @return 수정 여부
	 */
	public boolean update(Customer customer);
	
	/**
	 * 회원 번호를 이용해 해당 회원 정보를 리스트에서 삭제하고 true를 리턴한다.
	 * @param id 삭제할 회원 번호
	 * @return boolean 삭제 여부 리턴 (삭제 완료 시 true, 삭제 실패 시 false)
	 */
	public boolean delete(String id);
	
	
	/**
	 * 회원 id 조회
	 * @param id 
	 * @return 회원 id가 있는 인덱스값 return 없으면 -1
	 */
	public int searchIndex(String id);
	
	/**
	 * 책 id 조회
	 * @param bookid
	 * @return 책 id가 있는 인덱스값 return 없으면 -1
	 */
	public int searchBookIndex(String bookid);
	
	/**
	 * 도서 추가
	 * @param book 리스트에 추가할 Book객체
	 * @return 추가 성공시 true, 실패 false
	 */
	public boolean insertBook(Book book);
	
	/**
	 * 책 정보 조회
	 * @param bookTitle 책 제목 넣으면 
	 * @return 리스트 인덱스 값 주면 되지
	 */
	public Book searchBook(String bookTitle);
	
	/**
	 * 책 대출
	 * @param bookid 책 id로 빌림
	 * @return 대출 성공시 true, 실패시 false
	 */
	public boolean borrowBook(String bookTitle); 
	
	/**
	 * 책 반납
	 * @param bookid 책 id로 반납
	 * @return 반납 성공시 true, 실패시 false
	 */
	public boolean returnBook(String bookTitle);

	
	
}

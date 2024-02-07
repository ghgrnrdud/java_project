package vo;

import java.util.ArrayList;

public class Customer {
	//멤버변수
	private String id;
	private String name;
	private ArrayList<Book> borringBook;
	
	//기본생성자
	public Customer() {
		super();
	}
	
	//생성자
	public Customer(String id, String name, ArrayList<Book> borringBook) {
		super();
		this.id = id;
		this.name = name;
		this.borringBook = borringBook;
	}
	
	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Book> getBorringBook() {
		return borringBook;
	}

	public void setBorringBook(ArrayList<Book> borringBook) {
		this.borringBook = borringBook;
	}
	
	//일반 메서드
	@Override
	public String toString() {
		if (borringBook == null) 
			return name + "님 아이디 : " + id + " 현재 대출중인 책 : 없음";
		else return name + "님 아이디 : " + id + " 현재 대출중인 책 : " + borringBook;
		
	}
	
}

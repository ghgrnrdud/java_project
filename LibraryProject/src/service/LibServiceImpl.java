package service;


import java.util.ArrayList;

import vo.Book;
import vo.Customer;

public class LibServiceImpl implements LibService{
	private ArrayList<Customer> coustomerList = new ArrayList<>();
			ArrayList<Book> bookList = new ArrayList<>();
	
	@Override
	public boolean insert(Customer customer) {
		//System.out.println(customer);
		if (coustomerList.add(customer)) return true;
		return false;
	}

	@Override
	public Customer searchCustomer(String id) {
		int i;
		for(i = 0; i < coustomerList.size(); ++i) {
			if(coustomerList.get(i).getId().equals(id)) { 
				return coustomerList.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean update(Customer customer) {
		int searchIndex = searchIndex(customer.getId());
		if (searchIndex != -1) {
			coustomerList.add(searchIndex, customer);
			return true;
		}
		return false;
	}//end update

	@Override
	public boolean delete(String id) {
		Customer customer = searchCustomer(id);
		if (coustomerList.remove(customer)) return true;
		return false;
	}//end delete

	
	@Override
	public int searchIndex(String id) {
		int i;
		for(i = 0; i < coustomerList.size(); ++i) {
			if(coustomerList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}//end searchIndex

	@Override
	public int searchBookIndex(String bookid) {
		int i;
		for(i = 0; i < bookList.size(); ++i) {
			if(bookList.get(i).getBookID().equals(bookid)) {
				return i;
			}
		}
		return -1;
	}//end searchBookIndex

	@Override
	public boolean insertBook(Book book) {
		if (bookList.add(book)) return true;
		return false;
	}//end insertBook

	@Override
	public Book searchBook(String bookTitle) {
		int i;
		for(i = 0; i < bookList.size(); ++i) {
			if(bookList.get(i).getBookTitle().equals(bookTitle)) { 
				return bookList.get(i);
			}
		}
		return null;
	}//end searchBook

	@Override
	public boolean borrowBook(String bookid) {
		int num = searchBookIndex(bookid);
		boolean yn = bookList.get(num).isBookAvalible();
		if (yn == true) {
			bookList.get(num).setBookAvalible(false);
			return true;
		}
		return false;
	}

	@Override
	public boolean returnBook(String bookid) {
		int num = searchBookIndex(bookid);
		boolean yn = bookList.get(num).isBookAvalible();
		if (yn == false) {
			bookList.get(num).setBookAvalible(true);
			return true;
		}
		return false;
	}

}

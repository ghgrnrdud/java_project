package UI;

import java.util.ArrayList;
import java.util.Scanner;

import service.LibService;
import service.LibServiceImpl;
import vo.Book;
import vo.Customer;

/**
 * 사용자 인터페이스
 */
public class LibraryUI {
	Scanner input = new Scanner(System.in);
	LibService service = new LibServiceImpl();
	
	//기본생성자
	public LibraryUI() {
		String choice;
		while(true) {
			mainMenu();
			choice = input.next();

			switch(choice) {
			case "1": //등록
				addcustomer();
				break;
			case "2": //삭제
				delete();
				break;
			case "3": //조회
				Print();
				break;
			case "4": //수정
				update();
				break;
			case "5": //도서추가
				addbook();
				break;
			case "6": //도서조회
				bookPrint();
				break;
			case "7": //도서대출
				borrowBook();
				break;
			case "8":
				returnBook();
				break;
			case "0":
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	/**
	 * 메인 메뉴
	 */
	public void mainMenu() {
		System.out.println("===[ 도서관 관리 ]===");
		System.out.println(" 1. 회원 가입");
		System.out.println(" 2. 회원 탈퇴");
		System.out.println(" 3. 회원 조회");
		System.out.println(" 4. 회원 수정");
		System.out.println(" 5. 도서 등록");
		System.out.println(" 6. 도서 조회");
		System.out.println(" 7. 도서 대출");
		System.out.println(" 8. 도서 반납");
		System.out.println(" 0. 종 료");
		System.out.println("===============");
		System.out.print  ("  > 선택: ");
	}
	
	public void addcustomer() {
		String id, name;
		System.out.println("[ 회원 가입 ]");
		
		System.out.print("> 회원아이디 : "); id = input.next();
		
		int searchIndex = service.searchIndex(id);
		if(searchIndex != -1) {
			System.out.println("중복된 회원 아이디입니다.");
			return;
		}
		
		System.out.print("> 회원 이름 : "); name = input.next();
		//System.out.print("> 대출 중인 책 : "); name = input.next();
		
		Customer coustomer  = new Customer(id, name, null);
		boolean result = service.insert(coustomer);
		if(result) System.out.println("회원 가입 되었습니다.");
	}//end add
	
	public void delete() {
		System.out.println("[ 회원 탈퇴 ]");
		System.out.print("> 탈퇴할 회원 아이디 > ");
		input.nextLine();
		
		String id = input.nextLine();
		int ID = service.searchIndex(id);
		
		if(ID == -1) {
			System.out.println("[ 정보 ] 회원이 존재하지 않습니다.");
			return;
		}	
		
		boolean result = service.delete(id);
		if(result) System.out.println("[ 정보 ] 탈퇴 되었습니다.");
	}//end delete
	
	
	public void Print() {
		System.out.println("[ 회원 조회 ]");
		System.out.print("> 회원아이디 : "); String id = input.next();
		int ID = service.searchIndex(id);
		
		if(ID == -1) {
			System.out.println("[ 정보 ] 회원이 존재하지 않습니다.");
			return;
		}	
		
		Customer list = service.searchCustomer(id);
		System.out.print("> " + id + "님의 정보 : ");
		System.out.println(list);
	}//end print
	
	public void update() {
		System.out.println("[ 회원 수정 ]");
		System.out.print("수정할 회원의 아이디 > ");
		input.nextLine();
		
		String id = input.nextLine();
		int ID = service.searchIndex(id);
		
		if(ID == -1) {
			System.out.println("[ 정보 ] 회원이 존재하지 않습니다.");
			return;
		}	
		
		System.out.print("수정할 회원 이름 > ");
		String name = input.nextLine();
		Customer customer = new Customer(id, name, null);
		
		boolean result = service.update(customer);
		if(result) System.out.println("[ 정보 ] 수정되었습니다.");
		System.out.print("수정된 회원 정보 : ");
		System.out.println(customer);
	}//end update
	
	public void addbook() {
		System.out.println("[ 도서 등록 ]");
		
		System.out.print("> 책 아이디 : "); String id = input.next();
		
		int searchIndex = service.searchBookIndex(id);
		if(searchIndex != -1) {
			System.out.println("중복된 책 아이디입니다.");
			return;
		}
		
		System.out.print("> 책 제목 : "); String title = input.next();
		System.out.print("> 책 저자 : "); String Author = input.next();
		//System.out.print("> 대출 여부 : "); boolean Avalible = input.nextBoolean();
		
		Book Book  = new Book(id, title, Author, true);
		boolean result = service.insertBook(Book);
		if(result) System.out.println("도서 등록 되었습니다.");
		
	}//end addbook
	
	public void bookPrint() {
		System.out.println("[ 도서 조회 ]");
		System.out.print("> 책 제목 : "); String name = input.next();
		Book book = service.searchBook(name);
		
		if(book == null) {
			System.out.println("[ 정보 ] 책이 존재하지 않습니다.");
			return;
		}	
		
		//Customer list = service.searchCustomer(id);
		System.out.print("> 책의 정보 : ");
		System.out.println(book);
	}//end bookPrint
	
	
	public void borrowBook() {
		System.out.println("[ 도서 대출 ]");
		System.out.print("> 대출 할 책 아이디 : "); String id = input.next();
		int idd = service.searchBookIndex(id);
		
		if(idd == -1) {
			System.out.println("[ 정보 ] 책이 존재하지 않습니다.");
			return;
		}

		boolean yn = service.borrowBook(id);
		if(yn == true) 
			System.out.println("> 대출 되었습니다.");
		else System.out.println("> 대출이 불가합니다.");	
	}//end borrowBook
	
	public void returnBook() {
		System.out.println("[ 도서 반납 ]");
		System.out.print("> 반납 할 책 아이디 : "); String id = input.next();
		int idd = service.searchBookIndex(id);
		
		if(idd == -1) {
			System.out.println("[ 정보 ] 책이 존재하지 않습니다.");
			return;
		}
		
		boolean yn = service.returnBook(id);
		if(yn == true) 
			System.out.println("> 반납 되었습니다.");
		else System.out.println("> 반납이 불가합니다.");	
	}//end returnbook
	
}//end class

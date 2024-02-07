package service;

import java.util.Scanner;

import VO.Fitness;

public class FitnessService {
	Scanner keyin = new Scanner(System.in);	//우리멤버. main이 호출되면 자동으로 생성되도록 만들어짐. 
	Fitness fitness;  //FitnessMain 클래스의 우리멤버로 선언만.(메모리x, 객체x). 즉, Fitness를 통째로 올려놓은 것과 마찬가지.
	
	public FitnessService() {
//		Fitness member1 = new Fitness();  //에러남. 패키지가 다르면 못 불러옴. so import시켜줘야함.
//		member1.output();
//		
//		Fitness member2 = new Fitness("1", "홍길동", 180, 88);
//		member2.output();
//		
//		member2.setWeight(70);
//		member2.output();
//		
//		member2.setHeight(175);
//		member2.output();
//		FitnessService service = new FitnessService(); //객체를 생성하면 static main과 non-static인 create, menu를 이을 수 있음. 
		
		String choice;
		
		while (true) {
			//service.menu(); 
			menu();                         
			choice = keyin.next();  //static에서 non-static을 호출하는거니까 service.하는거임. 
			
			switch(choice) {
			case "1" : create(); break;
			case "2" : read(); break;
			case "3" : update(); break;
			case "4" : delete(); break;
			case "0" : System.out.println("## 프로그램을 종료합니다."); return;
			default : System.out.println("## 메뉴를 다시 선택하세요"); keyin.nextLine();
			}
		}//end while
		
	}//end 생성자
	
	public void menu() {
		System.out.println("===[ 디마 피트니스 회원관리 ]===");
		System.out.println("          1) 회원등록");
		System.out.println("          2) 회원조회");
		System.out.println("          3) 정보수정");
		System.out.println("          4) 탈	   퇴");
		System.out.println("          0) 종    료");
		System.out.println("================================");
		System.out.print  ("              선택 : ");
	}//end menu
	
	private void create() {
		System.out.println(" [ 회원 등록 ] ");
		String id, name; 		// 지역변수
		double weight, height;	
		
		System.out.print(" > 아이디 : "); id = keyin.next();   // create랑 scanner는 non-static임. 
		System.out.print(" > 이  름 : "); name = keyin.next();
		System.out.print(" > 키(cm) : "); height = keyin.nextDouble();
		System.out.print(" > 몸무게(kg) : "); weight = keyin.nextDouble();
		
		fitness = new Fitness(id, name, height, weight);  // 입력 후 초기화
		System.out.println("## 회원등록 완료!");
	}
	
	private void read() {
		System.out.println(" [ 회원 정보 조회 ] ");
		if(fitness == null) {
			System.out.println("## 등록된 회원이 없습니다.\n");
			return; // 실제로 반환되는 값이 없으므로 return 문은 값의 반환이 아니라 메서드의 종료를 의미
		}
		fitness.output();
	}
	
	private void update() {
		System.out.println(" [ 회원 정보 수정 ] ");
		if(fitness == null) {
			System.out.println("## 등록된 회원이 없습니다.\n");
			return;
		}
		double weight, height;	//update의 지역 변수
		
		System.out.print(" > 키(cm) : "); height = keyin.nextDouble();
		System.out.print(" > 몸무게(kg) : "); weight = keyin.nextDouble();
		
		fitness.setHeight(height);
		fitness.setWeight(weight);
		
		System.out.println("## 정보 수정 완료!");
	}
	
	private void delete() {
			System.out.println(" [ 회원 탈퇴 ]");
			String confirm;
			
			if(fitness == null) {
				System.out.println("## 등록된 회원이 없습니다.\n");
				return;
			}			
			
			System.out.print("> 정말 탈퇴하시겠습니까? (y/n)\n");
			confirm = keyin.next();
			if (!(confirm.equals("Y") || confirm.equals("y"))) {
				System.out.println("## 탈퇴가 취소되었습니다!");
				return;
			}
			fitness = null;  // fitness 클래스에 저장된 변수 값들이 다 null로 바뀜.
			System.out.println("## 탈퇴 되었습니다!\n");
		
		}
	

}//end class

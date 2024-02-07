/*
 * 피트니스 멤버 관리 프로젝트

회원이름 : 문자열 (Not Null)

회원아이디 : 임의의 숫자. Primary Key(중복되지 않아야 한다. 빈 값x) 

키 : double (키가 자랄수잇으니 setter)

몸무게 : double (변할수있으니 setter)

BMI : (계산할 수 있는 값이므로 메서드)

결과 :
 */
package VO;

public class Fitness {
	//멤버 변수 
	private String id;
	private String name;
	private double height;
	private double weight;
	private double BMI;
	private String result; // 프로그램을 하면서 이 값을 바꿀일이 있으면 선언만 해놔
	//public final static double PI = 3.14159; //값을 바꿀일이 없으면 처음부터 아예 값을 박아버려

	// 기본생성자
	public Fitness() {
		super();
	}

	//생성자 오버로딩
	public Fitness(String id, String name, double height, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		calcBMI(); 
		//생성자 내에서 메서드를 호출하는 이유는 초기화 과정에서 객체의 상태를 설정하거나 계산을 수행하기 위해서다.
	}

	//setter
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
		calcBMI();
	}
	public void setWeight(double weight) {
		this.weight = weight;   // 몸무게가 main쪽에서 바뀌면 멤버변수 값도 바꿔주고 BMI 다시 계산해야지.
		calcBMI();
	}
	public void setBMI(double bMI) {
		BMI = bMI;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public double getBMI() {
		return BMI;
	}
	public String getResult() {
		return result;
	}


	// 일반메서드
	// 외부에서 호출 가능 = public. 불가능 = private
	private void calcBMI() { 
		this.BMI = weight / (height * height * 0.0001); //동작
		calcResult(); // 호출
	}
	
	private void calcResult() {
		if(BMI >= 35) result = "고도 비만";
		else if(BMI >= 30) result = "중도 비만";
		else if(BMI >= 25) result = "경도 비만";
		else if(BMI >= 23) result = "과체중";
		else if(BMI >= 18.5) result = "정상";
		else result = "저체중";
	}

	public void output() {
		System.out.printf("ID : %s(%s) : %.2fcm, %.2fkg, %.2f, %s\n", id, name, height, weight, BMI, result);
	}
	
}//end class

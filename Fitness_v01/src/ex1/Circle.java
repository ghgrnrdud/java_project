package ex1;

public class Circle {
	//멤버변수
	private double radius;  //반지름
	private final static double PI = 3.141592;
	//private double area;
	
	// 생성자
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	//setter
	public void setRadius(double radius) {
		this.radius = radius;
	}

	
	//getter
	public double getRadius() {
		return radius;
	}
	public static double getPi() {
		return PI;
	}
	public double getArea() { //반지름 사용하여 원의 면적 구하기
		return (radius * radius) * PI;
	}
	
}//end class

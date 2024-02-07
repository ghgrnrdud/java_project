package ex1;

public class Cylinder {
	//멤버변수
	Circle cir;  //circle 클래스를 멤버변수로 선언. 통째로 갖다놓음.
	double height; 
	
	// 생성자
	public Cylinder(Circle cir, double height) {
		super();
		this.cir = cir;
		this.height = height;
	}
	
	//메소드
	public double Volume() {
		return cir.getArea() * height;
	}
	
	public static void main(String[] args) {
		Circle cp = new Circle(2.8);
		Cylinder cd = new Cylinder(new Circle(2.8), 5.6);
		double height = 5.6;
		
		System.out.println("부피 : " + (cp.getArea()*height));
		System.out.println(cd.Volume());
		
	}
}

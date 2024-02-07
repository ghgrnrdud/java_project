package ex1;

class StudentEx2 {
	//멤버변수
	private String name;
	private String id;
	
	//기본 생성자
	public StudentEx2() {
		super();
	}
	
	//생성자
	public StudentEx2(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// getter
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}

	//일반 메서드
	public void output() {
		System.out.printf("%s의 학과는 %s다.\n", name, id);
	} 
	
}

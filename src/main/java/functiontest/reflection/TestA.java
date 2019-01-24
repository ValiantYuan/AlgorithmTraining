package functiontest.reflection;

public class TestA {
	private int num;
	
	public TestA(int num) {
		super();
		this.num = num;
	}

	public void say() {
		System.out.println("this is Test A, and number is " + num);
	}
}

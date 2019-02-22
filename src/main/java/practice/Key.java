package practice;

public class Key {
	int value;
	
	
	
	public Key(int value) {
		super();
		this.value = value;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return value % 10;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}

package functiontest.dynamicproxy;

public class PersonService {
	public PersonService() {
		// TODO Auto-generated constructor stub
		System.out.println("PersonService Constructor");
	}

	final public PersonService getPerson(String code) {
		System.out.println("PersonService:getPerson>>" + code);
		return null;
	}
	
	public void setPerson() {
		System.out.println("PersonService:setPerson");
	}
}

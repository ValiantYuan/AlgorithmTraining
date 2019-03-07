package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListResourceBundle;

public class Fanxing {
	public static void main(String[] args) {
		List<A> listA;
		List<B> listB= new LinkedList<>();
		//compile error
//		listA = listB; 
		System.err.println("done");
	}
}

class A {
	
}

class B extends A {
	
}

package bookcode.marchonoffer.entity;


public class Node {
	public int value;
	public Node next;
	public Node(int value) {
		this.value = value;
		next = null;
	}
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public static String printLinkedNodeListValue(Node head) {
		if (head == null) {
			return "fail";
		}
		Node cur = head;
		StringBuilder result = new StringBuilder();
		while (cur != null) {
			result.append(cur.value + " ");
			cur = cur.next;
		}
		return result.toString();
	}
}

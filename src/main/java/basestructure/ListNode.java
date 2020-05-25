package basestructure;

public 	class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		// TODO Auto-generated constructor stub
		this.val = x;
	}

	public void print() {
		System.out.print(val + " ");
		if(next != null) next.print();
	}
}

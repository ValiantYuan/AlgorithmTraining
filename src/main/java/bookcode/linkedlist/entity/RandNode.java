package bookcode.linkedlist.entity;

public class RandNode {
	public int value;
	public RandNode next = null;
	public RandNode rand = null;
	public RandNode(int value) {
		this.value = value;
	}
	
	public static String printLinkedNodeListValue(RandNode head) {
		if (head == null) {
			return "fail";
		}
		RandNode cur = head;
		StringBuilder result = new StringBuilder();
		String randValue;
		while (cur != null) {
			randValue = cur.rand == null ? "��" : (cur.rand.value + "");
			result.append("��ǰ�ڵ�ֵΪ" + cur.value + ",randֵΪ" + randValue + "\n");
			cur = cur.next;
		}
		return result.toString();
	}
}

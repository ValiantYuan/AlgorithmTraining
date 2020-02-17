package bookcode.marchonoffer;

import bookcode.marchonoffer.linkedlist.CopyRandLinkedList;
import org.junit.Test;

import bookcode.marchonoffer.entity.RandNode;

public class CopyRandLinkedListTest {

	@Test
	public void testCopy() {
	}

	@Test
	public void testCopyBetter() {
		RandNode head = new RandNode(0);
		RandNode cur = head;
		RandNode last;
		for (int i = 1; i < 5; i++) {
			RandNode node = new RandNode(i);
			cur.next = node;
			last = cur;
			cur = node;
			cur.rand = last;
		}		
		System.out.println(RandNode.printLinkedNodeListValue(head));
		System.out.println(RandNode.printLinkedNodeListValue(new CopyRandLinkedList().copyBetter(head)));
	}

}

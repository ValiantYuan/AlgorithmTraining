package stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.xml.soap.Node;

/**
 * һ��û���ظ����ݵ�����
 * MaxTree��һ�ö������������ûһ��ֵ��Ӧ��������һ���ڵ�
 * ���������ĸ��ڵ㶼�����ֵ��
 * д�����������MaxTree�ĺ�����Ҫ��ʱ�临�Ӷ�ΪO(N)������ռ临�Ӷ�O(N)
 * @author Valiant
 * 
 * ����˼·��
 * �ҳ�һ������ߵ�һ����������������ұߵ�һ��������������бȽϣ�ȡ�ϴ������Ϊ���ڵ㣬���ڵ��������������
 *
 */
public class ArrayMaxTree {
	
	public Node generate(Integer[] array) {
		
		
		Node[] nodes = new Node[array.length];
		Map<Node, Node> lMap = new HashMap<>();
		Map<Node, Node> rMap = new HashMap<>();
		Node head = null;
		
		
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(array[i]);
		}
		Stack<Node> stack = new Stack<>();
		
		/**
		 * ��������������ջ������ÿ������ߵ�һ������������ŵ�map��
		 * ������ɺ�ջ��ʣ���������ջ����ջ�����α�С��������Ҫ��������һ��ջ
		 */
		for (int i = 0; i < nodes.length; i++) {
			Node currentNode = nodes[i];
			while (!stack.empty() && stack.peek().value < currentNode.value ) {
				popNodeAndSetMap(stack, lMap);
			}
			stack.push(currentNode);
		}
		while (!stack.empty()) {
			popNodeAndSetMap(stack, lMap);
		}
		/**
		 * �����������������ջ������ÿ�����ұߵ�һ������������ŵ�map��
		 * ������ɺ�ջ��ʣ���������ջ����ջ�����α�С��������Ҫ��������һ��ջ
		 */
		for (int i = nodes.length - 1; i >= 0; i--) {
			Node currentNode = nodes[i];
			while (!stack.empty() && stack.peek().value < currentNode.value ) {
				popNodeAndSetMap(stack, rMap);
			}
			stack.push(currentNode);
		}
		while (!stack.empty()) {
			popNodeAndSetMap(stack, rMap);
		}
		
		/**
		 * �����ÿ������ߵ�һ������ֵ���ұߵ�һ������ֵ�Ѿ�ȷ���������������������tree
		 */
		for (int i = 0; i < nodes.length; i++) {
			Node currentNode = nodes[i];
			Node lNode = lMap.get(currentNode);
			Node rNode = rMap.get(currentNode);
			//���ϴ�ֵΪnull
			if (lNode == null) {
				//�Ҳ�ϴ�ֵΪnull,��ǰ�ڵ�Ϊȫ�����ڵ㣬��ͷ���
				if (rNode == null) {
					head = currentNode;
				} else {   //��ǰ�Ҳ�ϴ�ֵ�ڵ㲻Ϊnull����ýڵ�������Ҳ�Ϊ�յ��ӽڵ���Ϊ��ǰ�ڵ�
					if(rNode.left == null) {
						rNode.left = currentNode;
					} else {
						rNode.right = currentNode;
					}
				}
			} else if (rNode == null) {
				if (lNode.left == null) {
					lNode.left = currentNode;
				} else {
					lNode.right = currentNode;
				}
			} else {
				Node parent = lNode.value > rNode.value ? lNode : rNode;
				if (parent.left == null) {
					parent.left = currentNode;
				} else {
					parent.right = currentNode;
				}
			}
		}
		return head;
	}

	
	public void popNodeAndSetMap(Stack<Node> stack, Map<Node, Node> map) {
		Node popNode = stack.pop();
		if (stack.empty()) {
			map.put(popNode, null);
		} else {
			map.put(popNode, stack.peek());
		}
	}
	
	class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
		}
	}
}


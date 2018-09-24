package stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.xml.soap.Node;

/**
 * 一个没有重复数据的数组
 * MaxTree是一棵二叉树，数组的没一个值对应二叉树的一个节点
 * 所有子树的根节点都是最大值的
 * 写出生产数组的MaxTree的函数，要求时间复杂度为O(N)，额外空间复杂度O(N)
 * @author Valiant
 * 
 * 解题思路：
 * 找出一个数左边第一个比它大的数，和右边第一个比它大的数进行比较，取较大的数作为父节点，父节点从左到右依次填满
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
		 * 遍历数组依次入栈，并把每个数左边第一个比它大的数放到map中
		 * 遍历完成后栈中剩余的数，从栈顶到栈底依次变小，所以需要单独遍历一次栈
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
		 * 倒叙遍历数组依次入栈，并把每个数右边第一个比它大的数放到map中
		 * 遍历完成后栈中剩余的数，从栈顶到栈底依次变小，所以需要单独遍历一次栈
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
		 * 到这里，每个数左边第一个最大的值和右边第一个最大的值已经确定下来，接下来就是组成tree
		 */
		for (int i = 0; i < nodes.length; i++) {
			Node currentNode = nodes[i];
			Node lNode = lMap.get(currentNode);
			Node rNode = rMap.get(currentNode);
			//左侧较大值为null
			if (lNode == null) {
				//右侧较大值为null,则当前节点为全局最大节点，即头结点
				if (rNode == null) {
					head = currentNode;
				} else {   //当前右侧较大值节点不为null，则该节点从左往右不为空的子节点设为当前节点
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


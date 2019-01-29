package geektimepractice.trie;

import java.util.LinkedList;
import java.util.Queue;
/**
 * AC自动机的时间效率：
 * 创建Trie树的时间复杂度是O(m*len)，m是敏感词个数，len是敏感词平均长度
 * 失败指针的构建时间复杂度是O(k*len),k是Trie树中节点的总个数，每个节点最大遍历的次数是trie树的层数，而层数最大只能是len
 * 匹配时间复杂度O(n*len),n是需要匹配字符串的长度
 * @author Valiant
 *
 */
public class ACAutomaton {
	//
	ACNode root = new ACNode('/');
	
	public void insertWord(char[] text) {
		ACNode curNode = root;
		for (int i = 0; i < text.length; i++) {
			int index = text[i] - 'a';
			if (curNode.children[index] != null) {
				curNode = curNode.children[index];
			} else {
				curNode = new ACNode(text[i]);
			}
		}
		curNode.isEndingChar = true;
		curNode.length = text.length;
	}
	
	/**
	 * 按照广度优先的思路，计算所有节点的失效指针
	 */
	public void buildFailPointer() {
		Queue<ACNode> queue = new LinkedList<>();
		root.fail = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			ACNode curNode = queue.poll();
			ACNode[] children = curNode.children;
			for (int i = 0; i < children.length; i++) {
				ACNode child = children[i];
				//如果当前子节点为空，则跳过继续执行，只有这样，才能让queue逐渐变空
				if (child == null) {
					continue;
				}
				/**
				 * 如果当前节点时根节点root，则所有子节点child的失效指针都指向root,即在匹配第一个字符就失效的话，立刻匹配第一层的下一个字符
				 */
				if (curNode == root) {
					child.fail = root;
				}
				/**
				 * 若当前节点不是根节点，则到当前节点的失效节点中找到与当前子节点对应的child节点是否为空，如果不为空，则child的失效节点指向该子节点
				 * 如果为空，则再找当前节点对应失效节点对应的失效节点，如此递归下去，知道fail节点为空，为空的话，则把失效节点指向root
				 */
				else {
					ACNode fail = curNode.fail;
					/**
					 * 找到不为空的子节点则退出循环
					 */
					while (fail != null) {
						if (fail.children[i] != null) {
							child.fail = fail.children[i];
							break;
						} 
						fail = fail.fail;
					}
					if (fail == null) {
						child.fail = root;
					}
				}
				queue.add(child);
			}
		}
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	public void match(char[] text) {
		ACNode curNode = root;
		for (int i = 0; i < text.length; i++) {
			int index = text[i] - 'a';
			//
			while (curNode.children[index] == null && curNode != root) {
				curNode = curNode.fail;
			}
			curNode = curNode.children[index];
			//如果失效指针所在的子节点不存在，则说明当前text已读内容中，没有匹配的敏感词，从root开始继续往后遍历
			if (curNode == null) {
				curNode = root;
			}
			ACNode tmp = curNode;
			/**
			 * 这里的理解很关键，假设有两个敏感词    abcde bc,当text是abc时，其实bc已经满足敏感词屏蔽了，但是在match时可能还在abcde分支上，此时就可以通过abc的c节点来遍历失效指针所能指定的敏感词isEndingChar
			 * 所以此时会输出bc所在位置的敏感词，如果text最终遍历结果满足了abcde时，bc同样会被屏蔽掉，所以此时如果不计算效率的情况下，已经可以进行替换敏感词为*的操作，后续abcde的屏蔽将会把*再次替换为*,不影响最终的结果
			 */
			while (tmp != root) {
				if (tmp.isEndingChar) {
					int startPos = i - tmp.length + 1; 
					System.out.println("the start position is " + startPos + " and the length is " + tmp.length);
				}
				tmp = tmp.fail;
			}
		}
	}
}

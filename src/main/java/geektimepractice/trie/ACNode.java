package geektimepractice.trie;

public class ACNode {
	char data;
	ACNode[] children = new ACNode[26];
	boolean isEndingChar = false;
	int length = -1;
	//失败指针
	ACNode fail = null;
	public ACNode(char data) {
		super();
		this.data = data;
	}
	
	
}

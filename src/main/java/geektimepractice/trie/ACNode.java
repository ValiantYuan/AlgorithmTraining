package geektimepractice.trie;

public class ACNode {
	char data;
	ACNode[] children = new ACNode[26];
	boolean isEndingChar = false;
	int length = -1;
	ACNode fail = null;
	public ACNode(char data) {
		super();
		this.data = data;
	}
	
	
}

package geektimepractice.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import sun.print.PSPrinterJob.PluginPrinter;

/**
 * 
 * @author valiant
 *
 */
public class Graph {
	private int v; //vertex�ĸ���
	private LinkedList<Integer> adj[];//�ڽӱ�
	boolean found = false;//������ȵݹ�ʱ��Ҫ�õ�found��־����ֹ�ݹ�
	
	
	public Graph(int v) {
		// TODO Auto-generated constructor stub
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	//���մӱ�Ž�С�Ķ��㵽��Žϴ�Ķ���ķ�ʽ��ӱ�
	public void addEdge(int i, int j) {
		if (i > j) {
			System.out.println("please input the edge from smaller to bigger vertex");
			return;
		}
		adj[i].add(j);
		adj[j].add(i);
	}
	
	//������ȱ���ͼ,�ݹ�ʵ��
	public void dfs(int s, int t) {
		// TODO Auto-generated method stub
		if (s == t) {
			return;
		}
		
		boolean[] visited = new boolean[v];
		int[] prev = new int[v];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = -1;
		}
		
		visited[s] = true;
		for (int i = 0; i < adj[s].size(); i++) {
			if (!found) {
				
			}
			recursiveDfs(s, t, visited, prev);
		}
	}
	
	private void recursiveDfs(int s, int t, boolean[] visited, int[] prev) {
		
	}
	
	
	//������ȱ���ͼ
	public void bfs(int s, int t) {
		// TODO Auto-generated method stub
		if (s == t) {
			return;
		}
		//�����¼��Ӧ��ŵĶ����Ƿ񱻷��ʹ�
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		//��¼��Ӧ��ŵĶ����ǰһ������ʲô�����·��ʱʹ��
		int[] prev = new int[v];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = -1;
		}
		while (queue.size() != 0) {
			int w = queue.poll();
			for (int i = 0; i < adj[w].size(); i++) {
				int q = adj[w].get(i);
				if (!visited[q]) {
					prev[q] = w;
				}
				if (q == t) {
					print(s, t, prev);
					return;
				}
				visited[q] = true;
				queue.add(q);
			}
		}
	}
	
	//�ݹ��ӡ s-->t��·��
	private void print(int s, int t, int[] prev) {
		if (s != t && prev[t] != -1) {
			print(s, prev[t], prev);
		}
		System.out.println(t + " " );
	}
}

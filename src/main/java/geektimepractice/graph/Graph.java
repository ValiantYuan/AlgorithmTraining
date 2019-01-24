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
	private int v; //vertex的个数
	private LinkedList<Integer> adj[];//邻接表
	boolean found = false;//深度优先递归时需要用到found标志来终止递归
	
	
	public Graph(int v) {
		// TODO Auto-generated constructor stub
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	//按照从编号较小的顶点到编号较大的顶点的方式添加边
	public void addEdge(int i, int j) {
		if (i > j) {
			System.out.println("please input the edge from smaller to bigger vertex");
			return;
		}
		adj[i].add(j);
		adj[j].add(i);
	}
	
	//深度优先遍历图,递归实现
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
	
	
	//广度优先遍历图
	public void bfs(int s, int t) {
		// TODO Auto-generated method stub
		if (s == t) {
			return;
		}
		//数组记录对应编号的顶点是否被访问过
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		//记录对应编号的顶点的前一顶点是什么，输出路径时使用
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
	
	//递归打印 s-->t的路径
	private void print(int s, int t, int[] prev) {
		if (s != t && prev[t] != -1) {
			print(s, prev[t], prev);
		}
		System.out.println(t + " " );
	}
}

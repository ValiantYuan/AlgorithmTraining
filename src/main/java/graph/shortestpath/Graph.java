package graph.shortestpath;

import java.util.LinkedList;

/**
 * @ClassName Graph
 * @Description: TODO
 * @Author: YuanQi
 * @Date: 2020/1/8
 */
public class Graph {
    // 邻接表
    private LinkedList<Edge> adjacentTable[];
    // 节点个数
    private int number;

    public Graph(int number) {
        this.number = number;
        this.adjacentTable = new LinkedList[number];
        for (int i = 0; i < number; i++) {
            this.adjacentTable[i] = new LinkedList<>();
        }
    }

    /**
     * 添加一条边
     * @param sid
     * @param tid
     * @param weight
     */
    public void addEdge(int sid, int tid, int weight) {
        this.adjacentTable[sid].add(new Edge(sid, tid, weight));
    }

    private class Edge {
        // 边的起始顶点编号
        public int sid;
        // 边的终止顶点编号
        public int tid;
        // 边的权重
        public int weight;

        public Edge(int sid, int tid, int weight) {
            this.sid = sid;
            this.tid = tid;
            this.weight = weight;
        }
    }

    private class Vertex {
        // 顶点编号id
        public int id;
        // 从起始顶点到当前顶点的距离
        public int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    private class PriorityQueue {
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int count) {
            this.nodes = new Vertex[count + 1];
            this.count = count;
        }

        public Vertex poll() {
            return null;
        }

        public void add(Vertex vertex) {

        }

        public void update(Vertex vertex) {

        }

        public boolean isEmpty() {
            return false;
        }
    }

    public void dijkstra(int sid, int tid) {
        // 用来还原最短路径
        int[] predecessor = new int[this.number];
        // 初始化所有顶点为距离起始点距离为无穷
        Vertex[] vertexes = new Vertex[this.number];
        for (int i = 0; i < this.number; i++) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // 小顶堆
        PriorityQueue queue = new PriorityQueue(this.number);
        // 判断顶点是否进入过队列
        boolean[] inqueue = new boolean[this.number];
        vertexes[sid].dist = 0;
        queue.add(vertexes[sid]);
        inqueue[sid] = true;
        while (!queue.isEmpty()) {
            // 弹出堆顶元素
            Vertex minVertex = queue.poll();
            // 最短路径产生了
            if (minVertex.id == tid) break;
            // 最关键的点: 当一个顶点出现在堆顶，代表从起点到这个顶点的最短距离已确定，以后不再会入堆
            for (int i = 0; i < adjacentTable[minVertex.id].size(); i++) {
                Edge edge = adjacentTable[minVertex.id].get(i);
                Vertex nextVertex = vertexes[edge.tid];
                //遍历的是堆顶元素邻接的顶点，如果从当前最小顶点出发到顶点i后距离小于顶点i当前的距离，则修改当前距离
                if (minVertex.dist + edge.weight < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + edge.weight;
                    // 更新当前顶点的前序节点
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        //
        System.out.print(sid);
        print(sid, tid, predecessor);
    }

    private void print(int sid, int tid, int[] predecessor) {
        if (sid == tid) return;
        print(sid, predecessor[tid], predecessor);
        System.out.print("->" + tid);
    }

}

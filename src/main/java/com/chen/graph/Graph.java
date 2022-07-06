package com.chen.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private final ArrayList<String> vertexList; //存储顶点的集合
    private final int[][] edges; //存储图对应的邻接矩阵
    private int numsOfEdges; //表示边的数目

    private boolean[] isVisited;

    /**
     * 构造器
     *
     * @param n 顶点的个数
     */
    public Graph(int n) {
        //初始化矩阵和VertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numsOfEdges = 0;
    }

    /**
     * 得到第一个相邻节点的下标
     * @param index 该节点下标
     * @return 如果存在则返回对应下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * @param v1 已遍历的节点
     * @param v2 已遍历节点v1的下一个节点
     * @return 下一个结点下标，无则返回-1；
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisited, int i) {
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将节点设置为已访问
        isVisited[i] = true;
        //查找该节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while (w != -1) { //说明有下一个节点
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果节点w已经被访问过了
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行重载，遍历所有节点
    public void dfs() {

        isVisited = new boolean[getNumsOfVertex()];
        //遍历所有节点（回溯）
        for (int i = 0; i < getNumsOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;
        LinkedList<Integer> queue = new LinkedList<>();

        //访问该节点，并输出其 值
        System.out.print(getValueByIndex(i)+"->");
        //将该节点isVisited属性置为true
        isVisited[i] = true;
        //将该节点添加到队列的末尾，随后回溯时从队列中取出最后添加的节点
        queue.addLast(i);

        //如果队列不为空
        while (!queue.isEmpty()) {
            //从队列中取出一个节点
            u = queue.removeFirst();
            //找到该节点的第一个邻接节点
            w =  getFirstNeighbor(u);
            //当该邻接节点存在时
            while (w != -1) {
                //如果没有访问过该节点
                if (!isVisited[w]) {
                    //则输出该节点，并将其isVisited属性置为true
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    //将该节点加入到队列中
                    queue.addLast(w);
                }
                //对w进行迭代，找到u的所有邻接节点中w的下一个邻接节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {

        isVisited = new boolean[getNumsOfVertex()];
        for (int i = 0; i < getNumsOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    /**
     * 得到图中节点的个数
     * @return 节点个数 int
     */
    public int getNumsOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到图中边的个数
     * @return 边的条数 int
     */
    public int getNumsOfEdges() {
        return numsOfEdges;
    }

    /**
     * 返回节点i（下标） 对应的数据
     * 0->"A", 1->"B" 2->"C"
     * @param i 节点下标
     * @return 节点值
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 获取连通两个节点v1，v2的边的权重，若节点之间无连通，应给出提示
     * @param v1 节点1
     * @param v2 节点2
     * @return 权重
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }
    /**
     * 添加节点
     * @param vertex 节点值
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 表示点的下表，即第几个顶点： "A"-"B" "A"->[0]; "B"->[1];
     * @param v2 第二个顶点对应的下标
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numsOfEdges++;
    }
}

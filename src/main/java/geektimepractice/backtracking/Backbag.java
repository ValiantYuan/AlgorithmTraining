package geektimepractice.backtracking;

/**
 * @NAME: Backbag
 * @USER: valiant
 * @DATE: 2019-08-28
 * @DESCRITION:
 **/
public class Backbag {

    //每个物品有多重
    private int[] items;
    //背包都最大容量
    private int capacity;
    //放入物品的最大重量
    private int maxWeight;
    //记录背包中准备放入第n个物品，当前总重量为m的状态是否被访问过
    private boolean[][] mem;


    public Backbag(int[] items, int capacity, int maxWeight) {
        this.items = items;
        this.capacity = capacity;
        this.maxWeight = maxWeight;
    }

    /**
     * 对于每一个物品都判断放入或者不放入两种情况，超重了则回溯处理
     * @param index 表示当前遍历到第几个物品
     * @param weight 表示当前袋子中的总重量
     */
    public void put(int index, int weight) {
        if (index == items.length || weight == capacity) {
            if (weight > maxWeight) {
                maxWeight = weight;
            }
            return;
        }
        if (mem[index][weight]) {
            return;
        }
        mem[index][weight] = true;
        //不把第index个物品放进袋子中
        put(index + 1, weight);
        //如果把第index个物品放入袋子中没有超重，则把改物品放入袋子中
        if (weight + items[index - 1] <= capacity) {
            put(index + 1, weight + items[index - 1]);
        }
    }
}

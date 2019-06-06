package com.zozospider.test.sum;

import java.util.*;

/**
 * 在指定票据集合里, 找出多个票据金额的和等于指定金额的多个匹配组合集 (单个匹配组合中的票据 key 不能重复)
 */
public class BillSumHandle {

    private Map<Integer, Double> allBill; // 所有票据集合 (value 已按照票面金额升序排列)
    private Integer[] allBillKeys; // 所有票据 key (票据 id) 数组
    private double sum; // 待匹配票据金额和

    private List<Integer> currentMatchKeys = new ArrayList<>(); // 单次匹配的试探票据集合 (多次匹配可复用)
    private List<Integer> currentDifferentKeys = new ArrayList<>(); // 单次匹配的试探票据 key (票据 id) 非重复集合 (防止重复 key 被统计) (多次匹配可复用)
    private int currentSum; // 试探票据金额和 (多次匹配可复用)

    private int machNumber; // 所有匹配成功次数
    private List<List<Integer>> allMatchKeys = new ArrayList<>(); // 所有匹配的试探票据集合的集合

    public BillSumHandle(Map<Integer, Double> allBill, double sum) {
        this.allBill = allBill;
        this.allBillKeys = allBill.keySet().toArray(allBill.keySet().toArray(new Integer[]{}));
        this.sum = sum;
    }

    public List<List<Integer>> getBill() {
        division(0);
        return allMatchKeys;
    }

    private void division(int x) {

        // 如果试探票据金额和等于 sum
        if (currentSum == sum) {
            // 匹配成功次数 +1
            machNumber++;
            System.out.print("mach " + machNumber + ": ");

            // 打印本次匹配结果
            System.out.print(sum + " = ");
            for (int i = 0; i < currentMatchKeys.size(); i++) {
                if (i != currentMatchKeys.size() - 1) {
                    System.out.print("(" + currentMatchKeys.get(i) + "->" + allBill.get(currentMatchKeys.get(i)) + ") + ");
                } else {
                    System.out.println("(" + currentMatchKeys.get(i) + "->" + allBill.get(currentMatchKeys.get(i)) + ")");
                }
            }

            // 将单次匹配的试探票据集合 加入到 所有匹配的试探票据集合的集合 中
            allMatchKeys.add(new ArrayList<>(currentMatchKeys));

        // 如果试探和大于 N, 则返回到上一层 (结束当前 devision, 返回上一个 devision)
        } else if (currentSum > sum) {
            return;

        // currentSum < N (即当前试探和未达到 N) 的情况, 循环范围: 输入参数 x (即上一层传进来的试探数 x) 到试探和 N
        } else {
            for (int i = x; i < allBillKeys.length; i++) {

                // 试探准备
                //     防止重复 key
                if (currentDifferentKeys.contains(allBillKeys[i])) {
                    continue;
                }
                //     防止重复 key: 加入单次匹配的试探票据 key (票据 id) 集合, 防止重复 key
                currentDifferentKeys.add(allBillKeys[i]);
                //     当前试探数加入试探数字集合
                currentMatchKeys.add(allBillKeys[i]);
                //     当前试探数累加到试探和
                currentSum += allBill.get(allBillKeys[i]);

                // 递归试探
                division(i);

                // 试探完毕
                //     将试探票据 key (票据 id) 从试探票据 key (票据 id) 集合中移除 (多次匹配可复用)
                currentDifferentKeys.remove(currentDifferentKeys.size() - 1);
                //     将试探数从试探数字集合中移除, 以待下一次循环加上新的试探数来试探 (多次匹配可复用)
                currentMatchKeys.remove(currentMatchKeys.size() - 1);
                //     将试探数从试探和减去, 以待下一次循环加上新的试探数来试探 (多次匹配可复用)
                currentSum -= allBill.get(allBillKeys[i]);
            }
        }
    }

}

package com.zozospider.test.sum;

import java.util.*;

public class BillSumHandle {

    private Map<Integer, Double> allBill; // 所有票据集合 (value 已按照票面金额升序排列)
    private Iterator<Map.Entry<Integer, Double>> allBillIterator;
    private double sum; // 待匹配票据金额和

    private int machNumber; // 匹配成功次数

    private List<Integer> currentNumbers = new ArrayList<>(); // 单次匹配的试探票据集合
    private List<List<Integer>> allNumbers = new ArrayList<>(); // 所有匹配的试探票据集合的集合
    private int currentSum; // 试探票据金额和

    public BillSumHandle(Map<Integer, Double> allBill, double sum) {
        this.allBill = allBill;
        this.sum = sum;
    }

    public List<List<Integer>> getBill() {
        restoreAllBillIterator();
        division();
        return allNumbers;
    }

    private void division() {

        // 如果试探票据金额和等于 sum
        if (currentSum == sum) {
            // 匹配成功次数 +1
            machNumber++;
            System.out.print("mach " + machNumber + ": ");

            // 打印本次匹配结果
            System.out.print(sum + " = ");
            for (int i = 0; i < currentNumbers.size(); i++) {
                if (i != currentNumbers.size() - 1) {
                    System.out.print(currentNumbers.get(i) + " + ");
                } else {
                    System.out.println(currentNumbers.get(i));
                }
            }
            // 将单次匹配的试探票据集合 加入到 所有匹配的试探票据集合的集合 中
            allNumbers.add(currentNumbers);
            // 重新
            restoreAllBillIterator();

        // 如果试探和大于 N, 则返回到上一层 (结束当前 devision, 返回上一个 devision)
        } else if (currentSum > sum) {
            return;

        // currentSum < N (即当前试探和未达到 N) 的情况, 循环范围: 输入参数 x (即上一层传进来的试探数 x) 到试探和 N
        } else {
            while (allBillIterator.hasNext()) {
                Map.Entry<Integer, Double> next = allBillIterator.next();
                Integer key = next.getKey();
                Double value = next.getValue();
                // 当前试探数加入试探数字集合
                currentNumbers.add(key);
                // 当前试探数累加到试探和
                currentSum += value;
                // 递归试探
                division();
                // 试探完毕后, 将试探数从试探数字集合中移除, 以待下一次循环加上新的试探数来试探
                currentNumbers.remove(currentNumbers.size() - 1);
                // 试探完毕后, 将试探数从试探和减去, 以待下一次循环加上新的试探数来试探
                currentSum -= value;
            }
        }
    }

    private void restoreAllBillIterator() {
        allBillIterator = allBill.entrySet().iterator();
    }

}

package com.zozospider.test.sum;

import java.util.ArrayList;
import java.util.List;

public class PositiveIntegerSum2 {

    private int N = 7; // 待匹配数
    private int[] params = new int[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {
        PositiveIntegerSum2 positiveIntegerSum = new PositiveIntegerSum2();
        // 从 1 开始试探
        positiveIntegerSum.division(0);
        System.out.println("end");
    }

    private int machingNumber; // 匹配成功次数

    private int currentSum; // 试探和
    private int currentPosition; // 试探指针
    private List<Integer> currentNumbers = new ArrayList<>(); // 试探数字集合

    private void division(int x) {

        // 如果试探和等于 N
        if (currentSum == N) {
            // 匹配成功次数 +1
            machingNumber++;
            // System.out.print("mach " + machingNumber + ": ");

            // 打印本次匹配结果
            System.out.print(N + " = ");
            for (int i = 0; i < currentNumbers.size(); i++) {
                if (i != currentNumbers.size() - 1) {
                    System.out.print(params[currentNumbers.get(i)] + " + ");
                } else {
                    System.out.println(params[currentNumbers.get(i)]);
                }
            }

        // 如果试探和大于 N, 则返回到上一层 (结束当前 devision, 返回上一个 devision)
        } else if (currentSum > N) {
            return;

        // currentSum < N (即当前试探和未达到 N) 的情况, 循环范围: 输入参数 x (即上一层传进来的试探数 x) 到试探和 N
        } else {
            for (int i = x; i < params.length; i++) {
                // 当前试探数加入试探数字集合
                currentNumbers.add(i);
                // 当前试探数累加到试探和
                currentSum += params[i];
                // 递归试探
                division(i);
                // 试探完毕后, 将试探数从试探数字集合中移除, 以待下一次循环加上新的试探数来试探
                currentNumbers.remove(currentNumbers.size() - 1);
                // 试探完毕后, 将试探数从试探和减去, 以待下一次循环加上新的试探数来试探
                currentSum -= params[i];
            }
        }

    }

}

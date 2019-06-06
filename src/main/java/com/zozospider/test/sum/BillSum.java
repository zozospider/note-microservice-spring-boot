package com.zozospider.test.sum;

import java.util.*;

public class BillSum {

    public static void main(String[] args) {

        // 求和金额
        double sum = 300.00;
        // 找出所有票据, 建议按照票面金额升序排列, 方便查看结果 (select id, money from tbl_bill order by money asc;)
        // 格式: 如果找出的结果集是升序排序的, 就必须放到 LinkedHashMap 里 (票据 id / 票据号 (需要唯一标识能唯一标识一条记录) -> 票面金额)
        Map<Integer, Double> allBill = new LinkedHashMap<>();
        allBill.put(2, 20.0);
        allBill.put(1, 50.0);
        allBill.put(4, 50.0);
        allBill.put(6, 80.0);
        allBill.put(5, 100.0);
        allBill.put(7, 150.0);
        allBill.put(3, 200.0);
        allBill.put(8, 250.0);

        // 调用, 一定要 new 一个新的 BillSumHandle, 不要用单例 (BillSumHandle 不要加 Spring 注解)
        BillSumHandle handle = new BillSumHandle(allBill, sum);
        List<List<Integer>> allMatchKeys = handle.getBill();

        // 输出测试
        System.out.println();
        System.out.println("---------get allMatchKeys success, matchSize: " + allMatchKeys.size() + "-----------");
        for (List<Integer> matchKeys : allMatchKeys) {
            System.out.print(sum + " = ");
            for (int i = 0; i < matchKeys.size(); i++) {
                if (i != matchKeys.size() - 1) {
                    System.out.print("(" + matchKeys.get(i) + "->" + allBill.get(matchKeys.get(i)) + ")" + " + ");
                } else {
                    System.out.println("(" + matchKeys.get(i) + "->" + allBill.get(matchKeys.get(i)) + ")");
                }
            }
        }
    }

}

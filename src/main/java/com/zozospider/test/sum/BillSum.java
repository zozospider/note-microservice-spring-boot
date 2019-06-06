package com.zozospider.test.sum;

import java.util.*;

public class BillSum {

    public static void main(String[] args) {
        // 求和金额
        double sum = 200.00;
        // 找出所有票据, 按照票面金额升序排列 (select id, money from tbl_bill order by money asc;)
        // 格式: 必须用 LinkedHashMap (票据 id -> 票面金额)
        Map<Integer, Double> allBill = new LinkedHashMap<>();
        allBill.put(1, 50.00);
        allBill.put(4, 50.00);
        allBill.put(6, 80.00);
        allBill.put(5, 100.00);
        allBill.put(2, 100.00);
        allBill.put(3, 200.00);

//        Set<Map.Entry<Integer, Double>> allBillEntries = allBill.entrySet();
//        for (Map.Entry<Integer, Double> allBillEntry : allBillEntries) {
//            System.out.println(allBillEntry.getKey() + ": " + allBillEntry.getValue());
//        }
//        System.out.println("-----------");
//        for (Map.Entry<Integer, Double> allBillEntry : allBillEntries) {
//            System.out.println(allBillEntry.getKey() + ": " + allBillEntry.getValue());
//        }
//
//        Iterator<Map.Entry<Integer, Double>> iterator = allBill.entrySet().iterator();
//
//        Set<Integer> allBillKey = allBill.keySet();

        BillSumHandle2 handle = new BillSumHandle2(allBill, sum);
        List<List<Integer>> bill = handle.getBill();
        System.out.println("bill: " + bill);
    }

}

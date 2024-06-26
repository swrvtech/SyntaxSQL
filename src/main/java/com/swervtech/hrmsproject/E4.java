package com.swervtech.hrmsproject;

import java.util.List;
import java.util.Map;

public class E4 {
    public static void main(String[] args) {
        System.out.println(DBUtils.fetch("Select * from employee"));
        List<Map<String,String>> allData = DBUtils.fetch("Select * from employee");
        System.out.println(allData.get(1));
        Map<String,String> row1 = allData.get(0);
        System.out.println(row1.get("salary"));
    }
}

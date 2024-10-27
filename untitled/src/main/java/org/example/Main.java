package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> stuMap = new HashMap<String, Integer>();
        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(new Student(1,"It"));
        stuList.add(new Student(1,"Mech"));
        stuList.add(new Student(1,"It"));
        stuList.add(new Student(1,"CSE"));

        Map<String, List<Student>> collect = stuList.stream().collect(Collectors.groupingBy(i -> i.dept));

        collect.forEach((i,j)->System.out.println("using collectors "+i+" "+j));


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        stuList.stream().forEach(i->{
            if(stuMap.keySet().contains(i.dept)){
                stuMap.put(i.dept,stuMap.get(i.dept)+1);
            }
            else{
                stuMap.put(i.dept,1);
            }
        });

        stuMap.forEach((i,j)->System.out.println("Using map "+i+" "+j));

    }
}
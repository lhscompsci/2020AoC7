package com.wtxcompsci;

import java.io.File;
import java.io.IOException;
import java.util.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner inf = new Scanner(new File(("input.dat")));

        long ans = 1L;

        String target = "shiny gold";

        ArrayList<String> data = new ArrayList<>();

        while(inf.hasNext()){
            data.add(inf.nextLine());
        }

        Map<String, TreeMap<String, Integer>> cmap = new TreeMap<>();
        for(String s: data){
            String[] kp = s.split(" bags contain ");
            String[] c = kp[1].split(" bags?, ");
            TreeMap<String, Integer> l = new TreeMap<>();
            for(String i:c){
                String[] trim = i.split(" ");
                l.put((trim[1] +" "+ trim[2]), (trim[0].equals("no")?0:Integer.parseInt(trim[0])));
            }
            cmap.put(kp[0],l);
        }

        Set<String> bags = new TreeSet<>();
        for(String k: cmap.keySet()){
            TreeMap<String,Integer> bob = cmap.get(k);
            if((bob).keySet().contains(target)) {
//                out.println("found in another bag: "+k);
                bags.add(k);
//                out.println(bags);

                checkForMore(bags, k, cmap);


            }
        }
        
        out.println(ans);
    }

    public static long checkForMore(Set<String> b, String tar, Map<String,ArrayList<String>> cm){
//        out.println(b + " "+ tar);

        for(String x: cm.keySet()){
            if(cm.get(x).contains(tar)) {
//                out.println("found deeper in another bag: "+x);
                if(b.contains(x))
                    continue;
                b.add(x);
                checkForMore(b, x, cm);
            }
        }
    }
/*
    long val = 0;
    for (String g: bob.keySet()){
     if(g.equals("other bags."))
         return 1L;




*/

}

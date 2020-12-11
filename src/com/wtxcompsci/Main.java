package com.wtxcompsci;

import java.io.File;
import java.io.IOException;
import java.util.*;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner inf = new Scanner(new File(("sample.dat")));

        int ans = 0;

        String target = "shiny gold";

        ArrayList<String> data = new ArrayList<>();

        while(inf.hasNext()){
            data.add(inf.nextLine());
        }

        Map<String, ArrayList<String>> cmap = new TreeMap<>();
        for(String s: data){
            String[] kp = s.split(" bags contain ");
            String[] c = kp[1].split(" bags?, ");
            ArrayList<String> l = new ArrayList<>();
            for(String i:c){
                String[] trim = i.split(" ");
                l.add((trim[1] +" "+ trim[2]));
            }
            cmap.put(kp[0],l);
        }

        Set<String> bags = new TreeSet<>();
        for(String k: cmap.keySet()){
            if(cmap.get(k).contains(target)) {
                out.println("found in another bag: "+k);
                bags.add(k);
                checkForMore(bags,k,cmap);
            }
        }
        
        out.println(ans);
    }

    public static void checkForMore(Set<String> b, String k, Map<String,ArrayList<String>> cm){


    }



}

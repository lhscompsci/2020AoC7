package com.wtxcompsci;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner inf = new Scanner(new File(("input.dat")));

        long ans = 1L;

        ArrayList<String> map = new ArrayList<>();

        while(inf.hasNext()){
            map.add(inf.nextLine());
        }

        
        
        
        System.out.println(ans);
    }
}

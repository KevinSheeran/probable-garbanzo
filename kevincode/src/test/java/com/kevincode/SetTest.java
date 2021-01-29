package com.kevincode;

import java.util.HashSet;
import java.util.Set;

/**
 * User: kevin.xie<br/>
 * Date: 31/08/2020<br/>
 * Time: 10:29<br/>
 */
public class SetTest {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(101);
        set.add(201);
        set.add(301);
        set.add(401);

        set.remove(101);

        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}

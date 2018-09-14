package com.example.demo.contain;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by za-lijunnan on 2018/9/13.
 */
public class MapCompare {
    /**
     * TreeMap 这个是排序的map,根据key升序排列
     */
    public void testTreeMap(){
        TreeMap treeMap = new TreeMap();
        treeMap.put("a","wssks");
        treeMap.put("d","wsadfsks");
        treeMap.put("c","ssd");
        treeMap.put("e","bax");
        Set sets = treeMap.keySet();
        Iterator iter = sets.iterator();
        while (iter.hasNext()){
            String sa = (String)iter.next();
            System.out.print("key:"+sa+";velue:"+treeMap.get(sa));
        }

    }

    public static void main(String[] args) {
        new MapCompare().testTreeMap();
    }
}

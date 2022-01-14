/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 *
 * @author user
 */
public class FindGreatestInHashMap {
    public static <K, V extends Comparable<? super V>> List<Entry<K, V>> 
        findGreatest(Map<K, V> map, int n)
    {
        Comparator<? super Entry<K, V>> comparator = 
            new Comparator<Entry<K, V>>()
        {
            @Override
            public int compare(Entry<K, V> e0, Entry<K, V> e1)
            {
                V v0 = e0.getValue();
                V v1 = e1.getValue();
                return v0.compareTo(v1);
            }
        };
        PriorityQueue<Entry<K, V>> highest = 
            new PriorityQueue<Entry<K,V>>(n, comparator);
        for (Entry<K, V> entry : map.entrySet())
        {
            highest.offer(entry);
            while (highest.size() > n)
            {
                highest.poll();
            }
        }

        List<Entry<K, V>> result = new ArrayList<Map.Entry<K,V>>();
        while (highest.size() > 0)
        {
            result.add(highest.poll());
        }
        return result;
    }
}

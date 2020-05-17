package swordOfOffer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author lei.X
 * @date 2020/3/8
 *
 * 使用linkedHashMap （单向链表 ） 构建LRU
 */
public class LRUcache2 {

    LinkedHashMap<Integer,Integer> linkedHashMap;
    int capacity;


    public LRUcache2(int capacity){
        this.linkedHashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }


    public int get(int key){

        if (!linkedHashMap.containsValue(key)) return -1;

        int value = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key,value);
        return value;
    }


    public void put(int key,int value){

        if (linkedHashMap.containsValue(key)){
            linkedHashMap.remove(key);
        }

        if (linkedHashMap.size() == capacity){
            Set<Integer> keySet= linkedHashMap.keySet();  // linkedHashMap 中不存在Iterator，所以改采用keySet的iterator
            Iterator<Integer> iterator = keySet.iterator();
            linkedHashMap.remove(iterator.next());

        }

        linkedHashMap.put(key,value);
    }


}

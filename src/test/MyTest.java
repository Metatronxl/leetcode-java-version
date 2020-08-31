package test;

import java.util.HashMap;

/**
 * @author lei.X
 * @date 2020/2/3
 */
public class MyTest<K,V> {


    class Entry<K,V>{

        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }

    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;
    private HashMap<K,Entry<K,V>> hashMap;

    public MyTest(int size){
        MAX_CACHE_SIZE = size;
        hashMap = new HashMap<>();
    }

    public void put(K key, V value){
        Entry entry = getEntry(key);
        if (entry == null){
            entry = new Entry();
            if (hashMap.size() == MAX_CACHE_SIZE){
                removeFromLast();
                hashMap.remove(last.key);
            }
        }
        entry.key = key;
        entry.value = value;
        addToFirst(entry);
        hashMap.put(key,entry);

    }

    public V get(K key){
        Entry entry = getEntry(key);
        if (entry == null) return null;
        addToFirst(entry);
        return (V)entry.value;
    }


    private void addToFirst(Entry entry){
        if (entry == first) return;
        if (first == null || last == null){
            first = last = entry;
            return;
        }
        if (entry.pre != null){
            entry.pre.next = entry.next;
        }
        if (entry.next !=null){
            entry.next.pre = entry.pre;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeFromLast(){

        if (last !=null){
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }

    }

    public Entry getEntry(K key){
         return hashMap.get(key);
    }


}


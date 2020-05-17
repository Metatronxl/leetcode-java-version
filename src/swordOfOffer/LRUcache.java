package swordOfOffer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author lei.X
 * @date 2020/3/8
 *
 * 使用LinkedList 双向链表实现
 */


class Node{

    int key;
    int value;


    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }

}


public class LRUcache {


    LinkedList<Node> cache;
    int capacity;

    public LRUcache(int capacity){
        this.cache = new LinkedList<>();
        this.capacity = capacity;
    }

    public void put(int key, int value){

        Iterator<Node> iterator = cache.iterator();
        while (iterator.hasNext()){

            Node node = iterator.next();
            if (node.key == key){
                iterator.remove();
                break;
            }
        }

        if (capacity == cache.size()){
            cache.removeFirst();
        }

        cache.add(new Node(key,value));
    }

    public int  get(int key){

        Iterator<Node> iterator = cache.iterator();
        int result = -1;
        while (iterator.hasNext()){

            Node node = iterator.next();
            if (node.key == key){

                result = node.value;
                iterator.remove();
                put(key,result);
                break;
            }

        }

        return result;

    }

}

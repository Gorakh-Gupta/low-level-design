package com.gorakh.lldrunner.lru;

import java.util.HashMap;
import java.util.Map;

class LRUCache<K,V> {

    private final int capacity;
    private final Map<K, Node<K,V>> cache;
    private final Node<K,V> head;
    private final Node<K,V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key) {
        Node<K,V>node = cache.get(key);
        if(node == null){
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K,V> node = cache.get(key);
        if(node != null){
           node.value = value;
            moveToHead(node);
        }
        else{
            node = new Node<>(key,value);
            if(cache.size() == capacity){
                Node<K, V> removedNode = removeTail();
                cache.remove(removedNode.key);
            }
            cache.put(key, node);
            addToHead(node);
        }
    }

    private Node<K, V> removeTail() {
        Node<K, V> node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
//        node.prev = head;
//        node.next = head.next;
//        head.next.prev = node;
//        head.next = node;
    }
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

//        Node<K ,V>l = node.prev;
//        Node<K,V>ll= node.next;
//        l.next = node.next;
//        ll.prev =l;
    }

    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

}

package com.k7;

import java.util.Iterator;

public class MySet<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int curBucket = -1;
            private Node cur = null;

            @Override
            public boolean hasNext() {
                if (cur != null && cur.next != null) {
                    cur = cur.next;
                    return true;
                }
                for (++curBucket;curBucket<buckets.length;++curBucket){
                    if (buckets[curBucket]!=null) {
                        cur = buckets[curBucket];
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                return (T)cur.value;
            }
        };
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size = 0;

    public MySet(int size) {
        this.buckets = new Node[size];
    }

    public MySet() {
        this(16);
    }

    public void add(T elem) {
        int index = getIndex(elem);
        Node existNode = findNode(elem, index);
        if (existNode != null) {
            existNode.value = elem;
        } else {
            Node n = new Node(elem);
            n.next = buckets[index];
            buckets[index] = n;
            ++size;
        }

    }

    public boolean contains(T elem) {
        int index = getIndex(elem);
        Node existNode = findNode(elem, index);
        return existNode != null;
    }
    public T find(T elem) {
        int index = getIndex(elem);
        Node existNode = findNode(elem, index);
        return existNode!=null?(T)existNode.value:null;
    }

    private int getIndex(T elem) {
        int hash = elem.hashCode();
        hash = hash > 0 ? hash : -hash;
        return hash % buckets.length;
    }

    public T get (int index){
        int i = 0;
        for (T t:this) {
            if (i == index) return t;
            ++i;
        }
        return null;
    }

    private Node findNode(T elem, int index) {
        for (Node cur = buckets[index]; cur != null; cur = cur.next) {
            if (cur.value.equals(elem))
                return cur;
        }
        return null;
    }

}

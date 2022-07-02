import java.util.*;

class Node {
    int key;
    int value;
    int freq;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        freq = 1;
        next = null;
        prev = null;
    }
}

class DLList {
    int size;
    Node head;
    Node tail;

    public DLList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void insert(Node newNode) {
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        size++;
    }
}

class LFUCache {
    int capacity;
    int currCapacity;
    int minFreq;
    Map<Integer, DLList> freqMap;
    Map<Integer, Node> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        currCapacity = 0;
        minFreq = 1;
        freqMap = new HashMap<>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node tempNode = cache.get(key);
        updateList(tempNode);
        return tempNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (cache.containsKey(key)) {
            Node tempNode = cache.get(key);
            tempNode.value = value;
            updateList(tempNode);
        } else {
            currCapacity++;
            if (currCapacity > capacity) {
                DLList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
                currCapacity--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            DLList minFreqList = freqMap.getOrDefault(1, new DLList());
            minFreqList.insert(newNode);
            freqMap.put(minFreq, minFreqList);
            cache.put(key, newNode);
        }
    }

    private void updateList(Node node) {
        int currFreq = node.freq;
        DLList currFreqList = freqMap.get(currFreq);
        currFreqList.remove(node);
        if (currFreq == minFreq && currFreqList.size == 0)
            minFreq++;
        currFreq++;
        node.freq = currFreq;
        DLList upgradedFreqList = freqMap.getOrDefault(currFreq, new DLList());
        upgradedFreqList.insert(node);
        freqMap.put(currFreq, upgradedFreqList);
    }
}

package Solutions;

import sun.jvm.hotspot.debugger.windbg.DLL;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode{
        private int key;
        private int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DLinkedNode>(capacity);
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //hash查
        if (!map.containsKey(key)){
            return -1;
        }
        DLinkedNode node = map.get(key);
        moveToHead(node);
        return node.value;
        //更新链表位置
    }

    public void put(int key, int value) {
        //如果有，更新值
        if (map.containsKey(key)){
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            DLinkedNode node = new DLinkedNode(key, value);
            if (map.size() == this.capacity){
                //remove队尾节点
            }
            map.put(key, node);
            addToHead(node);
        }
        //没有，新增，并且判断是否超长；超长删除尾节点；

        //更新链表位置
    }
}

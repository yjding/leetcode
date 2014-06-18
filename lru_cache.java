import java.util.Hashtable;

class DoublyLinkedListNode{
    int key = 0;
    int val = 0;
    DoublyLinkedListNode pre = null;
    DoublyLinkedListNode next = null;
    
    DoublyLinkedListNode(int key, int value){
        this.key = key;
        val = value;
    }
}

public class LRUCache{
    int maxsize = 0;
    DoublyLinkedListNode head=null;
    DoublyLinkedListNode end=null;
    Hashtable<Integer, DoublyLinkedListNode> hashtable;
    int len = 0;

    public LRUCache(int capacity){
        maxsize = capacity;
        hashtable = new Hashtable<Integer, DoublyLinkedListNode>(capacity);
    }
    
    void removeNode(DoublyLinkedListNode node){
        if(node==null) return;
        if(len<=1){
            head = null;
            end = null;
        }else{
            if(node.pre==null){
                head = node.next;
                head.pre = null;
                node.next = null;
            }else{
                if(node.next==null){
                    end = node.pre;
                    end.next = null;
                }else{
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    node.pre = null;
                    node.next = null;
                }
            }
        }

    }

    void moveHead(DoublyLinkedListNode node){
        if(head==null){
            head = node;
            end = node;
        }else{
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    public int get(int key){
        if(!hashtable.containsKey(key)){
            return -1;
        }
        DoublyLinkedListNode node = hashtable.get(key);
        removeNode(node);
        moveHead(node);
        return node.val;
    }

    public void set(int key, int value){
        DoublyLinkedListNode node;
        if(hashtable.containsKey(key)){
            node = hashtable.get(key);
            node.val = value;
            removeNode(node);
            moveHead(node);
        }else{
            if(len==maxsize){
                hashtable.remove(end.key);
                removeNode(end);
                node = new DoublyLinkedListNode(key, value);
                moveHead(node);
                hashtable.put(key, node);
            }else{
                node = new DoublyLinkedListNode(key, value);
                moveHead(node);
                len += 1;
                hashtable.put(key, node);
            }
        }
    }
}

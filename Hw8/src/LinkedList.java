public class LinkedList {
        private class Node {
            private Object data;
            private Node next, prev;

            private Node(Object data, Node pref, Node next) {
                this.data = data;
                this.prev = pref;
                this.next = next;
            }
        }

        private Node head;
        private int size;

        public LinkedList() {
            this.head = new Node(null, null, null);
            this.head.next = this.head;
            this.head.prev = this.head;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.head == this.head.next;
        }
        @Override
        public String toString() {
        String result = "( ";
        for (Node node = this.head.next; node != this.head;
             node = node.next) {
            result += node.data + ",";
        }
        return result + ")";
        }
        public void addFirst(Object data) {
            Node nn = new Node(data, this.head, this.head.next);
            this.head.next.prev = nn;
            this.head.next = nn;
            this.size++;
        }
        public void addLast(Object data) {
            Node cur = this.head.prev;
            Node nn = new Node(data, cur, cur.next);
            cur.next.prev = nn;
            cur.next = nn;
            this.size++;
        }
        public Object getSize() { // have him check this
            return this.size;
        }
        public Object getFirst() {
            Node cur = this.head.next;
            return cur.data;
        }
        public Object removeFirst() {
            Node cur = this.head.next;
            Object temp = cur.data;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            this.size--;
            return temp;
        }
        public LinkedList merge(LinkedList listA, LinkedList listB) {
           LinkedList listC =  new LinkedList(); //with size equal to size(A) + size(B)?
            Object firstA, firstB;
            while(!listA.isEmpty() && !listB.isEmpty()) {
               firstA = listA.getFirst();
               firstB = listB.getFirst();
               if(Integer.parseInt(String.valueOf(firstA)) < Integer.parseInt(String.valueOf(firstB))) {
                   listA.removeFirst();
                   listC.addLast(firstA);
               }
               else {
                   listB.removeFirst();
                   listC.addLast(firstB);
               }
           }
           while(!listA.isEmpty()) {
               firstA = listA.getFirst();
               listC.addLast(firstA);
               listA.removeFirst();
           }
            while(!listB.isEmpty()) {
                firstB = listB.getFirst();
                listC.addLast(firstB);
                listB.removeFirst();
            }
        return listC;
        }
        public void mergeSort() {
            Queue queue = new Queue();
            for(Node cur = this.head.next; cur != this.head; cur = cur.next) {
                LinkedList newList = new LinkedList();
                newList.addFirst(cur.data);
                queue.enqueue(newList);
            }
            while(queue.size() > 1) {

                LinkedList sublist1 = (LinkedList) queue.dequeue();
                LinkedList sublist2 = (LinkedList) queue.dequeue();
                LinkedList tempList = merge(sublist1, sublist2);
                queue.enqueue(tempList);
            }
            LinkedList newlist = (LinkedList) queue.dequeue();
            this.head = newlist.head;
            }
        public void insertionSort() {
            Node lastSorted, sortedWalker;
            Comparable firstUnsortedData;
            for(lastSorted=this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next ) {
                firstUnsortedData = (Comparable)lastSorted.next.data;
            for(sortedWalker=lastSorted; sortedWalker != head && ((Comparable)sortedWalker.data).compareTo(firstUnsortedData) > 0;
                sortedWalker = sortedWalker.prev){
                sortedWalker.next.data = sortedWalker.data;
            }
            sortedWalker.next.data = firstUnsortedData;
            }
        }
        public boolean isSorted() {
            if(head == null) {
                return true;
            }
            for(Node cur = this.head.next; cur != this.head; cur = cur.next) {
                if(((Comparable)cur.data).compareTo(cur.next.data) >= 0) {
                    return true;
                }
            }
            return false;
    }
}

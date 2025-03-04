package dingcorithm.two_week;

class NodeList {
    int data;
    NodeList link;

    public NodeList(int data) {
        this.data = data;
        this.link = null;
    }

    public int getData() {
        return this.data;
    }
}

class LinkedList {
    private NodeList head;

    // 생성자 만들 시, head 초기화
    public LinkedList(int data) {
        this.head = new NodeList(data);
    }

    // linkedList append 구현
    public void append(int data) {
        NodeList newNode = new NodeList(data);

        if(head == null) {
            this.head = newNode;
        } else {
            NodeList tempNode = head;
            while(tempNode.link != null) {
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }

    }

    // 1. 첫번째 방식 node 에 담긴 값들을 string 으로 변환해서 해당 linkedList 의 모든 값들을 String으로 합쳐주기
    // 2. 두번째 방식으로는 node 에 담긴 값들을 다 더해주는데 앞선 node 에 *10을 하면서 하는 방식이 있다.
    public int sumList() {
        NodeList tempNode = this.head;
        StringBuilder sum = new StringBuilder();
        while(tempNode != null) {
            sum.append(tempNode.getData());
            tempNode = tempNode.link;
        }
        return Integer.parseInt(sum.toString());
    }
}

public class LinkedListSum {

    public static void main(String[] args) {
        LinkedList linkedListFirst = new LinkedList(6);
        linkedListFirst.append(7);
        linkedListFirst.append(8);

        LinkedList linkedListTwo = new LinkedList(3);
        linkedListTwo.append(5);
        linkedListTwo.append(4);

        System.out.println(getLinkedListSum(linkedListFirst, linkedListTwo));

    }

    private static int getLinkedListSum(LinkedList linkedListFirst, LinkedList linkedListTwo) {
        return linkedListFirst.sumList() + linkedListTwo.sumList();
    }
}



package dingcorithm.two_week;

class Node {
    int data;
    Node link;             // link 를 포함한 node

     public Node(int data) {
         this.data = data;
         this.link = null;
     }
}


class LinkedList2 {

    Node head;

    public LinkedList2(int value) {
        this.head = new Node(value);
    }

    public void append(int value) {
        Node temp = this.head;
        while (temp.link != null) {
            temp = temp.link;
        }

        temp.link = new Node(value);
    }

    // 리스트 끝에서 K번째 값 출력
    // 내가 푼 풀이
    public Node getKthNodeFromLast(LinkedList2 list, int k) {
        // 맨 마지막의 인덱스 구하기
        Node temp = list.head;
        int size = 1;
        while(temp.link != null) { // temp 는 link 를 따라감
            temp = temp.link;
            size++; // 맨 마지막 사이즈 구하기
        }

        // 특정 인덱스의 데이터 뽑아오기 2
        int idx = 0;
        int index = size - k;
        temp = list.head;
        while(idx != index) {
            temp = temp.link;
            idx++;
        }
        return temp;
    }

    // 리팩토링
    public Node getKthNodeFromLast2(LinkedList2 list, int k) {
        // 맨 마지막의 인덱스 구하기
        Node temp = list.head;
        int size = 1;
        while(temp.link != null) { // temp 는 link 를 따라감
            temp = temp.link;
            size++; // 맨 마지막 사이즈 구하기
        }

        // 특정 인덱스의 데이터 뽑아오기 2
        int idx = 0;
        temp = list.head;
        while(idx != (size - k)) {
            temp = temp.link;
            idx++;
        }
        return temp;
    }
}

public class KthNodeFromLast {

    public static void main(String[] args) {
        LinkedList2 linkedList2 = new LinkedList2(6);
        linkedList2.append(7);
        linkedList2.append(8);

        // [6]->[7]->[8]
        System.out.println(linkedList2.getKthNodeFromLast(linkedList2,2).data);
    }


}

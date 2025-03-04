package dingcorithm.two_week;

class ListNode {

    // java 에서 LinkedList 는 연산을 수행하기 쉽도록 get(index) 형태의 메서드를 제공하지만
    // 메서드 내부의 동작은 순차 탐색으로 이루어져있다.
    private String data;            // 데이터 저장 변수
    public ListNode link;   // 다른 노드를 참조할 링크노드

    public ListNode() {
        this.data = null;
        this.link = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }


}

public class AppendLinkedList {

    private ListNode head;      // ListNode 타입의 head 노드 인스턴스 변수

    // head 초기화
    public AppendLinkedList() {
        head = null;
    }

    // 중간 삽입
    public void insertNode(ListNode preNode, String data) {
        // 노드만 만들어진 LinkedList
        ListNode newNode = new ListNode(data);

        newNode.link = preNode.link;
        preNode.link = newNode;
    }

    // 마지막 삽입
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);
        if(head == null) {
            this.head = newNode;
        } else {
            ListNode tempNode = head;
            while(tempNode.link != null) {
                tempNode = tempNode.link;
            }

            tempNode.link = newNode;
        }
    }

    // 검색
    public ListNode searchNode(String data) {
        ListNode tempNode = this.head;

        while(tempNode != null) {
            if(data.equals(tempNode.getData())) {
                return tempNode;
            } else {
                tempNode = tempNode.link;
            }
        }

        return tempNode;
    }

    // 출력
    public void printList() {
        ListNode tempNode = this.head;

        while(tempNode != null) {
            System.out.println(tempNode.getData() + " ");
            tempNode = tempNode.link;
        }
        System.out.println();
    }

    // index 번째 노드 반환
    public ListNode getNode(int index) {
        ListNode tempNode = this.head;
         int idx = 0;

         while(idx != index) {
             tempNode = tempNode.link;
             idx += 1;
         }

         return tempNode;
    }

    // index 번째 원소 추가
    public static void insertNodeByIndex(AppendLinkedList linkedList, int index, String data) {
        ListNode newNode = new ListNode(data);

        if(index == 0) {
            newNode.link = linkedList.head;
            linkedList.head = newNode;
        } else {
            ListNode prevNode = linkedList.getNode(index - 1);
            newNode.link = prevNode.link;
            prevNode.link = newNode;
        }

    }

    // index 번째 원소 삭제
    public static void deleteNodeByIndex(AppendLinkedList linkedList, int index) {

        ListNode nextNode = linkedList.getNode(index + 1);
        if(index == 0) {
            linkedList.head = nextNode;
        } else {
            // 이전 노드
            ListNode prevNode = linkedList.getNode(index - 1);
            // 현재 인덱스의 다음 노드의 링크를 향하게 하면 된다.
            prevNode.link = nextNode;
        }
    }


    public static void main(String[] args) {
        AppendLinkedList linkedList = new AppendLinkedList();  // 연결 리스트 생성
        String data = "팰월드";
        linkedList.insertNode("게임 : ");
        linkedList.insertNode("재밌다");
        linkedList.insertNode("다같이");
        linkedList.insertNode("노가다");
        linkedList.insertNode("더재밌음");

        linkedList.printList();

        // node 검색 테스트
//        ListNode preNode = linkedList.searchNode("게임 : ");
        // node 중간 삽입 테스트
//        linkedList.insertNode(preNode, data);

        // 모두 출력 테스트
//        linkedList.printList();

        // index 로 원소 찾기 테스트
//        System.out.println(linkedList.getNode(1).getData());

        // index 로 중간 추가 테스트
//        insertNodeByIndex(linkedList,0, data);
//        linkedList.printList();

        // index 로 중간 삭제 테스트
//        deleteNodeByIndex(linkedList, 0);
//        linkedList.printList();
    }


}

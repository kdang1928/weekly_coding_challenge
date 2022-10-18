package oct172022;

public class IntersectingLinkedList {
    static class Node {
        int val;
        Node next;
        Node(int v)
        {
            val = v;
            next = null;
        }
    }

    public static Node getIntersectionNode(int N, int M, Node headA, Node headB) {
        if(N > M){
            for(int i = 0; i < (N-M); i++){
                headA = headA.next;
            }
        } else if (M > N) {
            for(int i = 0; i < (M-N); i++){
                headB = headB.next;
            }
        }

        Node intersect = null;
        while(headB!=null && headA!=null){
//            System.out.printf("%d, %d\n", headA.val, headB.val);
            if(headA.val==headB.val){
                if(intersect==null) intersect = headA;
//                System.out.println(intersect.val);
            } else {
                intersect = null;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return intersect;
    }

    public static void main(String[] args) {
        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = new Node(8);

        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(1);
        headB.next.next.next = new Node(8);

        System.out.println(getIntersectionNode(3, 4, headA, headB).val);
    }
}

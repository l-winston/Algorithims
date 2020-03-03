public class LinkedLists {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

        a = reverse(a);
        b = reverse(b);

        ListNode<Integer> c = null;
        ListNode<Integer> head = null;

        int rem = 0;
        while (a != null && b != null) {
            int val = a.value + b.value + rem;
            rem = val / 10000;
            if (c == null) {
                c = new ListNode<Integer>(val % 10000);
                head = c;
            } else {
                c.next = new ListNode<Integer>(val % 10000);
                c = c.next;
            }

            a = a.next;
            b = b.next;
        }

        while (a != null) {
            int val = a.value + rem;
            rem = val / 10000;
            c.next = new ListNode<Integer>(val % 10000);
            c = c.next;
            a = a.next;
        }

        while (b != null) {
            int val = b.value + rem;
            rem = val / 10000;
            c.next = new ListNode<Integer>(val % 10000);
            c = c.next;
            b = b.next;
        }

        while (rem > 0) {
            c.next = new ListNode<Integer>(rem % 10000);
            c = c.next;
            rem = rem / 10000;
        }

        head = reverse(head);

        return head;
    }

    ListNode<Integer> reverse(ListNode<Integer> l) {
        ListNode<Integer> prev = null;
        ListNode<Integer> curr = l;
        ListNode<Integer> next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        ListNode<Integer> ret = null;
        ListNode<Integer> start = l;

        ListNode<Integer> prev = null;
        ListNode<Integer> curr = l;
        ListNode<Integer> next = null;

        while(true){

            prev = null;
            next = null;

            int c = 0;

            while(curr != null && c < k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

                c++;
            }

            if(ret == null) {
                ret = prev;
                break;
            }

            start.next = curr;
        }

        return ret;
    }

    public static void main(String[] args){


    }
}

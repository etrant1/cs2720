import java.util.Scanner;
// test cases implemented in deleteNode procedure & print procedure
public class LList {
    // reference to start of llist
    static ListNode head = null;
    static int counter;

    // constructor for llist nodes
    static class ListNode {
        int value;
        ListNode next = null;
        public ListNode (int value) {
            this.value = value;
        }
    }

    // addNode
    public static void addNode(int a){
        // initialize a node to store integer
        ListNode newNode = new ListNode(a);

        // if no other nodes, make new node the head
        if (LList.head == null) {
            LList.head = newNode;
        } else {
            // find last node in list
            ListNode curNode = LList.head;
            while (curNode.next != null){
                curNode = curNode.next;
            }
            // add node to end of last node in list
            curNode.next = newNode;
        }
        // reflect new nodes in counter
        counter++;
    }

    // deleteNode
    public static void deleteNode(int N) {
        // Test case 1: one value in linked list
        if (counter - N <= 1) {
            System.out.println("Null");
            return;
        }

        // Test case 3: input greater than size of linked list
        if (N > counter) {
            System.out.println("Position # cannot be greater than size of <llist>");
            return;
        }

        ListNode fast = head, slow = head; // initialize pointers at same position

        // move fast pointer to end of list
        for (int i = 0; i < N; i++) {
            fast = fast.next;
        }

        // search list for deletion index N
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete single element
        if (slow.next == null) {
            head = null;
            counter--;
            return;
        }

        // deleteNode at N
        slow.next = slow.next.next;
        // reflect change in list size
        counter--;
        return;
    }
    public static void printLList(){
        // Test case 2: list is empty
        if (LList.head == null) {
            System.out.println("<llist> is empty ノಠ益ಠノ彡┻━┻");
        }
        else {
            // reference to start of list
            ListNode curNode = LList.head;

            // output list values up to last node in list
            while (curNode.next != null) {
                System.out.print(curNode.value + " ");
                curNode = curNode.next; // move to next node
            }
            // output value of last node
            System.out.println(curNode.value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lets build a linked list! Type \"stop\" to execute program");
        while (true) {
            System.out.print("Enter linked list element: ");
            String input = scanner.nextLine();

            // error handling for cheeky users
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                if (input.equals("stop")) break;
                System.out.println("Please enter a valid number");
            }
            // generate node and add it to list
            addNode(Integer.parseInt(input));
        }

        System.out.print("\nYour <llist> : ");
        printLList();
        System.out.println();

        while (true) {
            System.out.print("Enter position to delete: ");
            String input = scanner.nextLine();

            // error handling for cheeky users
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                if (input.equals("stop")) break;
                System.out.println("Please enter a valid number");
            }
            // delete node @ position from list
            deleteNode(Integer.parseInt(input));
        }

        System.out.print("\nfinal <llist> : ");
        printLList();
    }
}

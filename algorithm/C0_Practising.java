import java.util.Stack;

public class C0_Practising {
    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void preOrder(Node head){
        if (head != null){
            System.out.print(head.val + " ");
            preOrder(head.left);
            preOrder(head.right);
        }
    }

    public static void inOrder(Node head){
        if (head != null){
            inOrder(head.left);
            System.out.print(head.val + " ");
            inOrder(head.right);
        }
    }

    public static void posOrder(Node head){
        if (head != null){
            posOrder(head.left);
            posOrder(head.right);
            System.out.print(head.val + " ");
        }
    }

    public static void preOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            while (!stack.isEmpty()){
                Node node =stack.pop();
                System.out.print(node.val + " ");
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
        }
    }

    public static void inOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.printf(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void posOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack_1 = new Stack<Node>();
            Stack<Node> stack_2 = new Stack<Node>();
            stack_1.push(head);
            while (!stack_1.isEmpty()){
                Node node =stack_1.pop();
                stack_2.push(node);
                if (node.left != null){
                    stack_1.push(node.left);
                }
                if (node.right != null){
                    stack_1.push(node.right);
                }

            }
            while (!stack_2.isEmpty()){
                System.out.print(stack_2.pop().val + " ");
            }
        }
    }




    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        preOrder(node1);    // 1 2 4 3 5
        System.out.println();

        inOrder(node1);     // 4 2 1 3 5
        System.out.println();

        posOrder(node1);    // 4 2 5 3 1
        System.out.println();

        System.out.println("-------------------------");

        preOrderUnRecur(node1);    // 1 2 4 3 5
        System.out.println();

        inOrderUnRecur(node1);     // 4 2 1 3 5
        System.out.println();

        posOrderUnRecur(node1);    // 4 2 5 3 1
        System.out.println();
    }
}

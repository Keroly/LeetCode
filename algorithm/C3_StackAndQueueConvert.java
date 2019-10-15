import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 使用两个队列表示栈   使用两个栈表示队列
public class C3_StackAndQueueConvert {
    public static class TwoQueueStack{ // 用两个队列实现栈     队尾12345队头   ->  队尾1234队头
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack(){
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void swap(){
            Queue<Integer> temp = help;
            help = queue;
            queue = temp;
        }
        public void push(int pushInt){
            queue.offer(pushInt);
        }

        public int peek(){
            if (queue.isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            while (queue.size()!=1){
                help.offer(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop(){
            if (queue.isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            while (queue.size()!=1){
                help.offer(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }
    }

    public static class TwoStacksQueue { // 用两个栈实现队列  两个水杯互相倒水
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}

import java.util.Stack;

// O(1),找到栈中最小值
public class C3_GetMinStack {
    public static class MyStack2{ // 使用两个栈
        private Stack<Integer> stackData; // 存真实数据
        private Stack<Integer> stackMin; // 存最小值数据  个数等于stackData

        public MyStack2(){
            stackData = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public int getMin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }

        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if (newNum < this.getMin()){
                this.stackMin.push(newNum);
            }else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            this.stackData.pop();
            return this.stackData.pop();
        }
    }
}

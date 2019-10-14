
public class C3_Array_To_Stack_Queue {

    public static class ArrayStack{
        private Integer[] arr;
        private Integer index; // 表示入栈应该放在哪

        public ArrayStack(int initSize) throws Exception { // 初始化栈
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        public void push (int obj){
            if (index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[index++] = obj;
        }

        public Integer peek(){
            if (index == 0){
                return null;
            }
            return arr[index -1];
        }

        public Integer pop(){
            if (index == 0){
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--index];
        }
    }

    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size; // 表示队列中已有元素个数,用于判断能不能入队,出队
        private Integer start; // 出队的位置
        private Integer end; // 入队的位置

        public ArrayQueue(int initsize){
            if (initsize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initsize];
            size = 0;
            start = 0;
            end = 0;
        }

        public void push (int obj){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size ++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer peek(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[start];
        }

        public Integer poll(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            int temp = start;
            start = start == arr.length -1 ? 0 : start + 1;
            return arr[temp];
        }
    }
}

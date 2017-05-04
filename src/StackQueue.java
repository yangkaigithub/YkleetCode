import java.util.Stack;

/**
 * Created by tpusers on 2017/3/14.
 */
public class StackQueue {
    Stack<Integer> pushstack;
    Stack<Integer> popstack;
    public StackQueue(){
        pushstack = new Stack<Integer>();
        popstack = new Stack<Integer>();
    }
    public void push(Integer m){
        pushstack.push(m);
    }
    public Integer pop(){
        if(popstack.isEmpty()) {
            while (!pushstack.isEmpty()) {
                popstack.push(pushstack.pop());
            }
        }
        return popstack.pop();
    }
    public static void main(String[] args){
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        stackQueue.push(5);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        stackQueue.push(6);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }

}

package Icof.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xwx_ on 2020/6/30
 */
public class CStack {

    private Queue<Integer> inputQueue;
    private Queue<Integer> outputQueue;

    public CStack() {
        // 输入输出队列
        inputQueue = new LinkedList<>();
        outputQueue = new LinkedList<>();
    }

    public void push(int value) {
        inputQueue.offer(value);
        // 将原有元素转移到输出队列
        while (!outputQueue.isEmpty()) {
            inputQueue.offer(outputQueue.remove());
        }
        // 交换输入输出队列
        Queue temp = inputQueue;
        inputQueue = outputQueue;
        outputQueue = temp;
    }

    public int pop() {
        return outputQueue.poll();
    }

    public int top() {
        return outputQueue.peek();
    }

    public boolean isEmpty() {
        return outputQueue.isEmpty();
    }

    public static void main(String[] args) {
        CStack cs = new CStack();
        cs.push(1);
        cs.push(2);
        cs.push(3);
        System.out.println(cs.pop());
        System.out.println(cs.top());
        System.out.println(cs.isEmpty());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.isEmpty());
    }
}

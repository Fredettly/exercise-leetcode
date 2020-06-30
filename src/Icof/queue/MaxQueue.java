package Icof.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xwx_ on 2020/6/30
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> helper;

    public MaxQueue() {
        queue = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public int max_value() {
        return helper.isEmpty() ? -1 : helper.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!helper.isEmpty() && value > helper.peekLast()) {
            helper.pollLast();
        }
        helper.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.poll();
        if (val == helper.peek()) {
            helper.poll();
        }
        return val;
    }

    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        mq.push_back(4);
        mq.push_back(3);
        mq.push_back(5);
        mq.push_back(2);
        System.out.println(mq.max_value());
        System.out.println(mq.pop_front());
        System.out.println(mq.pop_front());
        System.out.println(mq.max_value());
        System.out.println(mq.pop_front());
        System.out.println(mq.max_value());

    }
}

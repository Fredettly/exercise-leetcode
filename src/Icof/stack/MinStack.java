package Icof.stack;
/**
 * Created by xwx_ on 2020/6/14
 */

import java.util.Stack;

/**
    155. 最小栈
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) —— 将元素 x 推入栈中。
    pop() —— 删除栈顶的元素。
    top() —— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。


    示例:

    输入：
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    输出：
    [null,null,null,null,-3,null,0,-2]

    解释：
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> 返回 -3.
    minStack.pop();
    minStack.top();      --> 返回 0.
    minStack.getMin();   --> 返回 -2.


    提示：

    pop、top 和 getMin 操作总是在 非空栈 上调用。
 */


//解法：辅助栈

public class MinStack {
    class MinStackA {

        public Stack<Integer> dataStack;
        public Stack<Integer> minStack;

        public MinStackA() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (dataStack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }


        public int top() {
            return dataStack.peek();
        }


        public int getMin() {
            return minStack.peek();
        }
    }

// 解法：Stack<Node>

    class MinStackB {
        private class Node {
            int val;
            int min;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        public Stack<Node> stack;

        public MinStackB() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new Node(x, x));
            } else {
                stack.push(new Node(x, Math.min(stack.peek().min, x)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }


// 解法：单链表定义栈

    static class MinStackC {
        private class Node {
            int val;
            int min;
            Node next;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        private Node head;

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
            } else {
                head = new Node(x, Math.min(head.min, x), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

}



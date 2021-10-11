package com.oasis.problems.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 最小栈 单调栈的应用
public class LC155 {
    class MinStack {
        private Stack<List<Integer>> stk = null;

        /** initialize your data structure here. */
        public MinStack() {
            this.stk = new Stack<>();
        }

        public void push(int val) {
            if (stk.isEmpty()) {
                this.stk.add(Arrays.asList(val, val));
                return;
            }
            this.stk.add(new ArrayList<Integer>(){{
                add(val);
                add(Math.min(stk.peek().get(1), val));
            }});
        }

        public void pop() {
            stk.pop();
        }

        public int top() {
            return stk.peek().get(0);
        }

        public int getMin() {
            return stk.peek().get(1);
        }
    }

}

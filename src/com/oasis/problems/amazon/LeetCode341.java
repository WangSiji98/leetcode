package com.oasis.problems.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LeetCode341 {
    // 对外暴露的接口，我们不需要自己实现
    public static interface NestedInteger {
 
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
  }
    
    public static class NestedIterator implements Iterator<Integer> {
        private List<Integer> res;
        int curIndex;

        public NestedIterator(List<NestedInteger> nestedList) {
            res = new ArrayList<>();
            getNum(nestedList);
            curIndex = 0;
        }

        private void getNum(List<NestedInteger> nestedList) {

            for (int i = 0; i < nestedList.size(); ++i) {
                NestedInteger cur = nestedList.get(i);
                if (cur.isInteger()) {
                    res.add(cur.getInteger());
                } else {
                    getNum(cur.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return res.get(curIndex++);
        }

        @Override
        public boolean hasNext() {
            return curIndex < res.size();
        }
    }

}

package com.oasis.problems.amazon.oa;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  missing lru
 *
 *  https://algo.monster/problems/count_lru_cache_misses
 *
 *  A virtual memory management system use least-recently-Used (LRU) cache. When a requested memory page is not in the cache and the cache is full, the page that was least-recently-used should be removed from the cache to make room for the requested page. If the cache is not full, the requested page can simply be added to the cache and considered the most-recently-used page in the cache. A given page should occur at most once in the cache.
 *
 * Given the maximum size of the cache and a list of page requests,write an algorithm to calculate the number of cache misses. A cache miss occurs when a page is requested and isn't found in the cache.
 *
 * int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize)
 * Input
 * The input consists of three arguments:
 *
 * num : an integer representing the number of pages
 *
 * pages : a list of integers representing the pages requested
 *
 * maxCacheSize : an integer representing the size of the cache
 *
 * Output
 * Return an integer for the number of cache misses.
 *
 * Note
 * The cache is initially empty and the list contains pages numbered in the range 1-50. A page at index "i" in the list is requested before a page at index "i+1".
 *
 * Constraints
 * 0 <= i < num
 *
 * Examples
 * Example 1:
 * Input:
 * num = 6
 *
 * pages = [1,2,1,3,1,2]
 *
 * maxCacheSize = 2
 *
 * Output: 4
 * Explanation:
 *   Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache:
 *
 *   1*
 *
 *   1,2*
 *
 *   2,1
 *
 *   1,3*
 *
 *   3,1
 *
 *   1,2*
 *
 *   Asterisk (*) represents a cache miss. Hence, the total number of a cache miss is `4`.
 */

class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    private int miss = 0;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public void get(int key) {
        if (!super.containsKey(key)) {
            super.put(key, 0);
            ++miss;
        } else {
            super.get(key);
        }
    }

    public int getMiss() {
        return miss;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

// 如果是 OA 直接使用java的LinkedHashMap

public class OA13_1 {
    private LRUCache cache = null;

    public int cacheMiss(int n, int[] pageRequests, int maxCacheSize) {
        cache = new LRUCache(maxCacheSize);
        for (int page: pageRequests) {
            cache.get(page);
        }
        return cache.getMiss();
    }

    public static void main(String[] args) {
        OA13_1 oa13_1 = new OA13_1();
        int[] pages = new int[]{1,2,1,3,1,2};
        System.out.println(oa13_1.cacheMiss(6, pages, 2));
    }
}

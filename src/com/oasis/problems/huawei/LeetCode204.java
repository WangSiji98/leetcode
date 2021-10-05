package com.oasis.problems.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 暴力枚举，那肯定是超时
class Solution1 {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        int res = 1;
        for (int i = 3; i < n; ++i) {
            if (i % 2 == 1 && checkPrime(i)) {
                ++res;
            }
        }
        return res;
    }

    private boolean checkPrime(int n) {
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// 埃式筛
class Solution2 {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}

// 线性筛
class Solution3 {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}

// 经典算法 计算质数
public class LeetCode204 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.countPrimes(10));

    }

}

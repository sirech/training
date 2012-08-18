package com.hceris.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.hceris.strings.AFIStrings;


public class Sequences {
    private Sequences() {}

    public static int[] longestIncreasingRun(int[] a) {
        int longestRun = 1;
        int last = 0;
        int currentRun = 1;

        for(int i = 1; i < a.length; i++) {
            if(a[i-1] < a[i]) {
                currentRun++;
                if(currentRun > longestRun) {
                    longestRun = currentRun;
                    last = i;
                }
            } else {
            	    	currentRun = 1;
            }
        }

        int[] run = new int[longestRun];
        for(int i = longestRun - 1; i >= 0; i--) {
            run[i] = a[last - longestRun + 1 + i];
        }
        return run;
    }

    public static int[] longestIncreasingSequence(int[] a) {
        int[] seq = new int[a.length];
        int[] prev = new int[a.length];
        int max = 0;

        for(int i = 0; i < a.length; i++) {
            seq[i] = 1;
            prev[i] = -1;

            for(int j = 0; j < i; j++) {
                if(a[j] < a[i] && seq[j] + 1 > seq[i]) {
                    seq[i] = seq[j] + 1;
                    prev[i] = j;
                }
            }

            if(seq[i] > seq[max]) {
                max = i;
            }
        }

        int[] res = new int[seq[max]];
        for(int i = seq[max] - 1, k = max; k != -1; i--, k = prev[k]) {
            res[i] = a[k];
        }
        return res;
    }

    public static int[] maximumSubArray(int[] a) {
        int start = -1;
        int end = -2;
        int max = 0;
        int maxhere = 0;

        for(int i = 0; i < a.length; i++) {
            int newmaxhere = Math.max(0, maxhere + a[i]);
            if(newmaxhere > max) {
                max = newmaxhere;
                end = i;
                if(maxhere == 0) {
                    start = i;
                }
            }
            maxhere = newmaxhere;
        }

        int[] res = new int[end - start + 1];
        for(int i = 0; i < res.length; i++) {
            res[i] = a[i + start];
        }

        return res;
    }

    public static int cutRod(int[] p, int n) {
        int[] partial = new int[n + 1];
        int[] cuts = new int[n + 1];
        partial[0] = 0;

        for(int i = 1; i <= n; i++) {
            int q = -1;
            for(int j = 1; j <= i; j++) {
                if( q < p[j] + partial[i - j]) {
                    q = p[j] + partial[i - j];
                    cuts[i] = j;
                }
            }
            partial[i] = q;
        }

        return partial[n];
    }

    public static String longestCommonSubsequence(String a, String b) {
        return new String(longestCommonSubsequence(a.toCharArray(), b.toCharArray()));
    }

    public static char[] longestCommonSubsequence(char[] a, char[] b) {
        int[][] m = new int[a.length + 1][b.length + 1];

        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                if(a[i-1] == b[j-1]) {
                    m[i][j] = m[i-1][j-1] + 1;
                } else {
                    m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
                }
            }
        }

        char[] res = new char[m[a.length][b.length]];
        for(int k = res.length - 1, i = a.length, j = b.length; i > 0 && j > 0; ){
            if(a[i - 1] == b[j - 1]) {
                res[k] = a[i - 1];
                k--; i--; j--;
            } else if (m[i][j - 1] > m[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        return res;
    }
    
    public static String longestPalindrome(String s) {
       return longestCommonSubsequence(s, new String(AFIStrings.reverse(s)));
    }
    
    public static String longestContiguousPalindrome(String s) {
        String longest = s.substring(0, 1);

        for(int i = 0; i < s.length() - 1; i++) {
            String p1 = expandAroundCenter(s, i, i);
            if(p1.length() > longest.length()) {
                longest = p1;
            }

            String p2 = expandAroundCenter(s, i, i+1);
            if(p2.length() > longest.length()) {
                longest = p2;
            }
        }
        
        return longest;
    }

    public static String longestSubstringWithoutRepetition(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        String longest = "";
        Set<Character> seen = new HashSet<Character>();

        while(j < s.length()) {
            if(!seen.add(s.charAt(j))) {
            	if(j - i > max) {
            		max = j - i;
            		longest = s.substring(i, j);
            	}
                while(s.charAt(i) != s.charAt(j)) {
                    seen.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            j++;
        }

        return longest;
    }

    private static String expandAroundCenter(String s, int c1, int c2) {
        int left = c1;
        int right = c2;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }

    public static int minDistance(Iterable<String> words, String w1, String w2) {
        int distance = Integer.MAX_VALUE;
        int counter = 0;
        String lastWord = "";

        for(String word : words) {
            if(word.equals(w1) || word.equals(w2)) {
                if(!lastWord.isEmpty() && !lastWord.equals(word)) {
                    distance = Math.min(distance, counter);
                }
                
                lastWord = word;
                counter = 0;
            } else {
                counter++;
            }
        }

        return distance;
    }
    
    public static int editDistance(String a, String b) {
        return editDistance(a.toCharArray(), b.toCharArray());
    }

    public static int editDistance(char[] a, char[] b) {
        int[][] m = new int[a.length + 1][b.length + 1];
        
        for(int i = 0; i < a.length + 1; i++) {
        	m[i][0] = i;
        }
        
        for(int j = 0; j < b.length + 1; j++) {
        	m[0][j] = j;
        }

        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                if(a[i-1] == b[j-1]) {
                    m[i][j] = m[i-1][j-1];
                } else {
                    m[i][j] = Math.min(m[i-1][j], Math.min(m[i][j-1], m[i-1][j-1])) + 1;
                }
            }
        }
        
        return m[a.length][b.length];
    }

    public static int[] productsExceptSelf(int[] a) {
        int[] result = new int[a.length];
        int[] before = new int[a.length];
        int[] after = new int[a.length];

        before[0] = 1;
        for(int i = 1; i < a.length; i++) {
            before[i] = before[i-1] * a[i-1];
        }

        after[a.length - 1] = 1;
        for(int i = a.length - 2; i >= 0; i--) {
            after[i] = after[i+1] * a[i+1];
        }

        for(int i = 0; i < a.length; i++) {
            result[i] = before[i] * after[i];
        }
        return result;
    }

    public static int minJumps(int[] a) {
        int[] min = new int[a.length];

        for(int i = 1; i < a.length; i++) {
            int partial = -1;
            for(int j = 0; j < i; j++) {
                if(a[j] + j >= i && (partial == -1 || min[j] + 1 < partial)) {
                    partial = min[j] + 1;
                }
            }
            min[i] = partial;
        }

        return min[a.length - 1];        
    }
    
    // assumption: every element >= 0
    public static int[] subarrayWithSum(int[] a, int target) {
    	int left = 0;
    	int right = 0;
    	int sum = a[0];
    	
    	while(right < a.length && sum != target) {
    		if(sum < target) {
    			right++;
    			if(right < a.length) {
    				sum += a[right];
    			}
    		} else {
    			sum -= a[left++];
    		}
    	}
    	
    	if(sum == target) {
    		return new int[] { left, right };
    	} else {
    		return new int[] {};
    	}
    }

    public static int[] generalSubarrayWithSum(int[] a, int target) {
        int[] sumThusFar = new int[a.length];
        Map<Integer,Integer> inverse = new HashMap<Integer,Integer>();

        for(int i = 0; i < a.length; i++) {
            sumThusFar[i] = a[i] + (i > 0 ? sumThusFar[i-1] : 0);
            inverse.put(sumThusFar[i], i);

            if(sumThusFar[i] == target) {
                return new int[] { 0, i };
            }
        }

        for(int i = 1; i < a.length; i++) {
            Integer rest = inverse.get(sumThusFar[i] - target);
            if(rest != null) {
                return new int[] { rest + 1, i };
            }
        }

        return new int[] {};
    }
}

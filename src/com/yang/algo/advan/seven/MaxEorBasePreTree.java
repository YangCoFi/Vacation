package com.yang.algo.advan.seven;

public class MaxEorBasePreTree {
    public static class Node {
        public Node[] nexts = new Node[2];      //这个Node只有下一级的数组nexts，只有2个路 一个是0的路，一个是1的路
    }

    public static class NumTrie {
        public Node head = new Node();

        /**
         * 无论加一个数add还是选择一个最大值maxXor 因为for循环是32次，所以他们都是常数级别的。
         * 而整个代码套在一个O(N)的代码(maxXorSubarray)里
         *  for (int i = 0; i < arr.length; i++) 所以最后的时间复杂度O(N)
         * */


        //path代表路  cur.nexts[path]就是这个路尽头有无节点，没有，就没有这个路
        public void add(int num) {
            Node cur = head;
            //把每个位上的数字提取出来，加到前缀树里面去
            for (int move = 31; move >= 0; move--) {        //整数是32位
                int path = ((num >> move) & 1);     //右移31位之后，符号位来到最后，再与1，就可以得到此时符号位的数，path要么0，要么1
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];   //当前节点有无走path的路，没有就建上Node
                cur = cur.nexts[path];
            }
        }

        /***
         * @param num    就是0--i的异或结果
         * 对于符号位来说，他希望选择的路应该和符号位的数一样，因为异或的结果就是0
         * 不是符号位，你是0我就选1，你是1我就选0
         * 一定能走到底的，因为一开始加数字进来就是32位的。不可能既没0，又没1
         */

        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                int best = move == 31 ? path : (path ^ 1);  //就是我期待要选的路
                best = cur.nexts[best] != null ? best : (best ^ 1); //我实际要选的路  因为这条路可能有也可能没有
               //结果依次设置好，每一次从高位开始选，每选一条路，实际上结果相应的位置上的那个值就确定了
                res |= (path ^ best) << move;   //设置每一位的答案
                cur = cur.nexts[best];
            }
            return res;
        }
    }

    /**
     * @numTrie;黑盒
     * 黑盒的作用：你扔我一个从0到i的结果，我这个黑盒里面有所有的从0到0，从0到1，从0到2，从0到i-1的结果。OK我给你选择一个你能得到的最大的xor的值
     * eor永远是从0到i的异或值     0...i
     * 所以每一次往黑盒里面丢的时候就是0到i的丢进去，下面你要算i+1位置了，你往黑盒里面不断的扔东西就可以了
     * 每个位置结尾的最大异或值黑盒会告诉你，不用你去操心。
     * */
    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];      //eor    0...i异或值
            max = Math.max(max, numTrie.maxXor(eor));//numTrie.maxXor(eor) 你给我0...i的异或值，我给你以i结尾的最大异或值
            numTrie.add(eor);
        }
        return max;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j < arr.length; j++) {
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = maxXorSubarray(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

class Solution {
    class Pair {
        int val, arrNum;
        Pair (int val, int arrNum) {
            this.val = val;
            this.arrNum = arrNum;
        }
    }
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int MAX = 2500;
        
        Pair[] arr = new Pair[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++)   arr[i] = new Pair(arr1[i], 1);
        for (int i = 0; i < arr2.length; i++)   arr[i + arr1.length] = new Pair(arr2[i], 2);
        Arrays.sort(arr, (a,b) -> Integer.compare(a.val, b.val));
        int N = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].val != arr[N].val) {
                ++N;
                arr[N] = arr[i];
            }
            else {
                if (arr[i].arrNum == 2) arr[N].arrNum = 2;
            }
        }
        ++N;
        
        int[][] f = new int[arr1.length][N];
        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < N; j++)
                f[i][j] = MAX;
        
        for (int j = 0; j < N; j++) {
            if (arr[j].val < arr1[0]) {
                if (arr[j].arrNum == 2) {
                    for (int k = j; k < N; k++)
                        f[0][k] = 1;
                }
            }
            else {
                f[0][j] = 0;
            }
        }
        
        for (int i = 1; i < arr1.length; i++)
            for (int j = 1; j < N; j++) {
                int cost;
                if (arr[j].arrNum == 2)
                    cost = 1;
                else
                    cost = MAX;
                if (arr[j].val == arr1[i])  cost = 0;
                f[i][j] = Math.min(f[i][j-1], f[i-1][j-1] + cost);
            }
        
        if (f[arr1.length-1][N-1] >= MAX) return -1;
        return f[arr1.length-1][N-1];
    }
}

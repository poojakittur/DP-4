/*
 * Time complexity : O(n)
 * Space complexity : O(1)
 */
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        if(A == null || A.length == 0){
            return 0;
        }
        
        int[] dp = new int[A.length];
        for(int i=0; i<A.length; i++){
            int max = 0;
            
            for(int j = 1; i-j+1 >= 0 && j <= K; j++){
                max = Math.max(max, A[i-j+1]);
                
                if(i >= j){
                    dp[i] = Math.max(dp[i], max*j + dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        
        return dp[dp.length-1];
    }
}
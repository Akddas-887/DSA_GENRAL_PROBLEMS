static boolean isPalindrome(String str){
    int start=0;
    int end=str.length()-1;

    while(start<=end){
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;
}
static int solve(int i,int j,String str,int dp[][]){
    if(i==j){
        return 0;
    }

    if(dp[i][j]!=Integer.MAX_VALUE){
        return dp[i][j];
    }

    int mn=Integer.MAX_VALUE;
    String temp="";
    for(int k=i;k<str.length();k++){
        temp+=str.charAt(k);
        if(isPalindrome(temp)){
            int cost=1+solve(k+1,j,str,dp);
            mn=Math.min(cost,mn);
        }
    }
    return dp[i][j]=mn;
}
static int palindromicPartition(String str)
{

    //We ned to find fewest cuts as possible
    //for that we need to find (fewest palindromic substring as possible)-1

    //i-->starting of palindromic Substring
    //j-->ending of Palindromic Substring

    int n=str.length();
    int dp[][]=new int[n+1][n+1];

    for(int a[]:dp){
        Arrays.fill(a,Integer.MAX_VALUE);
    }
    return solve(0,n,str,dp)-1;
}
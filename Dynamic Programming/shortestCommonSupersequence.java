public static int findCommon(int i,int j,String str1,String str2,int dp[][]){
    if(i==0||j==0){
        return 0;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }

    if(str1.charAt(i-1)==str2.charAt(j-1)){
        return  dp[i][j]=1+findCommon(i-1,j-1,str1,str2,dp);
    }else{
        return dp[i][j]=Math.max(findCommon(i-1,j,str1,str2,dp),findCommon(i,j-1,str1,str2,dp));
    }
}
//Function to find length of shortest common supersequence of two strings.
public static int shortestCommonSupersequence(String X,String Y,int m,int n)
{
    int dp[][]=new int[m+1][n+1];
    for(int a[]:dp){
        Arrays.fill(a,-1);
    }
    //Its Like LCM
    return m+n-findCommon(m,n,X,Y,dp);
}
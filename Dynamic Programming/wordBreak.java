import java.util.*;

class wordBreak{
    public static boolean solve(int i,String str,Set<String> hs,boolean dp[]){
        if(i==str.length()){
            return true;
        }

        if(dp[i]){
            return dp[i];
        }

        String temp="";
        for(int j=i;j<str.length();j++){
            temp+=str.charAt(j);
            if(hs.contains(temp)){
                if(solve(j+1,str,hs,dp)){
                    return dp[j]=true;
                }
            }
        }

        return dp[i];
    }
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {

        //Add dictionary Elements in Set for check if String char is contains or not
        Set<String> hs=new HashSet<>();
        for(String str:dictionary){
            hs.add(str);
        }
        boolean dp[]=new boolean[s.length()];
        boolean ans=solve(0,s,hs,dp);

        if(ans){
            return 1;
        }else{
            return 0;
        }

    }
}
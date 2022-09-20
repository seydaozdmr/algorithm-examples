package org.com.algo.java;

public class RepeatedSubStrings {
    public static boolean repeatedSubStrings(String s){
        int length=s.length();
        for(int i=length/2;i>=1;i--){
            if(length%2==0){
                int numberOfSubstring=length/i;
                StringBuilder builder=new StringBuilder();
                String subString=s.substring(0,i);
                for(int j=0;j<numberOfSubstring;j++){
                    builder.append(subString);
                }
                if(builder.toString().equals(s))
                    return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubStrings("seydaseyda"));
    }
}

package org.example;

public class Permutation {

    public static void permute(String str,String Result){

if (str.length()==0){
    System.out.println(Result);
    return;
}
for (int i=0;i<str.length();i++){
    char current=str.charAt(i);
    String remaing=str.substring(0,i)+str.substring(i+1);
    permute(remaing,Result+current);
}



    }



/*
    public  static void permute(String str,String result){
           //base codition
        if (str.length()==0){
            System.out.println(result);
            return;
        }
        for (int i=0;i<str.length();i++){
            char current=str.charAt(i);
            String remaining=str.substring(0,i)+str.substring(i+1);
          permute(remaining,result+current);
        }


    }




    public static void main(String[] args) {

        String str="abc";
        permute(str, "");



 */

    public static void main(String[] args) {
        String str="abc";
        permute(str,"");

    }
}

package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

public class Anagrams {

    public static boolean isAnagram(String str,String str1){
        str=str.replaceAll("\\s","").toLowerCase();
        str1=str1.replaceAll("\\s","").toLowerCase();

        if (str.length()!=str1.length()){
            return false;
        }

        char[] arr1=str.toCharArray();
        char[] arr2=str1.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);



    }








/*
  public   static  boolean isAnagrams(String str1,String str2){
      str1=str1.replaceAll("\\s","").toLowerCase();
      str2=str2.replaceAll("\\s","").toLowerCase();

      if (str1.length()!=str2.length()){
          return false;

      }
// convert to chararray
      char[] arr1=str1.toCharArray();
      char[] arr2=str2.toCharArray();

// sorting
      Arrays.sort(arr1);
      Arrays.sort(arr2);


      //compare sorted arrays
      return Arrays.equals(arr1,arr2);

  }





    public static void main(String[] args) {
        String str1="abc";
        String str2="bca";

        if (isAnagrams(str1,str2)){
            System.out.println(str1+"   and  "+str2+"     are anagrams ");
        }else {
            System.out.println("not");
        }





    }

 */

    public static void main(String[] args) {
        String str="abc";
        String str1="bvc";
        if (isAnagram(str,str1)){
            System.out.println("anagram abc and bvc true:");
        }else {
            System.out.println("not  a anagrams ");
        }


    }





}

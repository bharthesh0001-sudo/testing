package org.example;

import java.util.HashSet;

public class ToFindDuplicate {
      public static void findDuplicate(String str){
          HashSet<Character> seen=new HashSet<>();
          HashSet<Character> Duplicate=new HashSet<>();
          for (char c1:str.toCharArray()){
              if (seen.contains(c1)){
                  Duplicate.add(c1);
              }else {
                  seen.add(c1);

              }
          }
          System.out.println("Duplicate cgaracter:"+Duplicate);
      }

    public static void main(String[] args) {
        String str="abca";
        findDuplicate(str);

    }
}

package org.example;

import org.openqa.selenium.json.JsonOutput;

import java.util.HashSet;

public class UniqueChar {

    public  static boolean yesUnique(String str){

        str=str.replaceAll("\\s","");
        str=str.toLowerCase();



        HashSet<Character> set = new HashSet<>();
      for (char c:str.toCharArray()){
          if (set.contains(c)){
              return false;

          }
          set.add(c);

      }return true;



    }





    public static void main(String[] args) {
        String  st1="bharathesh";
        String st2="yesbhart";

        System.out.println(st1+"  >"+yesUnique(st1));
        System.out.println(st2+" > "+yesUnique(st2));


    }
}

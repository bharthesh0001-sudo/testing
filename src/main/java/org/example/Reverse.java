package org.example;

public class Reverse {

public  static  String recusive(String name){
    if (name.isEmpty()||name.length()==1){ // base
        return name;
    }
    return recusive(name.substring(1))+name.charAt(0);

}

     public static void main(String[] args) {

    String name="abc";
    String rever=recusive(name);
        System.out.println("original name="  +name);
        System.out.println("reverse name="   +rever);


/*
        String name="bharthesh";
        String reverse="  ";
        for (int i=name.length()-1;i>=0;i--){
            reverse=reverse+name.charAt(i);
        }
        System.out.println(reverse);



    StringBuilder sb=new StringBuilder(name);
        System.out.println( sb.reverse());

       // String rev=sb.toString();
       // System.out.println(rev);



 */
    }
}

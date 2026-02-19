package org.example;


import java.util.concurrent.Callable;

public class Counter {

       /* int a=10;
        int m1(int a){
            System.out.println("show");
            return  this.a;

        }

        public static void main(String[] args) {
            Counter c=new Counter();
            int result= c.m1(100);
            System.out.println("m1()return value is" +result);
        }

        */
        Counter m1(){
            System.out.println("m1 method ");
            Counter c=new Counter();
            return c;

        }
        Counter m2(){
            System.out.println("m2 method ");
            return this ;

        }

        public static void main(String[] args) {
            Counter c=new Counter();
            Counter c1= c.m1();
          Counter c2=  c.m2();
        }





    }



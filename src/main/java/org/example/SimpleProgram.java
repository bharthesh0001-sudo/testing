package org.example;

public class SimpleProgram {
    public static void main(String[] args) {



        int dept=1;
        int role=2;

        switch(dept){
            case 1:
                System.out.println("softwarwe deptare");

                switch (role)
                {case 1:
                    System.out.println("dev;oper");
                    break;
                    case 2:
                        System.out.println("tester");
                        break;
                    default:
                        System.out.println("invalid");
                }
                System.out.println("soft ware ");
                break;
    }
}
}

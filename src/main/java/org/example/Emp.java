package org.example;

 class Emp {

    static int eid;
    static {
        eid=111;
    }
    static void assisgn(){
        eid =232;
    }
    static void disp()
    {
        System.out.println(eid);
    }

    public static void main(String[] args) {

        Emp.disp();
//
    }

}

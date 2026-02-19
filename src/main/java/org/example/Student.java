package org.example;

public class Student {
   String name;
   int id;
   Teacher teacher;// has relationship
   Student(String name,int id,Teacher teacher){
       this.name=name;
       this.id=id;
      this.teacher=teacher;// recieving exiting object

   }
   void departname(){
       System.out.println("fav student of teacher ="+name+"   "+id);
       teacher.showteacher();
   }

    public static void main(String[] args) {
        Teacher t1=new Teacher("harshitha");
        Student t2=new Student("bnharthesh",101,t1);
        t2.departname();
    }

}

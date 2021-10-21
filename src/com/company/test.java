package com.company;

class Person{
  public int age;
  public String name;
  public Person(){
    System.out.println("父类");
    say();
  }
  public void say(){
    System.out.println("有人说话。");
  }
}
class Student extends Person{
  public String school;
  public int age;
  public Student(){
    System.out.println("子类");
  }
  public void say(){
    System.out.println("学生"+name+age);
  }
}
public class test
{
  public static void main(String[] args) {
    Student s = new Student();
    s.age=20;
    s.name="tom";
    s.say();
  }
}




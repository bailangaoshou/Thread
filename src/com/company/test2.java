package com.company;

public class test2 {



   class memberclass{
      public  String getMessage(){
          return  "member";
      }
    }


    public static void main(String[] args) {
        test2 t1 = new test2();
        System.out.println(t1.new memberclass().getMessage());
        test2 t2 = new test2();



    }

}

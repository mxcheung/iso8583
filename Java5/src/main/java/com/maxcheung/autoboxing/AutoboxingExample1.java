package com.maxcheung.autoboxing;

class AutoboxingExample1
{
   public static void myMethod(Integer num){
	System.out.println(num);
   }
   public static void main(String[] args) {
       /* passed int (primitive type), it would be 
        * converted to Integer object at Runtime
        */
   	myMethod(2);
   }
}
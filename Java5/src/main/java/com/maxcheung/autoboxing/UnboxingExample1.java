package com.maxcheung.autoboxing;

class UnboxingExample1
{
   public static void myMethod(int num){
	System.out.println(num);
   }
   public static void main(String[] args) {
    	
    	Integer inum = new Integer(100);
    	
        /* passed Integer wrapper class object, it 
         * would be converted to int primitive type 
         * at Runtime
         */
    	myMethod(inum);
    }
}
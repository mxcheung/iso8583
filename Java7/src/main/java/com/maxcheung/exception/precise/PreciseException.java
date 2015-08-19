package com.maxcheung.exception.precise;


public class PreciseException {
 
	public static void main(String args[]) throws Exception {
	    boolean flag = true;
	    try {
	        if (flag){
	            throw new OpenException();
	        }
	        else {
	            throw new CloseException();
	        }
	    }
	    catch (Exception e) {
    //		System.out.println("caught exception: " + e);
    		System.out.println(e.getMessage());
	        throw e;
	    } 
	}
}
package com.maxcheung.exception.multicatch;


public class MultipleExceptionsInCatchBlock {
 
    public static void main(String[] args)
    {
            sampleMethod();
    }
 
    public static void sampleMethod()
                    //throws Throwable  //No need to do this
    {
        try
        {
            //Do some processing which throws NullPointerException; I am sending directly
            throw new NullPointerException();
        }
 
        //You can catch multiple exception added after 'pipe' character
        catch(NullPointerException | IndexOutOfBoundsException ex)
        {
    		System.out.println("caught exception: " + ex);

            throw ex;
        }
 
        //Now method sampleMethod() do not need to have 'throws' clause
        catch(Throwable ex)
        {
            throw ex;
        }
    }
}
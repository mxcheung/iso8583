package com.maxcheung.exception.precise;


class OpenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;}
class CloseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1680875542623752880L;}
 
public class PreciseRethrows {
     
    public static void main(String args[]) throws OpenException, CloseException {
        boolean flag = true;
        try {
            if (flag){
                throw new OpenException();
            }
            else {
                throw new CloseException();
            }
        } catch(OpenException oe) {
            System.out.println(oe.getMessage());
            throw oe;
        }
        catch (CloseException ce) {
            System.out.println(ce.getMessage());
            throw ce;
        }
    }
}
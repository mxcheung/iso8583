package com.maxcheung.enums;

public class ReqStatus {
	 
    public enum Status{
        STATUS_OPEN,
        STATUS_STARTED,
        STATUS_INPROGRESS,
        STATUS_ONHOLD,
        STATUS_COMPLETED,
        STATUS_CLOSED;
    }
 
    public static void main(String[] args){
        for (Status stat: Status.values()){
            System.out.println(stat);
        }
    }
}
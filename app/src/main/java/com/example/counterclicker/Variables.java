package com.example.counterclicker;

import java.util.ArrayList;
import java.util.Arrays;

public class Variables{
    public int counter=0;
    public int countermax=100;
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public String event1 = "Event 1";
    public String event2 = "Event 2";
    public String event3 = "Event 3";

    public void setCounter() {
        this.counter +=1;
    }

    public void setCountermax(int countermax) {
        this.countermax = countermax;
    }
    public void setCounterarray(int counterarray) {
        this.arrayList.add(counterarray);
    }

    public void setEvent1(String event1){
        this.event1=event1;
    }
    public void setEvent2(String event2){
        this.event2=event2;
    }
    public void setEvent3(String event3){
        this.event3=event3;
    }
}

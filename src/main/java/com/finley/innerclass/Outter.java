package com.finley.innerclass;

/**
 * Created by ֣Զ�� on 2017/8/21.
 */
public class Outter {
    private String value="Hello World!";
    public  class Inner{
        public void print(){
            System.out.print(value);
        }
    }

    public static void main(String []args){
        Outter outter=new Outter();
        Inner inner=outter.new Inner();
        inner.print();
    }
}

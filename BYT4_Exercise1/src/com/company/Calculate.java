package com.company;

public class Calculate {

    public static void main(String[] args){

        Chain chain1 = new Add();

        Chain chain2= new Subtract();

        Chain chain3 = new Mult();

        Chain chain4 = new Divide();

        chain1.setNextChain(chain2);

        chain2.setNextChain(chain3);

        chain3.setNextChain(chain4);

        Numbers request = new Numbers(10,2,"div");

        chain1.calculate(request);

        System.out.println();

        Numbers request2 = new Numbers(10,2,"mult");

        chain1.calculate(request2);

        System.out.println();

        Numbers request3 = new Numbers(10,2,"add");

        chain1.calculate(request3);

        System.out.println();

        Numbers request4 = new Numbers(10,2,"sub");

        chain1.calculate(request4);
    }
}

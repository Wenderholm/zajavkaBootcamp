package com.company.klasZagnieżdżone.memberInnerClass;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.call();


    }


    public void call(){
        NoMain noMain = new NoMain();
        NoMain.Inner inner1 = noMain.new Inner("Inner1");
        NoMain.Inner inner2 = noMain.new Inner("Inner2");

        inner1.innerCall();
        inner2.innerCall();

        OtherMain otherMain = new OtherMain();
        OtherMain.Inner inner = otherMain.new Inner();
        OtherMain.Inner.InnerInner innerInner = inner.new InnerInner();
        OtherMain.Inner.InnerInner.InnerInnerInner innerInnerInner = innerInner.new InnerInnerInner();

        innerInnerInner.printAllA();
    }


}

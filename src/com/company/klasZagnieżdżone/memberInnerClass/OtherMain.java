package com.company.klasZagnieżdżone.memberInnerClass;

public class OtherMain {
    private int a  = 1;
    class Inner{
        private int a  = 2;
        class InnerInner{
            private int a  = 3;
            class InnerInnerInner {
                private int a  = 4;

                public void printAllA(){
                    System.out.println(a);
                    System.out.println(this.a);
                    System.out.println(InnerInnerInner.this.a);
                    System.out.println(InnerInner.this.a);
                    System.out.println(Inner.this.a);
                    System.out.println(OtherMain.this.a);
                }

            }
        }
    }
}

package com.yang.basic.day17;

public class TestInner {
    private int number = 100;
    public class Inner{
        private int number = 200;
        public void myPrinter(){
            int number = 300;
            System.out.println(number);
            //通过this引用内部类的成员属性
            System.out.println(this.number);
            //通过外部类名加上this的方式访问外部类成员属性
            System.out.println(TestInner.this.number);
        }
    }

    public static void main(String[] args) {
        TestInner tl = new TestInner();
        TestInner.Inner in  = tl.new Inner();
        in.myPrinter();
    }

}

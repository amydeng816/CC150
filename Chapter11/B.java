class A {

    public void foo(A a) {
	System.out.println("hello");
    }

    // public static void main(String[] args) {
    // 	A a = new A();
    // 	a.foo(a);
    // }
}

class B extends A {

    public void foo(B b) {
	System.out.println("world");
    }
    public static void main(String[] args) {
    	B a = new B();
    	a.foo(a);
    }
}

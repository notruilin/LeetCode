class Foo {
    private volatile int num = 1;

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.num = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (num == 2)   break;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.num = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (this.num == 3)   break;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

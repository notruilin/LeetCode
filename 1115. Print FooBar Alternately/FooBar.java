class FooBar {
    private int n;
    private volatile int num;

    public FooBar(int n) {
        this.n = n;
        num = -1;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (num != -1) {
                wait();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            num = 1;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (num != 1) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            num = -1;
            notifyAll();
        }
    }
}

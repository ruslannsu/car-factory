public class Main {
    public static void printSomething() {
        System.out.println("thread check");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        thread2.start();
        thread1.start();
        thread1.join();
        thread2.join();
    }
}
package threadpool;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private LinkedBlockingQueue<Task> tasks = new LinkedBlockingQueue<>();
    private ArrayList<Thread> threads = new ArrayList<>();
    public void addThread() {
        Thread thread = new TaskExecuter(tasks);
        threads.add(thread);
    }
    public void addTask() {
        Task task = new Task();
        tasks.offer(task);
    }
    public void threadPoolRun() {
        for (Thread thread: threads) {
            thread.start();
        }
    }
}

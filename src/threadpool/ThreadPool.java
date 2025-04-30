package threadpool;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private LinkedBlockingQueue<Task> tasks = new LinkedBlockingQueue<>();
    private ArrayList<Thread> threads = new ArrayList<>();
    public void addThread(TaskExecuter taskExecuter) {
        threads.add(taskExecuter);
    }
    public LinkedBlockingQueue<Task> getTasks() {
        return tasks;
    }
    public void addTask(Task task) {
        tasks.offer(task);
    }
    public void threadPoolRun() {
        for (Thread thread: threads) {
            thread.start();
        }
    }
}

package threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class TaskExecuter  extends Thread {
    LinkedBlockingQueue<Task> tasks;
    public TaskExecuter(LinkedBlockingQueue<Task> tasks) {
        super();
        this.tasks = tasks;
    }
    @Override
    public void run() {
        while (isAlive()) {
            try {
                Task task = tasks.take();
                System.out.println(threadId());
                task.execute();
                sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

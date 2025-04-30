package factory.workers;

import threadpool.Task;
import threadpool.TaskExecuter;

import java.util.concurrent.LinkedBlockingQueue;

public class Worker extends TaskExecuter {
    public Worker(LinkedBlockingQueue<Task> tasks) {
        super(tasks);
    }

}

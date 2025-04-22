package threadpool;

public class Task {
    int taskID = System.identityHashCode(this);
    int getTaskID() {
        return taskID;
    }
    public void execute() {

    }

}

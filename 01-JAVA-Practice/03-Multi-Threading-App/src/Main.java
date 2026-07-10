//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyTask t1 = new MyTask();
        MyTask t2 = new MyTask();

        t1.start();
        t2.start();

    }
}

class MyTask extends Thread {
    public void run() {
        System.out.println("Task running by: " + Thread.currentThread().getName());
    }
}
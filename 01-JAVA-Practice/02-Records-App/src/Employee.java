
public record Employee(Integer id, String name, Double salary) implements Runnable{

    @Override
    public void run() {
        System.out.println("run () method called...");
    }

    public void m1(){
        System.out.println("m1() method called..");
    }
}

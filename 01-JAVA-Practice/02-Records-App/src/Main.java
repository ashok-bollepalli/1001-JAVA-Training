//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee(101, "Ashok", 1000.00);

        // emp.id = 102;  (Invalid)

        System.out.println(emp.id());
        System.out.println(emp.name());
        System.out.println(emp.salary());

        emp.m1();

    }
}
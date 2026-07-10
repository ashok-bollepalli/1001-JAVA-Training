import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentsCertificates {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new CertificateTask("Raj"));
        executor.submit(new CertificateTask("Anil"));
        executor.submit(new CertificateTask("Sunil"));
        executor.submit(new CertificateTask("Sita"));
        executor.submit(new CertificateTask("Gita"));
        executor.submit(new CertificateTask("John"));

        executor.shutdown();


    }
}

class CertificateTask implements Runnable{

    private String studentName;

    public CertificateTask(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("Generating certificate for " + studentName + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Certificate generation interrupted");
        }
        System.out.println("Certificate generated for " + studentName);
    }
}
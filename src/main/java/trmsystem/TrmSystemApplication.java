package trmsystem;

/**
 * Created by lion on 10.05.17.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class TrmSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrmSystemApplication.class, args);
    }
}

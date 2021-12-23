package FileExample.fileExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileExampleApplication.class, args);

        System.out.println("----------------------------------");
        System.out.println("Application running on port: 8002");
    }
}

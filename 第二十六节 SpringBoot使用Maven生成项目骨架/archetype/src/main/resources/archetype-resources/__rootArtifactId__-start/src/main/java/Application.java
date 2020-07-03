#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Spring Boot Starter
 * @author starter
 */
@SpringBootApplication(scanBasePackages = {"${package}"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
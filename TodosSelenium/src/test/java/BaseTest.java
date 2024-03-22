import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/angular/dist/browser/#/all");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }
//    @AfterEach
//    void close(){
//        driver.close();
//    }

}

import Helper.DatabaseHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

public class SampleDatabaseTest {

    private WebDriver wd;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testDatabaseConnection() throws SQLException {
//        wd.get("https://qa.engati.com/");

//        String query = "select * from common_admin where email = \"pulimi.keerthi@engati.com\";";
        String query = "update user set last_active_at = '2024-02-12 10:05:54' where user_id = '917995492257' and bot_ref = '67303';";
        int resultSet = DatabaseHelper.executeUpdate(query);
        System.out.println(resultSet);

//        while (resultSet.next()) {
//            String columnValue = resultSet.getString("user_name");
//            System.out.println("Column Value: " + columnValue);
//        }
    }

    @AfterClass
    public void tearDown() {
        if (wd != null) {
            wd.quit();
        }
    }
}
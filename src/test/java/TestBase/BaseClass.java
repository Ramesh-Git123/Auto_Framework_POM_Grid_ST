
package TestBase;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
//loading properties file
		FileReader file = new FileReader("./src//test//resources//conf.properties");
		p = new Properties();
		p.load(file);

		if (p.getProperty("exe_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();

//os
			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching os");
				return;
			}

//browser
			switch (br.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("edge");
				break;
			default:
				System.out.println("no match browser");
				return;
			}

			driver = new RemoteWebDriver(new URL("http://192.168.1.23:4444"), cap);
		}

		if (p.getProperty("exe_env").equalsIgnoreCase("local")) {

			switch (br) {
			case "chrome":
				driver = new ChromeDriver();
				break;

			case "firefox":
				driver = new FirefoxDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("invalid browser method");
			}

		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("ApplicationURL"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String genratedString = RandomStringUtils.randomAlphabetic(5);
		return genratedString;
	}

	public String randomNumber() {
		String genratedNumber = RandomStringUtils.randomNumeric(10);
		return genratedNumber;
	}

	public String randomAlphaNumeric() {
		String genratedString = RandomStringUtils.randomAlphabetic(5);
		String genratedNumber = RandomStringUtils.randomNumeric(10);
		return (genratedString + genratedNumber);

	}

}
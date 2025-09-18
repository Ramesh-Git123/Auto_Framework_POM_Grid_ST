package Utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReportManager implements ITestListener {
        public ExtentSparkReporter sparkReporter; // UI of the report
        public ExtentReports extent; // populate the common information
        public ExtentTest test; // update report
        public void onStart(ITestContext context) // Report path & name
        {
                sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\MyReports.html");// Path
                                                                                                                                                                                                                                        // for
                                                                                                                                                                                                                                        // extentreport(project>folder)
                sparkReporter.config().setDocumentTitle("Automation Report");// config() use:title of report
                sparkReporter.config().setReportName("Functional Report");
                sparkReporter.config().setTheme(Theme.STANDARD);
                extent = new ExtentReports(); // for information
                extent.attachReporter(sparkReporter); // bind with sparkReporter
                extent.setSystemInfo("Computer Name", "Ramesh");// Key-value pair
                extent.setSystemInfo("Env", "QA");
                extent.setSystemInfo("Tester name", "Mohan");
                extent.setSystemInfo("OS", "windows");
                extent.setSystemInfo("Browser Name", "Chrome");
        }
        public void onTestSuccess(ITestResult result) // For PASS in report
        {
                test = extent.createTest(result.getName());
                test.log(Status.PASS, "Test case PASSED is : " + result.getName());
        }
        public void onTestFailure(ITestResult result) // For FAIL in report
        {
                test = extent.createTest(result.getName());
                test.log(Status.FAIL, "Test case FAILED is : " + result.getName());
                test.log(Status.FAIL, "Test case FAILED cause is : " + result.getThrowable());// Fail reason
        }
        public void onTestSkipped(ITestResult result) // For SKIPP in report
        {
                test = extent.createTest(result.getName());
                test.log(Status.SKIP, "Test case SKIPPED is : " + result.getName());
                test.log(Status.SKIP, "Test case SKIPPED cause is : " + result.getThrowable());// SKIPP reason
        }
        public void onFinish(ITestContext context) // For cheking all status in report
        {
                extent.flush();
        }
}

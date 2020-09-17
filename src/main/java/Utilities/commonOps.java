package Utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class commonOps extends base {

    // Get data from an XML file to avoid hardcoded code
    public static String getData(String nodeName) {
        File fxmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void saveLog(String logName, LogEntry actualLog) throws FileNotFoundException {
        out = new FileOutputStream(logName + ".json", true);
        p = new PrintStream( out );
        p.append (actualLog.getMessage());
        p.close();
    }

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else
            throw new RuntimeException(("Invalid platform name stated"));
        driver.manage().window().maximize();
//        driver.get(getData("UrlGeektime"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("TimeOut")));
    }

    public static WebDriver initChromeDriver() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        WebDriverManager.chromedriver().setup();
        logPres = new LoggingPreferences();
        logPres.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability("goog:loggingPrefs", logPres);
        WebDriver driver = new ChromeDriver(caps);
        return driver;
    }

    @BeforeClass
    public void startSession() {
        if (getData("PlatformName").equalsIgnoreCase("web")) {
            initBrowser(getData("BrowserName"));
        }
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }

}

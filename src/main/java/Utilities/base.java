package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class base {

    // Automation Objects
    public static WebDriver driver;
    public static WebDriverWait wait;

    // Logs
    public static LoggingPreferences logPres;

    // File
    public static FileOutputStream out; // declare a file output object
    public static PrintStream p; // declare a print stream object

}

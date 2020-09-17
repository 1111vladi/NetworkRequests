package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.logging.LogEntry;

import java.io.FileNotFoundException;
import java.util.List;

public class networkActions extends commonOps {
    @Step("Refresh browser page")
    public static void getReportType(String logType) throws FileNotFoundException {
        List<LogEntry> les = driver.manage().logs().get(logType).getAll();
        System.out.println(les.size() + " " + logType + " log entries found");
        for (LogEntry le : les) {
            System.out.println(le.getMessage());
            saveLog("reportLog", le);

        }
    }
}

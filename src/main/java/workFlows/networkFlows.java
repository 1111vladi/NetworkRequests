package workFlows;

import Extensions.networkActions;
import Extensions.uiActions;
import Utilities.commonOps;
import Utilities.listeners;
import io.qameta.allure.Step;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Listeners;

import java.io.FileNotFoundException;

@Listeners(listeners.class)
public class networkFlows extends commonOps {

    @Step("Get team from Grafana")
    public static void getNetworkTraffic(String url, int cycle, int waitSeconds) throws InterruptedException, FileNotFoundException {
        uiActions.getUrl(url);
        for (int i = 0; i < cycle; i++) {
            uiActions.sleep(waitSeconds);
            networkActions.getReportType(LogType.PERFORMANCE);
            networkActions.getReportType(LogType.BROWSER);
            uiActions.refreshPage();
        }
    }
}

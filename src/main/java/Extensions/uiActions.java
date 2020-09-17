package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;

public class uiActions extends commonOps {

    @Step("Refresh browser page")
    public static void refreshPage() {
        driver.navigate().refresh();
    }

    @Step("Refresh browser page")
    public static void getUrl(String url){
        driver.get(url);
    }

    @Step("Refresh browser page")
    public static void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }
}

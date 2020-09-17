package Tests;

import Utilities.commonOps;
import Utilities.listeners;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workFlows.networkFlows;

import java.io.FileNotFoundException;

@Listeners(listeners.class)
public class SourceDefense extends commonOps {

    @Test(description = "Test01: Go to geektime and track traffic")
    @Description("Test Description: Go to geektime and track network requests, console logs and errors")
    public void test01_getNetworkReport() throws InterruptedException, FileNotFoundException {
        networkFlows.getNetworkTraffic(getData("UrlGeektime"), 1, 5);
    }
}

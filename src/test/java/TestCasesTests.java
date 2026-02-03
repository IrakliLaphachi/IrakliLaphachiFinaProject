import base.TestBase;

import io.qameta.allure.Description;

import org.testng.annotations.Test;

import pages.TestCasesPage;

import utils.DriverFactory;

public class TestCasesTests extends TestBase {
    @Description("Verify Test Cases Load")
    @Test (priority = 1)
    public void TestCaseTabTest() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        TestCasesPage Cases = new TestCasesPage(DriverFactory.getDriver());
        Cases.checkHomePage();
        Cases.clickTestCaseTab();
    }
}
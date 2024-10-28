package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.helpers.SystemHelpers;
import anhtester.com.pages.UploadFileCMSPage;
import anhtester.com.keywords.WebUI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression test")
@Feature("Upload File test")
public class UploadFileCMS extends BaseTest {

    @Test
    public void testUploadFileWithSendKeys() {
        WebUI.openURL("https://cgi-lib.berkeley.edu/ex/fup.html");
        WebUI.waitForPageLoaded();
        By inputFileUpload = By.xpath("//input[@name='upfile']");
        By inputBtnPress = By.xpath("//input[@value='Press']");
        By pNotiUploaded = By.xpath("//body/p[1]");
        boolean checkPage = WebUI.checkElementExist(pNotiUploaded);

        //DriverManager.getDriver().findElement(inputFileUpload).sendKeys(SystemHelpers.getCurrentDir() + "datatest/Selenium4_Upload.png");
        WebUI.setText(inputFileUpload, SystemHelpers.getCurrentDir() + "datatest\\Selenium4_Upload.jpg");
        WebUI.clickElement(inputBtnPress);
        Assert.assertTrue(checkPage, "You've uploaded a file. Your notes on the file were:");
        WebUI.sleep(3);
    }

    @Test
    public void testUploadFileInCategoryCMS() {
        UploadFileCMSPage uploadFileCMSPage = new UploadFileCMSPage();
        uploadFileCMSPage.loginCMS();
        uploadFileCMSPage.uploadFileInCategory();
    }

}

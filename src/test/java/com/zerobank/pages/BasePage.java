package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (linkText = "Online Banking")
    public WebElement onlineBanking;




    public void navigateTo(String module , String tab){

        Driver.get().findElement(By.linkText(module)).click();
        BrowserUtils.waitForPageToLoad(1);
        Driver.get().findElement(By.linkText(tab)).click();
        BrowserUtils.waitForPageToLoad(1);
    }



    public void navigateTo(String module){

        Driver.get().findElement(By.linkText(module)).click();

    }




}

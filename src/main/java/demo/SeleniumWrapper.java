package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumWrapper {
    public WebDriver driver;

    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
    }
    
    public WebElement findElement(By locator){
        return driver.findElement(locator);

    }

    public void clickElement(By locator) throws InterruptedException{

        Thread.sleep(2000);
        findElement(locator).click();

    }

    public void enterText(By locator, String text) throws InterruptedException{
        WebElement element = findElement(locator);
        Thread.sleep(2000);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    // public void selectOptionFromDropdown(String by, String optionText) {
    //     WebElement dropdownElement = driver.findElement(By.id(by));
    //     Select dropdown = new Select(dropdownElement);
    //     dropdown.selectByVisibleText(optionText);
    // }

    // public boolean selectOptionFromDropdown(WebElement element1, WebElement element2){
    //     try {
    //         Thread.sleep(2000);
    //         element1.click();
    //         Thread.sleep(3000);
    //         element2.click();
    //         Thread.sleep(3000);
    //         return true;

    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         return false;

        // }
    }

       
    
    


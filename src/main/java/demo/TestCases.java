package demo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import demo.SeleniumWrapper;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {

    ChromeDriver driver;
    //SeleniumWrapper selenium;

    public TestCases()
    {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(3000);
        


         SeleniumWrapper wrapper= new SeleniumWrapper(driver); // Use wrapper methods
         
         wrapper.enterText(By.xpath("//div[@jscontroller='oCiKKc']//div[@class='Xb9hP']//input"), "RADHA BS");
         
         long epoch = System.currentTimeMillis()/1000; //Returns epoch in seconds;
         wrapper.enterText(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"), "I want to be the best QA Engineer!" + epoch); 

    
         wrapper.clickElement(By.xpath("(//div[@class='SG0AAe']//div[@id='i13'])"));
         //wrapper.clickElement(By.xpath("(//div[@class='SG0AAe']/div/label/div/div/div[@id='i13']"));

         wrapper.clickElement(By.xpath("//div[@class='eBFwI']/label//div[@id='i30' and @data-answer-value='Java']"));
         wrapper.clickElement(By.xpath("//div[@class='eBFwI']/label//div[@id='i33' and @data-answer-value='Selenium']"));
         wrapper.clickElement(By.xpath("//div[@class='eBFwI']/label//div[@id='i39' and @data-answer-value='TestNG']"));

         Thread.sleep(2000);
         
   
        //  wrapper.selectOptionFromDropdown(By.xpath("//div[@jscontroller='liFoG']//div[@class='e2CuFe eU809d']") , "Mrs");
        // Thread.sleep(1000);

         WebElement ChooseDropDown = driver.findElement(By.xpath("//div[@jscontroller='liFoG']//div[@class='e2CuFe eU809d']"));
         ChooseDropDown.click();
         Thread.sleep(3000);

        
         WebElement ChooseMrs = driver.findElement(By.xpath("(//div[@jsname='wQNmvb']//span[text()='Mrs'])[2]"));
         ChooseMrs.click();
         Thread.sleep(3000);

         LocalDateTime myDateobj = LocalDateTime.now().minusDays(7);
         DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         String FormattedDate = myDateobj.format(myDateFormatter);

         WebElement CalendarIcon = driver.findElement(By.cssSelector("input[type='date']"));
         CalendarIcon.clear();
         Thread.sleep(2000);

         //CalendarIcon.click();
         Thread.sleep(5000);
         CalendarIcon.sendKeys(FormattedDate);
         CalendarIcon.sendKeys(Keys.ENTER);
         Thread.sleep(2000);

         LocalTime myObj = LocalTime.now();
         DateTimeFormatter myHourObj = DateTimeFormatter.ofPattern("HH");
         DateTimeFormatter myMinObj = DateTimeFormatter.ofPattern("mm");
         String FormattedHour = myObj.format(myHourObj);
         String FormattedMin = myObj.format(myMinObj);

         wrapper.enterText(By.xpath("//input[@aria-label='Hour']"), FormattedHour);
         wrapper.enterText(By.xpath("//input[@aria-label='Minute']"), FormattedMin);

         wrapper.clickElement(By.xpath("//span[text()='Submit']"));
         Thread.sleep(2000);

         WebElement MessageDisplayed = driver.findElement(By.xpath("//div[text() = 'Thanks for your response, Automation Wizard!']"));
         String Submission = MessageDisplayed.getText();
         System.out.println(Submission);
                   
         System.out.println("end Test case: testCase01");
         //endTest();

    }

    }


    



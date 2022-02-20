package com.phase1amazonproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Project {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");    
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement EleSearch=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		EleSearch.sendKeys("iphone 12");
		
		WebElement EleSrchBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		EleSrchBtn.click();
		
	List<WebElement> Products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	List<WebElement> ProductPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
	System.out.println("******************************************************");
	System.out.println("Product Name: "+Products.size()); 
	
	
	// Get the list of products and their prices normal way
	
	for(int count=0;count<Products.size();count++)
    {
        if(Products.get(count).getText().toLowerCase().contains("Apple iphone 12"))
        {
            System.out.println("Product Name :"+Products.get(count).getText() + "    " + " Product Price:"
            						+ProductPrice.get(count).getText() );
        }
    }
		
	driver.close();	
		}

}

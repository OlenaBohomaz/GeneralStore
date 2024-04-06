package generalStore;

import com.sun.jdi.Value;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class ProductTest {
    public static void main(String[] args) throws Exception {

        // setup desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Galaxy A51");
        capabilities.setCapability("appium:udid", "R58NA5CK9ME");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:appPackage", "com.androidsample.generalstore");
        capabilities.setCapability("appium:appActivity", ".SplashActivity");
        capabilities.setCapability("appium:automationName", "UIAutomator2");

        // инициализируем драйвер
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);


       WebElement title = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
     //   WebElement inputName = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        WebElement inputName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/nameField")));
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/btnLetsShop")));
    //    WebElement button = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));


        WebElement secondTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        WebElement productList = driver.findElement(By.id("com.androidsample.generalstore:id/rvProductList"));
        WebElement firstPicture = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.androidsample.generalstore:id/productImage\"])[1]"));
        WebElement firstProductName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Air Jordan 4 Retro\"]"));
        WebElement cart = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));


        verifyTitleProperties(title);
        verifyInputProperties(inputName);
        driver.hideKeyboard();
        verifyIButtonProperties(button);

        verifySecondTitleProperties(secondTitle);
        verifyProductListProperties(productList);
        verifyFirstPictureProperties(firstPicture);
        verifyFirstProductNameProperties(firstProductName);
        verifyCartProperties(cart);
        scrollDown(driver);
    }
    private static void verifyTitleProperties(WebElement title) {
        // check if Title is displayed
        if (title.isDisplayed()) {
            System.out.println("Title 'General store'  is present on page");
        } else {
            System.out.println("TEST FAILED! Title 'General store'  is absent!!! on page");
        }
    }
        public static void verifyInputProperties(WebElement inputName){

        inputName.sendKeys("Olena");
        String actualName = inputName.getAttribute("Value");
        if(actualName.equals("Olena")) {
            System.out.println("inputName is correct");
        } else {
            System.out.println("inputName is not correct and equals" + inputName.getAttribute("Value") );
        }

    }
    public static void verifyIButtonProperties(WebElement button){
        button.click();
    }
    private static void  verifySecondTitleProperties(WebElement secondTitle) {
        // check if secondTitle is displayed
        if (secondTitle.isDisplayed()) {
            System.out.println("secondTitle 'Products'  is present on page");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products'  is absent!!! on page");
        }

        // check if secondTitle is enabled
        if (secondTitle.isEnabled()) {
            System.out.println("secondTitle 'Products' is enable");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products'  is not enable!!!");
        }
        // Check if the secondTitle is clickable
        String clickableAttribute = secondTitle.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("secondTitle 'Products' is not clickable.");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products' is clickable!!!");
        }
        // check is the secondTitle is displayed
        String displayedAttribute = secondTitle.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("secondTitle 'Products' is displayed");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products' is not displayed!!!");
        }
        // check is the secondTitle is focusable
        String focusableAttribute = secondTitle.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("secondTitle 'Products' is not focusable");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products'  is focusable!!!");
        }
        // check is the secondTitle is focused
        String focusedAttribute = secondTitle.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("secondTitle 'Products' is not focused");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products' is focused!!!");
        }
        // check is the secondTitle is scrollable
        String scrollableAttribute = secondTitle.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("secondTitle 'Products' is not scrollable");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products' is scrollable!!!");
        }
        // check is the secondTitle is selected
        String selectedAttribute = secondTitle.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("secondTitle 'Products' is not selected");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products' is selected!!!");
        }
        // check if the secondTitle's text is "Products"
        String expectedResultTitleText = "Products";
        String actualResultTitleText = secondTitle.getText();
        if (actualResultTitleText.equals(expectedResultTitleText)) {
            System.out.println("Text 'Products' is correct");
            System.out.println("Element text: " + secondTitle.getText());
        } else {
            System.out.println("TEST FAILED! Text 'Products' is not correct!!!");
            System.out.println("Element text: " + secondTitle.getText());
        }
    }
    public static void verifyCartProperties(WebElement cart){

        // check is element displayed on the tab
        if (cart.isDisplayed()) {
            System.out.println("cart is present on page");
        } else {
            System.out.println("TEST FAILED! cart is absent!!! on page");
        }
        // check if cart is enabled
        if (cart.isEnabled()) {
            System.out.println("cart is enable");
        } else {
            System.out.println("TEST FAILED! cart is not enable!!!");
        }
        // Check if the cart is clickable
        String clickableAttribute = cart.getAttribute("clickable");
        if ("true".equals(clickableAttribute)) {
            System.out.println("cart is clickable.");
        } else {
            System.out.println("TEST FAILED! cart is not clickable!!!");
        }
        // check if cart is focusable
        String focusableAttribute = cart.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("cart is focusable");
        } else {
            System.out.println("TEST FAILED! cart is not focusable!!!");
        }
        // check if the cart is focused
        String focusedAttribute = cart.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("cart  is not focused");
        } else {
            System.out.println("TEST FAILED! cart is focused!!!");
        }
        // check if the cart is scrollable
        String scrollableAttribute = cart.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("cart is not scrollable");
        } else {
            System.out.println("TEST FAILED! cart is scrollable!!!");
        }
        // check if the cart is selected
        String selectedAttribute = cart.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("cart is not selected");
        } else {
            System.out.println("TEST FAILED! cart is selected!!!");
        }
        //check if the cart is checked
        String checkedAttribute = cart.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("cart is not checked");
        } else {
            System.out.println("TEST FAILED! cart is checked!!!");
        }
        //check if the cart is checkable
        String checkableAttribute = cart.getAttribute("checkable");
        if ("false".equals(checkableAttribute)) {
            System.out.println("cart is not checkable");
        } else {
            System.out.println("TEST FAILED! cart is  checkable!!!");
        }
        cart.click();

    }

    public static void verifyProductListProperties(WebElement productList){
        // check if productList is displayed on the tab
        if (productList.isDisplayed()) {
            System.out.println("productList is present on page");
        } else {
            System.out.println("TEST FAILED! productList is absent!!! on page");
        }
        // check if productList is enabled
        if (productList.isEnabled()) {
            System.out.println("productList  is enable");
        } else {
            System.out.println("TEST FAILED! productList is not enable!!!");
        }
        // Check if the productList is clickable
        String clickableAttribute = productList.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("productList is not clickable.");
        } else {
            System.out.println("TEST FAILED! productList is clickable!!!");
        }
        // check if productList is focusable
        String focusableAttribute = productList.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("productList is focusable");
        } else {
            System.out.println("TEST FAILED! productList is not focusable!!!");
        }
        // check if the productList is focused
        String focusedAttribute = productList.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("productList  is not focused");
        } else {
            System.out.println("TEST FAILED! productList is focused!!!");
        }
        // check if the productList is scrollable
        String scrollableAttribute = productList.getAttribute("scrollable");
        if ("true".equals(scrollableAttribute)) {
            System.out.println("productList is scrollable");
        } else {
            System.out.println("TEST FAILED! productList is not scrollable!!!");
        }
        // check if the productList is selected
        String selectedAttribute = productList.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("productList is not selected");
        } else {
            System.out.println("TEST FAILED! productList is selected!!!");
        }
        //check if the productList is checked
        String checkedAttribute = productList.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("productList is not checked");
        } else {
            System.out.println("TEST FAILED! productList is checked!!!");
        }
        //check if the productList is checkable
        String checkableAttribute = productList.getAttribute("checkable");
        if ("false".equals(checkableAttribute)) {
            System.out.println("productList is not checkable");
        } else {
            System.out.println("TEST FAILED! productList is  checkable!!!");
        }
        //check if the productList has class android.support.v7.widget.RecyclerView
        String classAttribute = productList.getAttribute("class");
        if ("android.support.v7.widget.RecyclerView".equals(classAttribute)) {
            System.out.println("productList has class android.support.v7.widget.RecyclerView");
        } else {
            System.out.println("TEST FAILED! productList has not class android.support.v7.widget.RecyclerView!!!");
        }
    }
    public static void verifyFirstPictureProperties(WebElement firstPicture){
        // check if firstPicture is displayed on the tab
        if (firstPicture.isDisplayed()) {
            System.out.println("firstPicture is present on page");
        } else {
            System.out.println("TEST FAILED! firstPicture is absent!!! on page");
        }
        // check if firstPicture is enabled
        if (firstPicture.isEnabled()) {
            System.out.println("firstPicture  is enable");
        } else {
            System.out.println("TEST FAILED! firstPicture is not enable!!!");
        }
        // Check if the firstPicture is clickable
        String clickableAttribute = firstPicture.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("firstPicture is not clickable.");
        } else {
            System.out.println("TEST FAILED! firstPicture is clickable!!!");
        }
        // check if firstPicture is focusable
        String focusableAttribute = firstPicture.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("firstPicture is not focusable");
        } else {
            System.out.println("TEST FAILED! firstPicture is focusable!!!");
        }
        // check if the firstPicture is focused
        String focusedAttribute = firstPicture.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("firstPicture  is not focused");
        } else {
            System.out.println("TEST FAILED! firstPicture is focused!!!");
        }
        // check if the firstPicture is scrollable
        String scrollableAttribute = firstPicture.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("firstPicture is not scrollable");
        } else {
            System.out.println("TEST FAILED! firstPicture is scrollable!!!");
        }
        // check if the firstPicture is selected
        String selectedAttribute = firstPicture.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("firstPicture is not selected");
        } else {
            System.out.println("TEST FAILED! firstPicture is selected!!!");
        }
        //check if the firstPicture is checked
        String checkedAttribute = firstPicture.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("firstPicture is not checked");
        } else {
            System.out.println("TEST FAILED! firstPicture is checked!!!");
        }
        //check if the firstPicture is checkable
        String checkableAttribute = firstPicture.getAttribute("checkable");
        if ("false".equals(checkableAttribute)) {
            System.out.println("firstPicture is not checkable");
        } else {
            System.out.println("TEST FAILED! firstPicture is  checkable!!!");
        }
        //check if the firstPicture has  android.widget.ImageView
        String firstPictureAttribute = firstPicture.getAttribute("class");
        if ("android.widget.ImageView".equals(firstPictureAttribute)) {
            System.out.println("firstPicture has class android.widget.ImageView");
        } else {
            System.out.println("TEST FAILED! firstPicture has not class android.widget.ImageView!!!");
        }
    }
    public static void verifyFirstProductNameProperties(WebElement firstProductName){
        // check if firstProductName is displayed on the tab
        if (firstProductName.isDisplayed()) {
            System.out.println("firstProductName is present on page");
        } else {
            System.out.println("TEST FAILED! firstProductName is absent!!! on page");
        }
        // check if firstProductName is enabled
        if (firstProductName.isEnabled()) {
            System.out.println("firstProductName  is enable");
        } else {
            System.out.println("TEST FAILED! firstProductName is not enable!!!");
        }
        // Check if the firstProductName is clickable
        String clickableAttribute = firstProductName.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("firstProductName is not clickable.");
        } else {
            System.out.println("TEST FAILED! firstProductName is clickable!!!");
        }
        // check if firstProductName is focusable
        String focusableAttribute = firstProductName.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("firstProductName is not focusable");
        } else {
            System.out.println("TEST FAILED! firstProductName is focusable!!!");
        }
        // check if the firstProductName is focused
        String focusedAttribute = firstProductName.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("firstPicture  is not focused");
        } else {
            System.out.println("TEST FAILED! firstPicture is focused!!!");
        }
        // check if the firstProductName is scrollable
        String scrollableAttribute = firstProductName.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("firstProductName is not scrollable");
        } else {
            System.out.println("TEST FAILED! firstProductName is scrollable!!!");
        }
        // check if the firstProductName is selected
        String selectedAttribute = firstProductName.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("firstProductName is not selected");
        } else {
            System.out.println("TEST FAILED! firstProductName is selected!!!");
        }
        //check if the firstProductName is checked
        String checkedAttribute = firstProductName.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("firstProductName is not checked");
        } else {
            System.out.println("TEST FAILED! firstProductName is checked!!!");
        }
        //check if the firstProductName is checkable
        String checkableAttribute = firstProductName.getAttribute("checkable");
        if ("false".equals(checkableAttribute)) {
            System.out.println("firstProductName is not checkable");
        } else {
            System.out.println("TEST FAILED! firstProductName is  checkable!!!");
        }
        //check if the firstProductName has  android.widget.ImageView
        String firstPictureAttribute = firstProductName.getAttribute("class");
        if ("android.widget.TextView".equals(firstPictureAttribute)) {
            System.out.println("firstProductName has class android.widget.TextView");
        } else {
            System.out.println("TEST FAILED! firstProductName has not class android.widget.TextView!!!");
        }
    }
    public static void scrollDown(AndroidDriver driver) {
//        Dimension size = driver.manage().window().getSize();
//        int starty = (int) (size.height * 0.50);
//        int endy = (int) (size.height * 0.20);
//        int startx = size.width / 2;
//
//        TouchAction action = new TouchAction(driver);
//
//        action.press(PointOption.point(startx, starty))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
//                .moveTo(PointOption.point(startx, endy))
//                .release()
//                .perform();

        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.80);
        int endY = (int) (size.height * 0.20);


        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();

    }

}

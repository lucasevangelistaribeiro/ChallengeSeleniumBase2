package br.com.desafiobase2.bases;

import br.com.desafiobase2.exceptions.NeededElementNotFoundException;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.desafiobase2.utils.StringUtils;
import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public static final String VALUE = "value";

    // Variaveis globlais
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor javaScriptExecutor = null;
    protected long timeOutDefault;
    protected long implicitTimeOutDefault;

    // Construtor
    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.timeOutDefault = getWaitForTimeout().toMillis();
        this.implicitTimeOutDefault = getImplicitWaitTimeout().toMillis();
        this.wait = new WebDriverWait(driver, getWaitForTimeout().getSeconds());
        this.javaScriptExecutor = (JavascriptExecutor) driver;
    }

    //Utils
    public By getLocatorFromWebElement(WebElement element) {
        String regex = "(?!->\\s)(id|className|cssSelector|linkText|name|partialLinkText|tagName|xpath):\\s.+[^\\]]";

        String sElement = element.toString();

        String fullLocator = StringUtils.substringByRegex(sElement, regex);
        String locatorKey = fullLocator.split(":")[0];
        String locatorValue = fullLocator.split(":")[1].trim();

        By locator = null;
        switch (locatorKey) {
            case "id":
                locator = By.id(locatorValue);
                break;
            case "className":
                locator = By.className(locatorValue);
                break;
            case "cssSelector":
                locator = By.cssSelector(locatorValue);
                break;
            case "linkText":
                locator = By.linkText(locatorValue);
                break;
            case "name":
                locator = By.name(locatorValue);
                break;
            case "partialLinkText":
                locator = By.partialLinkText(locatorValue);
                break;
            case "tagName":
                locator = By.tagName(locatorValue);
                break;
            case "xpath":
                locator = By.xpath(locatorValue);
                break;
            default:
                locator = null;
        }
        return locator;
    }

    // Custom Actions
    private void waitUntilPageReady() {
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= this.timeOutDefault) {
            if (javaScriptExecutor.executeScript("return document.readyState").toString().equals("complete")) {
                timeOut.stop();
                break;
            }
        }
    }

    protected WebElement waitForElement(By locator) {
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected WebElement waitForElementByTime(By locator, int time) {
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        waitTime.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected WebElement waitForElementDisabled(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    // Função usada para acessar os elementos que estão dentro de um #shadow-root
    // Ex: WebElement root = driver.findElement(By.tagName("driver-app-shell"))--->
    // elemento onde se encontra o shadow-root
    // WebElement shadowRoot = expandShadowRootElement(root); ----> pegando os
    // elementos que estão dentro do shadow-root
    protected WebElement expandShadowRootElement(By locator) {
        return (WebElement) javaScriptExecutor.executeScript("return arguments[0].shadowRoot", waitForElement(locator));
    }

    protected void click(By locator) {
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= this.timeOutDefault) {
            WebElement element = null;

            try {
                element = waitForElement(locator);
                element.click();
                timeOut.stop();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                // Skip
            } catch (WebDriverException e) {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click")) {
                    continue;
                }

                throw e;
            }
        }

        if(possibleWebDriverException != null) {
            LOGGER.error(possibleWebDriverException.getMessage());
            throw new NeededElementNotFoundException(String.format("Não foi possível clicar no elemento com o locator '%s'.", locator), possibleWebDriverException);
        }
        throw new NeededElementNotFoundException(String.format("Não foi possível clicar no elemento com o locator '%s'.", locator));
    }

    protected void sendKeys(By locator, CharSequence text) {
        waitForElement(locator).sendKeys(text);
    }

    protected void sendKeysWithoutWaitVisible(By locator, CharSequence text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    protected void clear(By locator) {
        WebElement webElement = waitForElement(locator);
        webElement.clear();
    }

    protected void clearAndSendKeys(By locator, CharSequence text) {
        WebElement webElement = waitForElement(locator);
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(text);
    }

    protected void comboBoxSelectByVisibleText(By locator, String text) {
        Select comboBox = new Select(waitForElement(locator));
        comboBox.selectByVisibleText(text);
    }

    protected void mouseOver(By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(waitForElement(locator)).build().perform();
    }

    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }

    protected String getValue(By locator) {
        return waitForElement(locator).getAttribute(VALUE);
    }

    protected boolean returnIfElementIsDisplayed(By locator) {
        return waitForElement(locator).isDisplayed();
    }

    protected boolean returnIfElementExists(By locator) {
        boolean result = false;

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    protected boolean returnIfElementIsEnabled(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator).isEnabled();
    }

    protected boolean returnIfElementIsSelected(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator).isSelected();
    }

    // Javascrip actions
    protected void sendKeysJavaScript(By locator, String value) {
        WebElement element = waitForElement(locator);
        javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", element);
    }

    protected void clickJavaScript(By locator) {
        WebElement element = waitForElement(locator);
        javaScriptExecutor.executeScript("arguments[0].click();", element);
    }

    protected void scrollToElementJavaScript(By locator) {
        WebElement element = waitForElement(locator);
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToTop() {
        javaScriptExecutor.executeScript("window.scrollTo(0, 0);");
    }

    // Default actions
    public void refresh() {
        driver.navigate().refresh();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void openNewTab() {
        javaScriptExecutor.executeScript("window.open();");
    }

    public void closeTab() {
        driver.close();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
}
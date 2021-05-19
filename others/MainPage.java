package br.com.desafiobase2.pages;

import br.com.desafiobase2.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageBase {

    //Constructor
    public MainPage(WebDriver driver){
        super(driver);
    }
    //Mapping
    By usernameLoginInfoTextArea = By.xpath("//td[@class='login-info-left']/span[@class='italic']");
    By reportIssueLink = By.xpath("//a[@href='/bug_report_page.php']");

    //Actions
    public String retornaUsernameDasInformacoesDeLogin(){
        return getText(usernameLoginInfoTextArea);
    }

    public void clicarEmReportIssue(){
        click(reportIssueLink);
    }
}

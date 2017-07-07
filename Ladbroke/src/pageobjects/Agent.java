package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.provar.core.model.ui.api.UiFacet;
import com.provar.core.testapi.annotations.*;

@Page( connection="Provar_CenterAgent"
     )             
public class Agent {

WebDriver driver;

public Agent(WebDriver driver) {
  this.driver = driver;
 }
 
 @LinkType()
	@FindBy(linkText = "Offline")
	public WebElement StatusAll;
	
	@LinkType()
@FindBy(xpath = "//*[@id=\"nav-tab-4\"]")
public WebElement liveAgentSupervisor;			

@PageTable(row = Status.class)
		@FindBy(xpath = "//ul[@role='presentation']/li")
		public List<Status> Status;
		
		@PageRow()
		public static class Status {
			@LinkType
			@FindBy(xpath = "a")
			public WebElement Name;

}
	
 
 public void clickOnButtonOmni() {

    WebElement button = driver.findElement(By.xpath("(//td[@class='x-btn-mc'])[2]"));
    Actions action = new Actions(driver);
    int width = button.getSize().width;
    action.moveToElement(button).moveByOffset(((width/2)-(width/20)), 0).click().build().perform();
 }
 
  
		@LinkType()
		@FindBy(linkText = "Accept")
		public WebElement accept;
		
		

		@LinkType()
		@FindBy(xpath = "//div[contains(@class,'efhpFieldValue')]")
		public WebElement CustomerName;
		
		 		
		@TextType()
		@FindBy(id = "liveAgentChatTextArea")
		public WebElement writeAMessage;

		@ButtonType()
		@FindBy(css = "button.liveAgentChatElement.liveAgentSendButton")
		public WebElement send;

@FindBy(xpath="//iframe[contains(@src,'/liveagent/chatlog')]")
 public Log ChatLog;
 
 @PageFrame()
 public static class Log
 {

		@TextType()
		@FindBy(xpath = "(//span[@class='messageText'])[4]")
		public WebElement VerifyQueryMessage;

		@TextType()
		@FindBy(id = "chatTextArea")
		public WebElement WriteReply;  
		
		@TextType()
		@FindBy(id = "chatInputSend")
		public WebElement Send;

		@LinkType()
		@FindBy(id = "assistanceFlagIcon")
		public WebElement Flag;
		
		@LinkType()
		@FindBy(id = "endChat")
		public WebElement EndChatAgent;
		
		@LinkType()
		@FindBy(id = "confirmEndChat")
		public WebElement ConfirmEndChatAgent;
		
		
		@SetType()
		@FindBy(id = "agentComboBox")
		public WebElement agentComboo;
		
		@LinkType()
		@FindBy(id = "chatTransferIcon")
		public WebElement Transfer;
		
		@TextType()
		@FindBy(id = "assistanceFlagMessage")
		public WebElement FlagMessage;
		
		@TextType()
		@FindBy(id = "notifyMessage")
		public WebElement TransferMessage;

@LinkType()
		@FindBy(xpath = "//div[contains(text(),'Raise Flag')]")
		public WebElement FlagBtn;



}

@TextType()
@FindBy(xpath = "//*[@id=\"liveAgentChatLogText\"]/div[3]/p/span[2]/span")
public WebElement ContactCentreResponse;

@LinkType()
@FindBy(css = "tr.dataRow.LA_Available.LA_FlagRaised a.LA_FlagRaisedIcon")
public WebElement FlagRaised;

@TextType()
@FindBy(xpath = "//textarea[contains(@class, \"zen-input\")]")
public WebElement writeAMessage1;

@ButtonType()
@FindBy(css = "button.liveAgentChatElement.liveAgentEndButton")
public WebElement endChat;

@ButtonType()
@FindBy(css = "button.liveAgentChatElement.liveAgentEndButton3")
public WebElement endChat1;

@ButtonType()
@FindBy(css = "button.liveAgentChatElement.liveAgentEndButton3")
public WebElement endChat2;


}

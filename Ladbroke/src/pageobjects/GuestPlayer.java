package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.provar.core.model.ui.api.UiFacet;
import com.provar.core.testapi.annotations.*;

@Page( title="GuestPlayer"                                
     , connection="GuestUser"
     )             
public class GuestPlayer {

WebDriver driver;

public GuestPlayer(WebDriver driver) {
  this.driver = driver;
 }

	@ButtonType()
@FindBy(xpath = "//div[contains(@class, \"col-lg-3\")]/div/div[1]/button")
public WebElement Chat_Community;

@TextType()
  @FindBy(xpath = "//*[@id='selectedCategory']")
  public WebElement GameOptions;
	
		@ButtonType()
		@FindBy(xpath = "//input[contains(@class, \"slds-button\")]")
		public WebElement startChat;

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

@TextType()
@FindBy(xpath = "//*[@id=\"liveAgentChatLogText\"]/div[3]/p/span[2]/span")
public WebElement ContactCentreResponse;

@TextType()
@FindBy(xpath = "//textarea[contains(@class, \"zen-input\")]")
public WebElement writeAMessage1;

@ButtonType()
@FindBy(css = "button.liveAgentChatElement.liveAgentEndButton")
public WebElement endChat;

}

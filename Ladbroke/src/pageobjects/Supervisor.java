package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.provar.core.model.ui.api.UiFacet;
import com.provar.core.testapi.annotations.*;

@SalesforcePage(
		title = "Supervisor",
		connection="Provar_Supervisor",
		page="liveagent/supervisor.apexp"
     )             
public class Supervisor {

WebDriver driver;

public Supervisor(WebDriver driver) {
  this.driver = driver;
 }

	@LinkType()
	@FindBy(linkText = "Offline")
	public WebElement StatusAll;
	
	
	@PageRow()
	public static class AgentTable {
	}

	@FacetFindBys(value = { @FacetFindBy(findBy = @FindBy(xpath = ".//tr"), facet = UiFacet.DATA_ROWS) })
	@FindBy(xpath = "//*[contains(@id,'agentPanel')\"]")
	@PageTable(firstRowContainsHeaders = true, row = AgentTable.class)
	public List<AgentTable> AgentTable;
	
 public void clickOnButton() {

    WebElement button = driver.findElement(By.xpath("(//td[@class='x-btn-mc'])[5]"));
    Actions action = new Actions(driver);
    int width = button.getSize().width;
    action.moveToElement(button).moveByOffset(((width/2)-(width/20)), 0).click().build().perform();
 }
 

@LinkType()
@FindBy(xpath = "//*[@id=\"nav-tab-4\"]")
public WebElement liveAgentSupervisor;			
		
@FindBy(xpath="//iframe[contains(@src,'/liveagent/supervisor')]")
 public AgentTabSupervisor AgentTabSupervisor;
 
 @PageWait.Field(timeoutSeconds = 20)
 @PageFrame()
 public static class AgentTabSupervisor
 {

		@PageTable(row = LiveAgents.class)
		@FindBy(xpath = "//table[@class='list supervisorAgents']/tbody/tr")
		public List<LiveAgents> LiveAgents;

	
		@PageRow()
		public static class LiveAgents {
			@LinkType
			@FindBy(xpath = "td[1]/a[3]")
			public WebElement AgentName;
			
			@LinkType
			@FindBy(xpath = "td[1]/a[1]")
			public WebElement FlagRaised;
			
			
			@TextType
			@FindBy(xpath = "td[2]")
			public WebElement AgentStatus;

}
		@PageTable(row = LiveAgentsChat.class)
		@FindBy(xpath = "//table[@class='list chatList']/tbody/tr")
		public List<LiveAgentsChat> LiveAgentsChat;

		@PageRow()
		public static class LiveAgentsChat {
			@LinkType
			@FindBy(xpath = "td[8]/a")
			public WebElement View;
}

		@PageTable(row = SupervisorFlagOff.class)
		@FindBy(xpath = "//table[@class='viewTable']/tbody/tr")
		public List<SupervisorFlagOff> SupervisorFlagOff;

		@PageRow()
		public static class SupervisorFlagOff {
			@TextType
			@FindBy(xpath = "td[3]/div[3]/form/div/textarea")
			public WebElement Text;
			
			@LinkType
			@FindBy(xpath = "td[3]/div[3]/input")
			public WebElement SendBtn;
}
}
 		
		@TextType()
		@FindBy(id = "liveAgentChatTextArea")
		public WebElement writeAMessage;

		@ButtonType()
		@FindBy(css = "button.liveAgentChatElement.liveAgentSendButton")
		public WebElement send;

}

package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Knowledge"                                
     , summary=""
     , relativeUrl=""
     , connection="Provar_CenterAgent"
     )             
public class Knowledge {


@FindBy(xpath="//iframe[contains(@id,'scc_widget_knowledgeOne')]")
 public KnowledgeFooter KnowledgeFooter;
 
 @PageFrame()
 public static class KnowledgeFooter
 {

	@FindBy(xpath = "//a[@class='filterToggleBtn']")
	@LinkType()
	public WebElement filters;
			
}
@FindBy(xpath = "//span[@class='x-tab-strip-text '][contains(text(),'URL')]")
	@LinkType()
	public WebElement url;

@PageTable(row = HelpCenter.class)
		@FindBy(xpath = "//table[@class='detailList']/tbody/tr")
		public List<HelpCenter> HelpCenter;
		
		@PageRow()
		public static class HelpCenter {
			
			@TextType()
	@FindBy(xpath = "td/span")
	public WebElement Value;
	
	@TextType()
	@FindBy(xpath = "th")
	public WebElement HelpCenterURL;
}
}
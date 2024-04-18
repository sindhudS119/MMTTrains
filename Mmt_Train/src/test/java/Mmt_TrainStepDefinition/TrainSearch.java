package Mmt_TrainStepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Mmt_PageFactory.TrainSearchPageFactory;
import Mmt_TrainDriverSetup.DriverTrain;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrainSearch {
	static WebDriver driver;
	 TrainSearchPageFactory pf;
	 WebDriverWait wait= new  WebDriverWait(driver ,Duration.ofSeconds(3));
	@Given("User is on Homepage")
	public void user_is_on_homepage() throws InterruptedException {
		driver=DriverTrain.chromeDriver(); 
	}

	@When("User clicks on the Train option")
	public void user_clicks_on_the_train_option() throws InterruptedException {
		pf=new TrainSearchPageFactory(driver);
	    pf.train();
	    //pf.source();
	}

//	@And("User enters the fromstation,tostation,traveldate, class")
//	public void user_enters_the_fromstation_tostation_traveldate_class(DataTable dataTable) throws AWTException, InterruptedException {
//		List<String> tripDetails = dataTable.asList(String.class);
//		//List<List<String>> tripDetails = dataTable.cells();
//	       tripDetails.remove(0); //As it contains column name
//	       pf.source();
//	       pf.typeFrom(tripDetails.get(0));
//		        Robot r=new Robot();
//		        r.keyPress(KeyEvent.VK_DOWN);
//		        r.keyRelease(KeyEvent.VK_DOWN);
//		        r.keyPress(KeyEvent.VK_ENTER);	       
//		        r.keyRelease(KeyEvent.VK_ENTER);
//		   pf.destination();
//	       pf.typeTo(tripDetails.get(1));
//		        r.keyPress(KeyEvent.VK_DOWN);
//		        r.keyRelease(KeyEvent.VK_DOWN);
//		        r.keyPress(KeyEvent.VK_ENTER);	       
//		        r.keyRelease(KeyEvent.VK_ENTER);
//	       pf.enterDate(tripDetails.get(2));
//	       pf.enterTime(tripDetails.get(3));
	//}

  @When("User enters the {string},{string},{string} and {string}")
   public void user_enters_the_and(String source , String destin, String date, String classnam) throws InterruptedException, AWTException {
	 pf.enterSource(source);
	 pf.enterDest(destin);
	 pf.enterDate(date);
	 pf.classMethod();
    }

	@And("click on search option")
	public void click_on_search_option() {
		pf.searchMethod();
		
		
	}

	@Then("list of train appears")
	public void list_of_train_appears() {
		String searchexp=pf.AssertSearch();
		Assert.assertTrue(searchexp.contains("Udyan Express"));
		
	}
	
	

//-------------------------------------------------------------------------------
	//scenario 2
	@When("User is on the searchpage")
	public void user_is_on_the_searchpage() throws InterruptedException {
		pf=new TrainSearchPageFactory(driver);
	    pf.train();
	    Thread.sleep(2000);
	    pf.searchMeth();
	}
	@And("click on AC filter")
	public void click_on_ac_filter() {
		pf.searchFilter();
	}
	@Then("AC trains are displayed")
	public void ac_trains_are_displayed() {
		String filter=pf.AssertFilter();
		Assert.assertTrue(filter.contains("Applied filters"));
	}
	
///--------------------------------------------------------------------------------------
	//Scenario3

	@When("user to click the train option from the homepage")
	public void user_to_click_the_train_option_from_the_homepage() throws InterruptedException {
		pf=new TrainSearchPageFactory(driver);
		pf.train();
	    Thread.sleep(2000);
	}
	@When("User should click on check pnr status")
	public void user_should_click_on_check_pnr_status() {
		pf.checkpnrstatus();
	}
	@When("User should enter the valid pnr number")
	public void user_should_enter_the_valid_pnr_number(DataTable credentials) throws InterruptedException, AWTException {
		//pf = new TrainSearchPageFactory(driver);
		pf.Clickenterpnr();
		
	    Thread.sleep(2000);
	   // pf = new TrainSearchPageFactory(driver);
		List<List<String>> cells = credentials.cells();
		// pf.livestatus(cells.get(0).get(0));
		 pf.enterpnrnumber(cells.get(0).get(0));
	}
	@When("user should click on the check status button")
	public void user_should_click_on_the_check_status_button() throws InterruptedException {
		Thread.sleep(2000);
		pf.checkstatuspnr();
	    
	}
	@Then("user should see the current status of booked tickets")
	public void user_should_see_the_current_status_of_booked_tickets() {

		
		String pnrstatus=pf.assertpnr();
		Assert.assertTrue(pnrstatus.contains("PNR 4364810556" ));
	
	}
///---------------------------scenario4---------------------------------------------

@When("user to be in the train option of the homepage")
public void user_to_be_in_the_train_option_of_the_homepage() throws InterruptedException {
	pf=new TrainSearchPageFactory(driver);
	pf.train();
    Thread.sleep(2000);
}
@When("User will click on check pnr status")
public void user_will_click_on_check_pnr_status() {
	pf.checkpnrstatus();
}
@When("User should enter the invalid pnr number")
public void user_should_enter_the_invalid_pnr_number(DataTable pnrnumber) throws InterruptedException {
	pf.Clickenterpnr();
	
    Thread.sleep(2000);
   // pf = new TrainSearchPageFactory(driver);
	List<List<String>> cells = pnrnumber.cells();
	// pf.livestatus(cells.get(0).get(0));
	 pf.enterpnrnumber(cells.get(0).get(0));
}
@When("user will click on the check status button")
public void user_will_click_on_the_check_status_button() throws InterruptedException {
	Thread.sleep(2000);
	pf.checkstatuspnr();
}
@Then("user will see PNR is either not generated")
public void user_will_see_pnr_is_either_not_generated() {
//	Assert.assertTrue(true);
//	System.out.print("pnr is not generated");
//	String checkv=pf.assertpnr();
//	Assert.assertTrue(checkv.contains("This PNR is either not generated or flushed"));
	
	String pnrinvalid=pf.assertinvalid();
	Assert.assertTrue(pnrinvalid.contains("This PNR is either not generated or flushed" ));

}
	
///-------scernario5------------------------------------------------------------------------------

	@When("user in on the train page")
	public void user_in_on_the_train_page() throws InterruptedException {
	pf=new TrainSearchPageFactory(driver);
	pf.train();
    Thread.sleep(2000);
	}
	
	@And("user should click on live train status")
	public void user_should_click_on_live_train_status() {
	pf.livetrainstatus();
	}
	
	@And("user should enter the train number and date of the journey")
	public void user_should_enter_the_train_number_and_date_of_the_journey(DataTable dataTable) throws InterruptedException, AWTException {
		pf.clicklivetrainsta();
		Thread.sleep(2000);
	   // pf = new TrainSearchPageFactory(driver);
		List<List<String>> cells = dataTable.cells();
		 pf.livestatus(cells.get(0).get(0)); 
		 
		// pf.enteryourStop();
		 //Thread.sleep(2000);
		 
		 pf.enteryourstopinput();
		 pf.Dateselect();
		
		
	}

	@And("user should be able to click on check status to the live status of the train")
	public void user_should_be_able_to_click_on_check_status_to_the_live_status_of_the_train() {
		pf.livestatuscheckstatus();
	}
	
	@Then("user should be able see the live status of particular train")
	public void user_should_be_able_see_the_live_status_of_particular_train() {
	    System.out.println("live status receieved");
	    String msg=pf.assertlivestatus();
	    Assert.assertTrue(msg.contains("Kaveri Express"));
	}
	
	@AfterStep
	public static void takeScreendown(Scenario scenerio) 
	{
		   TakesScreenshot ts= (TakesScreenshot) driver;
		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		   scenerio.attach(src, "image/png",scenerio.getName());
	}

}


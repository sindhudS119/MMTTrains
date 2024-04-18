package Mmt_TrainRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\Features123\\Train.feature",
glue = "Mmt_TrainStepDefinition",
plugin= {"pretty",
		"html:target/HTMLReports/MMTTrainReport.html",	
		"json:target/JSONReports/MMTTrainReport.json",
	"junit:target/JUNITReports/MMTTrainReport.xml"})
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//tags="@scenario5")

public class TrainSearchRunner extends AbstractTestNGCucumberTests  {
}

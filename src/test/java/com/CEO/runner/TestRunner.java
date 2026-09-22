package com.CEO.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	
		features = "src/test/resources/features",
		glue="com.CEO.stepdefinition",
		tags="@leavee",
		dryRun=false,
		monochrome = true,//it is false then console readability not
				plugin= {"rerun:target/failed_scenario1.txt"}
	//	plugin= {"rerun:target/failed_scenario.txt","html:target/cucumber-reports/report.html",
			//	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		//v-19 plugin for reporting
		//1.plugin= {"rerun:target/failed_scenario.txt","pretty"}
		//1.plugin= {"rerun:target/failed_scenario.txt","usage"}
		
		//plugin={"rerun:failed_scenario/failed_scenario.txt"}
		
		)
public class TestRunner {

	//System.setProperty("webdriver.edge.driver","msedgedriver.exe");
}

package com.CEO.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features = "@failed_scenario/failed_scenario.txt"
		features = "@target/failed_scenario1.txt",
		glue="com.CEO.stepdefinition",
		dryRun=false,
		monochrome = true
		
		)
public class ReRunner {

}

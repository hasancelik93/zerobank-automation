package com.zerobank.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"           // simple report in cucumber run through intellij not maven
        },
        features = "src/test/resources/features",
        glue = "com/zerobank/stepdefinitions",
        // dryRun = true checks the steps if they have definition or not
        dryRun = false,
        // checks the tags and compiles matched tag scenarios
        // you can put or , and to execute the test cases that you want
        // if you want to skip test case use exp:tags = " @driver and not @wip"
        tags = "@wip"
)
public class CukesRunner {
}


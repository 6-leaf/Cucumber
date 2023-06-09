package com.exelenter.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue = "com/exelenter/steps"
        ,dryRun = false
        ,monochrome = true
//        ,tags = "@smoke or @regression"
        ,tags = "@login"
)





public class TestRunner {
}

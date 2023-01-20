package com.crm.GenricUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerImplementaion implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//Execution Starts from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"------> Testscript execution Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"----> Passed");
		Reporter.log(MethodName+"------> Testscript execution sucessful");
		
	}

	public void onTestFailure(ITestResult result) {
		String FailedScript=result.getMethod().getMethodName();
		String fs="FailedScript"+new JavaUtility().getDateInFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass1.sdriver);
		 File src = edriver.getScreenshotAs(OutputType.FILE);
		 File path = new File("./ScreenShot/"+fs+".png");
		 String filePath=path.getAbsolutePath();
		 try {
			FileUtils.copyFile(src, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 test.addScreenCaptureFromPath(filePath);
		 test.log(Status.FAIL, result.getThrowable());
		 Reporter.log("--Testscript Execution failed--");
	}

	public void onTestSkipped(ITestResult result) {
		//configure the Report
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"-- Skipped");
		Reporter.log("--TestScript Execution Skipped--");
		
	}

	public void onStart(ITestContext context) {
		//configure the report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET45 ExtentReport");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("eduCare Report");
		
	 report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "https://localhost:8888");
		report.setSystemInfo("Reorter Name", "Rishi");
	}

	public void onFinish(ITestContext context) {
		//consolidated the report
		report.flush();
		
	}
	
	

}

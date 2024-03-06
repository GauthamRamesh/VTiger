package com.crm.genericUtils;
import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ListImplClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) 
	{
		// Execution Starts from here //
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+" ------>  Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" --->  Passed");
		Reporter.log(methodName+" ------TestScript Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			String methodName=result.getMethod().getMethodName();
			String screenshot=WebDriverUtils.getScreenShot(BaseClass.sdriver, methodName);
			test.log(Status.FAIL, methodName+" --->   Failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(methodName+" ------TestScript Failed");
			test.addScreenCaptureFromPath(screenshot);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" --->   Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+" ------TestScript Skipped");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlreport= new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-54");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("VTiger");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		
		report.setSystemInfo("Base platform", "windows 10");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Vijaylakshmi");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

}

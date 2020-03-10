package com.shopcart.qa.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.shopcart.qa.base.TestBase;

public class TestNGListeners extends TestBase implements ITestListener {
	public static ExtentReports reports;
	public static ExtentTest test;
	public static Logger log = Logger.getLogger(TestBase.class);

	public void onFinish(ITestContext ITC) {
		System.out.println("============================[--Finished_Test_Cases--]=================================");

		log.info("Ending Chrome Test_Case Finished Time..." + ITC);

		System.out.println("[__Test_Case Finished Time__] :-" + ITC.getName());
		System.out.println("[........Finish_Time........] :-" + new java.util.Date());
		reports.endTest(test);
		reports.flush();
	}

	public void onStart(ITestContext ITC2) {
		System.out.println("=========================[--Started_Test_Cases--]====================================");

		System.out.println("[__Test_Case Started Time__] :-" + ITC2.getName());
		System.out.println("[.....Test_Start_Time......] :-" + new java.util.Date());

		log.info("Lunching Test_Case Started Time..." + ITC2);

		reports = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReposhot.html", true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult TBWSP) {
		System.out.println(
				"=============================[--Test_Is_Failed_But_Within_Success_Percentage--]================================");

		log.info("Test Failed But Within Success Percentage..." + TBWSP);

		System.out.println("[....Test_Failed But Within Success Percentage....] :-" + TBWSP.getName());
		System.out.println("[....TestFailedButWithinSuccessPercentage Time....] :-" + new java.util.Date());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("==============================[--Test_Is_Failed--]===============================");

		log.info("Test Failed..." + result);

		System.out.println("[__Test Failure Exception is occured__] : " + result);
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "_[..Test is Failed X..]");
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "_..Please Verify & Validate Your Test..");

		String screenShotPath = null;
		try {

			screenShotPath = TestUtil.takeScreenshotAtEndOfTest(driver, screenShotPath);
			test.log(LogStatus.FAIL, "Failed_Test | Screenshot" + test.addScreenCapture(screenShotPath));

		} catch (IOException e1) {

			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult TS) {
		System.out.println("==============================[--Test_Is_Skipped--]===============================");

		log.info("Test Skipped..." + TS);

		System.out.println("[____Test_Skipped___] :-" + TS.getName());
		System.out.println("[....Skipped_Time...] :-" + new java.util.Date());
		test.log(LogStatus.SKIP, TS.getMethod().getMethodName() + "_[..Test is Skipped..]");
	}

	public void onTestStart(ITestResult TSRT) {
		System.out.println("==============================[--Test_Is_Started--]===============================");

		log.info("Test Started..." + TSRT);

		System.out.println("[____Test_Start____] :-" + TSRT.getName());
		System.out.println("[....Start_Time....] :-" + new java.util.Date());
		test = reports.startTest(TSRT.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult TSS) {
		System.out.println("=============================[--Test_Is_Success--]================================");

		log.info("Test Successed..." + TSS);

		System.out.println("[______Test_Success_______] :-" + TSS.getName());
		System.out.println("[....Test_Success_Time....] :-" + new java.util.Date());
		test.log(LogStatus.PASS, TSS.getMethod().getMethodName() + "_[..Test is Passed..]");
	}

}

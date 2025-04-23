
package UtilityProgpt;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener extends BaseProgpt implements ITestListener {
	
	@Override
	public void onTestStart (ITestResult result) {
		log.info("Test Method "+result.getName()+ " Starts---------------------------");
	}
	@Override
	public void onTestSuccess (ITestResult result) {
		log.info("---------------------------Test Method "+result.getName()+ " passes");
	}
	@Override
	public void onTestFailure (ITestResult result) {
		log.error("Test Method "+result.getName()+ " ++++++++++++++fails++++++++++++++++");
		screenShot( result.getName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		log.error("Test Method "+result.getName()+ " ++++++++++++++skips");
	}
//	@Override
//	public void onStart(ITestContext context) {
//		System.out.println("Test Method "+context.getName()+ " Start");
//	}
//	@Override
//	public void onFinish(ITestContext context) {
//		System.out.println("Test Method "+context.getName()+ " End----------------------------");
//	}
	

}

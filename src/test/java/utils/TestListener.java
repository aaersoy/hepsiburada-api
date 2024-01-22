package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        result.setStatus(ITestResult.FAILURE);
        AssertionError errorCast = new AssertionError(
                result.getThrowable().getMessage(),
                result.getThrowable()
        );
        result.setThrowable(errorCast);
    }
}

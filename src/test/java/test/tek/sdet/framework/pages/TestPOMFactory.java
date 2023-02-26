package test.tek.sdet.framework.pages;
import test.tek.sdet.framework.base.TestBaseSetup;

public class TestPOMFactory extends TestBaseSetup {
	
	private TestRetailHomePage homePage;
	private TestRetailSignInPage signInPage;
	private TestRetailAccountPage accountPage;
	
	
	public TestPOMFactory() {
		
	this.homePage = new TestRetailHomePage();	
	this.signInPage = new TestRetailSignInPage();
	this.accountPage = new TestRetailAccountPage();
	}
	
	public TestRetailHomePage homePage() {
		return this.homePage;
	}
	
	public TestRetailSignInPage signInPage() {
		return this.signInPage;
	}
	
	public TestRetailAccountPage accountPage() {
		return this.accountPage;
	}
}
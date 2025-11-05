package encova

import static com.kms.katalon.core.testobject.SelectorMethod.CSS
import static com.kms.katalon.core.testobject.SelectorMethod.XPATH

import java.nio.file.Path
import java.text.MessageFormat

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.SystemUtils
import org.openqa.selenium.Keys
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.ConsoleCommandBuilder
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.util.OSUtil

import io.cucumber.datatable.dependency.difflib.myers.PathNode


public class WebAuthenticator {
	static String userDataDir;

	static String chromeDebuggingPort;

	static String browserBinary = "";

	static Process process;

	static String getBrowserBinary() {
		if (StringUtils.isNotBlank(browserBinary)) {
			return browserBinary;
		}
		if (SystemUtils.IS_OS_WINDOWS) {
			return "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome";
		}
		if (SystemUtils.IS_OS_LINUX) {
			return "/usr/bin/chrome";
		}
		if (SystemUtils.IS_OS_MAC) {
			return "/Applications/Google Chrome.app/Contents/MacOS/Google\\ Chrome";
		}
	}

	static String getBrowserExecutableName() {
	}

	/**
	 * 1. Use Selenium to generate a Chrome profile
	 * 2. Start a browser manually with the generated profile
	 * 3. Login to Google with the opened browser
	 */
	@Keyword
	def loginWithGoogle(String username, String password, boolean use2FA = false) {
		openUndetectedBrowser();

		doGoogleLogin(username, password, use2FA);

		//		switchToNormalBrowser();
	}

	@Keyword
	def closeBrowser() {
		try {
			def driver = DriverFactory.getWebDriver();
			if (driver != null) {
				try {
					driver.close();
				} catch (Exception error) {
					//
				}
				try {
					driver.quit();
				} catch (Exception error) {
				}
				WebAuthenticator.process.destroyForcibly();
			}
		} catch (Exception error) {
			//			println error
		}
	}

	def switchToNormalBrowser() {
		closeBrowser()

		WebUI.delay(1)

		if (StringUtils.isNotBlank(userDataDir)) {
			List<String> args = new ArrayList();

			Map<String, Object> properties = RunConfiguration.getDriverPreferencesProperties(DriverFactory.WEB_UI_DRIVER_PROPERTY);
			def existingArgs = properties.get("args");
			if (existingArgs != null) {
				args.addAll(existingArgs);
			}
			args.add("--user-data-dir=" + userDataDir);
			println "> User data dir 2: " + userDataDir;

			RunConfiguration.setWebDriverPreferencesProperty("args", args);
		}

		WebUI.openBrowser('');
	}

	def doGoogleLogin(String username, String password, boolean use2FA = false) {
		WebUI.navigateToUrl("https://accounts.google.com/");

		WebUI.waitForPageLoad(0);
		WebUI.delay(1);

		def usernameInput = buildTestObject('[type="email"]');
		WebUI.waitForElementClickable(usernameInput, 0);
		WebUI.setText(usernameInput, username + Keys.RETURN);

		WebUI.delay(3);

		def passwordInput = buildTestObject('[type="password"]');
		WebUI.waitForElementClickable(passwordInput, 0);
		WebUI.setText(passwordInput, password + Keys.RETURN);

		WebUI.delay(3);
		WebUI.waitForPageLoad(0);

		if (use2FA) {
			WebUI.delay(30);
		}

		//		def notNow = buildTestObject("//span[contains(., 'Not now')]");
		//		WebUI.click(notNow, FailureHandling.OPTIONAL);
		//		WebUI.delay(10);
	}

	@Keyword
	def openUndetectedBrowser() {
		prepareChromeProfile();

		String browserBinaryDir = new File(getBrowserBinary()).getParent();
		String browserBinaryName = new File(getBrowserBinary()).getName();
		String commonArgs = "--no-first-run"
		String command = MessageFormat.format("{0} {1} --remote-debugging-port={2} --user-data-dir=\"{3}\"", browserBinaryName, commonArgs, chromeDebuggingPort, userDataDir);
		process = ConsoleCommandBuilder.create(command).addPath(browserBinaryDir).exec();

		WebUI.delay(3); // Wait for the browser to launch

		ChromeOptions chromeOptions2 = new ChromeOptions();
		chromeOptions2.addArguments("--user-data-dir=" + userDataDir);
		chromeOptions2.setExperimentalOption("debuggerAddress", "127.0.0.1:" + chromeDebuggingPort);
		//		chromeOptions2.setExperimentalOption("excludeSwitches", ["enable-automation", "test-type", "use-mock-keychain", "allow-pre-commit-input", "disable-background-networking", "disable-client-side-phishing-detection", "disable-default-apps", "disable-hang-monitor", "disable-popup-blocking", "disable-prompt-on-repost", "disable-sync", "enable-logging", "log-level", "no-service-autorun", "password-store"]);

		def driver = new ChromeDriver(chromeOptions2);
		DriverFactory.changeWebDriver(driver);

		return driver;
	}

	def prepareChromeProfile() {
		System.setProperty(DriverFactory.CHROME_DRIVER_PATH_PROPERTY_KEY, DriverFactory.getChromeDriverPath());
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless=new");
		def driver = new ChromeDriver(chromeOptions);

		def caps = driver.getCapabilities();
		TreeMap chromeCaps = caps.getCapability("chrome");
		userDataDir = chromeCaps.get("userDataDir");
		println "> User data dir: " + userDataDir;

		TreeMap chromeOpts = caps.getCapability("goog:chromeOptions");
		chromeDebuggingPort = ((String) (chromeOpts.get("debuggerAddress"))).split(":")[1]

		driver.close()
		WebUI.delay(1)
	}

	static def TestObject buildTestObject(String selector) {
		TestObject testObject = new TestObject();
		testObject.objectId = selector;
		if (selector.startsWith("//")) {
			testObject.setSelectorMethod(XPATH);
			testObject.setSelectorValue(XPATH, selector);
		} else {
			testObject.setSelectorMethod(CSS);
			testObject.setSelectorValue(CSS, selector);
		}
		return testObject;
	}
}
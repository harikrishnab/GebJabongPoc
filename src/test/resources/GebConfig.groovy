/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

import java.util.concurrent.TimeUnit

waiting {
	timeout = 10
}


environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
	//	driver = { new ChromeDriver() }
		driver = {
			def chromeBrowser = new ChromeDriver()
			chromeBrowser.manage().window().maximize()
			chromeBrowser.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS)
			chromeBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
			return chromeBrowser
		}
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = {
			def ff = new FirefoxDriver()
			ff.manage().window().maximize()
			return ff
		}
	}

    phantomJs {
        driver = { new PhantomJSDriver() }
    }

}

// To run the tests with all browsers just run “./gradlew test”

//baseUrl = "http://gebish.org"
baseUrl = "http://www.jabong.com/online-sale/"

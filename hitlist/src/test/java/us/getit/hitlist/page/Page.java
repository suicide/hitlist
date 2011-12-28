/**
 * 
 */
package us.getit.hitlist.page;

import org.openqa.selenium.WebDriver;

/**
 * @author psy
 * 
 */
public abstract class Page {

	protected WebDriver driver;

	protected String baseUrl;

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param baseUrl
	 *            the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}

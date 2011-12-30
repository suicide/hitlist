/**
 * 
 */
package us.getit.hitlist.page;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author psy
 * 
 */
public abstract class Page {

	@Autowired
	protected WebDriver driver;

	@Value("#{configData.baseUrl}")
	protected String baseUrl;

}

/**
 * 
 */
package us.getit.hitlist.page;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author psy
 * 
 */
@Component
public class ListPage extends Page {

	@Value("#{configData.listPage}")
	private String path;

	public void clickAddPage() {

		WebElement link = driver.findElement(id("addLink"));
		link.click();

	}

	public void open() {
		driver.get(baseUrl + path);
	}

}

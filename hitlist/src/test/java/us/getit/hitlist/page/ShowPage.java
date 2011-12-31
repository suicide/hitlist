/**
 * 
 */
package us.getit.hitlist.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author psy
 * 
 */
@Component
public class ShowPage extends Page {

	@Value("#{configData.showPage}")
	private String path;

	/**
	 * open Person by id
	 * 
	 * @param id
	 */
	public void open(long id) {

		driver.get(baseUrl + path + "/" + id);

	}

	public String getFirstname() {

		WebElement firstnameContainer = driver.findElement(By.id("firstname"));
		return firstnameContainer.getText();

	}

	public String getLastname() {
		WebElement lastnameContainer = driver.findElement(By.id("lastname"));
		return lastnameContainer.getText();
	}

}

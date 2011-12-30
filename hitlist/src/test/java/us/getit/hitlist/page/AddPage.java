/**
 * 
 */
package us.getit.hitlist.page;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * @author psy
 * 
 */
@Component
public class AddPage extends Page {

	public void cancel() {

		WebElement link = driver.findElement(id("cancelLink"));
		link.click();

	}

	public void setFirstname(String firstname) {
		WebElement field = driver.findElement(id("person.firstname"));
		field.sendKeys(firstname);
	}

	public void setLastname(String lastname) {
		WebElement field = driver.findElement(id("person.lastname"));
		field.sendKeys(lastname);

	}

	public void submitForm() {
		WebElement submitButton = driver.findElement(id("formSubmit"));
		submitButton.submit();

	}

}

/**
 * 
 */
package us.getit.hitlist.page;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.WebElement;

/**
 * @author psy
 * 
 */
public class AddPage extends Page {

	private ListPage listPage;

	/**
	 * @param listPage
	 *            the listPage to set
	 */
	public void setListPage(ListPage listPage) {
		this.listPage = listPage;
	}

	public ListPage cancel() {

		WebElement link = driver.findElement(id("cancelLink"));
		link.click();

		return listPage;
	}

	public void setFirstname(String firstname) {
		WebElement field = driver.findElement(id("person.firstname"));
		field.sendKeys(firstname);
	}

	public void setLastname(String lastname) {
		WebElement field = driver.findElement(id("person.lastname"));
		field.sendKeys(lastname);

	}

	public ListPage submitForm() {
		WebElement submitButton = driver.findElement(id("formSubmit"));
		submitButton.submit();

		return listPage;
	}

}

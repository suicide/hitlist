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
public class ListPage extends Page {

	private AddPage addPage;

	private final String path;

	/**
	 * @param addPage
	 *            the addPage to set
	 */
	public void setAddPage(AddPage addPage) {
		this.addPage = addPage;
	}

	public ListPage() {
		path = "/list";
	}

	public AddPage clickAddPage() {

		WebElement link = driver.findElement(id("addLink"));
		link.click();

		return addPage;
	}

	public void open() {
		driver.get(baseUrl + path);
	}

}

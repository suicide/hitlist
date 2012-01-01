/**
 * 
 */
package us.getit.hitlist.page;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

import java.util.ArrayList;
import java.util.List;

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

	public void clickShowLink(long id) {
		WebElement link = driver.findElement(id("showLink_" + id));
		link.click();
	}

	public List<String> getPersons() {
		List<WebElement> elements = driver.findElements(className("person"));

		// Too much logic here for my taste. Better to refactor to general
		// helper method. Maybe there is already something like this...
		List<String> personList = new ArrayList<String>();

		for (WebElement element : elements) {
			personList.add(element.getText());
		}

		return personList;
	}

}

/**
 * 
 */
package us.getit.hitlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import us.getit.hitlist.service.PersonService;

/**
 * @author psy
 * 
 */
@Controller
public class ListController {

	@Autowired
	private PersonService personService;

	/**
	 * @param personService
	 *            the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/list")
	public String list(Model model) {

		model.addAttribute("personList", personService.list());

		return "list";
	}

}

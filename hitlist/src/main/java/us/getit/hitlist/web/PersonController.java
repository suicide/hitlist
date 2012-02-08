/**
 * 
 */
package us.getit.hitlist.web;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import us.getit.hitlist.model.Person;
import us.getit.hitlist.service.PersonService;

/**
 * @author psy
 * 
 */
@Controller
public class PersonController {

	/**
	 * Data Access
	 */
	@Autowired
	private PersonService personService;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	/**
	 * list all persons
	 * 
	 * @return
	 */
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	List<Person> list(HttpServletRequest request) {

		return personService.list();
	}

	/**
	 * 
	 * Get by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	Person getById(@PathVariable long id) {
		return personService.getById(id);
	}

	/**
	 * create new person
	 * 
	 * @param person
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Person person, HttpServletRequest request,
			HttpServletResponse response) {

		long id = personService.save(person);

		StringBuffer url = request.getRequestURL();

		UriTemplate template = new UriTemplate(url.append("/{personId}")
				.toString());
		String personUrl = template.expand(id).toASCIIString();

		response.setHeader("Location", personUrl);
	}

	/**
	 * 
	 * update existing person
	 * 
	 * @param id
	 * @param person
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable long id, @RequestBody Person person) {
		Person dbPerson = personService.getById(id);

		dbPerson.setFirstname(person.getFirstname());
		dbPerson.setLastname(person.getLastname());

		personService.save(dbPerson);
	}

	/**
	 * delete person
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		Person person = personService.getById(id);

		personService.delete(person);
	}

}

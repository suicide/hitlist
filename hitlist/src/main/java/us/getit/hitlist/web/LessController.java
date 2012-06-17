/**
 * 
 */
package us.getit.hitlist.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hastybox.lesscss.compileservice.WebLessCompileService;

/**
 * Simple LESS to CSS Controller
 * 
 * @author psy
 * 
 */
@Controller
public class LessController {

	@Autowired
	private WebLessCompileService lessCompileService;

	@RequestMapping({ "/css/*.css", "/css/*/*.css" })
	public void retrieveCss(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String requestPath = request.getRequestURI();

		String regex = "^.+/css/(.*)\\.css";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(requestPath);

		if (!matcher.find()) {
			throw new Exception("this is not working");
		}

		String filePath = matcher.group(1) + ".less";

		String cssCode = lessCompileService.compileFromPath(filePath, request.getSession().getServletContext());

		response.getWriter().write(cssCode);
	}
}

/**
 * 
 */
package us.getit.hitlist.config;

import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.descriptor.JspPropertyGroupDescriptor;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author psy
 * 
 */
public class HitlistInitializer implements WebApplicationInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
	 * .ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
		rootContext.setConfigLocation("/WEB-INF/classes/config/spring-config.xml");

		// Register Spring Root Application Context
		servletContext.addListener(new ContextLoaderListener(rootContext));

		// Create Spring Web Context
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("/WEB-INF/config/hitlist-config.xml");

		// Add DispatcherServlet
		ServletRegistration.Dynamic dispatcher = servletContext
				.addServlet("hitlist", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		// TODO how to set default servlet somewhere else?
		servletContext.getServletRegistration("default").addMapping("/static/*");
		servletContext.getServletRegistrations();

		// does that work? Eclipse does not recognize this in the jsp :P
		JspPropertyGroupDescriptor taglibInclude = new JspPropertyGroupDescriptor() {

			@Override
			public Collection<String> getUrlPatterns() {
				return Collections.singleton("*.jsp");
			}

			@Override
			public String getTrimDirectiveWhitespaces() {
				return null;
			}

			@Override
			public String getScriptingInvalid() {
				return null;
			}

			@Override
			public String getPageEncoding() {
				return "UTF-8";
			}

			@Override
			public String getIsXml() {
				return null;
			}

			@Override
			public Collection<String> getIncludePreludes() {
				return Collections.singleton("/WEB-INF/include/taglibs.jsp");
			}

			@Override
			public Collection<String> getIncludeCodas() {
				return null;
			}

			@Override
			public String getErrorOnUndeclaredNamespace() {
				return null;
			}

			@Override
			public String getElIgnored() {
				return null;
			}

			@Override
			public String getDeferredSyntaxAllowedAsLiteral() {
				return null;
			}

			@Override
			public String getDefaultContentType() {
				return null;
			}

			@Override
			public String getBuffer() {
				return null;
			}
		};

		servletContext.getJspConfigDescriptor().getJspPropertyGroups().add(taglibInclude);

	}

}

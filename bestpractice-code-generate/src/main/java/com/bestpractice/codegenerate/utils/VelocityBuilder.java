package com.bestpractice.codegenerate.utils;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class VelocityBuilder {

	static {
		Velocity.addProperty("resource.loader", "class");
		Velocity.addProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.addProperty("resource.loader", "globbing,string");
		Velocity.init();
	}

	private VelocityContext context;

	private VelocityBuilder(VelocityContext context) {
		this.context = context;
	}

	public static VelocityBuilder create() {
		return new VelocityBuilder(new VelocityContext());
	}

	public VelocityBuilder add(String name, Object value) {
		context.put(name, value);
		return this;
	}

	public VelocityContext getVelocityContext() {
		return context;
	}

	public String render(String templateName) {
		Template template = null;
		try {
			template = Velocity.getTemplate(templateName);
		} catch (ResourceNotFoundException rnfe) {
			// couldn't find the template
		} catch (ParseErrorException pee) {
			// syntax error: problem parsing the template
		} catch (MethodInvocationException mie) {
			// something invoked in the template
			// threw an exception
		} catch (Exception e) {
		}

		StringWriter sw = new StringWriter();

		template.merge(context, sw);
		return sw.toString();
	}
}

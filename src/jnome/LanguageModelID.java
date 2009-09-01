package jnome;

import java.io.IOException;

import jnome.core.language.Java;
import jnome.editor.JavaEditorExtension;
import jnome.input.JavaModelFactory;
import jnome.output.JavaCodeWriter;
import chameleon.core.language.Language;
import chameleon.editor.connector.ChameleonEditorExtension;
import chameleon.editor.connector.EclipseBootstrapper;
import chameleon.input.ModelFactory;
import chameleon.input.ParseException;
import chameleon.output.Syntax;

public class LanguageModelID implements EclipseBootstrapper {

	public String getLanguageName() {
		return "Java";
	}

	public String getLanguageVersion() {
		return "1.5";
	}

	public String getVersion() {
		return "Jnome build Auguest 27 2009";
	}

	public String getDescription() {
		return "Jnome: a Chameleon model for Java";
	}

	public String getLicense() {
		return "";
	}

	public Syntax getCodeWriter() {
		return new JavaCodeWriter();
	}

	public Language createLanguage() throws IOException, ParseException {
		Java result = new Java();
		ModelFactory factory = new JavaModelFactory(result);
		factory.setLanguage(result, ModelFactory.class);
		result.setConnector(ChameleonEditorExtension.class, new JavaEditorExtension());
		return result;
	}

}

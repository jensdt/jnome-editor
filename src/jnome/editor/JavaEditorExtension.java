package jnome.editor;

import java.util.List;

import chameleon.core.element.Element;
import chameleon.core.method.Method;
import chameleon.core.method.MethodHeader;
import chameleon.core.method.MethodSignature;
import chameleon.core.namespace.Namespace;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.type.Type;
import chameleon.core.variable.FormalParameter;
import chameleon.core.variable.RegularMemberVariable;
import chameleon.editor.connector.ChameleonEditorExtension;
import chameleon.editor.project.ChameleonProjectNature;
import chameleon.support.member.simplename.SimpleNameMethodSignature;
import chameleon.tool.Connector;

/**
 * @author Marko van Dooren
 * @author Koen Vanderkimpen
 */
public class JavaEditorExtension extends ChameleonEditorExtension {
	
//    public JavaEditorExtension(ChameleonProjectNature nature) {
//		 super(nature);
//	  }

		public String getLabel(Element element) {
  		String result;
            if (element instanceof Method) {
                Method<? , ? , ? ,?> method = (Method<? , ? , ?,? >)element;
                result = method.name();
                List<FormalParameter> params = method.formalParameters();
                if (params.size()>0) {
                    result += "(";
                    for (int i = 0;i<params.size();i++) {
                        FormalParameter p = params.get(i);
                        result += p.getTypeReference().getName();
                        if (i<params.size()-1) {
                        	result += ",";
                        }
                    }
                    result += ")";
                }
            } else if (element instanceof RegularMemberVariable) {
                result = ((RegularMemberVariable)element).getName();
            } else if (element instanceof Type) {
                result = ((Type)element).getName();
            } else if (element instanceof NamespacePart) {
            	Namespace namespace = ((NamespacePart)element).namespace();
            	if(namespace != null) {
            		result = namespace.getFullyQualifiedName();
            	} else {
            		result = "Error in namespace declaration.";
            	}
            } else {
            	result = "";
            }
        return result;
    }

    public Connector clone() {
        return new JavaEditorExtension();
    }

}

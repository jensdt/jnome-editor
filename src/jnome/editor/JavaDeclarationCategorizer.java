package jnome.editor;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.member.Member;
import chameleon.core.method.Method;
import chameleon.core.method.RegularMethod;
import chameleon.core.type.Type;
import chameleon.core.variable.MemberVariable;
import chameleon.editor.presentation.DeclarationCategorizer;
import chameleon.support.member.simplename.operator.Operator;

public class JavaDeclarationCategorizer implements DeclarationCategorizer {

	public int category(Declaration declaration)  {
		Element element = declaration;
		if(element instanceof Member){
			if(element instanceof Method){
				if(element instanceof RegularMethod)
					return 3;
				if(element instanceof Operator)
					return 4;
				else
					return 10;
			} 
			if(element instanceof Type)
				return 5;
			if(element instanceof MemberVariable)
				return 1;
			else
				return 20;
		}
		return 30;
	}

}

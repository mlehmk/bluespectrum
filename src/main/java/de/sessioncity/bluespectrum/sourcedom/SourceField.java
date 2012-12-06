package de.sessioncity.bluespectrum.sourcedom;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.FieldVisitor;

import de.sessioncity.bluespectrum.utils.MutableString;
import de.sessioncity.bluespectrum.utils.MutableStringRoot;

public class SourceField implements FieldVisitor {

	public SourceField(int access, MutableString name, String desc, String signature, Object value)
	{
		
	}
	
	@Override
	public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visitAttribute(Attribute arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitEnd() {
		// TODO Auto-generated method stub

	}

}

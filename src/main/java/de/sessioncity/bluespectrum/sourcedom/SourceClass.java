package de.sessioncity.bluespectrum.sourcedom;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class SourceClass implements ClassVisitor {

	@Override
	public void visit(int version, int access, String name, String signature,
			String superName, String[] interfaces) {
		// TODO Auto-generated method stub

	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visitAttribute(Attribute attr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc,
			String signature, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visitInnerClass(String name, String outerName,
			String innerName, int access) {
		// TODO Auto-generated method stub

	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visitOuterClass(String owner, String name, String desc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitSource(String source, String debug) {
		// TODO Auto-generated method stub

	}

}

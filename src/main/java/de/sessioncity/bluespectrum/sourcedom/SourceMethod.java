package de.sessioncity.bluespectrum.sourcedom;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import de.sessioncity.bluespectrum.utils.MutableString;

public class SourceMethod implements MethodVisitor {

	public SourceMethod(int access, MutableString internalize, String desc,
			String signature, String[] exceptions) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationVisitor visitAnnotationDefault() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visitAttribute(Attribute arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitCode() {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitFieldInsn(int arg0, String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitFrame(int arg0, int arg1, Object[] arg2, int arg3,
			Object[] arg4) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitIincInsn(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitInsn(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitIntInsn(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitJumpInsn(int arg0, Label arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitLabel(Label arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitLdcInsn(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitLineNumber(int arg0, Label arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitLocalVariable(String arg0, String arg1, String arg2,
			Label arg3, Label arg4, int arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitLookupSwitchInsn(Label arg0, int[] arg1, Label[] arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitMaxs(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitMethodInsn(int arg0, String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitMultiANewArrayInsn(String arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public AnnotationVisitor visitParameterAnnotation(int arg0, String arg1,
			boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visitTableSwitchInsn(int arg0, int arg1, Label arg2,
			Label[] arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitTryCatchBlock(Label arg0, Label arg1, Label arg2,
			String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitTypeInsn(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitVarInsn(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

}

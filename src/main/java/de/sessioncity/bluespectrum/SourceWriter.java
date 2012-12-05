package de.sessioncity.bluespectrum;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class SourceWriter implements ClassVisitor {
	private Writer writer;
	private int indent = 0;

	public SourceWriter(OutputStream stream) {
		this.writer = new BufferedWriter(new OutputStreamWriter(stream));
	}

	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer = null;
	}

	private void writeIndent() {
		try {
			for (int i = 0; i < indent; ++i) {
				writer.write("    ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeAccess(int access) {
		try {
			if ((access & Opcodes.ACC_PUBLIC) != 0) {
				writer.write("public ");
			}
			if ((access & Opcodes.ACC_PRIVATE) != 0) {
				writer.write("private ");
			}
			if ((access & Opcodes.ACC_PROTECTED) != 0) {
				writer.write("protected ");
			}
			if ((access & Opcodes.ACC_ABSTRACT) != 0) {
				writer.write("abstract ");
			}
			if ((access & Opcodes.ACC_STATIC) != 0) {
				writer.write("static ");
			}
			if ((access & Opcodes.ACC_FINAL) != 0) {
				writer.write("final ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeType(String desc) {
		try {
			Type type = Type.getType(desc);
			if (type.equals(Type.BOOLEAN_TYPE)) {
				writer.write("boolean");
			} else if (type.equals(Type.BYTE_TYPE)) {
				writer.write("byte");
			} else if (type.equals(Type.CHAR_TYPE)) {
				writer.write("char");
			} else if (type.equals(Type.DOUBLE_TYPE)) {
				writer.write("double");
			} else if (type.equals(Type.FLOAT_TYPE)) {
				writer.write("float");
			} else if (type.equals(Type.INT_TYPE)) {
				writer.write("int");
			} else if (type.equals(Type.LONG_TYPE)) {
				writer.write("long");
			} else if (type.equals(Type.SHORT_TYPE)) {
				writer.write("short");
			} else if (type.equals(Type.VOID_TYPE)) {
				writer.write("void");
			} else {
				writer.write(type.getInternalName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(int version, int access, String name, String signature,
			String superName, String[] interfaces) {
		writeIndent();
		try {
			writeAccess(access);
			writer.write("class ");
			writer.write(name);
			if (signature != null) {
				writer.write(signature);
			}
			if (!superName.equals("java/lang/Object")) {
				writer.write(" extends ");
				writer.write(superName);
			}
			if (interfaces != null) {
				if (interfaces.length > 0) {
					writer.write(" implements ");
					writer.write(interfaces[0]);
				}
				for (int i = 1; i < interfaces.length; ++i) {
					writer.write(", ");
					writer.write(interfaces[i]);
				}
			}
			writer.write(" {\n");
			++indent;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class SourceAnnotationVisitor implements AnnotationVisitor {

		@Override
		public void visit(String arg0, Object arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public AnnotationVisitor visitAnnotation(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return this;
		}

		@Override
		public AnnotationVisitor visitArray(String arg0) {
			// TODO Auto-generated method stub
			return this;
		}

		@Override
		public void visitEnd() {
			// TODO Auto-generated method stub

		}

		@Override
		public void visitEnum(String arg0, String arg1, String arg2) {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return new SourceAnnotationVisitor();
	}

	@Override
	public void visitAttribute(Attribute arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitEnd() {
		--indent;
		writeIndent();
		try {
			writer.write("}\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class SourceFieldVisitor implements FieldVisitor {

		@Override
		public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
			// TODO Auto-generated method stub
			return new SourceAnnotationVisitor();
		}

		@Override
		public void visitAttribute(Attribute attribute) {
			// TODO Auto-generated method stub

		}

		@Override
		public void visitEnd() {
			// TODO Auto-generated method stub

		}

	}

	private void writeString(String str) {
		try {
			writer.write('"');
			writer.write(str); // TODO: Compute Escape
			writer.write('"');
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc,
			String signature, Object value) {
		try {
			writeIndent();
			writeAccess(access);
			writeType(desc);
			if (signature != null) {
				writer.write(signature);
			}
			writer.write(" ");
			writer.write(name);
			if (value != null) {
				writer.write(" = ");
				if (value.getClass().getSimpleName().equals("String")) {
					writeString((String) value);
				} else if (desc.equals("Z")) {
					writer.write((int) value != 0 ? "true" : "false");
				} else {
					writer.write('(');
					writer.write(value.getClass().getSimpleName());
					writer.write(')');
					writer.write(value.toString());
				}
			}
			writer.write(";\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new SourceFieldVisitor();
	}

	@Override
	public void visitInnerClass(String arg0, String arg1, String arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	private class SourceMethodVisitor implements MethodVisitor {

		@Override
		public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
			// TODO Auto-generated method stub
			return new SourceAnnotationVisitor();
		}

		@Override
		public AnnotationVisitor visitAnnotationDefault() {
			// TODO Auto-generated method stub
			return new SourceAnnotationVisitor();
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
		public void visitFieldInsn(int arg0, String arg1, String arg2,
				String arg3) {
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
		public void visitMethodInsn(int arg0, String arg1, String arg2,
				String arg3) {
			// TODO Auto-generated method stub

		}

		@Override
		public void visitMultiANewArrayInsn(String arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public AnnotationVisitor visitParameterAnnotation(int arg0,
				String arg1, boolean arg2) {
			// TODO Auto-generated method stub
			return new SourceAnnotationVisitor();
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

	@Override
	public MethodVisitor visitMethod(int arg0, String arg1, String arg2,
			String arg3, String[] arg4) {
		// TODO Auto-generated method stub
		return new SourceMethodVisitor();
	}

	@Override
	public void visitOuterClass(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitSource(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}
}

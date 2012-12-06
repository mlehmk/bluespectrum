package de.sessioncity.bluespectrum.sourcedom;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AnnotationNode;

import de.sessioncity.bluespectrum.utils.MutableRope;
import de.sessioncity.bluespectrum.utils.MutableString;
import de.sessioncity.bluespectrum.utils.MutableStringRoot;
import de.sessioncity.bluespectrum.utils.SourceUtils;

public class SourceRoot extends SourceClass {

	private String _package;
	private List<String> _imports = new ArrayList<String>();
	private String _modifiers;
	private String _classname;
	private String _signature;
	private MutableString _super;
	private List<MutableString> _interfaces;
	private List<SourceField> _fields = new ArrayList<SourceField>();
	private List<SourceMethod> _methods = new ArrayList<SourceMethod>();
	private MutableStringRoot _root = new MutableStringRoot();
	private LinkedHashMap<String, AnnotationNode> _annotations = new LinkedHashMap<>();
	
	public String getPackage()
	{
		return _package;
	}
	
	public String[] getImports()
	{
		return (String[])_imports.toArray();
	}
	
	public String getClassName()
	{
		return _classname;
	}
	
	public SourceField[] getFields()
	{
		return (SourceField[])_fields.toArray();
	}
	
	public SourceMethod[] getMethods()
	{
		return (SourceMethod[])_methods.toArray();
	}
	
	@Override
	public void visit(int version,
	           int access,
	           String name,
	           String signature,
	           String superName,
	           String[] interfaces) {
		// TODO Auto-generated method stub
		_modifiers = SourceUtils.getAccess(access);
		_package = SourceUtils.getPackage(name);
		_classname = SourceUtils.getName(_package, name);
		_signature = signature;
		_super = _root.internalize(SourceUtils.getName(_package, name));
		if(interfaces != null) {
			_interfaces = new ArrayList<MutableString>(interfaces.length);
			for(int i = 0; i < interfaces.length; ++i) {
				_interfaces.add(_root.internalize(SourceUtils.getName(_package, name)));
			}
		}
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		AnnotationNode node = new AnnotationNode(desc);
		_annotations.put(desc, node);
		return node;
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
		SourceField field = new SourceField(access, _root.internalize(name), desc, signature, value);
		_fields.add(field);
		return field;
	}

	@Override
	public void visitInnerClass(String name, String outerName,
			String innerName, int access) {
		// TODO Auto-generated method stub

	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		SourceMethod method = new SourceMethod(access, _root.internalize(name), desc, signature, exceptions);
		_methods.add(method);
		return method;
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

package de.sessioncity.bluespectrum.utils;

import org.objectweb.asm.Opcodes;

public class SourceUtils {
	private SourceUtils() {

	}

	public static String getAccess(int access) {
		StringBuilder result = new StringBuilder();
		if ((access & Opcodes.ACC_PUBLIC) != 0) {
			result.append("public ");
		}
		if ((access & Opcodes.ACC_PRIVATE) != 0) {
			result.append("private ");
		}
		if ((access & Opcodes.ACC_PROTECTED) != 0) {
			result.append("protected ");
		}
		if ((access & Opcodes.ACC_ABSTRACT) != 0) {
			result.append("abstract ");
		}
		if ((access & Opcodes.ACC_STATIC) != 0) {
			result.append("static ");
		}
		if ((access & Opcodes.ACC_FINAL) != 0) {
			result.append("final ");
		}
		return result.toString();
	}

	public static String getPackage(String name) {
		String s = getName(name);
		int p = s.lastIndexOf('.');
		return s.substring(0, p);
	}

	public static String getName(String prefix, String name) {
		String s = getName(name);
		if(s.startsWith(prefix)) {
			return s.substring(prefix.length(), s.length());
		}
		return s;
	}
	
	public static String getName(String name) {
		return name.replace('/', '.');
	}
}

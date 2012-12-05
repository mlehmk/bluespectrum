package de.sessioncity.bluespectrum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

public class App {
	public static void main(String[] args) {
		byte[] classdata;
		try {
			File classfile = new File(args[0]);
			int classsize = (int) classfile.length();
			classdata = new byte[classsize];
			InputStream stream = new FileInputStream(classfile);
			try {
				stream.read(classdata);
			} finally {
				stream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(20);
			return;
		}
		ClassReader reader = new ClassReader(classdata);
		ClassNode root = new ClassNode();
		reader.accept(root, 0);

		SourceWriter writer = new SourceWriter(System.out);
		root.accept(writer);
		writer.close();
	}
}

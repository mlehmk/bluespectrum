package de.sessioncity.bluespectrum.utils;

public class MutableString implements CharSequence, Comparable<MutableString> {

	private String shadow;
	private MutableStringRoot root;
	
	private MutableString(MutableStringRoot root, String shadow)
	{
		this.root = root;
		this.shadow = shadow;
	}
	
	public static MutableString internalize(MutableStringRoot root, String value)
	{
		MutableString result = root.find(value);
		if(result != null) return result;
		result = new MutableString(root, value);
		root.collection.put(value, result);
		return result;
	}
	
	public MutableStringRoot getRoot()
	{
		return root;
	}
	
	public void set(String value)
	{
		root.collection.remove(shadow);
		shadow = value;
		root.collection.put(value, this);
	}
	
	@Override
	public char charAt(int arg0) {
		return shadow.charAt(arg0);
	}

	@Override
	public int length() {
		return shadow.length();
	}

	@Override
	public CharSequence subSequence(int arg0, int arg1) {
		return shadow.subSequence(arg0, arg1);
	}

	@Override
	public boolean equals(Object arg0) {
		if(this == arg0) return true;
		return shadow.equals(arg0);
	}

	@Override
	public int hashCode() {
		return shadow.hashCode();
	}

	@Override
	public String toString() {
		return shadow;
	}

	@Override
	public int compareTo(MutableString o) {
		if(equals(o)) return 0;
		return shadow.compareTo(o.toString());
	}
}

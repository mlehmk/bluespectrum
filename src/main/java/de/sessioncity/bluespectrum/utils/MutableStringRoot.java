package de.sessioncity.bluespectrum.utils;

import java.util.HashMap;

public class MutableStringRoot {

	HashMap<String, MutableString> collection;
	private MutableStringRoot _parent;

	public MutableString find(String value) {
		MutableString result = collection.get(value);
		if (result == null) {
			result = _parent.find(value);
		}
		return result;
	}

	public MutableString internalize(String value, boolean shadow) {
		if (shadow == true) {
			return internalize(value);
		} else {
			MutableString result = find(value);
			if (result == null) {
				return internalize(value);
			} else {
				return result;
			}
		}
	}

	public MutableString internalize(String value) {
		return MutableString.internalize(this, value);
	}
}

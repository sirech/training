package com.hceris.strings;

import static com.hceris.util.Utils.swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	private Permutations() {
	}

	// assumptions: No duplicates
	public static List<String> permutations(String s) {
		if (s.length() == 0) {
			return Arrays.asList("");
		}

		char first = s.charAt(0);
		List<String> perm = permutations(s.substring(1));
		List<String> result = new ArrayList<String>();

		for (String elem : perm) {
			for (int i = 0; i <= elem.length(); i++) {
				result.add(insertCharAt(first, i, elem));
			}
		}
		return result;
	}

	private static String insertCharAt(char c, int i, String elem) {
		return elem.substring(0, i) + c + elem.substring(i);
	}

	public static List<String> permutations2(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return permutations2(chars, 0);
	}

	private static List<String> permutations2(char[] chars, int start) {
		if (chars.length - 1 <= start) {
			return Arrays.asList(new String(chars));
		}

		List<String> result = new ArrayList<String>();
		Character last = null;
		for (int i = start; i < chars.length; i++) {
			if (last != null && chars[i] == last)
				continue;

			swap(chars, i, start);
			result.addAll(permutations2(chars, start + 1));
			swap(chars, i, start);
			last = chars[i];
		}

		return result;
	}

	public static List<String> interleave(String s1, String s2) {
		List<String> combinations = new ArrayList<String>();
		interleave(s1, s2, "", combinations);
		return combinations;
	}

	private static void interleave(String s1, String s2, String current,
			List<String> combinations) {
		if (s1.length() == 0 && s2.length() == 0) {
			combinations.add(current);
			return;
		}

		if (s1.length() > 0) {
			interleave(s1.substring(1), s2, current + s1.charAt(0),
					combinations);
		}

		if (s2.length() > 0) {
			interleave(s1, s2.substring(1), current + s2.charAt(0),
					combinations);
		}
	}
}

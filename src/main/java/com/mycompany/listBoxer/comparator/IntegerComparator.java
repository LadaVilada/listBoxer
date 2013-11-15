package com.mycompany.listBoxer.comparator;

import java.util.Comparator;

public class IntegerComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		try {
			Integer value1 = Integer.parseInt(o1);
			Integer value2 = Integer.parseInt(o2);
			return value1 - value2;
		} catch (Exception ex) {
			return o1.compareTo(o2);
		}
	}

}

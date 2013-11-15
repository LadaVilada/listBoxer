package com.mycompany.listBoxer.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.mycompany.listBoxer.dto.RangeType;
import com.mycompany.listBoxer.dto.SelectionCriteria;

public class RangeUtils {

	private static final String RANGE_AM = "[A-Ma-m]";
	private static final String RANGE_NZ = "[N-Zn-z]";

	public static Boolean isInRange(String value, SelectionCriteria criteria) {

		if (StringUtils.isBlank(value)) {
			return Boolean.FALSE;
		}

		if (criteria == null) {
			return Boolean.FALSE;
		}

		if (criteria.getAlphabetic() && criteria.getNumeric()) {
			if (ObjectUtils.equals(criteria.getRange(), RangeType.ALL)) {
				return Boolean.TRUE;
			}
		}

		if (criteria.getAlphabetic()) {
			if (ObjectUtils.equals(criteria.getRange(), RangeType.AM)) {
				if (Pattern.matches(RANGE_AM, value.substring(0, 1)))
					return Boolean.TRUE;
			}
			if (ObjectUtils.equals(criteria.getRange(), RangeType.NZ)) {
				if (Pattern.matches(RANGE_NZ, value.substring(0, 1))) {
					return Boolean.TRUE;
				}
			}
		}

		if (criteria.getNumeric()) {
			switch (criteria.getRange()) {
			case NUM1:
				if (StringUtils.isNumeric(value)) {
					if (intervallContains(0, 100, Integer.parseInt(value)))
						return Boolean.TRUE;
				}
				break;

			case NUM2:
				if (StringUtils.isNumeric(value)) {
					if (intervallContains(101, 200, Integer.parseInt(value)))
						return Boolean.TRUE;
				}
				break;

			case NUM3:
				if (StringUtils.isNumeric(value)) {
					if (intervallContains(201, 300, Integer.parseInt(value)))
						return Boolean.TRUE;
				}
				break;

			case NUM4:
				if (StringUtils.isNumeric(value)) {
					if (intervallContains(301, 999, Integer.parseInt(value)))
						return Boolean.TRUE;
				}
				break;
			}

		}

		return Boolean.FALSE;
	}

	private static Boolean intervallContains(int low, int high, int n) {
		return n >= low && n <= high;
	}

}

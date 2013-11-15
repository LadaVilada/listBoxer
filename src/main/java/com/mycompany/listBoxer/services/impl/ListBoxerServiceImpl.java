/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listBoxer.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.mycompany.listBoxer.comparator.IntegerComparator;
import com.mycompany.listBoxer.dto.SelectionCriteria;
import com.mycompany.listBoxer.services.ListBoxerService;

/**
 * 
 * @author vbobina
 */

public class ListBoxerServiceImpl implements ListBoxerService {

	private List<String> content = new ArrayList<String>();
	private static final String PATTERN_AM = "[A-Ma-m]";
	private static final String PATTERN_NZ = "[N-Zn-z]";

	@Override
	public Boolean saveContent(String userInput) {
		if (StringUtils.isBlank(userInput)) {
			return Boolean.FALSE;
		}

		content.add(userInput);
		return Boolean.TRUE;
	}

	@Override
	public String getAll() {
		StringBuffer buffer = new StringBuffer();
		for (String item : content) {
			buffer.append(String.format("%s \n", item));
		}
		return buffer.toString();
	}

	@Override
	public List<String> getByCriteria(SelectionCriteria selCriteria) {
		/*
		 * According to FilterMockitoTest
		 * 
		 * 1.get elements by range (first letter)
		 * 
		 * 2.do alphabetic/numeric (!!! move to listener) check and filter list
		 * according to it
		 * 
		 * 3.apply assortment
		 */
		List<String> rangeList = getElementsByRange(getContent(), selCriteria);

		if (selCriteria.getAsc())
			Collections.sort(rangeList, new IntegerComparator());
		else if (selCriteria.getDesc())
			Collections.sort(rangeList, Collections.reverseOrder());

		return rangeList;
	}

	private List<String> getElementsByRange(List<String> list,
			SelectionCriteria criteria) {
		List<String> result = new ArrayList<String>();
		for (String item : list) {
			if (stringIsInRange(criteria, item))
				result.add(item);
		}
		return result;
	}

	public static boolean intervallContains(int low, int high, int n) {
		return n >= low && n <= high;
	}

	private boolean stringIsInRange(SelectionCriteria criteria, String str) {
		if (criteria.getAlphabetic()) {
			if (!criteria.getNumeric()) {
				// numeric = false, nordic = true
				switch (criteria.getRange()) {
				case ALL: {
					return true;
				}
				case AM:
					if (Pattern.matches(PATTERN_AM, str.substring(0, 1)))
						return true;
					break;
				case NZ:
					if (Pattern.matches(PATTERN_NZ, str.substring(0, 1))) {
						return true;
					}
					break;
				default:
					break;
				}
			} else {
				// numeric = true, nordic = true
				switch (criteria.getRange()) {
				case ALL: {
					return true;
				}
				case AM:
					if (Pattern.matches(PATTERN_AM, str.substring(0, 1)))
						return true;
					break;
				case NZ:
					if (Pattern.matches(PATTERN_NZ, str.substring(0, 1))) {
						return true;
					}
					break;
				case NUM1: {
					if (StringUtils.isNumeric(str)) {
						if (intervallContains(0, 100, Integer.parseInt(str)))
							return true;
					}
					break;

				}
				case NUM2: {
					if (StringUtils.isNumeric(str)) {
						if (intervallContains(101, 200, Integer.parseInt(str)))
							return true;
					}
					break;
				}

				case NUM3: {
					if (StringUtils.isNumeric(str)) {
						if (intervallContains(201, 300, Integer.parseInt(str)))
							return true;
					}
					break;
				}
				case NUM4: {
					if (StringUtils.isNumeric(str)) {
						if (intervallContains(300, 999, Integer.parseInt(str)))
							return true;
					}
					break;

				}

				default:
					break;
				}

			}
		} else {
			// nordic = false, numeric = true
			switch (criteria.getRange()) {
			case ALL: {
				return true;
			}
			case NUM1: {
				if (StringUtils.isNumeric(str)) {
					if (intervallContains(0, 100, Integer.parseInt(str)))
						return true;
				}
				break;

			}
			case NUM2: {
				if (StringUtils.isNumeric(str)) {
					if (intervallContains(101, 200, Integer.parseInt(str)))
						return true;
				}
				break;
			}

			case NUM3: {
				if (StringUtils.isNumeric(str)) {
					if (intervallContains(201, 300, Integer.parseInt(str)))
						return true;
				}
				break;
			}
			case NUM4: {
				if (StringUtils.isNumeric(str)) {
					if (intervallContains(300, 999, Integer.parseInt(str)))
						return true;
				}
				break;

			}

			default:
				break;
			}
		}

		return false;

		// switch (criteria.getRange()) {
		// case ALL: {
		// return true;
		// }
		// case AM:
		// if (Pattern.matches(PATTERN_AM, str.substring(0, 1)))
		// return true;
		// break;
		// case NZ:
		// if (Pattern.matches(PATTERN_NZ, str.substring(0, 1))) {
		// return true;
		// }
		// break;
		// case NUM1: {
		// if (StringUtils.isNumeric(str)) {
		// if (intervallContains(0, 100, Integer.parseInt(str)))
		// return true;
		// }
		// break;
		//
		// }
		// case NUM2: {
		// if (StringUtils.isNumeric(str)) {
		// if (intervallContains(101, 200, Integer.parseInt(str)))
		// return true;
		// }
		// break;
		// }
		//
		// case NUM3: {
		// if (StringUtils.isNumeric(str)) {
		// if (intervallContains(201, 300, Integer.parseInt(str)))
		// return true;
		// }
		// break;
		// }
		// case NUM4: {
		// if (StringUtils.isNumeric(str)) {
		// if (intervallContains(300, 999, Integer.parseInt(str)))
		// return true;
		// }
		// break;
		//
		// }
		//
		// default:
		// break;
		// }

	}

	@Override
	public Boolean clearAll() {
		content.clear();
		return Boolean.TRUE;
	}

	@Override
	public List<String> getContent() {
		return content;
	}
}

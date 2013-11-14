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

import com.mycompany.listBoxer.dto.RangeType;
import com.mycompany.listBoxer.dto.SelectionCriteria;
import com.mycompany.listBoxer.services.ListBoxerService;

/**
 * 
 * @author vbobina
 */

public class ListBoxerServiceImpl implements ListBoxerService {

	private List<String> content = new ArrayList<String>();

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
		List<String> resultList = getElementsByRange(getContent(),
				selCriteria.getRange());
		if (selCriteria.getAsc())
			Collections.sort(resultList);
		else if (selCriteria.getDesc())
			Collections.sort(resultList, Collections.reverseOrder());

		return resultList;
	}

	private List<String> getElementsByRange(List<String> list, RangeType range) {
		List<String> result = new ArrayList<String>();
		for (String item : list) {
			if (stringIsInRange(range, item))
				result.add(item);
		}
		return result;
	}

	public static boolean intervallContains(int low, int high, int n) {
		return n >= low && n <= high;
	}

	private boolean stringIsInRange(RangeType range, String str) {
		String PATTERN_AM = "[A-Ma-m]";
		String PATTERN_NZ = "[N-Zn-z]";

		switch (range) {
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
			if (intervallContains(0, 100, Integer.parseInt(str)))
				return true;

		}
		case NUM2: {
			if (intervallContains(101, 200, Integer.parseInt(str)))
				return true;
		}

		case NUM3: {
			if (intervallContains(201, 300, Integer.parseInt(str)))
				return true;

		}
		case NUM4: {
			if (intervallContains(300, 999, Integer.parseInt(str)))
				return true;

		}

		default:
			break;
		}

		return false;

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

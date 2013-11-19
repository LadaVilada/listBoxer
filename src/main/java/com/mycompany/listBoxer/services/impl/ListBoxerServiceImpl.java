/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listBoxer.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mycompany.listBoxer.comparator.IntegerComparator;
import com.mycompany.listBoxer.dto.SelectionCriteria;
import com.mycompany.listBoxer.services.ListBoxerService;
import com.mycompany.listBoxer.utils.RangeUtils;

/**
 * 
 * @author vbobina
 */

public class ListBoxerServiceImpl implements ListBoxerService {

	private List<String> content;

	public ListBoxerServiceImpl() {
		this.content = new ArrayList<String>();
	}

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
			buffer.append(String.format("%s\n", item));
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
		if (selCriteria == null)
			return new ArrayList<String>();

		List<String> rangeList = getElementsByRange(getContent(), selCriteria);

		if (selCriteria.getAsc())
			Collections.sort(rangeList, new IntegerComparator());
		else if (selCriteria.getDesc())
			Collections.sort(rangeList, Collections.reverseOrder());

		return rangeList;
	}

	@Override
	public Boolean clearAll() {
		content.clear();
		return Boolean.TRUE;
	}

	@Override
	public List<String> getContent() {
		return this.content;
	}

	private List<String> getElementsByRange(List<String> list,
			SelectionCriteria criteria) {
		List<String> result = new ArrayList<String>();
		for (String item : list) {
			if (RangeUtils.isInRange(item, criteria))
				result.add(item);
		}
		return result;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listBoxer.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
		// TODO Ticket #3 questions
		if (StringUtils.isBlank(userInput)) {
			return Boolean.FALSE;
		}

		content.add(userInput);
		return Boolean.TRUE;
	}

	@Override
	public List<String> getAll() {
		return content;
	}

	@Override
	public List<String> getByRange(String range) {
		// TODO
		return null;
	}

	@Override
	public List<String> getByCriteria(SelectionCriteria selCriteria) {
		// TODO
		return null;
	}

	@Override
	public Boolean clearAll() {
		content.clear();
		return Boolean.TRUE;
	}

	public List<String> getContent() {
		return content;
	}
}

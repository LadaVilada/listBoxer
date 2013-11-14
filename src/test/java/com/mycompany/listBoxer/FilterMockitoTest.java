package com.mycompany.listBoxer;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mycompany.listBoxer.dto.RangeType;
import com.mycompany.listBoxer.dto.SelectionCriteria;
import com.mycompany.listBoxer.services.ListBoxerService;
import com.mycompany.listBoxer.services.impl.ListBoxerServiceImpl;

/**
 * This test has covered the filter logic. User fill all necessary fields(range,
 * sort order and what type of symbols should be allowed.) Input check connected
 * with type of symbols will be checked in eventListener for user input in
 * textBox field.
 * 
 * Let's consider the situation where user input 5 lines and after that change
 * the current range to 'A-M,a-m'.
 * 
 * The result will follow : the size of list should change from 5 to 3 lines and
 * according to sort order the first element in list should be apple
 * 
 * 
 * @author vbobina
 */

public class FilterMockitoTest {

	private ListBoxerService service = new ListBoxerServiceImpl();
	private static final String[] USER_INPUT = new String[] { "apple", "bear",
			"nike", "moody", "zieben" };

	@Test
	public void getByRange_RangeInA_M_Success() {
		/*
		 * 1. create SelectionCriteria and fill it
		 * 
		 * 2. init content list
		 * 
		 * 
		 * 3.call method getByRange 4. Expected result (Assert)
		 */

		SelectionCriteria criteria = getSelectionCriteria();
		getContentList();
		List<String> content = service.getByCriteria(criteria);
		Assert.assertEquals(3, content.size());
		Assert.assertEquals(USER_INPUT[0], content.get(0));
		service.clearAll();
	}

	private SelectionCriteria getSelectionCriteria() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setAsc(Boolean.TRUE);
		criteria.setDesc(Boolean.FALSE);
		criteria.setAlphabetic(Boolean.TRUE);
		criteria.setNumeric(Boolean.FALSE);
		criteria.setRange(RangeType.AM);

		return criteria;

	}

	private void getContentList() {
		for (int i = 0; i < USER_INPUT.length; i++) {
			service.saveContent(USER_INPUT[i]);
		}

	}
}

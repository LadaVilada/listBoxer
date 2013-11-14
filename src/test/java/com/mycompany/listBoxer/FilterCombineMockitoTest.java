package com.mycompany.listBoxer;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mycompany.listBoxer.dto.RangeType;
import com.mycompany.listBoxer.dto.SelectionCriteria;
import com.mycompany.listBoxer.services.ListBoxerService;
import com.mycompany.listBoxer.services.impl.ListBoxerServiceImpl;

/**
 * 
 * @author vbobina
 * 
 */

public class FilterCombineMockitoTest {

	private ListBoxerService service = new ListBoxerServiceImpl();
	private static final String[] USER_INPUT = new String[] { "13", "140", "0",
			"bear", "101", "zieben", "apple" };

	@Test
	public void getByRange_RangeInAll_Success() {
		/*
		 * 1. create SelectionCriteria and fill it
		 * 
		 * 2. init content list
		 * 
		 * 3.call method getByRange
		 * 
		 * 4. Expected result (Assert)
		 */

		SelectionCriteria criteria = getSelectionCriteria();
		getContentList();
		List<String> content = service.getByCriteria(criteria);
		Assert.assertEquals(7, content.size());
		Assert.assertEquals(USER_INPUT[2], content.get(0));
		service.clearAll();
	}

	private SelectionCriteria getSelectionCriteria() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setAsc(Boolean.TRUE);
		criteria.setDesc(Boolean.FALSE);
		criteria.setAlphabetic(Boolean.TRUE);
		criteria.setNumeric(Boolean.TRUE);
		criteria.setRange(RangeType.ALL);

		return criteria;

	}

	private void getContentList() {
		for (int i = 0; i < USER_INPUT.length; i++) {
			service.saveContent(USER_INPUT[i]);
		}

	}

}

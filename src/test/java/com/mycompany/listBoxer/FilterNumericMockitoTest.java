package com.mycompany.listBoxer;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mycompany.listBoxer.dto.RangeType;
import com.mycompany.listBoxer.dto.SelectionCriteria;
import com.mycompany.listBoxer.services.ListBoxerService;
import com.mycompany.listBoxer.services.impl.ListBoxerServiceImpl;

/* In this test we will create reaction on user behavior. 
 * If he choose:
 * 
 *  descending sort
 * digits type only
 * range [0-100]
 * 
 * 
 * @author vbobina
 */

public class FilterNumericMockitoTest {

	private ListBoxerService service = new ListBoxerServiceImpl();
	private static final String[] USER_INPUT = new String[] { "14", "0",
			"bear", "101", "zieben", "" };

	@Test
	public void getByRange_RangeInNUM1_Success() {
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
		Assert.assertEquals(2, content.size());
		Assert.assertEquals(USER_INPUT[0], content.get(0));
		service.clearAll();
	}

	private SelectionCriteria getSelectionCriteria() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setAsc(Boolean.FALSE);
		criteria.setDesc(Boolean.TRUE);
		criteria.setAlphabetic(Boolean.FALSE);
		criteria.setNumeric(Boolean.TRUE);
		criteria.setRange(RangeType.NUM1);

		return criteria;

	}

	private void getContentList() {
		for (int i = 0; i < USER_INPUT.length; i++) {
			service.saveContent(USER_INPUT[i]);
		}

	}

}

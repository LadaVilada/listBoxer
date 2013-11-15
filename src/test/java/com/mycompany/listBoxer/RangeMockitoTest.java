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

public class RangeMockitoTest {

	private ListBoxerService service = new ListBoxerServiceImpl();
	private static final String[] USER_INPUT = new String[] { "14", "0",
			"bear", "101", "zieben" };

	@Test
	public void getByCriteria_TypeNumericRangeInAM_EmptyList() {
		SelectionCriteria criteria = getSelectionCriteria();
		getContentList();
		List<String> content = service.getByCriteria(criteria);
		Assert.assertNotNull(content);
		Assert.assertEquals(0, content.size());
		service.clearAll();

	}

	private SelectionCriteria getSelectionCriteria() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setAsc(Boolean.FALSE);
		criteria.setDesc(Boolean.TRUE);
		criteria.setAlphabetic(Boolean.FALSE);
		criteria.setNumeric(Boolean.TRUE);
		criteria.setRange(RangeType.AM);

		return criteria;

	}

	private void getContentList() {
		for (int i = 0; i < USER_INPUT.length; i++) {
			service.saveContent(USER_INPUT[i]);
		}

	}

}

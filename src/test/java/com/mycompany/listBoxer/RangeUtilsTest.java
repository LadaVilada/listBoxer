package com.mycompany.listBoxer;

import org.junit.Assert;
import org.junit.Test;

import com.mycompany.listBoxer.dto.RangeType;
import com.mycompany.listBoxer.dto.SelectionCriteria;
import com.mycompany.listBoxer.services.ListBoxerService;
import com.mycompany.listBoxer.services.impl.ListBoxerServiceImpl;
import com.mycompany.listBoxer.utils.RangeUtils;

public class RangeUtilsTest {

	private ListBoxerService service = new ListBoxerServiceImpl();

	@Test
	public void isInRange_NullCriteria_False() {
		Boolean res = RangeUtils.isInRange("tmp", null);
		Assert.assertFalse(res);
	}

	@Test
	public void isInRange_EmptyString_False() {
		Boolean res = RangeUtils.isInRange("", null);
		Assert.assertFalse(res);
	}

	@Test
	public void isInRange_AlphabeticAndRangeTypeAll_True() {
		Boolean res = RangeUtils.isInRange("tmp", getSelectionCriteria());
		Assert.assertTrue(res);
	}

	@Test
	public void isInRange_AlphabeticAndRangeTypeAM_True() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setAlphabetic(Boolean.TRUE);
		criteria.setRange(RangeType.AM);
		Boolean res = RangeUtils.isInRange("bear", criteria);
		Assert.assertTrue(res);
	}

	@Test
	public void isInRange_AlphabeticAndRangeTypeNZ_True() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setAlphabetic(Boolean.TRUE);
		criteria.setRange(RangeType.NZ);
		Boolean res = RangeUtils.isInRange("oops", criteria);
		Assert.assertTrue(res);
	}

	@Test
	public void isInRange_NumericAndRangeTypeAll_True() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setNumeric(Boolean.TRUE);
		criteria.setRange(RangeType.ALL);
		Boolean res = RangeUtils.isInRange("123", criteria);
		Assert.assertTrue(res);
	}

	@Test
	public void isInRange_NumericAndRangeTypeNUM2_True() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setNumeric(Boolean.TRUE);
		criteria.setRange(RangeType.NUM2);
		Boolean res = RangeUtils.isInRange("102", criteria);
		Assert.assertTrue(res);
	}

	@Test
	public void isInRange_NumericAndRangeTypeNUM3_True() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setNumeric(Boolean.TRUE);
		criteria.setRange(RangeType.NUM3);
		Boolean res = RangeUtils.isInRange("205", criteria);
		Assert.assertTrue(res);
	}

	@Test
	public void isInRange_NumericAndRangeTypeNUM4_True() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setNumeric(Boolean.TRUE);
		criteria.setRange(RangeType.NUM4);
		Boolean res = RangeUtils.isInRange("400", criteria);
		Assert.assertTrue(res);
	}

	private SelectionCriteria getSelectionCriteria() {
		SelectionCriteria criteria = new SelectionCriteria();
		criteria.setAsc(Boolean.FALSE);
		criteria.setDesc(Boolean.TRUE);
		criteria.setAlphabetic(Boolean.TRUE);
		criteria.setNumeric(Boolean.FALSE);
		criteria.setRange(RangeType.ALL);

		return criteria;

	}

}
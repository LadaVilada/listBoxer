package com.mycompany.listBoxer.utils;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * "#" - only digits "?" - only characters "*" - all
 */
public class MaskedInputTextField extends JTextField {

	private static final long serialVersionUID = -1911866536519770202L;

	private static final String ONLY_DIGITS = "#";
	private static final String ONLY_CHAR = "?";

	private String mask = StringUtils.EMPTY;
	private int limit;

	public MaskedInputTextField(String mask, int limit) {
		super();
		this.mask = mask;
		this.limit = limit;
		setDocument(new CustomDocument());
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	private class CustomDocument extends PlainDocument {

		private static final long serialVersionUID = 668418361519807792L;

		CustomDocument() {
			super();
		}

		private boolean allDigits(String s) {
			for (int i = 0; i < s.length(); i++)
				if (!Character.isDigit(s.charAt(i)))
					return false;

			return true;
		}

		@Override
		public void insertString(int offset, String str, AttributeSet attr)
				throws BadLocationException {
			if (str == null)
				return;

			if (((getLength() + str.length()) <= limit) || (limit == 0)) {
				if (ObjectUtils.equals(mask, ONLY_DIGITS)) {
					if (!allDigits(str))
						return;
				}

				if (ObjectUtils.equals(mask, ONLY_CHAR))
					if (allDigits(str))
						return;

				super.insertString(offset, str, attr);
			}
		}
	}
}

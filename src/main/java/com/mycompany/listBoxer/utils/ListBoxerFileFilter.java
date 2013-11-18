package com.mycompany.listBoxer.utils;

import java.io.File;
import java.util.List;

import javax.swing.filechooser.FileFilter;

import org.apache.commons.lang3.StringUtils;

public class ListBoxerFileFilter extends FileFilter {

	private String description = StringUtils.EMPTY;
	private List<String> expansions;

	public ListBoxerFileFilter(String description, List<String> expansions) {
		this.description = description;
		this.expansions = expansions;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		} else {
			String path = file.getAbsolutePath().toLowerCase();
			for (String extension : expansions) {
				if ((path.endsWith(extension) && (path.charAt(path.length()
						- extension.length() - 1)) == '.')) {
					return true;
				}
			}
		}
		return false;
	}

}

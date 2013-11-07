package com.mycompany.listBoxer.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListBoxerPanel extends JPanel {

	private static final long serialVersionUID = -4541078376891317577L;

	private JButton button = new JButton("Action");
	private JTextArea textarea = new JTextArea(5, 20);
	private JLabel label = new JLabel("Text Area");

	public ListBoxerPanel() {

		add(label);

		textarea.setEditable(Boolean.FALSE);
		add(textarea);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}
		});
		add(button);
	}

}

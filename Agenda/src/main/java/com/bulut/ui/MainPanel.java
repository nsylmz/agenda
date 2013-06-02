package com.bulut.ui;

import javax.swing.JSplitPane;

import com.bulut.utils.AgendaUtility;

@SuppressWarnings("serial")
public class MainPanel extends JSplitPane {
	
	public MainPanel() {
		super(VERTICAL_SPLIT);
//		setDividerLocation(30);
		setTopComponent(new Menu());
		setBottomComponent(AgendaUtility.getEventManager());
	}

}

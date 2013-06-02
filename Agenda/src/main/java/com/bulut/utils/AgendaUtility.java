package com.bulut.utils;

import com.bulut.dao.AgendaDao;
import com.bulut.ui.EventCreator;
import com.bulut.ui.EventManager;
import com.bulut.ui.MainPanel;

public class AgendaUtility {

	private static AgendaDao agendaDao;

	private static EventCreator eventCreator;

	private static EventManager eventManager;
	
	private static MainPanel mainPanel;

	public static void init() {
		agendaDao = new AgendaDao();
		eventCreator = new EventCreator();
		eventManager = new EventManager();
		mainPanel = new MainPanel();
	}

	public static AgendaDao getAgendaDao() {
		return agendaDao;
	}

	public static EventCreator getEventCreator() {
		return eventCreator;
	}

	public static EventManager getEventManager() {
		return eventManager;
	}

	public static MainPanel getMainPanel() {
		return mainPanel;
	}

}

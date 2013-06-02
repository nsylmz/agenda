package com.bulut.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import com.bulut.utils.AgendaUtility;

@SuppressWarnings("serial")
public class Menu extends JToolBar {

	public Menu() {
        JButton createEventButton = new JButton("Event Create");
        JButton managementEventButton = new JButton("Event Management");
        
        add(createEventButton);
        add(managementEventButton);
        createEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	AgendaUtility.getMainPanel().setBottomComponent(AgendaUtility.getEventCreator());
            }
        });
        
        managementEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	AgendaUtility.getMainPanel().setBottomComponent(AgendaUtility.getEventManager());
            }
        });
	}
}

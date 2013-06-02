package com.bulut.ui;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;

import com.bulut.dao.AgendaDao;
import com.bulut.domain.Event;
import com.bulut.ui.tableModel.ToDoListTableModel;
import com.bulut.utils.AgendaUtility;

@SuppressWarnings("serial")
public class EventCreator extends JPanel {
	
	private AgendaDao dao = AgendaUtility.getAgendaDao();
	private Label eventName = new Label("Event Name");
	private Label eventDetail = new Label("Event Detail");
	private Label eventPlace = new Label("Event place");
	private Label startDate = new Label("Event Start Date");
	private Label endDate = new Label("Event End Date");
	private TextField eventNameField = new TextField();
	private TextField eventDetailField = new TextField();
	private TextField eventPlaceField = new TextField();
	
	private SqlDateModel startDateModel = new SqlDateModel();
	private	JDatePanelImpl startDatePanel = new JDatePanelImpl(startDateModel);
	private JDatePickerImpl startDateChooser = new JDatePickerImpl(startDatePanel);
	
	private SqlDateModel endDateModel = new SqlDateModel();
	private JDatePanelImpl endDatePanel = new JDatePanelImpl(endDateModel);
	private JDatePickerImpl endDateChooser = new JDatePickerImpl(endDatePanel);
	
	public EventCreator() {
		super(new GridLayout(8, 2, 100, 10));
//		setSize(100, 100);
		Label startTime = new Label("Event Start Time");
		final JSpinner startTimeSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
		startTimeSpinner.setEditor(startTimeEditor);
		
		Label endTime = new Label("Event End Time");
		final JSpinner endTimeSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
		endTimeSpinner.setEditor(endTimeEditor);
		
		JButton save = new  JButton("Kaydet");
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Event agenda = new Event();
            	agenda.setEventComplete(0);
            	agenda.setEventDetail(eventDetailField.getText());
            	agenda.setEventName(eventNameField.getText());
            	agenda.setEventPlace(eventPlaceField.getText());
            	agenda.setEventStartDate(((SqlDateModel) startDateChooser.getJDateInstantPanel().getModel()).getValue());
            	agenda.setEventEndDate(((SqlDateModel) endDateChooser.getJDateInstantPanel().getModel()).getValue());
            	agenda.setEventStartTime(new Time(((SpinnerDateModel) startTimeSpinner.getModel()).getDate().getTime()));
            	agenda.setEventEndTime(new Time(((SpinnerDateModel) endTimeSpinner.getModel()).getDate().getTime()));
				dao.saveEvent(agenda);
				
				JTable eventTable = AgendaUtility.getEventManager().getEventTable();
				ToDoListTableModel model = (ToDoListTableModel) eventTable.getModel();
				model.refReshData();
				eventTable.repaint();
				AgendaUtility.getMainPanel().setBottomComponent(AgendaUtility.getEventManager());
            }
        });
		
		
		add(eventName);
		add(eventNameField);
		add(eventDetail);
		add(eventDetailField);
		add(eventPlace);
		add(eventPlaceField);
		add(startDate);
		add(startDateChooser);
		add(endDate);
		add(endDateChooser);
		add(startTime);
		add(startTimeSpinner);
		add(endTime);
		add(endTimeSpinner);
		add(save);
		
		
	}

}

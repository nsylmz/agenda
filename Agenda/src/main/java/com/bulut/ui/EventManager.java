package com.bulut.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.bulut.ui.tableButton.ButtonEditor;
import com.bulut.ui.tableButton.ButtonRenderer;
import com.bulut.ui.tableModel.ToDoListTableModel;
import com.bulut.utils.AgendaUtility;

@SuppressWarnings("serial")
public class EventManager extends JPanel {
	
	private JTable eventTable = new JTable(new ToDoListTableModel());
	
	public JTable getEventTable() {
		return eventTable;
	}

	public EventManager() {
		super();
//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		eventTable.setBorder(BorderFactory.createRaisedBevelBorder());
		eventTable.setPreferredScrollableViewportSize(new Dimension(850, 250));
		eventTable.setFillsViewportHeight(true);
		
		TableColumn column = null;
		column = eventTable.getColumnModel().getColumn(0);
	    column.setMinWidth(0);
	    column.setMaxWidth(0);
	    column.setPreferredWidth(0);
	        
	    column = eventTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
		
        column = eventTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(200);

        column = eventTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        
        column = eventTable.getColumnModel().getColumn(4);
        column.setPreferredWidth(150);
        
        column = eventTable.getColumnModel().getColumn(5);
        column.setPreferredWidth(100);
        
        column = eventTable.getColumnModel().getColumn(6);
        column.setPreferredWidth(125);
        
        column = eventTable.getColumnModel().getColumn(7);
        column.setPreferredWidth(125);
        
        eventTable.getColumn("EVENT DELETE").setCellRenderer(new ButtonRenderer());
        eventTable.getColumn("EVENT DELETE").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        JButton save = new  JButton("Kaydet");
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int rowCount = eventTable.getModel().getRowCount();
            	for (int i = 0; i < rowCount; i++) {
            		AgendaUtility.getAgendaDao().updateEvent((Long) eventTable.getValueAt(i, 0), 
            												 (Boolean) eventTable.getValueAt(i, 6));
				}
            	
            }
        });
        eventTable.getTableHeader().setBorder(BorderFactory.createRaisedBevelBorder());
        add(save);
		add(eventTable.getTableHeader());
		add(new JScrollPane(eventTable));
	}
	
}

package com.bulut.ui.tableModel;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.bulut.dao.AgendaDao;
import com.bulut.domain.Event;
import com.bulut.utils.AgendaUtility;

@SuppressWarnings("serial")
public class ToDoListTableModel extends AbstractTableModel {
	
	private String[] columnNames = {"ID", "EVENT NAME", "EVENT DETAIL", "EVENT PLACE", "EVENT DATE", "EVENT TIME", "EVENT COMPLETE", "EVENT DELETE"};
	
	private Object[][] data = initData();
	
	public Object[][] initData() {
		AgendaDao dao = AgendaUtility.getAgendaDao();
		final List<Event> toDoList = dao.retriveAllEvent();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
		Object[][] eventData = new Object[toDoList.size()][columnNames.length];
				 
		Object[] obj = null;
		Event event = null;
		for (int i = 0; i < toDoList.size(); i++) {
			event = toDoList.get(i);
			
			obj = new Object[columnNames.length];
			obj[0] = event.getId();
			obj[1] = event.getEventName();
			obj[2] = event.getEventDetail();
			obj[3] = event.getEventPlace();
			obj[4] = dateFormat.format(event.getEventStartDate()) + " - " + dateFormat.format(event.getEventEndDate());
			obj[5] = timeFormat.format(event.getEventEndTime()) + " - " + timeFormat.format(event.getEventStartTime());
			obj[6] = event.getEventComplete()==0?new Boolean(false):new Boolean(true);
			obj[7] = "DELETE";
			
			eventData[i] = obj;
		}
		return eventData;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public void removeRow(int row) {
		this.data = initData();
        fireTableRowsDeleted(row, row);
    }
	
	public void refReshData() {
		this.data = initData();
        fireTableDataChanged();
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		if (col > 5) {
			return true;
		} else {
			return false;
		}
	}

	public void setValueAt(Object value, int row, int col) {
		if (col != 7) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

}
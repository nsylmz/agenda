package com.bulut.ui.tableButton;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import com.bulut.ui.tableModel.ToDoListTableModel;
import com.bulut.utils.AgendaUtility;

@SuppressWarnings("serial")
public class ButtonEditor extends DefaultCellEditor {
	protected JButton button;

	private String label;

	private boolean isPushed;

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) {
//			JTable eventTable = (JTable) super.listenerList.getListenerList()[1];
			JTable eventTable = AgendaUtility.getEventManager().getEventTable();
			int editingRow = eventTable.getEditingRow();
			Long id = (Long) eventTable.getValueAt(editingRow, 0);
			AgendaUtility.getAgendaDao().deleteEvent(id);
			ToDoListTableModel model = (ToDoListTableModel) eventTable.getModel();
			model.refReshData();
			eventTable.repaint();
		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}

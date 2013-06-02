package com.bulut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bulut.domain.Event;
import com.bulut.utils.Constants;
import com.bulut.utils.DbUtils;

public class AgendaDao {

	public void saveEvent(Event event) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DbUtils.getConnection();
			stmt = conn.prepareStatement(Constants.insertEvent);
			stmt.setString(1, event.getEventName());
			stmt.setString(2, event.getEventDetail());
			stmt.setDate(3, event.getEventStartDate());
			stmt.setTime(4, event.getEventStartTime());
			stmt.setDate(5, event.getEventEndDate());
			stmt.setTime(6, event.getEventEndTime());
			stmt.setString(7, event.getEventPlace());
			stmt.setInt(8, event.getEventComplete());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateEvent(Long id, boolean complete) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			int eventComplete = 0;
			if (complete == true) {
				eventComplete = 1;
			}
			conn = DbUtils.getConnection();
			stmt = conn.prepareStatement(Constants.updateEvent);
			stmt.setInt(1, eventComplete);
			stmt.setLong(2, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Event> retriveAllEvent() {
		List<Event> toDoList = new ArrayList<Event>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Event event = null;
		try {
			conn = DbUtils.getConnection();
			stmt = conn.prepareStatement(Constants.retriveAllEvents);
			rs = stmt.executeQuery();
			while (rs.next()) {
				event = new Event();
				event.setId(rs.getLong("ID"));
				event.setEventComplete(rs.getInt("EVENT_COMPLETE"));
				event.setEventDetail(rs.getString("EVENT_DETAIL"));
				event.setEventEndDate(rs.getDate("EVENT_END_DATE"));
				event.setEventEndTime(rs.getTime("EVENT_END_TIME"));
				event.setEventName(rs.getString("EVENT_NAME"));
				event.setEventPlace(rs.getString("EVENT_PLACE"));
				event.setEventStartDate(rs.getDate("EVENT_START_DATE"));
				event.setEventStartTime(rs.getTime("EVENT_START_TIME"));
				toDoList.add(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return toDoList;
	}
	
	public void deleteEvent(Long id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DbUtils.getConnection();
			stmt = conn.prepareStatement(Constants.deleteEvent);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}

package edu.spring.database.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.spring.database.model.Issue;
public class IssueRowMapper implements RowMapper<Issue>{
	public Issue mapRow(ResultSet rs, int rowNum)throws SQLException{

		Issue issue = new Issue();
		issue.setTid(rs.getInt("tid"));
		issue.setAssigned_to(rs.getString("assigned_to"));
		issue.setAssigned_by(rs.getString("assigned_by"));
		issue.setStatus(rs.getString("status"));

		return issue;
	}
}

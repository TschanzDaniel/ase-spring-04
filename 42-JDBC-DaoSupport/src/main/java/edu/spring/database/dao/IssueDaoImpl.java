package edu.spring.database.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import edu.spring.database.model.Issue;

public class IssueDaoImpl extends JdbcDaoSupport implements IssueDao{

	@Override
	public void addIssue(Issue issue){
		String sql = "insert into issue(assigned_to,assigned_by,status) values(?,?,?)";
		getJdbcTemplate().update(sql,issue.getAssigned_to(),issue.getAssigned_by(),issue.getStatus());

	}

	public void addIssueAndRetrieveId(Issue issue) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into issue(assigned_to,assigned_by,status) values(?,?,?)";
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, new String[] {"tid"});
						ps.setString(1, issue.getAssigned_to());
						ps.setString(2, issue.getAssigned_by());
						ps.setString(3, issue.getStatus());
						return ps;
					}
				},
				keyHolder);
		issue.setTid(keyHolder.getKey().intValue()); ; 

	}

	@Override
	public List<Issue> getAllIssues() {
		String sql="select * from issue";
		return getJdbcTemplate().query(sql,new IssueRowMapper());
	}


	@Override
	public List<Issue> getIssuesByAssignee(String assignee){

		String sql="select * from issue where assigned_by=?";
		return getJdbcTemplate().query(sql,new IssueRowMapper(),assignee);
	}

	@Override
	public Issue getIssuesById(int tid){

		String sql="select * from issue where tid=?";
		return getJdbcTemplate().queryForObject(sql,new IssueRowMapper(),tid);
	}

	@Override
	public int updateIssue(Issue issue){

		String sql = "update issue set assigned_to=?,assigned_by=?,status=? where tid=?";
		int rows=getJdbcTemplate().update(sql,issue.getAssigned_to(),issue.getAssigned_by(),issue.getStatus(),issue.getTid());
		return rows;
	}

	@Override
	public void deleteIssue(int tid){

		String sql = "delete from issue  where tid=?";
		getJdbcTemplate().update(sql,tid);
	}

} 

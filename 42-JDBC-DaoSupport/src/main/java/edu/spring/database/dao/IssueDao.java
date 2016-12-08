package edu.spring.database.dao;

import java.util.List;

import edu.spring.database.model.Issue;

public interface IssueDao{

	public void addIssue(Issue issue);
	public void addIssueAndRetrieveId(Issue issue);
	public List<Issue> getIssuesByAssignee(String asignee);
	public List<Issue> getAllIssues();
	public Issue getIssuesById(int tid);
	public int updateIssue(Issue issue);
	public void deleteIssue(int tid);
} 

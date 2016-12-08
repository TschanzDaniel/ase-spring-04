package edu.spring.database.service;



import java.util.List;

import edu.spring.database.model.Issue;

public interface IssueService{

	public void createIssue(Issue issue);
	public void createIssueAndRetrieveId(Issue issue);
	public List<Issue> listByAssignee(String asignee);
	public List<Issue> listAllIssues();
	public Issue getIssuesById(int tid);
	public int updateIssue(Issue issue);
	public void deleteIssue(int tid);
}

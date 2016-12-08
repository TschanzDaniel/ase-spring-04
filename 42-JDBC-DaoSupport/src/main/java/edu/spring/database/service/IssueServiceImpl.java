package edu.spring.database.service;


import java.util.List;

import edu.spring.database.dao.IssueDao;
import edu.spring.database.model.Issue;

public class IssueServiceImpl implements IssueService{

	private IssueDao issueDao;

	
	public void setIssueDao(IssueDao issueDao){
		this.issueDao=issueDao;
	}
	
	@Override
	public void createIssue(Issue issue){

		issueDao.addIssue(issue);
	}
	
	@Override
	public void createIssueAndRetrieveId(Issue issue) {
		issueDao.addIssueAndRetrieveId(issue);
		
	}

	@Override
	public List<Issue> listAllIssues() {
		List<Issue> list= issueDao.getAllIssues();
		return list;
	}

	
	@Override
	public List<Issue> listByAssignee(String asignee){
		List<Issue> list= issueDao.getIssuesByAssignee(asignee);
		return list;
	}

	@Override
	public Issue getIssuesById(int tid){

		Issue issue= issueDao.getIssuesById(tid);
		return issue;

	}

	@Override
	public int updateIssue(Issue issue){
		int row=issueDao.updateIssue(issue);
		return row;
	}

	@Override
	public void deleteIssue(int tid){
		issueDao.deleteIssue(tid);
	}


}

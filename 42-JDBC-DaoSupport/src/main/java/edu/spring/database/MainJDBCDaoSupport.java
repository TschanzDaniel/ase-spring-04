package edu.spring.database;

// source code from:
// http://java-journal.blogspot.ch/2013/03/spring-jdbc-integration-example-using.html


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.spring.database.model.Issue;
import edu.spring.database.service.IssueService;


public class MainJDBCDaoSupport{

	public static void main(String args[]){


		AbstractApplicationContext context = new ClassPathXmlApplicationContext("jdbc-config.xml");
		IssueService issueService = (IssueService) context.getBean("iService");
		
		/*Creating new Issues*/
		createIssues (issueService);

		/*Listing Issues*/
		printAll (issueService);
		printAssigendByIssueList (issueService, "Mr. B");
		
		/*Updating the issue*/
		updateIssue (issueService);

		/*Listing Issues*/
		printAll (issueService);

		/*deleting the issue*/
		deleteIssue (issueService);
		
		/*Listing Issues*/
		printAll (issueService);
		
		context.close();

	}
	
	private static void createIssues (IssueService issueService) {
		Issue issue = new Issue();

		issue.setAssigned_to("Mr. X");
		issue.setAssigned_by("Mr. A");
		issue.setStatus("Open");

		issueService.createIssueAndRetrieveId(issue);

		System.out.println("Issue Created... id=" + issue.getTid());

		issue = new Issue();

		issue.setAssigned_to("Mr. Y");
		issue.setAssigned_by("Mr. B");
		issue.setStatus("Open");

		issueService.createIssueAndRetrieveId(issue);
		System.out.println("Issue Created... id=" + issue.getTid());

		issue = new Issue();

		issue.setAssigned_to("Mr. Z");
		issue.setAssigned_by("Mr. B");
		issue.setStatus("Open");

		issueService.createIssue(issue);
		System.out.println("Issue Created (normal DAOSupportUpdate - no id)... id=" + issue.getTid());

	}
	
	
	private static void printAll (IssueService issueService) {
		List<Issue> issuesList=issueService.listAllIssues();
		System.out.println("==========================");
		System.out.println("print all Issues");
		printList (issuesList);
	}

	
	private static void printAssigendByIssueList (IssueService issueService, String byAssignee) {
		List<Issue> issuesList=issueService.listByAssignee(byAssignee);
		System.out.println("Issues assigned by Mr. B:");
		printList (issuesList);
	}
	
	private static void printList(List<Issue> issuesList) {
		System.out.println("==========================");
		for(Issue i:issuesList){
			System.out.print("Id:"+i.getTid());
			System.out.print("    Assigned By :"+i.getAssigned_by());
			System.out.print("    Assigned To:"+i.getAssigned_to());
			System.out.println("    Status:"+i.getStatus());
		}
		System.out.println("==========================");
		
	}

	
	private static void updateIssue (IssueService issueService) {
		System.out.println("Enter Id of the issue to be updated: ");

		int op=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			op= Integer.parseInt(br.readLine());
		}catch(IOException e){
			System.out.println(e);

		}

		Issue issue = new Issue();
		issue=issueService.getIssuesById(op);

		issue.setStatus("closed");

		issueService.updateIssue(issue);
		System.out.println("Issue status Updated...");

	}
	
	private static void deleteIssue (IssueService issueService) {
		System.out.println("Enter Id of the issue to be deleted: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int op=0;

		try {
			op= Integer.parseInt(br.readLine());
		} catch(IOException e){
			System.out.println(e);

		}

		issueService.deleteIssue(op);
		System.out.println("Issue Deleted...");

	}
} 

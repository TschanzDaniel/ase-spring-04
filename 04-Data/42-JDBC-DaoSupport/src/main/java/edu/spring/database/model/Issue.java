package edu.spring.database.model;

public class Issue{
	private int tid;
	private String assigned_to;
	private String assigned_by;
	private String status;

	public void setTid(int tid){
		this.tid = tid;
	}


	public int getTid(){
		return tid;
	}

	public void setAssigned_to(String assigned_to){
		this.assigned_to = assigned_to;
	}

	public String getAssigned_to(){
		return assigned_to;
	}

	public void setAssigned_by(String assigned_by){
		this.assigned_by = assigned_by;
	}

	public String getAssigned_by(){
		return assigned_by;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}

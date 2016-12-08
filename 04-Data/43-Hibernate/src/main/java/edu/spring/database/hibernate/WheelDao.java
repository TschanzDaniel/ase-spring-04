package edu.spring.database.hibernate;

import java.util.List;

import edu.spring.database.model.WheelEntity;

public interface WheelDao {

	public WheelEntity findById(int id);
	public void save(WheelEntity... cars);
	public void delete(WheelEntity car);
	public List<WheelEntity> getAllWheels();

}



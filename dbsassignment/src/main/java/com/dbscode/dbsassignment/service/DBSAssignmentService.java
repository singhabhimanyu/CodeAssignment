package com.dbscode.dbsassignment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbscode.dbsassignment.beans.Filefolder;
import com.dbscode.dbsassignment.util.DBSUtility;

/**
 * 
 * @author Abhimanyu Singh
 *
 */
@Component
@Service
public class DBSAssignmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DBSAssignmentService.class);

	/**
	 * 
	 * @return List<Filefolder>
	 */
	public List<Filefolder> getFileFolder() {
		LOGGER.info("Inside:- getFileFolder()");
		return DBSUtility.getFilesFolder();
	}

	/**
	 * 
	 * @return Filefolder
	 */
	public Filefolder getFileInfo() {
		LOGGER.info("Inside:- getFileInfo()");
		return DBSUtility.getFileInfo();
	}
}

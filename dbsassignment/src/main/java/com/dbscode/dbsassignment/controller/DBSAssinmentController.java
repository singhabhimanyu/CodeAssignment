package com.dbscode.dbsassignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbscode.dbsassignment.beans.Filefolder;
import com.dbscode.dbsassignment.service.DBSAssignmentService;

/**
 * 
 * @author Abhimanyu Singh
 *
 */
@RestController
@RequestMapping("/")
public class DBSAssinmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DBSAssinmentController.class);

	@Autowired
	DBSAssignmentService dbsService;

	@RequestMapping
	public String home() {

		return "<b>DBS Code Assignment!</b>";
	}

	@RequestMapping(value = "filefolder", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Filefolder> getFileFolder() {
		LOGGER.info("Inside :- getFileFolder()");
		return dbsService.getFileFolder();
	}

	@RequestMapping(value = "fileinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Filefolder getFileInfo() {
		LOGGER.info("Inside :- getFileInfo()");
		return dbsService.getFileInfo();
	}
}

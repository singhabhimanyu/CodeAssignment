package com.dbscode.dbsassignment.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.dbscode.dbsassignment.beans.Filefolder;

/**
 * 
 * @author Abhimanyu Singh
 *
 */
@Component
@PropertySource("classpath:application.properties")
public class DBSUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(DBSUtility.class);

	@Autowired
	public static Environment env;

	/**
	 * 
	 * @return fileDir
	 */
	public static List<Filefolder> getFilesFolder() {
		LOGGER.info("Inside :- getFilesFolder()");
		ResourceBundle messageSource = ResourceBundle.getBundle("application");
		String directoryPath = messageSource.getString("source.dir.path");
		LOGGER.info("Path of directory:- " + directoryPath);
		Filefolder filefolder;
		List<Filefolder> fileDir = new ArrayList<>();
		try {
			String contents[] = new File(directoryPath).list();
			long dirSize = 0;
			for (int i = 0; i < contents.length; i++) {
				filefolder = new Filefolder();
				if (new File(directoryPath + contents[i]).isFile()) {
					dirSize = dirSize + new File(directoryPath + contents[i]).length();
				}
				filefolder.setFolder(new File(directoryPath + contents[i]).isDirectory());
				filefolder.setSize(new File(directoryPath + contents[i]).length());
				filefolder.setFileFolderPath(new File(directoryPath + contents[i]).getPath());
				filefolder.setHidden(new File(directoryPath + contents[i]).isHidden());
				filefolder.setReadable(new File(directoryPath + contents[i]).canRead());
				filefolder.setWritable(new File(directoryPath + contents[i]).canWrite());
				if (new File(directoryPath + contents[i]).getPath() != null) {
					fileDir.add(filefolder);
				}
			}
		} catch (Exception e) {
			filefolder = new Filefolder();
			filefolder.setFileFolderPath("No File/Folder exist at given path - " + directoryPath);
			fileDir.add(filefolder);
			LOGGER.error("Error occured:- " + e);
			e.printStackTrace();
			return fileDir;
		}
		return fileDir;
	}

	/**
	 * 
	 * @return filefolder
	 */
	public static Filefolder getFileInfo() {
		Filefolder filefolder = new Filefolder();
		ResourceBundle messageSource = ResourceBundle.getBundle("application");
		String filePath = messageSource.getString("source.file.path");
		LOGGER.info("Path of directory:- " + filePath);
		try {
			if (new File(filePath).isFile()) {
				filefolder.setSize(new File(filePath).length());
				filefolder.setFileFolderPath(new File(filePath).getPath());
				filefolder.setHidden(new File(filePath).isHidden());
				filefolder.setReadable(new File(filePath).canRead());
				filefolder.setWritable(new File(filePath).canWrite());
			} else {
				LOGGER.error("No file exist at :- " + filePath);
				filefolder.setFileFolderPath("No File exist at " + filePath);
			}
		} catch (Exception e) {
			LOGGER.error("Error occured:- " + e);
			e.printStackTrace();
		}
		return filefolder;
	}
}

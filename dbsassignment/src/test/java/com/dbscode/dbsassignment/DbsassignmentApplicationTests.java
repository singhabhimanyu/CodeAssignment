package com.dbscode.dbsassignment;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dbscode.dbsassignment.beans.Filefolder;
import com.dbscode.dbsassignment.service.DBSAssignmentService;

@SpringBootTest
class DbsassignmentApplicationTests {

	@Autowired
	DBSAssignmentService dbsAssignment;

	@Test
	public void whenValidPathIsProvided_retrievedFileFolderAreCorrect() {
		dbsAssignment = Mockito.mock(DBSAssignmentService.class);
		List<Filefolder> lstFileFolder = new ArrayList<>();
		Filefolder filefolder1 = new Filefolder();
		filefolder1.setFileFolderPath("C:\\Projects\\DBSAssignment\\TestData\\");
		filefolder1.setDirSize(0);
		filefolder1.setFolder(true);
		filefolder1.setHidden(false);
		filefolder1.setReadable(true);
		filefolder1.setSize(0);
		filefolder1.setWritable(true);
		lstFileFolder.add(filefolder1);

		Filefolder filefolder2 = new Filefolder();
		filefolder2.setFileFolderPath("C:\\Projects\\DBSAssignment\\TestData\\testfile1.txt");
		filefolder2.setDirSize(0);
		filefolder2.setFolder(false);
		filefolder2.setHidden(false);
		filefolder2.setReadable(true);
		filefolder2.setSize(8768);
		filefolder2.setWritable(true);
		lstFileFolder.add(filefolder2);

		Mockito.when(dbsAssignment.getFileFolder()).thenReturn(lstFileFolder);
		assertThat(lstFileFolder.get(0).getFileFolderPath()).isEqualTo("C:\\Projects\\DBSAssignment\\TestData\\");
		assertThat(lstFileFolder.get(0).getDirSize()).isEqualTo(0);
		assertThat(lstFileFolder.get(0).isFolder()).isEqualTo(true);
		assertThat(lstFileFolder.get(0).isHidden()).isEqualTo(false);
		assertThat(lstFileFolder.get(0).isReadable()).isEqualTo(true);
		assertThat(lstFileFolder.get(0).isWritable()).isEqualTo(true);
		assertThat(lstFileFolder.get(0).getSize()).isEqualTo(0);

		assertThat(lstFileFolder.get(1).getFileFolderPath())
				.isEqualTo("C:\\Projects\\DBSAssignment\\TestData\\testfile1.txt");
		assertThat(lstFileFolder.get(1).getDirSize()).isEqualTo(0);
		assertThat(lstFileFolder.get(1).isFolder()).isEqualTo(false);
		assertThat(lstFileFolder.get(1).isHidden()).isEqualTo(false);
		assertThat(lstFileFolder.get(1).isReadable()).isEqualTo(true);
		assertThat(lstFileFolder.get(1).isWritable()).isEqualTo(true);
		assertThat(lstFileFolder.get(1).getSize()).isEqualTo(8768);
	}

	@Test
	public void whenValidPathIsProvided_retrievedFileInfoIsCorrect() {
		dbsAssignment = Mockito.mock(DBSAssignmentService.class);
		Filefolder filefolder = new Filefolder();
		filefolder.setFileFolderPath("C:\\Projects\\DBSAssignment\\TestData\\testfile1.txt");
		filefolder.setDirSize(0);
		filefolder.setFolder(false);
		filefolder.setHidden(false);
		filefolder.setReadable(true);
		filefolder.setSize(8768);
		filefolder.setWritable(true);

		Mockito.when(dbsAssignment.getFileInfo()).thenReturn(filefolder);
		assertThat(filefolder.getFileFolderPath()).isEqualTo("C:\\Projects\\DBSAssignment\\TestData\\testfile1.txt");
		assertThat(filefolder.getDirSize()).isEqualTo(0);
		assertThat(filefolder.isFolder()).isEqualTo(false);
		assertThat(filefolder.isHidden()).isEqualTo(false);
		assertThat(filefolder.isReadable()).isEqualTo(true);
		assertThat(filefolder.isWritable()).isEqualTo(true);
		assertThat(filefolder.getSize()).isEqualTo(8768);
	}

}

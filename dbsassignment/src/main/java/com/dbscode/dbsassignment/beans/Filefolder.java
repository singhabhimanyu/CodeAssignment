package com.dbscode.dbsassignment.beans;

/**
 * 
 * @author Abhimanyu Singh
 *
 */
public class Filefolder {

	private boolean isFolder;
	private long size;
	private String fileFolderPath;
	private boolean isHidden;
	private boolean isReadable;
	private boolean isWritable;
	private long dirSize;

	/**
	 * @return the isFolder
	 */
	public boolean isFolder() {
		return isFolder;
	}

	/**
	 * @param isFolder the isFolder to set
	 */
	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * @return the fileFolderPath
	 */
	public String getFileFolderPath() {
		return fileFolderPath;
	}

	/**
	 * @param fileFolderPath the fileFolderPath to set
	 */
	public void setFileFolderPath(String fileFolderPath) {
		this.fileFolderPath = fileFolderPath;
	}

	/**
	 * @return the isHidden
	 */
	public boolean isHidden() {
		return isHidden;
	}

	/**
	 * @param isHidden the isHidden to set
	 */
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	/**
	 * @return the isReadable
	 */
	public boolean isReadable() {
		return isReadable;
	}

	/**
	 * @param isReadable the isReadable to set
	 */
	public void setReadable(boolean isReadable) {
		this.isReadable = isReadable;
	}

	/**
	 * @return the isWritable
	 */
	public boolean isWritable() {
		return isWritable;
	}

	/**
	 * @param isWritable the isWritable to set
	 */
	public void setWritable(boolean isWritable) {
		this.isWritable = isWritable;
	}

	/**
	 * @return the dirSize
	 */
	public long getDirSize() {
		return dirSize;
	}

	/**
	 * @param dirSize the dirSize to set
	 */
	public void setDirSize(long dirSize) {
		this.dirSize = dirSize;
	}
}

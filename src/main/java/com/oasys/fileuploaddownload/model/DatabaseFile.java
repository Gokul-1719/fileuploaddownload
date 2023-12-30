package com.oasys.fileuploaddownload.model;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class DatabaseFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name = "fileName")

    private String fileName;

	@Column(name = "fileType")
    private String fileType;

	@Column(name = "data", length = 16777215) 
    private byte[] data;
    
    
   
    
    public DatabaseFile() {

    }

    public DatabaseFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }


    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getData() {
        return data;
    }



    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
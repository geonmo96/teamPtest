package com.care.root.file.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;



@Service
public interface FileService {
	public FileDTO itemview(int filen);
	public int fileList();
	public ArrayList<String> fileallnum();
	public void updata(FileDTO dto);
	String itemresult(String itemname);
	public ArrayList<String> categorylist(String cate);
	public int catelist(String cate);
}

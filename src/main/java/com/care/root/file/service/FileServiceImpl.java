package com.care.root.file.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FileServiceImpl implements FileService{
	@Autowired
	FileDAO dao;

	@Override
	public void updata(FileDTO dto) {
		dao.updata(dto);
		}

	@Override
	public String itemview(int filen) {
		FileDTO dto = dao.itemview(filen);
		String bpage = "itemView";
		String result = bpage + dto.getItemNum();
		return result;
	}

	@Override
	public int fileList() {
		int result = 0;
		ArrayList<String> itemlist = dao.itemList();
		result = itemlist.size();
		return result;
	}
	@Override
	public ArrayList<String> fileallnum(){
		ArrayList<String> allnumlist = dao.itemList();
		return allnumlist;
	}
}

package com.care.root.file.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.care.root.file.filedao.FileDAO;

@Service
@Configurable
@Repository 
public class FileServiceImpl implements FileService{
	@Autowired
	FileDAO dao;

	@Override
	public void updata(FileDTO dto) {
		System.out.println("임플 실행");
		dao.upfile(dto);
		System.out.println("임플 끝");
		}

	@Override
	public FileDTO itemview(int filen) {
		FileDTO dto = dao.itemview(filen);

		return dto;
	}

	@Override
	public int fileList() {
		System.out.println("파일리스트 서비스 시작");
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
	@Override
	public String itemresult(String itemname) {
		String itemnum = dao.viewnum(itemname);
		return itemnum;
	}

	@Override
	public ArrayList<String> categorylist(String cate) {
		ArrayList <String> catelist =  dao.categoryView(cate);
		return catelist;
	}
	@Override
	public int catelist(String cate) {
		System.out.println("카테리스트 서비스 시작");
		int result = 0;
		ArrayList<String> itemlist = dao.categoryView(cate);
		result = itemlist.size();
		return result;
	}
}

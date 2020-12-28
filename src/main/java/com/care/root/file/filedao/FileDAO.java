package com.care.root.file.filedao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.care.root.file.service.FileDTO;

@Repository
public interface FileDAO {
		@Insert("insert into itemlist(itemnum, itemName, makerName, brandName, makeRegion, kg, itemRegion, itemValue) "
				+ "values(itemn.nextval, #{itemName}, #{makerName}, #{brandName}, #{makeRegion}, #{kg}, #{itemRegion}, #{itemValue} )")
		public void upfile(FileDTO dto);
		
		@Select("select * from itemlist where itemnum = #{itemnum}")
		public FileDTO itemview(int filen);
		
		@Select("select filenum from itemlist;")
		public ArrayList<String> itemList();




}
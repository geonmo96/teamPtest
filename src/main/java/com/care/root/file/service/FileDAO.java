package com.care.root.file.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface FileDAO {

	
		@Insert("insert into items(itemnum, itemName, makerName, brandName, makeRegion, kg, itemRegion, itemValue)"
				+ " values(itemn_nextval, #{itemName}, #{makerName}, #{brandName}, #{makeRegion}, #{kg}, #{itemRegion}, #{itemValue} )")
		public void updata(FileDTO dto);
		
		@Select("select * from items where itemnum = #{itemnum}")
		public FileDTO itemview(int filen);
		
		@Select("select filenum from items;")
		public ArrayList<String> itemList();




}

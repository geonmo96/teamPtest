package com.care.root.file.filedao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.care.root.file.service.FileDTO;

@Repository
public interface FileDAO {
		@Insert("insert into itemlist(itemnum, itemName, makerName, brandName, makeRegion, kg, itemRegion, itemValue, itemprice, categorynum, kgpic) "
				+ "values(itemn.nextval, #{itemName}, #{makerName}, #{brandName}, #{makeRegion}, #{kg}, #{itemRegion}, #{itemValue}, #{itemprice}, #{categorynum}, #{kgpic})")
		public void upfile(FileDTO dto);
		
		@Select("select * from itemlist where itemnum = #{itemnum}")
		public FileDTO itemview(int filen);
		
		@Select("select itemnum from itemlist")
		public ArrayList<String> itemList();

		@Select("select itemnum from itemlist where itemname = #{itemname}")
		public String viewnum(String itemname);
		
		@Select("select itemnum from itemlist where categorynum = #{category}")
		public ArrayList<String> categoryView(String category);


}
package com.care.root.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.care.root.member.dto.ExternalMemberDTO;

@Repository
public interface ExternalMemberDAO {

	@Select("select * from external_member where e_id = #{e_id}")
	public ExternalMemberDTO selectId(int e_id);
	
	@Insert("insert into external_member values(#{e_id}, #{e_name})")
	public void join(ExternalMemberDTO dto);
}

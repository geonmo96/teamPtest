package com.care.root.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.care.root.member.dto.MemberDTO;

@Repository
public interface MemberDAO {
	@Insert("insert into member(id, pw, name, m_tel, m_address, email) values(#{id}, #{pw}, #{name}, #{m_tel}, #{m_address}, #{email} )")
	public void join(MemberDTO dto);
	
	@Select("select id from member where id = #{id}")
	public String dbIdCheck(String id);
}

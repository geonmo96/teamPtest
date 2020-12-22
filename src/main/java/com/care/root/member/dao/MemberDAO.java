package com.care.root.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.care.root.member.dto.MemberDTO;

@Repository
public interface MemberDAO {
	@Insert("insert into member(id, pw, name, m_tel, m_address, email) values(#{id}, #{pw}, #{name}, #{m_tel}, #{m_address}, #{email} )")
	public void join(MemberDTO dto);
	
	@Select("select id from member where id = #{id}")
	public String dbIdCheck(String id);
	@Select("select id, pw from member where id = #{id}")
	public MemberDTO login(MemberDTO dto);
	@Select("select name from member where email = #{email}")
	public String selectNameToEmail(String email);
	@Select("select id from member where email = #{email}")
	public String selectIdToEmail(String email);
	@Select("select * from member where id = #{id}")
	public MemberDTO selectId(String id);
	@Select("select * from member where m_tel = #{m_tel}")
	public MemberDTO dbNameCheck(MemberDTO dto);
	
	@Update("update member set pw = #{pw} where id = #{id}")
	public void modifyPw(MemberDTO dto);
}

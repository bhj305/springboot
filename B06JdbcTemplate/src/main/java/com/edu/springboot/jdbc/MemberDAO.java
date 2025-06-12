package com.edu.springboot.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

// @Controller와 @Service와 동일한 역할을 함.
@Repository
public class MemberDAO implements IMemberService
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
//	회원조회
	@Override
	public List<MemberDTO> select()
	{
		String sql = " SELECT * FROM member ORDER BY regidate DESC ";
		return jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class)); // BeanPropertyRowMapper: 자동으로 MemberDTO에 저장해줌. 
	}
	
//	회원등록
	@Override
	public int insert(MemberDTO memberDTO)
	{
		int result = jdbcTemplate.update(new PreparedStatementCreator()
		{
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException
			{
				String sql = " INSERT INTO member (id, pass, name) "
						+ " VALUES (?, ?, ?) ";
				
				PreparedStatement psmt = con.prepareStatement(sql);
				
				psmt.setString(1, memberDTO.getId());
				psmt.setString(2, memberDTO.getPass());
				psmt.setString(3, memberDTO.getName());
				
				return psmt;
			}
		});
		return result;
	}

//	회원조회
	@Override
	public MemberDTO selectOne(MemberDTO memberDTO)
	{
		String sql = " SELECT * FROM member WHERE id = ? ";
		memberDTO = jdbcTemplate.queryForObject(sql, 
				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class),
				new Object[] {memberDTO.getId()});
		return memberDTO;
	}

	@Override
	public int update(MemberDTO memberDTO)
	{
		String sql = " UPDATE member SET pass=?, name=? WHERE id=? ";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter()
		{
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException
			{
				ps.setString(1, memberDTO.getPass());
				ps.setString(2, memberDTO.getName());
				ps.setString(3, memberDTO.getId());
			}
		});
		return result;
	}

	@Override
	public int delete(MemberDTO memberDTO)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

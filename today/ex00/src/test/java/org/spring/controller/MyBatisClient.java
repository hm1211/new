package org.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.mapper.MemberMapper;
import org.spring.model.MemberVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//테스트 코도가 스프링을 실행하는 역할이라고 표시
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/data.xml" })
@Log4j // Lombok을 이용해서 로그 기록하는 객체 생성
public class MyBatisClient {
	// 개발자가 객체 생성을 하는것이 아닌 스프링이 객체 생성을 하게 만듬.
	@Inject
	private SqlSessionFactory sqlFactory;

	@Inject
	private MemberMapper memberMapper;

	@Test
	public void testFactory() {
		log.info(sqlFactory);
	}

	@Test
	public void testSession() {
		try (SqlSession session = sqlFactory.openSession()) {
			log.info(session);
			List<MemberVO> users = memberMapper.getAllMembers();

			System.out.println(users);

			MemberVO param = new MemberVO();
//			param.setId("efawe"); 없는 회원일 경우 null값 저장
			param.setId("hong");
			param.setPwd("1212");

			MemberVO user = memberMapper.getMember(param);

			System.out.println(user);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

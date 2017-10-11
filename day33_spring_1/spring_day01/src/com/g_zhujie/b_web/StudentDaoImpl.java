package com.g_zhujie.b_web;

import org.springframework.stereotype.Repository;

@Repository("studentDaoId")
public class StudentDaoImpl implements StudentDao {

	@Override
	public void save() {
		System.out.println("dao");
	}

}

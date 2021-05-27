package com.callor.todo.service;

import java.util.List;
import java.util.Map;

public interface TodoService {

	
	/*
	 * 	Map의 value를 어떤 형태의 데이터라도
	 *  저장할 수 있도록 하겠다
	 *  
	 *   Map의 선언방식
	 *   	Map<String, String> strmap
	 *   	strmap.put("이름","홍길동")
	 *   	-- 데이터는 문자열 type만 저장가능
	 *   
	 *   	Map<String, Integer> intMap
	 *   	intMap.put("이름",100)
	 *   	-- 데이터는 정수형 type만 저장가능
	 *   
	 *   	Map<String, Object> objMap
	 *   	objMap.put("이름","홍길동")
	 *   	objMap.put("나이",33)
	 *   	-- 어떤 형태의 데이터라도 저장가능	
	 */
	public List<Map<String, Object>> selectAll();

	public Map<String, Object> findById(Long seq);

	public void findBySDate(String td_sdate);

	public void findByDoit(String td_doit);

	public Integer insert(Map<String, Object> vo);

	public Integer update(Map<String, Object> vo);

	public Integer delete(Long seq);

}

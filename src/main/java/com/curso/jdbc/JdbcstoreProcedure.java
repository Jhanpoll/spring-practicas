package com.curso.jdbc;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;


@Component
public class JdbcstoreProcedure {
	
	@Autowired
	private JdbcTemplate template;
	
	private SimpleJdbcCall simpleJdbcCall;
	
	private static final Logger log = LoggerFactory.getLogger(JdbcstoreProcedure.class);
	public void ejecutarStoreProcedure() {
		
		simpleJdbcCall = new SimpleJdbcCall(template).withProcedureName("actualizarStreet");
		Map<String,Object> map=simpleJdbcCall.execute(new MapSqlParameterSource().addValue("p_id",30).addValue("p_street","cherito"));
		log.info("jdbtemplate:"+template);
		log.info("map:",map);
		/*
		simpleJdbcCall = new SimpleJdbcCall(template).withProcedureName("get_employee_by_id");
		Map<String,Object> map=simpleJdbcCall.execute(new MapSqlParameterSource("p_id",2));
		log.info("jdbtemplate:"+template);
		log.info("map:",map);
		*/
	}

}

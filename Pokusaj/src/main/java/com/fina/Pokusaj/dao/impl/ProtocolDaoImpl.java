package com.fina.Pokusaj.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fina.Pokusaj.dao.ProtocolDao;
import com.fina.Pokusaj.model.Protocol;


@Repository
public class ProtocolDaoImpl implements ProtocolDao {
	
	@Autowired
	private JdbcTemplate iJdbcTemplate;

	@Override
	public List<Protocol> dohvatiProtokole() {
		List<Protocol> tProtokoli = iJdbcTemplate.query("select * from PROTOKOL",
				new BeanPropertyRowMapper<>(Protocol.class));
		return tProtokoli;
	}

}

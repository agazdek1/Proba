package com.fina.Pokusaj.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fina.Pokusaj.dao.ProtocolDao;
import com.fina.Pokusaj.model.Protocol;


@RestController
public class ProtocolController {
	
	@Autowired
	ProtocolDao iProtocolDao;

	@GetMapping("/protokol")
	@ResponseBody
	public List<Protocol> listaProtokola() {

		return iProtocolDao.dohvatiProtokole();
	
		

	}

}

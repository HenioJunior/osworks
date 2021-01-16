package com.crystaldata.osworks.api.controller;


import java.util.List;

import com.crystaldata.osworks.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystaldata.osworks.domain.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
}
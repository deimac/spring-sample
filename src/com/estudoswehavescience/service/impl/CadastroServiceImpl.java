package com.estudoswehavescience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudoswehavescience.dao.PessoaDAO;
import com.estudoswehavescience.entities.Pessoa;
import com.estudoswehavescience.service.CadastroService;

@Service
@Transactional
public class CadastroServiceImpl implements CadastroService {
	@Autowired
	private PessoaDAO dao;

	public void cadastrar(Pessoa pessoa) throws IllegalArgumentException {
		pessoa.validate();
		dao.save(pessoa);
	}
}
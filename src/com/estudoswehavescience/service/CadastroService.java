package com.estudoswehavescience.service;
 
import com.estudoswehavescience.entities.Pessoa;
 
public interface CadastroService {
    void cadastrar(Pessoa pessoa) throws IllegalArgumentException;
}
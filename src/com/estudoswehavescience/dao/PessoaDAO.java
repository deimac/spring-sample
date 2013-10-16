package com.estudoswehavescience.dao;
 
import java.util.List;
 
import com.estudoswehavescience.entities.Pessoa;
 
public interface PessoaDAO {
    Pessoa getById(final Long id);
 
    List<Pessoa> findAll();
 
    void save(Pessoa pessoa);
 
    void update(Pessoa pessoa);
 
    void remove(Pessoa pessoa);
 
    void removeById(final Long id);
}
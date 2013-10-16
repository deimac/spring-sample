package com.estudoswehavescience.dao.impl;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.estudoswehavescience.dao.PessoaDAO;
import com.estudoswehavescience.entities.Pessoa;
 
@Repository
public class PessoaDAOImpl implements PessoaDAO {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public Pessoa getById(final Long id) {
        return entityManager.find(Pessoa.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<Pessoa> findAll() {
        return entityManager.createQuery("FROM " + Pessoa.class.getName())
                .getResultList();
    }
 
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }
 
    public void update(Pessoa pessoa) {
        entityManager.merge(pessoa);
    }
 
    public void remove(Pessoa pessoa) {
        pessoa = getById(pessoa.getId());
        entityManager.remove(pessoa);
    }
 
    public void removeById(final Long id) {
        Pessoa pessoa = getById(id);
        entityManager.remove(pessoa);
    }
}
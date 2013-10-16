package com.estudoswehavescience.beans;
 
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
 
import com.estudoswehavescience.entities.Pessoa;
import com.estudoswehavescience.service.CadastroService;
 
@Controller
@Scope("request")
public class CadastroBean {
    private Pessoa pessoa;
 
    @Autowired
    private CadastroService service;
 
    @PostConstruct
    private void init() {
        pessoa = new Pessoa();
    }
 
    public String cadastrar() {
        try {
            service.cadastrar(pessoa);
            message("Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException e) {
            message(e.getMessage());
        }
        return "";
    }
 
    private void message(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(msg, ""));
    }
 
    public Pessoa getPessoa() {
        return pessoa;
    }
 
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
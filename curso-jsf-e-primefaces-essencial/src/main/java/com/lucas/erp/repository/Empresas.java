package com.lucas.erp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lucas.erp.model.Empresa;

public class Empresas implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	
	public Empresas() {}
	
	public Empresas(EntityManager manager) {
		this.manager = manager;
	}
	
	
	 public Empresa porID(Long id) {
	        return manager.find(Empresa.class, id);
	    }
		
		  public List<Empresa> pesquisar(String nome) {
		        if (nome == null || nome.trim().isEmpty()) {
		            return new ArrayList<>();  // Retorna uma lista vazia se o nome for nulo ou vazio
		        }

		        TypedQuery<Empresa> query = manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
		        query.setParameter("nomeFantasia", nome + "%");
		        return query.getResultList();
		    }

		    // Método para salvar ou atualizar uma empresa
		    public Empresa guardar(Empresa empresa) {
		        if (empresa.getId() == null) {
		            // Se a empresa não tem ID, é uma nova empresa, então usa o persist
		            manager.persist(empresa);
		            return empresa;
		        } else {
		            // Se a empresa já tem ID, atualiza com o merge
		            return manager.merge(empresa);
		        }
		    }

		    // Método para remover uma empresa
		    public void remover(Empresa empresa) {
		        // Garantir que a empresa está carregada no contexto do EntityManager
		        empresa = porID(empresa.getId());
		        if (empresa != null) {
		            manager.remove(empresa);  // Remover a empresa
		        }
		    }

}

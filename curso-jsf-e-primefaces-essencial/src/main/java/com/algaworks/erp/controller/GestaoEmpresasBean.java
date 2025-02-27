package com.algaworks.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.lucas.erp.model.Empresa;
import com.lucas.erp.model.TipoEmpresa;

@ManagedBean  
@ViewScoped
public class GestaoEmpresasBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();
	
	

	

	
	 
	public void salvar() {
	    if (empresa == null) {
	        System.out.println("Empresa está nula!");
	    } else {
	        System.out.println("Razão Social: " + empresa.getRazaoSocial() + 
	                           " - Nome Fantasia: " + empresa.getNomeFantasia() +
	                           " - Tipo: " + (empresa.getTipo() != null ? empresa.getTipo() : "não selecionado"));
	    }
	}
	
	public String  ajuda() {
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTipoEmpresa() {
		return TipoEmpresa.values();
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

	
}

//por motivos de versão do tomcat, precisa utilizar essa notação, agradeço a um colega de trabalho pela ajuda!
package model.entities;

import java.util.Date;

public class Vendas{

	private String cliente, responsavel, equipamento;
	private int qtd, id;
	private Date dateTime;
		

	// --- Setters ---

	public void setCliente(String cliente){
		if (cliente != null && cliente != "") {
	      this.cliente = cliente;
	    } else{
	      System.out.println("Cliente vazio.");
	    }
	}

	public void setResponsavel(String responsavel){
		if (responsavel != null && responsavel != "") {
	      this.responsavel = responsavel;
	    } else{
	      System.out.println("Responsável vazio.");
	    }
	}

	public void setQtd(int qtd){
		if(qtd > 0){
			this.qtd = qtd;
		} else{
			System.out.println("Valor inválido");
		}
	}

	public void setDateTime(){
		Date dateTime = new Date();
		this.dateTime = dateTime; 
	}


	// --- Getters ---

	public String getCliente(){
		return this.cliente;
	}

	public String getResponsavel(){
		return this.responsavel;
	}

	public String getEquipamento(){
		return this.equipamento;
	}

	public int getQtd(){
		return this.qtd;
	}
	
	public int getId() {
		return this.id;
	}

	private Date getDateTime() {
		return this.dateTime;
	}


	// --- Métodos ---

	public void Cadastrar(Vendas venda){
		// Cadastra uma venda
	}

	public void GerarNota(Vendas venda){
		// Gera nota
	}

	public void Altarar(Vendas venda){
		// Altera uma venda
	}

	public void Cancelar(Vendas venda){
		// Cancela uma venda
	}

	
}

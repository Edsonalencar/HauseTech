package api.DTO;

import java.util.Date;

public class VendasDTO{

	private String cliente, responsavel, equipamento;
	private int qtd, id;
	private Date dateTime;
		

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
	public int getId() {
		return this.id;
	}
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

	private Date getDateTime() {
		return this.dateTime;
	}
}
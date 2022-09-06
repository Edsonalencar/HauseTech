package entity;

public class Equipametos {
private String nome, serialNumber, local, responsavel, ativo;
private double preco;
private int qtd; 



public String getNome(){
	return nome;
}
public String getSerialNumber(){
	return serialNumber;
}
public String getLocal(){
	return local;
}
public String getResponsavel(){
	return responsavel;
}
public String getAtivo(){
	return ativo;
}
public double getpreco(){
	return preco;
}
public int getQtd(){
	return qtd;
	
	
}
public void setNome(String nome){
	 this.nome = nome;
}
public void setSerialNumber(String serialNumber){
	this.serialNumber = serialNumber ;
}
public void setLocal(String local){
	this.local = local;
}
public void setResponsavel(String responsavel){
	this.responsavel = responsavel;
}
public void setAtivo(String ativo){
	this.ativo = ativo;
}
public void setPreco(double preco){
	this.preco = preco;
}
public void setQtd( int qtd){
	this.qtd = qtd;
}


}

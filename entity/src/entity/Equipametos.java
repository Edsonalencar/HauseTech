package entity;

public class Equipametos {
private String nome, local, responsavel;
private double preco;
private int qtd, serialNumber;
private boolean ativo;	



public String getNome(){
	return nome;
}
public int getSerialNumber(){
	return serialNumber;
}
public String getLocal(){
	return local;
}
public String getResponsavel(){
	return responsavel;
}
public boolean getAtivo(){
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
public void setSerialNumber(int serialNumber){
	this.serialNumber = serialNumber ;
}
public void setLocal(String local){
	this.local = local;
}
public void setResponsavel(String responsavel){
	this.responsavel = responsavel;
}
public void setAtivo(boolean ativo){
	this.ativo = ativo;
}
public void setPreco(double preco){
	this.preco = preco;
}
public void setQtd( int qtd){
	this.qtd = qtd;
}


}

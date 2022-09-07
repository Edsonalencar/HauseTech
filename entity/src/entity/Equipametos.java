package entity;

public class Equipamentos {

	
private String nome, local, responsavel;
private double preco;
private int qtd, serialNumber;
private boolean ativo;	


// getters
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

// setters
public void setNome(String nome){
if (nome != null) {
      this.nome = nome;
    } else {
      throw new IllegalArgumentException("Nome invalido");
    }
}
public void setSerialNumber(int serialNumber){
	if (serialNumber > 0) { this.serialNumber = serialNumber;
}
else {
      throw new IllegalArgumentException("Local invalido");
    }
}
public void setLocal(String local){
if (local != null) {
      this.local = local;
    } else {
      throw new IllegalArgumentException("Local invalido");
    }
}
public void setResponsavel(String responsavel){
	if (responsavel != null) {
      this.responsavel = responsavel;
    } else {
      throw new IllegalArgumentException("Responsavel invalido");
    }
}
public void setAtivo(boolean ativo){
	if (ativo == true || ativo == false){
	this.ativo = ativo;
	}
	else {
      throw new IllegalArgumentException("Ativo invalido");
}
}

public void setPreco(double preco){
	if (preco > 0){
	this.preco = preco;
	}
	else {
      throw new IllegalArgumentException("Preco invalido");
}
}

public void setQtd( int qtd){
	if (qtd > 0){
	this.qtd = qtd;
}
else {
      throw new IllegalArgumentException("Quantidade invalida");
}
}

// metodos
public void getBySerialNumber(int serial){
	// busca por serial number
}
public void GetByNome (String nome){
	// busca por nome
}
public void GetByLocal (String local){
    // busca por local
}
public void GetByResponsavel (String resp){
	// busca por responsavel
}
public void Add(Equipamentos equi){
	// adiciona equipamentos
}
public void Update(Equipamentos equi){
	// atualiza equipanentos
}


package model.entities;

import api.DTO.ClienteDTO;
import api.DTO.ResponsavelDTO;

public class Responsavel extends Pessoas {
  private int tel;

  // --- Setters ---
  public void setName(String name) {
    if (name != null && name != "") {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Nome invalido");
    }
  }

  public void setAdress(String adress) {
    if (adress != null && adress != "") {
      this.adress = adress;
    } else {
      throw new IllegalArgumentException("Endereço invalido");
    }
  }

  public void setTel(int tel) {
    if (tel > 0) {
      this.tel = tel;
    } else {
      throw new IllegalArgumentException("Telefone invalido");
    }
  }

  // --- Getters ---
  public String getNome() {
    return this.name;
  }

  public String getAdress() {
    return this.adress;
  }

  public int getTel() {
    return this.tel;
  }

  // --- Construtores ---
  public Responsavel() {
  }

  public Responsavel(int tel, String name, String endereco) {
    setName(name);
    setAdress(endereco);
    setTel(tel);

  }

  // --- Metodos ---
  public void GerarRelatorio() {
    // Acessa o registro de vendas e gera o relatorio de vendas por periodo
  }

  public void Vender(Vendas venda) {
    venda.Cadastrar(venda);
  }

  public void Cadastrar(Responsavel resp) {
    setName(resp.name);
    setAdress(resp.adress);
    setTel(resp.tel);
  }

  public void update(Responsavel resp) {
    setName(resp.name);
    setAdress(resp.adress);
    setTel(resp.tel);
  }

  public void updateName(String name) {
    setName(name);
  }

  public void updateAdress(String adress) {
    setAdress(adress);
  }

  public void updateTel(int tel) {
    setTel(tel);
  }
  
  public static Responsavel converter(ResponsavelDTO dto){
      Responsavel rsp = new Responsavel();
      rsp.setName(dto.getNome());
      rsp.setAdress(dto.getAdress());
      rsp.setTel(dto.getTel());
      return rsp;
  }
}

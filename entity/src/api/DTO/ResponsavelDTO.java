package api.DTO;

import api.DTO.ResponsavelDTO;

public class ResponsavelDTO extends PessoasDTO {
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
}

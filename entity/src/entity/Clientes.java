package entity;
public class Clientes extends Pessoas{
    private String cpf;
   
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
    
      public void setCef(String cpf) {
        if (cpf != null && cpf != "") {
          this.cpf = cpf;
        } else {
          throw new IllegalArgumentException("Telefone invalido");
        }
      }

      public String getNome() {
        return this.name;
      }
    
      public String getAdress() {
        return this.adress;
      }
    
      public String getCpf() {
        return this.cpf;
      }

    public void Compra(Vendas venda){}
    public void Cadastrar(Responsavel resp){}
    public void Alterar(Responsavel resp){}
}

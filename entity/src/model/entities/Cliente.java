package model.entities;
import api.DTO.ClienteDTO;
public class Cliente extends Pessoas{
    private String cpf;
   
    public void setNome(String name) {
        if (name != null && name != "") {
          this.name = name;
        } else {
          throw new IllegalArgumentException("Nome invalido");
        }
      }
    
      public void setEndereco(String adress) {
        if (adress != null && adress != "") {
          this.adress = adress;
        } else {
          throw new IllegalArgumentException("Endereço invalido");
        }
      }
    
      public void setCpf(String cpf) {
        if (cpf != null && cpf != "") {
          this.cpf = cpf;
        } else {
          throw new IllegalArgumentException("Cpf invalido");
        }
      }

      public String getNome() {
        return this.name;
      }
    
      public String getEndereco() {
        return this.adress;
      }
    
      public String getCpf() {
        return this.cpf;
      }

    public void Compra(Vendas venda){}
    public void Cadastrar(Responsavel resp){}
    public void Alterar(Responsavel resp){}

    public static Cliente converter(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setCpf(dto.getCpf());
        cliente.setNome(dto.getNome());
        cliente.setEndereco(dto.getEndereco());
        return cliente;
    }
}

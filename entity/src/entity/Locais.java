
package entity;
public class Locais{
    private String localDeArmazenamento;
    private String compartimento;
    // Metodos
    public void Adicionar(Locais local){
        this.localDeArmazenamento = local;
    }
    public void Alterar(Locais local){
        if(local != null){
            this.localDeArmazenamento = local;
        }
    }

    // getters
    public String getLocalDeArmazenamento(){
        return localDeArmazenamento;
    }
    public String getCompartimento(){
        return compartimento;
    }

    // setters
    public void setLocalDeArmazenamento(String localDeArmazenamento){
        this.localDeArmazenamento = localDeArmazenamento;
    }
    public void setCompartimento(String compartimento){
        this.compartimento = compartimento;
    }
}

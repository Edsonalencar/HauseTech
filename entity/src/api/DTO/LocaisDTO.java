
package api.DTO;
import api.DTO.LocaisDTO;
public class LocaisDTO {
    private String localDeArmazenamento;
    private String compartimento;


    // getters
    public String getLocalDeArmazenamento() {
        return this.localDeArmazenamento;
    }

    public String getCompartimento() {
        return this.compartimento;
    }

    // setters
    public void setLocalDeArmazenamento(String localDeArmazenamento) {
        if (localDeArmazenamento != null && localDeArmazenamento != "") {
            this.localDeArmazenamento = localDeArmazenamento;
        } else {
            throw new IllegalArgumentException("localDeArmazenamento é invalido");
        }
    }

    public void setCompartimento(String compartimento) {
        if (compartimento != null && compartimento != "") {
            this.compartimento = compartimento;
        } else {
            throw new IllegalArgumentException("compartimento é invalido");
        }
    }
}

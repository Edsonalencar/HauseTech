
package model.entities;

import api.DTO.LocaisDTO;

public class Locais {
    private String localDeArmazenamento;
    private String compartimento;

    // Metodos
    public void Adicionar(Locais local) {
        setLocalDeArmazenamento(local.localDeArmazenamento);
        setCompartimento(local.compartimento);
    }

    public void Alterar(Locais local) {
        setLocalDeArmazenamento(local.localDeArmazenamento);
        setCompartimento(local.compartimento);
    }

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

	public static Locais converter(LocaisDTO dto) {
		Locais local = new Locais();
        local.setLocalDeArmazenamento(dto.getLocalDeArmazenamento());
        local.setCompartimento(dto.getCompartimento());
        return local;
	}
}

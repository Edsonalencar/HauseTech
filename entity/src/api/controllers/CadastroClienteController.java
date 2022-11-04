package api.controllers;
import api.DTO.ClienteDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.ClienteBO;
import view.Telas;

public class CadastroClienteController{
    
	@FXML private TextField cpf;
    @FXML private TextField nome;
	@FXML private TextField endereco;
	private ClienteBO bo = new ClienteBO();
    
    public void cadastrar(){
        ClienteDTO dto = new ClienteDTO();
        dto.setCpf(cpf.getText());
		dto.setNome(nome.getText());
		dto.setEndereco(endereco.getText());
		bo.adicionar(dto);
		Telas.listarClientes();
    }
    
}
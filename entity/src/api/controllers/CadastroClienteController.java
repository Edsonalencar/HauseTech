package api.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.ClienteBO;
import api.DTO.ClienteDTO;
import view.Telas;

public class CadastroClienteController{
    
	@FXML private TextField cpf;
    @FXML private TextField nome;
	@FXML private TextField endereco;
	private ClienteBO bo = new ClienteBO();
    
	public void btCadastrarAction(){
        ClienteDTO dto = new ClienteDTO();
        dto.setCpf(cpf.getText());
		dto.setNome(nome.getText());
		dto.setEndereco(endereco.getText());
		bo.adicionar(dto);
		Telas.changeScreen("listaclientes"); // opcional
    }
    public void btCancelarAction(ActionEvent e) {
		Telas.changeScreen("dashboard");
    }
    
}
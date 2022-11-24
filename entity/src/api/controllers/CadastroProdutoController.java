package api.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.EquipamentosBO;
import api.DTO.EquipamentosDTO;
import view.Telas;

public class CadastroProdutoController extends MainController{
    
	@FXML private TextField serialnumber;
    @FXML private TextField nome;
	@FXML private TextField quantidade, local, responsavel, preco;
	private EquipamentosBO bo = new EquipamentosBO();
    
	public void btCadastrarAction(){
        EquipamentosDTO dto = new EquipamentosDTO();
        dto.setSerialNumber(Integer.parseInt(serialnumber.getText()));
		dto.setNome(nome.getText());
		dto.setQtd(Integer.parseInt(quantidade.getText()));
		dto.setLocal(local.getText());
		dto.setPreco(Double.parseDouble(preco.getText()));
		dto.setResponsavel(responsavel.getText());
		bo.adicionar(dto);
    }
    public void btCancelarAction(ActionEvent e) {
		Telas.changeScreen("dashboard");
    }
	@FXML protected void btListaClientesAction(ActionEvent e) {
		Telas.changeScreen("listaclientes");
	}
	@FXML protected void btListaProdutosAction(ActionEvent e) {
		Telas.changeScreen("listaprodutos");
	}
    
}

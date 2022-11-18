package api.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.Telas;
public class MainController {
	
	@FXML protected void btCadastroSceneAction(ActionEvent e) {
		Telas.changeScreen("cadastrocliente");
	}
	@FXML protected void btListaClientesAction(ActionEvent e) {
		Telas.changeScreen("listaclientes");
	}
	@FXML protected void btListaProdutosAction(ActionEvent e) {
		Telas.changeScreen("listaprodutos");
	}
	@FXML protected void btGerarRelatorioAction(ActionEvent e) {
		Telas.changeScreen("gerarrelatorio");
	}
	@FXML protected void btDashboardAction(ActionEvent e) {
		Telas.changeScreen("dashboard");
	}
}

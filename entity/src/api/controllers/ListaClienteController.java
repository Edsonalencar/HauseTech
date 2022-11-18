package api.controllers;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.DTO.ClienteDTO;
import model.services.ClienteBO;
import view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaClienteController extends MainController implements Initializable {
	@FXML private TableView<ClienteDTO> tabelaCliente;
	@FXML private TableColumn<ClienteDTO, String> columnNOME;
	@FXML private TableColumn<ClienteDTO, String> columnCPF;
	@FXML private TableColumn<ClienteDTO, String> columnENDERECO;
	private ClienteBO bo = new ClienteBO();
    private ObservableList<ClienteDTO> listaDeClientes;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarClientes();
	}
	public void listarClientes() {
		tabelaCliente.refresh();
		List<ClienteDTO> clientes = bo.listar();
		listaDeClientes = FXCollections.observableArrayList(clientes);
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnENDERECO.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tabelaCliente.setItems(listaDeClientes);
	}
	@FXML protected void btDashboardAction(ActionEvent e) {
		Telas.changeScreen("dashboard");
	}
	@FXML protected void btCadastroSceneAction(ActionEvent e) {
		Telas.changeScreen("cadastrocliente");
	}
	@FXML protected void btListaProdutosAction(ActionEvent e) {
		Telas.changeScreen("listaprodutos");
	}
}

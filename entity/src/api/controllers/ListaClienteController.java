package api.controllers;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.DTO.ClienteDTO;
import model.services.ClienteBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaClienteController implements Initializable {
	@FXML private TableView<ClienteDTO> tabelaCliente;
	@FXML private TableColumn<ClienteDTO, String> columnNome;
	@FXML private TableColumn<ClienteDTO, String> columnCpf;
	@FXML private TableColumn<ClienteDTO, String> columnEndereco;
	private ClienteBO bo = new ClienteBO();
    private ObservableList<ClienteDTO> listaDeClientes;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarClientes();
	}
	public void listarClientes() {
		List<ClienteDTO> clientes = bo.listar();
		listaDeClientes = FXCollections.observableArrayList(clientes);
		columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tabelaCliente.setItems(listaDeClientes);
		
	}
}

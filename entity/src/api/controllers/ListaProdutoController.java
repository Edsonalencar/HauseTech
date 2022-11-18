package api.controllers;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.DTO.EquipamentosDTO;
import model.services.EquipamentosBO;
import view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaProdutoController extends MainController implements Initializable {
	@FXML private TableView<EquipamentosDTO> tabelaProduto;
	@FXML private TableColumn<EquipamentosDTO, String> columnSERIALNUMBER;
	@FXML private TableColumn<EquipamentosDTO, String> columnNOME;
	@FXML private TableColumn<EquipamentosDTO, String> columnPRECO;
	@FXML private TableColumn<EquipamentosDTO, String> columnESTOQUE;
	@FXML private TableColumn<EquipamentosDTO, String> columnLOCAL;
	@FXML private TableColumn<EquipamentosDTO, String> columnRESPONSAVEL;
	@FXML private TableColumn<EquipamentosDTO, String> columnATIVO;


	private EquipamentosBO bo = new EquipamentosBO();
    private ObservableList<EquipamentosDTO> listaDeEquipamentos;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarEquipamentos();
	}
	public void listarEquipamentos() {
		List<EquipamentosDTO> eqps = bo.listar();
		listaDeEquipamentos = FXCollections.observableArrayList(eqps);
		columnSERIALNUMBER.setCellValueFactory(new PropertyValueFactory<>("serialnumber"));
		columnNOME.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnPRECO.setCellValueFactory(new PropertyValueFactory<>("preco"));
		columnESTOQUE.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnLOCAL.setCellValueFactory(new PropertyValueFactory<>("local"));
		columnRESPONSAVEL.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
		columnATIVO.setCellValueFactory(new PropertyValueFactory<>("ativo"));

		tabelaProduto.setItems(listaDeEquipamentos);
	}
	@FXML protected void btDashboardAction(ActionEvent e) {
		Telas.changeScreen("dashboard");
	}
	@FXML protected void btCadastroSceneAction(ActionEvent e) {
		Telas.changeScreen("cadastroproduto");
	}
	@FXML protected void btListaClientesAction(ActionEvent e) {
		Telas.changeScreen("listaclientes");
	}	
}

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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	@FXML private TextField FilterField;
	private final ObservableList<EquipamentosDTO> dataList = FXCollections.observableArrayList();

	private EquipamentosBO bo = new EquipamentosBO();
    private ObservableList<EquipamentosDTO> listaDeEquipamentos;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarEquipamentos();
		
		dataList.addAll(listaDeEquipamentos);
		// Campo de Busca
		FilteredList<EquipamentosDTO> filteredData = new FilteredList<>(dataList, b -> true);
		FilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(equipamentos -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if(equipamentos.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (String.valueOf(equipamentos.getSerialNumber()).indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (equipamentos.getResponsavel().toLowerCase().indexOf(lowerCaseFilter) != 1) {
					return true;
				} else if (equipamentos.getLocal().toLowerCase().indexOf(lowerCaseFilter) != 1)
					return true;
					else
						return false;
			});
		});
		
		SortedList<EquipamentosDTO> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tabelaProduto.comparatorProperty());
		tabelaProduto.setItems(sortedData);
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

//		tabelaProduto.setItems(listaDeEquipamentos);
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

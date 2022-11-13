package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	// Telas existentes
	private static Stage stage;
	private static Scene mainScene;
	private static Scene cadastroClienteScene;
	private static Scene listaClientesScene;
	private static Scene listaProdutosScene;
	private static Scene cadastroProdutoScene;
	
	public static void main (String args[]) {
		launch();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {	
		stage = primaryStage;
		primaryStage.setTitle("HauseTech");
		
		Parent fxmlMain = FXMLLoader.load(Telas.class.getResource("resources/dashboard.fxml"));
		mainScene = new Scene(fxmlMain);

		// Cadastros
		Parent fxmlCadastroCliente = FXMLLoader.load(Telas.class.getResource("resources/cadastroClientes.fxml"));
		cadastroClienteScene = new Scene(fxmlCadastroCliente);
		Parent fxmlCadastroProduto = FXMLLoader.load(Telas.class.getResource("resources/cadastroProdutos.fxml"));
		cadastroProdutoScene = new Scene(fxmlCadastroProduto);
		
		// Listar
		Parent fxmlListarClientes = FXMLLoader.load(Telas.class.getResource("resources/listarClientes.fxml"));
		listaClientesScene = new Scene(fxmlListarClientes);
		Parent fxmlListarProdutos = FXMLLoader.load(Telas.class.getResource("resources/listarProdutos.fxml"));
		listaProdutosScene = new Scene(fxmlListarProdutos);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	public static void changeScreen(String scr) {
		switch(scr) {
		case "dashboard":
			stage.setScene(mainScene);
			break;
		case "cadastrocliente":
			stage.setScene(cadastroClienteScene);
			break;
		case "listaclientes":
			stage.setScene(listaClientesScene);
			break;
		case "cadastroproduto":
			stage.setScene(cadastroProdutoScene);
			break;
		case "listaprodutos":
			stage.setScene(listaProdutosScene);
			break;
		}
	}
	
	/*
	public static void telaCadastroCliente() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/listarClientes.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Tela de Cadastro de Clientes");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void listarClientes() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/listarClientes.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Todos os Clientes");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}

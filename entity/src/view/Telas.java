package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage stage;
	public static void main (String args[]) {
		launch();
	}
	private void setStage(Stage st) {
		stage =st;
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		setStage(arg0);
		arg0.setTitle("Teste");
		telaCadastroCliente();
	}
	public static void telaCadastroCliente() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroClientes.fxml"));
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
	
}

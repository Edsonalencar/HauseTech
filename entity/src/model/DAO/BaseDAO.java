package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO<entity> implements BaseInterDAO<entity>{
	private Connection com;
	
	synchronized public Connection getConnection() {
		if(com == null) {
			try {
			    com = DriverManager.getConnection("jdbc:mysql://localhost:3306/hausetech","root","oioi"); // INSERIR DADOS DO DB
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return com;	
		}
		else return com;
	}

	@Override
	public boolean inserir(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public entity findById(entity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findBySpecifiedField(entity e, String field) {
		// TODO Auto-generated method stub
		return null;
	}

}

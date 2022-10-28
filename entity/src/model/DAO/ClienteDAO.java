package model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Cliente;

public class ClienteDAO extends BaseDAO<Cliente>{

    public boolean inserir(Cliente cliente){
        String sql = "INSERT INTO tb_cliente (cpf, nome, endereco) VALUES (?,?,?);";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, cliente.getCpf());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getEndereco());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Cliente cliente){
        String sql = "DELETAR FROM tb_clientes WHERE cpf=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, cliente.getCpf());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Cliente cliente){
        String sql = "UPDATE FROM tb_cliente SET cpf=?, nome=?, endereco=? WHERE cpf=?;";
        try{
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, cliente.getCpf());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getEndereco());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Cliente findById(Cliente e) {
        String sql = "SELECT * FROM tb_clientes WHERE id=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
//            pst.setInt(1, e.getId());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Cliente a = new Cliente();
                a.setCpf(rs.getString("cpf"));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString("endereco"));
//                a.setId(e.getId());
                return a;
            }
            else return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public ResultSet findAll(){
        String sql = "SELECT * FROM tb_cliente;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
	public ResultSet findBySpecifiedField(Cliente e, String field) {
		String sql = "SELECT * FROM tb_cliente WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "cpf":
				pst.setString(1, e.getCpf());
				break;
				
			case "nome":
				pst.setString(1, e.getNome());
				break;
					
			case "endereco":
				pst.setString(1, e.getEndereco());
				break;
			
//			default: 
//				pst.setInt(1, e.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	
	public Cliente buscar(Cliente cliente) {
		String sql = "SELECT * FROM tb_cliente WHERE cpf=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, cliente.getCpf());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return cliente;
			}
			else return null;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_cliente;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			return rs;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
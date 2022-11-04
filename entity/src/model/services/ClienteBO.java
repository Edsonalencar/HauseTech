package model.services;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.DTO.ClienteDTO;
import model.DAO.BaseInterDAO;
import model.DAO.ClienteDAO;
import model.entities.Cliente;

public class ClienteBO{
    BaseInterDAO<Cliente> DAO = new ClienteDAO();
    public boolean adicionar(ClienteDTO dto){
    	Cliente cliente = Cliente.converter(dto);
        ResultSet rs = DAO.findBySpecifiedField(cliente, "cpf"); //verifica se ja existe
        try {
            if(rs==null || !(rs.next()) ) {
                if(DAO.inserir(cliente) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<ClienteDTO> listar(){
        List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
        ResultSet rs = DAO.findAll();
        try{
            while(rs.next()) {
                ClienteDTO cliente = new ClienteDTO(); 
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean atualizar(Cliente cliente) {
        ResultSet rs = DAO.findBySpecifiedField(cliente, "cpf");
        try {
            if(rs!=null && rs.next() ) {
                if(DAO.alterar(cliente) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean apagar(Cliente cliente) {
        ResultSet rs = DAO.findBySpecifiedField(cliente, "cpf");
        try{
            if(rs!=null && rs.next() ) {
                if(DAO.deletar(cliente) == true)
                    return true;
                else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//	public static void main(String args[]){
//	    Cliente cliente = new Cliente();
//	    cliente.setCpf("12311976366");
//	    cliente.setNome("Fulano D'Tal");
//	    cliente.setEndereco("Rua Delá Atras");
//	    ClienteBO bo = new ClienteBO();
//	    List<Cliente> lista = bo.listar();
//	
//	    for (Cliente a: lista) {
//	        System.out.println(a.getNome());
//	    }
//  }
}
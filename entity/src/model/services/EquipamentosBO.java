package model.services;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.DTO.EquipamentosDTO;
import model.DAO.BaseInterDAO;
import model.DAO.EquipamentosDAO;
import model.entities.Equipamentos;

public class EquipamentosBO{
    BaseInterDAO<Equipamentos> DAO = new EquipamentosDAO();
    public boolean adicionar(EquipamentosDTO dto){
    	Equipamentos eqp = Equipamentos.converter(dto);
        ResultSet rs = DAO.findBySpecifiedField(eqp, "serialnumber"); //verifica se ja existe
        try {
            if(rs==null || !(rs.next()) ) {
                if(DAO.inserir(eqp) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<EquipamentosDTO> listar(){
        List<EquipamentosDTO> equipamentos = new ArrayList<EquipamentosDTO>();
        ResultSet rs = DAO.findAll();
        try{
            while(rs.next()) {
                EquipamentosDTO eqp = new EquipamentosDTO(); 
                eqp.setSerialNumber(rs.getInt("serialnumber"));
                eqp.setNome(rs.getString("nome"));
                eqp.setPreco(rs.getDouble("preco"));
                eqp.setAtivo(rs.getBoolean("ativo"));
                eqp.setLocal(rs.getString("local"));
                eqp.setResponsavel(rs.getString("responsavel"));
                eqp.setQtd(rs.getInt("qtd"));
                equipamentos.add(eqp);
            }
            return equipamentos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean atualizar(Equipamentos eqp) {
        ResultSet rs = DAO.findBySpecifiedField(eqp, "serialnumber");
        try {
            if(rs!=null && rs.next() ) {
                if(DAO.alterar(eqp) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean apagar(Equipamentos eqp) {
        ResultSet rs = DAO.findBySpecifiedField(eqp, "serialnumber");
        try{
            if(rs!=null && rs.next() ) {
                if(DAO.deletar(eqp) == true)
                    return true;
                else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
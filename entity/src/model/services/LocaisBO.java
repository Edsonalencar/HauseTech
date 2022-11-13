package model.services;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.DTO.LocaisDTO;
import model.DAO.BaseInterDAO;
import model.DAO.LocaisDAO;
import model.entities.Locais;

public class LocaisBO{
    BaseInterDAO<Locais> DAO = new LocaisDAO();
    public boolean adicionar(LocaisDTO dto){
    	Locais locais = Locais.converter(dto);
        ResultSet rs = DAO.findBySpecifiedField(locais, "serialnumber"); //verifica se ja existe
        try {
            if(rs==null || !(rs.next()) ) {
                if(DAO.inserir(locais) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<LocaisDTO> listar(){
        List<LocaisDTO> equipamentos = new ArrayList<LocaisDTO>();
        ResultSet rs = DAO.findAll();
        try{
            while(rs.next()) {
                LocaisDTO locais = new LocaisDTO(); 
                locais.setLocalDeArmazenamento(rs.getString("local_de_armazenamento"));
                locais.setCompartimento(rs.getString("compartimento"));
                equipamentos.add(locais);
            }
            return equipamentos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean atualizar(Locais locais) {
        ResultSet rs = DAO.findBySpecifiedField(locais, "local_de_armazenamento");
        try {
            if(rs!=null && rs.next() ) {
                if(DAO.alterar(locais) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean apagar(Locais locais) {
        ResultSet rs = DAO.findBySpecifiedField(locais, "local_de_armazenamento");
        try{
            if(rs!=null && rs.next() ) {
                if(DAO.deletar(locais) == true)
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
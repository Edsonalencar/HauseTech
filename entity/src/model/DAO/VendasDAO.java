package model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Vendas;

public class VendasDAO extends BaseDAO<Vendas> {
	public boolean inserir(Vendas vendas){
        String sql = "INSERT INTO tb_vendas (cliente, responsavel, equipamento, qtd) VALUES (?,?,?,?);";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, vendas.getCliente());
            pst.setString(2, vendas.getResponsavel());
            pst.setString(3, vendas.getEquipamento());
            pst.setInt(4, vendas.getQtd());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Vendas vendas){
        String sql = "DELETAR FROM tb_vendas WHERE id=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setInt(1, vendas.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Vendas vendas){
        String sql = "UPDATE FROM tb_vendas SET cliente=?, responsavel=?, equipamento=?, qtd=? WHERE id=?;";
        try{
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, vendas.getCliente());
            pst.setString(2, vendas.getResponsavel());
            pst.setString(3, vendas.getEquipamento());
            pst.setInt(4, vendas.getQtd());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Vendas findById(Vendas e) {
        String sql = "SELECT * FROM tb_vendas WHERE id=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Vendas a = new Vendas();
                a.setCliente(rs.getString("cliente"));
                a.setResponsavel(rs.getString("responsavel"));
//              a.setEquipamento(rs.getString("equipamento"));
                a.setQtd(rs.getInt("quantidade"));
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
        String sql = "SELECT * FROM tb_vendas;";
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
	public ResultSet findBySpecifiedField(Vendas e, String field) {
		String sql = "SELECT * FROM tb_vendas WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "cliente":
				pst.setString(1, e.getCliente());
				break;
				
			case "responsavel":
				pst.setString(1, e.getResponsavel());
				break;
				
			case "equipamento":
				pst.setString(1, e.getEquipamento());
				break;
				
			case "qtd":
				pst.setInt(1, e.getQtd());
				break;
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	
//	public Vendas buscar(Vendas vendas) {
//		String sql = "SELECT * FROM tb_vendas WHERE id=? ;";
//		try {
//			PreparedStatement pst = getConnection().prepareStatement(sql);
//			pst.setString(1, vendas.getLocalDeArmazenamento());
//			ResultSet rs = pst.executeQuery();
//			if(rs.next()) {
//				return vendas;
//			}
//			else return null;
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
	
	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_vendas;";
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
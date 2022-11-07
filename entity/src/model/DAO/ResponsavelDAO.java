package model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Responsavel;

public class ResponsavelDAO extends BaseDAO<Responsavel> {
	public boolean inserir(Responsavel	rsp){
        String sql = "INSERT INTO tb_responsavel (nome, endereco, telefone) VALUES (?,?,?);";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, rsp.getNome());
            pst.setString(2, rsp.getAdress());
            pst.setInt(3, rsp.getTel());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Responsavel rsp){
        String sql = "DELETAR FROM tb_responsavel WHERE nome=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, rsp.getNome());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Responsavel rsp){
        String sql = "UPDATE FROM tb_responsavel SET nome=?, endereco=?, telefone=? WHERE nome=?;";
        try{
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, rsp.getNome());
            pst.setString(2, rsp.getAdress());
            pst.setInt(3, rsp.getTel());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Responsavel findById(Responsavel e) {
        String sql = "SELECT * FROM tb_responsavel WHERE id=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Responsavel a = new Responsavel();
                a.setName(rs.getString("nome"));
                a.setAdress(rs.getString("endereco"));
                a.setTel(rs.getInt("telefone"));
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
        String sql = "SELECT * FROM tb_responsavel;";
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
	public ResultSet findBySpecifiedField(Responsavel e, String field) {
		String sql = "SELECT * FROM tb_responsavel WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "nome":
				pst.setString(1, e.getNome());
				break;
				
			case "endereco":
				pst.setString(1, e.getAdress());
				break;
				
			case "telefone":
				pst.setInt(1, e.getTel());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	
	public Responsavel buscar(Responsavel rsp) {
		String sql = "SELECT * FROM tb_responsavel WHERE nome=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, rsp.getNome());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return rsp;
			}
			else return null;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_responsavel;";
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
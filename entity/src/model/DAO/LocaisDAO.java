package model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Locais;

public class LocaisDAO extends BaseDAO<Locais> {
	public boolean inserir(Locais	locs){
        String sql = "INSERT INTO tb_locais (local_de_armazenamento, compartimento) VALUES (?,?);";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, locs.getLocalDeArmazenamento());
            pst.setString(2, locs.getCompartimento());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Locais locs){
        String sql = "DELETAR FROM tb_locais WHERE local_de_armazenamento=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, locs.getLocalDeArmazenamento());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Locais locs){
        String sql = "UPDATE FROM tb_locais SET local_de_armazenamento=?, compartimento=? WHERE local_de_armazenamento=?;";
        try{
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, locs.getLocalDeArmazenamento());
            pst.setString(2, locs.getCompartimento());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Locais findById(Locais e) {
        String sql = "SELECT * FROM tb_locais WHERE id=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Locais a = new Locais();
                a.setLocalDeArmazenamento(rs.getString("local_de_armazenamento"));
                a.setCompartimento(rs.getString("compartimento"));
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
        String sql = "SELECT * FROM tb_locais;";
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
	public ResultSet findBySpecifiedField(Locais e, String field) {
		String sql = "SELECT * FROM tb_locais WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "local_de_armazenamento":
				pst.setString(1, e.getLocalDeArmazenamento());
				break;
				
			case "compartimento":
				pst.setString(1, e.getCompartimento());
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
	
	public Locais buscar(Locais locs) {
		String sql = "SELECT * FROM tb_locais WHERE local_de_armazenamento=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, locs.getLocalDeArmazenamento());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return locs;
			}
			else return null;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_locais;";
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
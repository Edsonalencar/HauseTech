package model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Equipamentos;

	public class EquipamentosDAO extends BaseDAO<Equipamentos>{

	    public boolean inserir(Equipamentos	eqp){
	        String sql = "INSERT INTO tb_equipamentos (serialnumber, nome, preco, qtd, local, responsavel, ativo) VALUES (?,?,?,?,?,?,?);";
	        try {
	            PreparedStatement pst = getConnection().prepareStatement(sql);
	            pst.setInt(1, eqp.getSerialNumber());
	            pst.setString(2, eqp.getNome());
	            pst.setDouble(3, eqp.getPreco());
	            pst.setInt(4, eqp.getQtd());
	            pst.setString(5, eqp.getLocal());
	            pst.setString(6, eqp.getResponsavel());
	            pst.setBoolean(7, eqp.getAtivo());
	            pst.execute();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean deletar(Equipamentos eqp){
	        String sql = "DELETAR FROM tb_equipamentos WHERE serialnumber=?;";
	        try {
	            PreparedStatement pst = getConnection().prepareStatement(sql);
	            pst.setInt(1, eqp.getSerialNumber());
	            pst.execute();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean alterar(Equipamentos eqp){
	        String sql = "UPDATE FROM tb_equipamentos SET serialnumber=?, nome=?, preco=?, qtd=?, local=?, responsavel=? WHERE serialnumber=?;";
	        try{
	            PreparedStatement pst = getConnection().prepareStatement(sql);
	            pst.setInt(1, eqp.getSerialNumber());
	            pst.setString(2, eqp.getNome());
	            pst.setDouble(3, eqp.getPreco());
	            pst.setInt(4, eqp.getQtd());
	            pst.setString(5, eqp.getLocal());
	            pst.setString(6, eqp.getResponsavel());
	            pst.setBoolean(7, eqp.getAtivo());
	            pst.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    public Equipamentos findById(Equipamentos e) {
	        String sql = "SELECT * FROM tb_equipamentos WHERE id=?;";
	        try {
	            PreparedStatement pst = getConnection().prepareStatement(sql);
//	            pst.setInt(1, e.getId());
	            ResultSet rs = pst.executeQuery();
	            if(rs.next()){
	                Equipamentos a = new Equipamentos();
	                a.setSerialNumber(rs.getInt("serialnumber"));
	                a.setNome(rs.getString("nome"));
	                a.setPreco(rs.getDouble("preco"));
	                a.setQtd(rs.getInt("qtd"));
		            a.setLocal(rs.getString("local"));
		            a.setResponsavel(rs.getString("responsavel"));
		            a.setAtivo(rs.getBoolean("ativo"));
//	                a.setId(e.getId());
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
	        String sql = "SELECT * FROM tb_equipamentos;";
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
		public ResultSet findBySpecifiedField(Equipamentos e, String field) {
			String sql = "SELECT * FROM tb_equipamentos WHERE " + field +"=? ;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				switch (field) {
				case "serialnumber":
					pst.setInt(1, e.getSerialNumber());
					break;
					
				case "nome":
					pst.setString(1, e.getNome());
					break;
						
				case "preco":
					pst.setDouble(1, e.getPreco());
					break;
					
				case "qtd":
					pst.setInt(1, e.getQtd());					
					break;
					
				case "local":
					pst.setString(1, e.getLocal());
					break;
					
				case "responsavel":
					pst.setString(1, e.getResponsavel());
					break;
					
				case "ativo":
					pst.setBoolean(1, e.getAtivo());
					break;
//				default: 
//					pst.setInt(1, e.getId());
				}
				
				ResultSet rs = pst.executeQuery();
				return rs;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
		}
		
		public Equipamentos buscar(Equipamentos eqp) {
			String sql = "SELECT * FROM tb_equipamentos WHERE serialnumber=? ;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setInt(1, eqp.getSerialNumber());
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					return eqp;
				}
				else return null;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		public ResultSet buscar() {
			String sql = "SELECT * FROM tb_equipamentos;";
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

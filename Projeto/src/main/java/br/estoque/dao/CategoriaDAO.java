package br.estoque.dao;
import br.estoque.database.ConexaoBD;
import br.estoque.model.Categoria;
import java.sql.*;import java.util.*;
public class CategoriaDAO{
    public void cadastrar(Categoria c){
        String sql="INSERT INTO categorias (nome,descricao) VALUES(?,?)";
        try(Connection conn=ConexaoBD.conectar();
            PreparedStatement stmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1,c.getNome()); stmt.setString(2,c.getDescricao());
            stmt.executeUpdate();
            try(ResultSet k=stmt.getGeneratedKeys()){ if(k.next()) c.setId(k.getInt(1)); }
        }catch(Exception e){System.out.println("Erro: "+e.getMessage());}
    }
    public List<Categoria> listar(){
        List<Categoria> l=new ArrayList<>();
        try(Connection conn=ConexaoBD.conectar();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM categorias")){
            while(rs.next()){
                Categoria c=new Categoria(rs.getString("nome"),rs.getString("descricao"));
                c.setId(rs.getInt("id")); l.add(c);
            }
        }catch(Exception e){System.out.println("Erro: "+e.getMessage());}
        return l;
    }
}

package br.estoque.dao;
import br.estoque.database.ConexaoBD;
import br.estoque.model.Fornecedor;
import java.sql.*;import java.util.*;
public class FornecedorDAO{
    public void cadastrar(Fornecedor f){
        String sql="INSERT INTO fornecedores (nome,cnpj,telefone,email,endereco) VALUES(?,?,?,?,?)";
        try(Connection conn=ConexaoBD.conectar();
            PreparedStatement stmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1,f.getNome()); stmt.setString(2,f.getCnpj());
            stmt.setString(3,f.getTelefone()); stmt.setString(4,f.getEmail());
            stmt.setString(5,f.getEndereco());
            stmt.executeUpdate();
            try(ResultSet k=stmt.getGeneratedKeys()){ if(k.next()) f.setId(k.getInt(1)); }
        }catch(Exception e){System.out.println("Erro: "+e.getMessage());}
    }
    public List<Fornecedor> listar(){
        List<Fornecedor> l=new ArrayList<>();
        try(Connection conn=ConexaoBD.conectar();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM fornecedores")){
            while(rs.next()){
                Fornecedor f=new Fornecedor(rs.getString("nome"),rs.getString("cnpj"),
                rs.getString("telefone"),rs.getString("email"),rs.getString("endereco"));
                f.setId(rs.getInt("id")); l.add(f);
            }
        }catch(Exception e){System.out.println("Erro: "+e.getMessage());}
        return l;
    }
}

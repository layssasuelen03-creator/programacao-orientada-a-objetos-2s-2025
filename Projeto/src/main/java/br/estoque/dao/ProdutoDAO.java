package br.estoque.dao;
import br.estoque.database.ConexaoBD;
import br.estoque.model.*;
import java.sql.*;import java.util.*;
public class ProdutoDAO{
    public void cadastrar(Produto p,Integer idCat,Integer idFor){
        String sql="INSERT INTO produtos (nome,descricao,quantidade,preco,tipo,validade,garantia,id_categoria,id_fornecedor) VALUES(?,?,?,?,?,?,?,?,?)";
        try(Connection conn=ConexaoBD.conectar();
            PreparedStatement stmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1,p.getNome()); stmt.setString(2,p.getDescricao());
            stmt.setInt(3,p.getQuantidade()); stmt.setDouble(4,p.getPreco());
            stmt.setString(5,p.getTipo());
            if(p instanceof ProdutoPerecivel){
                stmt.setDate(6,Date.valueOf(((ProdutoPerecivel)p).getValidade()));
                stmt.setNull(7,Types.INTEGER);
            }else{
                stmt.setNull(6,Types.DATE);
                stmt.setInt(7,((ProdutoDuravel)p).getGarantia());
            }
            if(idCat!=null) stmt.setInt(8,idCat); else stmt.setNull(8,Types.INTEGER);
            if(idFor!=null) stmt.setInt(9,idFor); else stmt.setNull(9,Types.INTEGER);
            stmt.executeUpdate();
            try(ResultSet k=stmt.getGeneratedKeys()){ if(k.next()) p.id=k.getInt(1); }
        }catch(Exception e){System.out.println("Erro: "+e.getMessage());}
    }
}

package br.estoque.dao;
import br.estoque.database.ConexaoBD;
import br.estoque.model.Movimentacao;
import java.sql.*;import java.util.*;
public class MovimentacaoDAO{
    public List<Movimentacao> listar(){
        List<Movimentacao> l=new ArrayList<>();
        try(Connection conn=ConexaoBD.conectar();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM movimentacoes")){
            while(rs.next()){
                Movimentacao m=new Movimentacao(
                    rs.getInt("id_produto"),
                    rs.getString("tipo"),
                    rs.getInt("quantidade"),
                    rs.getString("observacao")
                );
                m.setId(rs.getInt("id"));
                l.add(m);
            }
        }catch(Exception e){System.out.println("Erro: "+e.getMessage());}
        return l;
    }
}

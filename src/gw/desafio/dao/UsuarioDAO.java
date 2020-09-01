package gw.desafio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gw.desafio.dominio.Usuario;

public class UsuarioDAO extends DAO{
	
	 public int inserir(Usuario usuario) {
		 int generatedKey = 0;
		 	try {
		    	 pstmt = getConnection().prepareStatement("insert into desafiogw.tbusuario(nome, email, senha, data_criacao, data_atualizacao, ultimo_login, salt) values (?, ?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);         
		         pstmt.setString(1, usuario.getNome());
		         pstmt.setString(2, usuario.getEmail());
		         pstmt.setString(3, usuario.getSenha());
		         pstmt.setDate(4, usuario.getDataCriacao());
		         pstmt.setDate(5, usuario.getDataAtualizacao());
		         pstmt.setDate(6, usuario.getDataUltimoLogin());
		         pstmt.setString(7, usuario.getSalt());
		         
		         pstmt.execute();
		         
				 ResultSet rs = pstmt.getGeneratedKeys();
				 
				 if (rs.next()) {
				     generatedKey = rs.getInt(1);
				 }
		         
		         connObj.close();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
		 return generatedKey;
	 }
	 
	 public boolean isEmailExistente(String usuarioEmail) throws SQLException {
		 StringBuilder query=new StringBuilder();
		 query.append("select * from desafiogw.tbusuario where email=");
		 query.append("'");
		 query.append(usuarioEmail);
		 query.append("'");
		 stmtObj = getConnection().createStatement();    
		 resultSetObj = stmtObj.executeQuery(query.toString());
		 
		 Usuario usuarioComEmail=null;
		 while(resultSetObj.next()) {
			 usuarioComEmail=new Usuario();
		 }
		 
		 return usuarioComEmail!=null;
	 }
	 
	 public Usuario procurarPorId(int usuarioId) throws SQLException {
		 StringBuilder query=new StringBuilder();
		 query.append("select * from desafiogw.tbusuario where id=");
		 query.append(usuarioId);

		 stmtObj = getConnection().createStatement();    
		 resultSetObj = stmtObj.executeQuery(query.toString());

		 Usuario usuarioProcurado=new Usuario();

		 resultSetObj.next();

		 usuarioProcurado.setNome(resultSetObj.getString("nome"));
		 usuarioProcurado.setEmail(resultSetObj.getString("email"));
		 usuarioProcurado.setSenha(resultSetObj.getString("senha"));
		 usuarioProcurado.setSalt(resultSetObj.getString("salt"));
		 usuarioProcurado.setDataCriacao(resultSetObj.getDate("data_criacao"));
		 usuarioProcurado.setDataAtualizacao(resultSetObj.getDate("data_atualizacao"));
		 usuarioProcurado.setDataUltimoLogin(resultSetObj.getDate("ultimo_login"));

 		 return usuarioProcurado;
	 }
}
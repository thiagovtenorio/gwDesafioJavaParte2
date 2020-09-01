package gw.desafio.dao;

import gw.desafio.dominio.Telefone;

public class TelefoneDAO extends DAO{
	
	public void inserir(Telefone telefone) {
		try {
			 pstmt = getConnection().prepareStatement("insert into desafiogw.tbtelefoneusuario(idusuario, ddd, numero) values (?, ?, ?)"); 
			 pstmt.setInt(1, telefone.getIdUsuario());
			 pstmt.setInt(2, telefone.getDdd());
			 pstmt.setString(3, telefone.getNumero());
			 pstmt.executeUpdate();
	         connObj.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

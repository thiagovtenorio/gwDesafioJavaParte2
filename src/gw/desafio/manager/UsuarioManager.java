package gw.desafio.manager;

import java.sql.Date;
import java.sql.SQLException;

import gw.desafio.dao.TelefoneDAO;
import gw.desafio.dao.UsuarioDAO;
import gw.desafio.dominio.Telefone;
import gw.desafio.dominio.Usuario;

public class UsuarioManager{
	private UsuarioDAO usuarioDAO;
	private TelefoneDAO telefoneDAO;
	
	public UsuarioManager() {
		this.usuarioDAO=new UsuarioDAO();
		this.telefoneDAO=new TelefoneDAO();
	}
	
	public Usuario cadastrar(Usuario novoUsuario) throws SQLException {
		
		if(usuarioDAO.isEmailExistente(novoUsuario.getEmail())) {
			
			System.out.println("E-mail já existente");
			
			return null;
			
		}else {
			Date dataAtual=new Date(System.currentTimeMillis());
			
			novoUsuario.setDataCriacao(dataAtual);
			novoUsuario.setDataAtualizacao(dataAtual);
			novoUsuario.setDataUltimoLogin(dataAtual);
			
			int novoUsuarioId=usuarioDAO.inserir(novoUsuario);
			
			for(Telefone telefone: novoUsuario.getTelefones()) {
				
				telefone.setIdUsuario(novoUsuarioId);	
				telefoneDAO.inserir(telefone);
			}
			
			Usuario usuarioCadastrado=usuarioDAO.procurarPorId(novoUsuarioId);
			
			return usuarioCadastrado;
		}
	}
}
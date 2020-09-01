package gw.desafio.teste;

import java.util.ArrayList;
import java.util.List;

import gw.desafio.dominio.Telefone;
import gw.desafio.dominio.Usuario;
import gw.desafio.manager.UsuarioManager;
import gw.desafio.utils.JsonUtils;

public class Teste {
	public static void main(String[] args) {
		
		UsuarioManager usuarioManager=new UsuarioManager();
		
		
		/** 
		 * Para funcionar é preciso especificar o caminho para o arquivo .json .
		 * O caminho deve estar no formato c\\pasta1\\pasta2\\nomeArquivo.json . */
		
		Usuario novoUsuario=JsonUtils.getUsuarioViaJSON();
		
		try {
			Usuario usuarioCadastrado=usuarioManager.cadastrar(novoUsuario);
			
			System.out.println(usuarioCadastrado.getNome());
			System.out.println(usuarioCadastrado.getEmail());
			System.out.println(usuarioCadastrado.getSenha());
			System.out.println(usuarioCadastrado.getDataAtualizacao());
			System.out.println(usuarioCadastrado.getDataCriacao());
			System.out.println(usuarioCadastrado.getDataUltimoLogin());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

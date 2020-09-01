package gw.desafio.teste;

import java.util.ArrayList;
import java.util.List;

import gw.desafio.dominio.Telefone;
import gw.desafio.dominio.Usuario;
import gw.desafio.manager.UsuarioManager;
import gw.desafio.utils.JsonUtils;
import gw.desafio.utils.PasswordUtils;

public class Teste {
	public static void main(String[] args) {
		
		UsuarioManager usuarioManager=new UsuarioManager();
		
		
		/** 
		 * Para funcionar a leitura do arquivo JSON é preciso especificar o caminho para o arquivo .json .
		 * O caminho deve estar no formato c\\pasta1\\pasta2\\nomeArquivo.json . */
		
		Usuario novoUsuario=JsonUtils.getUsuarioViaJSON();
		
		String salt = PasswordUtils.getSalt(30);
		
		String senhaSegura=PasswordUtils.generateSecurePassword(novoUsuario.getSenha(), salt);
		
		novoUsuario.setSenha(senhaSegura);
		
		novoUsuario.setSalt(salt);
		
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

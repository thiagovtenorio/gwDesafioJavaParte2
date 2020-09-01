package gw.desafio.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import gw.desafio.dominio.Telefone;
import gw.desafio.dominio.Usuario;

public class JsonUtils{
	public static void main(String[] args) {
		Usuario usuario=getUsuarioViaJSON();
		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		for(Telefone telefone:usuario.getTelefones()) {
			System.out.println(telefone.getDdd()+" "+telefone.getNumero());
		}
	}
	public static Usuario getUsuarioViaJSON() {
		JSONParser jsonParser = new JSONParser();
		
		 try (FileReader reader = new FileReader("C:\\Users\\Pichau\\eclipse-workspace\\gwDesafioJavaParte2\\src\\gw\\desafio\\json\\usuario.json"))
	     {
			 
	            Object obj = jsonParser.parse(reader);
	            
	            JSONObject usuarioObj = (JSONObject) obj;
	            
	            Usuario usuario=new Usuario();
	            usuario.setNome((String)usuarioObj.get("nome"));
	            usuario.setEmail((String)usuarioObj.get("email"));
	            usuario.setSenha((String)usuarioObj.get("senha"));
	            
	            JSONArray arr=(JSONArray)usuarioObj.get("telefones");
	            
	            List<Telefone> telefones=new ArrayList<Telefone>();
	            Telefone telefone=null;
	            
	            for(int i=0;i<arr.size();i++) {
	            	
	            	JSONObject jsonObj=(JSONObject)arr.get(i);
	            	int ddd=Integer.parseInt((String)jsonObj.get("ddd"));
	            	String numero=(String)jsonObj.get("numero");
	            	
	            	telefone=new Telefone(ddd, numero);
	            	telefones.add(telefone);
	            	
	            }
	            usuario.setTelefones(telefones);
	            
	            return usuario;
	            
	     	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return null;
	}
}
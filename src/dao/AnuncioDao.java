package dao;

import java.util.List;

import entidade.Anuncio;

/**
 * 
 * @author Viviane
 *
 */

public interface AnuncioDao {
	

		public boolean inserir(Anuncio anuncio);
			
			public void alterar(Anuncio anuncio);

			public void remover(Anuncio anuncio);

			public Anuncio pesquisar(String cpf);

			public List<Anuncio> listarTodos();
			
		}


	

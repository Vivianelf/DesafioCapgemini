package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Anuncio;

/**
 * 
 * @author Viviane
 *
 */
public class AnuncioDaoImpl implements AnuncioDao{
	private EntityManager ent;

	
	public AnuncioDaoImpl(EntityManager ent) {
		this.ent = ent;
	}


	
	public boolean inserir(Anuncio anuncio) {

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.merge(anuncio);
		tx.commit();

		return true;

	}

	public void alterar(Anuncio anuncio) {

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.merge(anuncio);
		tx.commit();

	}


	public void remover(Anuncio anuncio) {
		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.remove(anuncio);
		tx.commit();
		
	}

	public Anuncio pesquisar(String cpf) {

		Anuncio anuncio = ent.find(Anuncio.class, cpf);
		
		return anuncio;
		
	}

	public List<Anuncio> listarTodos() {

		Query query = ent.createQuery("from Anuncio u");
		
		@SuppressWarnings("unchecked")
		List<anuncio> anuncios = query.getResultList();
	
		return anuncios;
		
	}
	

}
 
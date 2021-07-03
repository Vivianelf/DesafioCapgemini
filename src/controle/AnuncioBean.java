package controle;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.AnuncioDao;
import dao.AnuncioDaoImpl;

import javax.faces.application.FacesMessage;

//import entidade.Telefone;
import entidade.Anuncio;
//import util.JpaUtil;


/**
 * 
 * @author Viviane
 *
 */

@ManagedBean(name = "AnuncioBean")
@SessionScoped
public class AnuncioBean {

	private Anuncio anuncio;
	private List<Anuncio> listaAnuncio;
	private AnuncioDao anuncioDao;
	private String cpfSelecionado;

	private static final String MANTER = "manterAnuncio.xhtml";
	private static final String PESQUISAR = "pesquisarAnuncio.xhtml";

	public AnuncioBean() {
		this.anuncio = new Anuncio();
		
		this.listaAnuncio = new ArrayList<Anuncio>();

		this.anuncioDao = new AnuncioDaoImpl(JpaUtil.getEntityManager());

		this.listaAnuncio = this.anuncioDao.listarTodos();

		System.out.println(this.listaAnuncio);
	}

	public void pesquisar() {
		this.listaAnuncio = this.anuncioDao.listarTodos();
		System.out.println("Pesquisa Ok!");
	}

	public void salvar() throws IOException {
		if (this.anuncioDao.inserir(this.anuncio)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Salvo com sucesso!!!"));

			 abrirPerquisarAnuncio();

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro ao inserir !!!"));
		}

	}

		

	public static String getManter() {
		return MANTER;
	}

	public static String getPesquisar() {
		return PESQUISAR;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public AnuncioDao getAnuncioDao() {
		return anuncioDao;
	}

	public void setAnuncioDao(AnuncioDao anuncioDao) {
		this.anuncioDao = anuncioDao;
	}

	public String getCpfSelecionado() {
		return cpfSelecionado;
	}

	public void setCpfSelecionado(String cpfSelecionado) {
		this.cpfSelecionado = cpfSelecionado;
	}
	
	

	public void abrirManterAnuncio() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(MANTER);
	}

	public void abrirPerquisarAnuncio() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
	}

	public void editar() throws IOException {
		Anuncio anuncioEdicao = this.anuncioDao.pesquisar(cpfSelecionado);
		this.anuncio = anuncioEdicao;
		abrirManterAnuncio();
	}
	
	public String remover() {
		Anuncio anuncioRemocao = this.anuncioDao.pesquisar(cpfSelecionado);
		this.anuncioDao.remover(anuncioRemocao);
		this.listaAnuncio = this.anuncioDao.listarTodos();
		return "";
	}
	
	public void limpar() {
		this.listaAnuncio = new ArrayList<Anuncio>();
		this.anuncio = new Anuncio();
		
	}
	
	
	


}

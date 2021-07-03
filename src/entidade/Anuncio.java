package entidade;

	/**
	 * 
	 * @author Viviane
	 *
	 */

	public class Anuncio {
		
		private String nomeDoAnuncio;
		private String cliente;
		private String cpf;
		private int dataDeInicio;
		private int	dataDeTermino;
		private int investimentoPorDia;
		
		
		public String getNomeDoAnuncio() {
			return nomeDoAnuncio;
		}
		public void setNomeDoAnuncio(String nomeDoAnuncio) {
			this.nomeDoAnuncio = nomeDoAnuncio;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public int getDataDeInicio() {
			return dataDeInicio;
		}
		public void setDataDeInicio(int dataDeInicio) {
			this.dataDeInicio = dataDeInicio;
		}
		public int getDataDeTermino() {
			return dataDeTermino;
		}
		public void setDataDeTermino(int dataDeTermino) {
			this.dataDeTermino = dataDeTermino;
		}
		public int getInvestimentoPorDia() {
			return investimentoPorDia;
		}
		public void setInvestimentoPorDia(int investimentoPorDia) {
			this.investimentoPorDia = investimentoPorDia;
		}
		
		
		

	}
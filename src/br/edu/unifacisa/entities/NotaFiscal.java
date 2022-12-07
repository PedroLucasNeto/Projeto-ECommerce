package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.unifacisa.enums.TipoPagamento;

public class NotaFiscal {

	private Cliente cliente;
	private Vendedor vendedor;
	private Date dataCompra;
	private List<Produto> produtos;
	private TipoPagamento tipoPagamento;

	public NotaFiscal(Cliente cliente, Vendedor vendedor, Date dataCompra) {
		super();
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.dataCompra = dataCompra;
		this.produtos = new ArrayList<>();
		this.cliente = new Cliente();
		this.vendedor = new Vendedor();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	@Override
	public String toString() {
		return "-------------NotaFiscal-------------\nCliente:" + cliente.getNome() + "\nVendedor:" + vendedor + "\nData da Compra:" + dataCompra
				+  "Tipo do Pagamento:" + tipoPagamento + "\nProdutos:" + produtos;
	}

	
}

package modelo;


import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Loja {
	private ArrayList<Produtos> listaDeProdutos = new ArrayList<Produtos>();
	private ArrayList<Cupom> listaDeCupom = new ArrayList<Cupom>();

	public void criarCupom(Cupom cupom) {
		listaDeCupom.add(cupom);
	}

	public void criarProd(Produtos produto) {
		listaDeProdutos.add(produto);
	}

	public String gerarDadosProd() {
		String info = "";
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);

			info += "Prod. " + produto.getDescricao() + "  " + " R$ " + produto.getPreco() + "  " + "Cód.: "
					+ produto.getCodigo() + "\n";

		}
		return info;
	}

	public boolean validaProd(String codCriado, String produtoDesejado) {
		String info = "";
		int quant = 0;
		boolean valid = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if ((produto.getCodigo().equals(codCriado)) || (produto.getCodigo().equals(produtoDesejado))) {
				valid = true;
			}
		}
		return valid;
	}

	public boolean validaProd2(String codCriado, String produtoDesejado) {
		String info = "";
		int quant = 0;
		boolean valid = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if (produto.getCodigo().equals(produtoDesejado)) {
				valid = true;
			}
		}
		return valid;
	}

	public void insereEstoque(String codCriado, int quantProd) {

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if (produto.getCodigo().equals(codCriado)) {
				produto.setQuantProd(produto.getQuantProd() + quantProd);
			}
		}
	}

	public String gerarInfoEstoque() {
		String info = "";
		for (Produtos produto : this.listaDeProdutos) {
			info += "Quant.: " + produto.getQuantProd() + "  " + "Prod.: " + produto.getDescricao() + "  " + " R$ "
					+ produto.getPreco() + "  " + "Cód.: " + produto.getCodigo() + "\n";
		}
		return info;
	}

	public boolean validaQuant(int quantProdDesejado) {
		boolean validaQuant = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);

			if (quantProdDesejado > produto.getQuantProd()) {
				validaQuant = true;
			}

		}
		return validaQuant;
	}

	public boolean validaQuantEstoque(int quantProdDesejado, String produtoDesejado) {
		boolean validadorEstoque = false;

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			int tot = quantProdDesejado - produto.getQuantProd();
			if ((tot > 0) && (produto.getCodigo().equals(produtoDesejado))) {

				validadorEstoque = true;
			}
		}
		return validadorEstoque;
	}

	public String produtosVendidos(int quantProdDesejado, String produtoDesejado, Date date, Cupom cupom) {
		String info = "";

		for (Produtos produto : this.listaDeProdutos) {
			if (produtoDesejado.equals(produto.getCodigo())) {

				info = ("Quant. Vendida: " + quantProdDesejado + "    Prod: " + produto.getDescricao() + "    R$ "
						+ cupom.getValorFinal() + "    Cód:" + produto.getCodigo() + "   Data: " + date);

			}
		}
		return info;
	}

	public void venderProd(int quantProdDesejado, String produtoDesejado) {

		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if (produtoDesejado.equals(produto.getCodigo())) {
				produto.setQuantProd(produto.getQuantProd() - quantProdDesejado);

			}
		}

	}
	

	
	public double calculaValor(double valor, int quantProdDesejado, String produtoDesejado ) {
		double valorFinal = 0;
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			if ((produto.getCodigo().equals(produtoDesejado))) {
				valorFinal = produto.getPreco() * quantProdDesejado;
			}
		}
		return valorFinal;
	}

	public String vendeProd(int quantProdDesejado, String produtoDesejado) {
		String info = "";
		double totValor = 0;
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			Produtos produto = this.listaDeProdutos.get(i);
			int tot = quantProdDesejado - produto.getQuantProd();
			if  (produto.getCodigo().equals(produtoDesejado))  {
				for (Cupom cupom : this.listaDeCupom) {
					info += "Quant: " + cupom.getQuantVendido() + "   R$ " + cupom.getValorFinal() + "   Data: "
							+ cupom.getData() + "\n ";
				
				}

			}

		}
		
		return info;
	}
	public double calculaValorTotal  () {
 
		double totValor = 0;
		 
				for (Cupom cupom : this.listaDeCupom) {
				 
					totValor += cupom.getValorFinal();
 
				}
				return totValor;
	}

	 public Date geraData() { 
			Date data = new Date();
			System.out.println("Data Agora: "+data);
			return data;
	 }
}
